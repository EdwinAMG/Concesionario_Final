package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IUsadoDao;
import integracion.proyectogradle.entity.Usado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsadoService implements IUsadoService{

    @Autowired
    private IUsadoDao usadoDao;

    @Override
    public List<Usado> findAll() {
        return usadoDao.findAll();
    }

    @Override
    public Optional<Usado> findById(Long id) {
        return usadoDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        usadoDao.deleteById(id);
    }

    @Override
    public Usado save(Usado u) {
        return usadoDao.save(u);
    }

}

