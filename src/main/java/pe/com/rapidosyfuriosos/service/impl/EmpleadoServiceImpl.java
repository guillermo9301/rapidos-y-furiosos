// EmpleadoServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.EmpleadoEntity;
import pe.com.rapidosyfuriosos.repository.EmpleadoRepository;
import pe.com.rapidosyfuriosos.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repo;

    @Override
    public List<EmpleadoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public EmpleadoEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity obj) {
        return repo.save(obj);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public EmpleadoEntity delete(Long id) {
        EmpleadoEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public EmpleadoEntity enable(Long id) {
        EmpleadoEntity obj = repo.getById(id);
        obj.setEstado(!obj.isEstado());
        return repo.save(obj);
    }
}
