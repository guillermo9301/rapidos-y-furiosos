// DistritoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService service;

    @GetMapping
    public String listarDistritos(Model model) {
        List<DistritoEntity> distritos = service.findAll();
        model.addAttribute("distritos", distritos);
        return "distrito/listar_distrito"; // busca la vista en templates/distrito/
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("distrito", new DistritoEntity());
        return "distrito/registrar_distrito";
    }

    @PostMapping("/guardar")
    public String guardarDistrito(@ModelAttribute DistritoEntity distrito) {
        service.add(distrito);
        return "redirect:/distrito";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable("id") Long id, Model model) {
        DistritoEntity distrito = service.findById(id);
        model.addAttribute("distrito", distrito);
        return "distrito/actualizar_distrito";
    }

    @PostMapping("/actualizar")
    public String actualizarDistrito(@ModelAttribute DistritoEntity distrito) {
        service.update(distrito, distrito.getCodigo());
        return "redirect:/distrito";
    }

    @GetMapping("/habilitar/{id}")
    public String cambiarEstado(@PathVariable("id") Long id) {
        DistritoEntity distrito = service.findById(id);
        distrito.setEstado(!distrito.isEstado()); // alternar estado
        service.update(distrito, id);
        return "redirect:/distrito";
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("distritos", service.findAll());
        return "distrito/listar_distrito";
    }
}
