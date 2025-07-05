// TipoDocumentoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService service;

    @GetMapping
    public List<TipoDocumentoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TipoDocumentoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public TipoDocumentoEntity crear(@RequestBody TipoDocumentoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public TipoDocumentoEntity actualizar(@PathVariable Long id, @RequestBody TipoDocumentoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public TipoDocumentoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public TipoDocumentoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("tipos", service.findAll());
        return "tipodocumento/listar_tipodocumento";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("tipoDocumento", new TipoDocumentoEntity());
        return "tipodocumento/registrar_tipodocumento";
    }

    @PostMapping("/registrar")
    public String registrarTipoDocumento(@ModelAttribute("tipoDocumento") TipoDocumentoEntity tipo) {
        service.add(tipo);
        return "redirect:/tipodocumento/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        TipoDocumentoEntity tipo = service.findById(id);
        model.addAttribute("tipoDocumento", tipo);
        return "tipodocumento/actualizar_tipodocumento";
    }

    @PostMapping("/actualizar")
    public String actualizarTipoDocumento(@ModelAttribute("tipoDocumento") TipoDocumentoEntity tipo) {
        service.update(tipo, tipo.getCodigo());
        return "redirect:/tipodocumento/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id);
        return "redirect:/tipodocumento/vista";
    }
}
