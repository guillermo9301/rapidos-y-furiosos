// EmpleadoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @GetMapping
    public List<EmpleadoEntity> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmpleadoEntity porId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EmpleadoEntity crear(@RequestBody EmpleadoEntity obj) {
        return service.add(obj);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity actualizar(@PathVariable Long id, @RequestBody EmpleadoEntity obj) {
        return service.update(obj, id);
    }

    @DeleteMapping("/{id}")
    public EmpleadoEntity eliminar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/enable/{id}")
    public EmpleadoEntity habilitar(@PathVariable Long id) {
        return service.enable(id);
    }
}
