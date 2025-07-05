// VehiculoServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.VehiculoEntity;
import pe.com.rapidosyfuriosos.repository.VehiculoRepository;
import pe.com.rapidosyfuriosos.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository repo;

    @Override
    public List<VehiculoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<VehiculoEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public VehiculoEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public VehiculoEntity add(VehiculoEntity obj) {
        return repo.save(obj);
    }

    @Override
    public VehiculoEntity update(VehiculoEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public VehiculoEntity delete(Long id) {
        VehiculoEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public VehiculoEntity enable(Long id) {
        VehiculoEntity obj = repo.getById(id);
        obj.setEstado(!obj.isEstado());
        return repo.save(obj);
    }
}
