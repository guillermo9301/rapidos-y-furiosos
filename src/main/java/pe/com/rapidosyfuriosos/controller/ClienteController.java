
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

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
}
