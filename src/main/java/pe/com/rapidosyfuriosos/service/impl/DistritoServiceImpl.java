// DistritoServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.DistritoEntity;
import pe.com.rapidosyfuriosos.repository.DistritoRepository;
import pe.com.rapidosyfuriosos.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository repo;

    @Override
    public List<DistritoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public DistritoEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public DistritoEntity add(DistritoEntity obj) {
        return repo.save(obj);
    }

    @Override
    public DistritoEntity update(DistritoEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public DistritoEntity delete(Long id) {
        DistritoEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public DistritoEntity enable(Long id) {
        DistritoEntity obj = repo.getById(id);
        obj.setEstado(true);
        return repo.save(obj);
    }
}
