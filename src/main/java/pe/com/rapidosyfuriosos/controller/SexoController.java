// SexoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.SexoEntity;
import pe.com.rapidosyfuriosos.service.SexoService;

@RestController
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
}
