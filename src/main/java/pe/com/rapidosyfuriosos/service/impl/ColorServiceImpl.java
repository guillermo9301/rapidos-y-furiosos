// ColorServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.ColorEntity;
import pe.com.rapidosyfuriosos.repository.ColorRepository;
import pe.com.rapidosyfuriosos.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository repo;

    @Override
    public List<ColorEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ColorEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public ColorEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ColorEntity add(ColorEntity obj) {
        return repo.save(obj);
    }

    @Override
    public ColorEntity update(ColorEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public ColorEntity delete(Long id) {
        ColorEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public ColorEntity enable(Long id) {
        ColorEntity obj = repo.getById(id);
        obj.setEstado(!obj.isEstado());
        return repo.save(obj);
    }
}
