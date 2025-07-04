// MarcaController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public List<MarcaEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MarcaEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public MarcaEntity crear(@RequestBody MarcaEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public MarcaEntity actualizar(@PathVariable Long id, @RequestBody MarcaEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public MarcaEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public MarcaEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }
}
