
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;
import pe.com.rapidosyfuriosos.service.DistritoService;
import pe.com.rapidosyfuriosos.service.SexoService;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired private SexoService sexoService;

    @Autowired private TipoDocumentoService tipoDocumentoService;

    @Autowired private DistritoService distritoService;

    @GetMapping
    public List<ClienteEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClienteEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClienteEntity crear(@RequestBody ClienteEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public ClienteEntity actualizar(@PathVariable Long id, @RequestBody ClienteEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public ClienteEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public ClienteEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }

    @GetMapping("/vista")
    public String listarVista(Model model) {
        model.addAttribute("clientes", service.findAll());
        return "cliente/listar_cliente";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        ClienteEntity cliente = new ClienteEntity();
        model.addAttribute("cliente", cliente);
        model.addAttribute("sexos", sexoService.findAllCustom());
        model.addAttribute("tiposDocumento", tipoDocumentoService.findAllCustom());
        model.addAttribute("distritos", distritoService.findAllCustom());
        return "cliente/registrar_cliente";
    }

    @PostMapping("/registrar")
    public String registrarCliente(@ModelAttribute("cliente") ClienteEntity cliente) {
        service.add(cliente);
        return "redirect:/cliente/vista";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        ClienteEntity cliente = service.findById(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("distritos", distritoService.findAllCustom());
        model.addAttribute("sexos", sexoService.findAllCustom());
        model.addAttribute("tipodocumentos", tipoDocumentoService.findAllCustom());
        return "cliente/actualizar_cliente";
    }

    @PostMapping("/actualizar")
    public String actualizarCliente(@ModelAttribute("cliente") ClienteEntity cliente) {
        service.update(cliente, cliente.getCodigo());
        return "redirect:/cliente/vista";
    }

    @GetMapping("/habilitar/{id}")
    public String habilitarOInhabilitar(@PathVariable Long id) {
        service.enable(id); // Alterna estado true/false
        return "redirect:/cliente/vista";
    }
}
