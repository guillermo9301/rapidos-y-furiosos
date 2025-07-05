// VehiculoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;
import pe.com.rapidosyfuriosos.service.ColorService;
import pe.com.rapidosyfuriosos.service.MarcaService;
import pe.com.rapidosyfuriosos.service.VehiculoService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @Autowired private ClienteService clienteService;

    @Autowired private MarcaService marcaService;

    @Autowired private ColorService colorService;

    @GetMapping
    public List<VehiculoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VehiculoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public VehiculoEntity crear(@RequestBody VehiculoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public VehiculoEntity actualizar(@PathVariable Long id, @RequestBody VehiculoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public VehiculoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public VehiculoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("vehiculos", service.findAll());
        return "vehiculo/listar_vehiculo";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("vehiculo", new VehiculoEntity());
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("colores", colorService.findAll());
        return "vehiculo/registrar_vehiculo";
    }

    @PostMapping("/registrar")
    public String registrarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity vehiculo) {
        service.add(vehiculo);
        return "redirect:/vehiculo/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        VehiculoEntity vehiculo = service.findById(id);
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("colores", colorService.findAll());
        model.addAttribute("clientes", clienteService.findAll());
        return "vehiculo/actualizar_vehiculo";
    }

    @PostMapping("/actualizar")
    public String actualizarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity vehiculo) {
        service.update(vehiculo, vehiculo.getCodigo());
        return "redirect:/vehiculo/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarVista(@PathVariable Long id) {
        service.enable(id);
        return "redirect:/vehiculo/vista";
    }
}
