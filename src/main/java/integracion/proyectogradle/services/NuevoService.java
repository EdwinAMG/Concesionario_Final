package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.INuevoDao;
import integracion.proyectogradle.entity.Nuevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NuevoService implements INuevoService{

    @Autowired
    private INuevoDao nuevoDao;

    @Override
    public List<Nuevo> findAll() {
        return nuevoDao.findAll();
    }

    @Override
    public Optional<Nuevo> findById(Long id) {
        return nuevoDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        nuevoDao.deleteById(id);
    }

    @Override
    public Nuevo save(Nuevo n) {
        return nuevoDao.save(n);
    }

}

