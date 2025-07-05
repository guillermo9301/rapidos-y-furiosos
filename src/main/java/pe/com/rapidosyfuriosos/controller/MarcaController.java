// MarcaController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.service.MarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public List<MarcaEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MarcaEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public MarcaEntity crear(@RequestBody MarcaEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public MarcaEntity actualizar(@PathVariable Long id, @RequestBody MarcaEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public MarcaEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public MarcaEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("marcas", service.findAll());
        return "marca/listar_marca";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("marca", new MarcaEntity());
        return "marca/registrar_marca";
    }

    @PostMapping("/registrar")
    public String registrarMarca(@ModelAttribute("marca") MarcaEntity marca) {
        service.add(marca);
        return "redirect:/marca/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        MarcaEntity marca = service.findById(id);
        model.addAttribute("marca", marca);
        return "marca/actualizar_marca";
    }

    @PostMapping("/actualizar")
    public String actualizarMarca(@ModelAttribute("marca") MarcaEntity marca) {
        service.update(marca, marca.getCodigo());
        return "redirect:/marca/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id); // Cambia el estado actual
        return "redirect:/marca/vista";
    }


}
