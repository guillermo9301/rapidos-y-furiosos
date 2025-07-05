// MarcaServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.MarcaEntity;
import pe.com.rapidosyfuriosos.repository.MarcaRepository;
import pe.com.rapidosyfuriosos.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository repo;

    @Override
    public List<MarcaEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<MarcaEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public MarcaEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public MarcaEntity add(MarcaEntity obj) {
        return repo.save(obj);
    }

    @Override
    public MarcaEntity update(MarcaEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public MarcaEntity delete(Long id) {
        MarcaEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public MarcaEntity enable(Long id) {
        MarcaEntity obj = repo.getById(id);
        obj.setEstado(!obj.isEstado());
        return repo.save(obj);
    }
}
