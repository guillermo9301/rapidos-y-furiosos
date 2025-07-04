// SexoServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.SexoEntity;
import pe.com.rapidosyfuriosos.repository.SexoRepository;
import pe.com.rapidosyfuriosos.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {

    @Autowired
    private SexoRepository repo;

    @Override
    public List<SexoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<SexoEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public SexoEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public SexoEntity add(SexoEntity obj) {
        return repo.save(obj);
    }

    @Override
    public SexoEntity update(SexoEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public SexoEntity delete(Long id) {
        SexoEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public SexoEntity enable(Long id) {
        SexoEntity obj = repo.getById(id);
        obj.setEstado(true);
        return repo.save(obj);
    }
}
