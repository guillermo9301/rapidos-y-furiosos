// ColorController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.service.ColorService;

@RestController
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
}
