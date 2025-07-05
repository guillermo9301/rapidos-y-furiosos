// ColorController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.service.ColorService;

@Controller
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorService service;

    @GetMapping
    public List<ColorEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ColorEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ColorEntity crear(@RequestBody ColorEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public ColorEntity actualizar(@PathVariable Long id, @RequestBody ColorEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public ColorEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public ColorEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("colores", service.findAll());
        return "color/listar_color";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("color", new ColorEntity());
        return "color/registrar_color";
    }

    @PostMapping("/registrar")
    public String registrarColor(@ModelAttribute("color") ColorEntity color) {
        service.add(color);
        return "redirect:/color/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        ColorEntity color = service.findById(id);
        model.addAttribute("color", color);
        return "color/actualizar_color";
    }

    @PostMapping("/actualizar")
    public String actualizarColor(@ModelAttribute("color") ColorEntity color) {
        service.update(color, color.getCodigo());
        return "redirect:/color/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id); // Cambia el estado actual: true → false o false → true
        return "redirect:/color/vista";
    }

}
