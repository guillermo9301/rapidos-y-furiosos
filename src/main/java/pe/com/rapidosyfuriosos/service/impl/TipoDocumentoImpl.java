// TipoDocumentoImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.TipoDocumentoEntity;
import pe.com.rapidosyfuriosos.repository.TipoDocumentoRepository;
import pe.com.rapidosyfuriosos.service.TipoDocumentoService;

@Service
public class TipoDocumentoImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository repo;

    @Override
    public List<TipoDocumentoEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<TipoDocumentoEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public TipoDocumentoEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public TipoDocumentoEntity add(TipoDocumentoEntity obj) {
        return repo.save(obj);
    }

    @Override
    public TipoDocumentoEntity update(TipoDocumentoEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public TipoDocumentoEntity delete(Long id) {
        TipoDocumentoEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public TipoDocumentoEntity enable(Long id) {
        TipoDocumentoEntity obj = repo.getById(id);
        obj.setEstado(true);
        return repo.save(obj);
    }
}
