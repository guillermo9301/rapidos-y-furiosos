// RolController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.service.RolService;

@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public List<RolEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RolEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public RolEntity crear(@RequestBody RolEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public RolEntity actualizar(@PathVariable Long id, @RequestBody RolEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public RolEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public RolEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("roles", service.findAll());
        return "rol/listar_rol";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("rol", new RolEntity());
        return "rol/registrar_rol";
    }

    @PostMapping("/registrar")
    public String registrarRol(@ModelAttribute("rol") RolEntity rol) {
        service.add(rol);
        return "redirect:/rol/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        RolEntity rol = service.findById(id);
        model.addAttribute("rol", rol);
        return "rol/actualizar_rol";
    }

    @PostMapping("/actualizar")
    public String actualizarRol(@ModelAttribute("rol") RolEntity rol) {
        service.update(rol, rol.getCodigo());
        return "redirect:/rol/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id); // cambia el estado actual
        return "redirect:/rol/vista";
    }
}
