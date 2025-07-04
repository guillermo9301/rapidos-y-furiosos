// DistritoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.service.DistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService service;

    @GetMapping
    public List<DistritoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DistritoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public DistritoEntity crear(@RequestBody DistritoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public DistritoEntity actualizar(@PathVariable Long id, @RequestBody DistritoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public DistritoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public DistritoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }
}
