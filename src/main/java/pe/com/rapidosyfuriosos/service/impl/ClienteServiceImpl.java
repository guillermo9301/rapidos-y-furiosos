// ClienteServiceImpl.java
package pe.com.rapidosyfuriosos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.rapidosyfuriosos.entity.ClienteEntity;
import pe.com.rapidosyfuriosos.repository.ClienteRepository;
import pe.com.rapidosyfuriosos.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public List<ClienteEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return repo.findAllCustom();
    }

    @Override
    public ClienteEntity findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public ClienteEntity add(ClienteEntity obj) {
        return repo.save(obj);
    }

    @Override
    public ClienteEntity update(ClienteEntity obj, Long id) {
        obj.setCodigo(id);
        return repo.save(obj);
    }

    @Override
    public ClienteEntity delete(Long id) {
        ClienteEntity obj = repo.getById(id);
        obj.setEstado(false);
        return repo.save(obj);
    }

    @Override
    public ClienteEntity enable(Long id) {
        ClienteEntity obj = repo.getById(id);
        obj.setEstado(!obj.isEstado());
        return repo.save(obj);
    }
}
