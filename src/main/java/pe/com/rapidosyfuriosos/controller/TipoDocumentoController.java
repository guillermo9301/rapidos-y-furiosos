// TipoDocumentoController.java
package pe.com.rapidosyfuriosos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@RestController
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
}
