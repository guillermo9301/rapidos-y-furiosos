// EmpleadoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;
import pe.com.rapidosyfuriosos.service.EmpleadoService;
import pe.com.rapidosyfuriosos.service.RolService;
import pe.com.rapidosyfuriosos.service.SexoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private SexoService sexoService;

    @GetMapping
    public List<EmpleadoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmpleadoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EmpleadoEntity crear(@RequestBody EmpleadoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity actualizar(@PathVariable Long id, @RequestBody EmpleadoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public EmpleadoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public EmpleadoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("empleados", service.findAll());
        return "empleado/listar_empleado";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        model.addAttribute("distritos", distritoService.findAll());
        model.addAttribute("roles", rolService.findAll());
        model.addAttribute("sexos", sexoService.findAll());
        return "empleado/registrar_empleado";
    }

    @PostMapping("/registrar")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        service.add(empleado);
        return "redirect:/empleado/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        EmpleadoEntity empleado = service.findById(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("distritos", distritoService.findAll());
        model.addAttribute("roles", rolService.findAll());
        model.addAttribute("sexos", sexoService.findAll());
        return "empleado/actualizar_empleado";
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        service.update(empleado, empleado.getCodigo());
        return "redirect:/empleado/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id);
        return "redirect:/empleado/vista";
    }




}
