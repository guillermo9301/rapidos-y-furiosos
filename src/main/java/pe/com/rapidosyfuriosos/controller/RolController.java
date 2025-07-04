// RolController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.service.RolService;

@RestController
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
}
