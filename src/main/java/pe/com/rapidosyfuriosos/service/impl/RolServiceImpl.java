// RolServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.RolEntity;
import pe.com.rapidosyfuriosos.repository.RolRepository;
import pe.com.rapidosyfuriosos.service.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository repo;

    @Override
    public List<RolEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public RolEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public RolEntity add(RolEntity obj) {
        return repo.save(obj);
    }

    @Override
    public RolEntity update(RolEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public RolEntity delete(Long id) {
        RolEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public RolEntity enable(Long id) {
        RolEntity obj = repo.getById(id);
        obj.setEstado(!obj.isEstado());
        return repo.save(obj);
    }
}
