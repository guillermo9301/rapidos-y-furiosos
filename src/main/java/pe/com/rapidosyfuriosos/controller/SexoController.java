// SexoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.SexoEntity;
import pe.com.rapidosyfuriosos.service.SexoService;

@Controller
@RequestMapping("/sexo")
public class SexoController {

    @Autowired
    private SexoService service;

    @GetMapping
    public List<SexoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SexoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public SexoEntity crear(@RequestBody SexoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public SexoEntity actualizar(@PathVariable Long id, @RequestBody SexoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public SexoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public SexoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("sexos", service.findAll());
        return "sexo/listar_sexo";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("sexo", new SexoEntity());
        return "sexo/registrar_sexo";
    }

    @PostMapping("/registrar")
    public String registrarSexo(@ModelAttribute("sexo") SexoEntity sexo) {
        service.add(sexo);
        return "redirect:/sexo/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        SexoEntity sexo = service.findById(id);
        model.addAttribute("sexo", sexo);
        return "sexo/actualizar_sexo";
    }

    @PostMapping("/actualizar")
    public String actualizarSexo(@ModelAttribute("sexo") SexoEntity sexo) {
        service.update(sexo, sexo.getCodigo());
        return "redirect:/sexo/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id);
        return "redirect:/sexo/vista";
    }
}
