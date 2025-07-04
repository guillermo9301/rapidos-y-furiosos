// VehiculoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;
import pe.com.rapidosyfuriosos.service.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping
    public List<VehiculoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VehiculoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public VehiculoEntity crear(@RequestBody VehiculoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public VehiculoEntity actualizar(@PathVariable Long id, @RequestBody VehiculoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public VehiculoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public VehiculoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }
}
