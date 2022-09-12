package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IServicioDao;
import integracion.proyectogradle.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements IServicioService{

    @Autowired
    private IServicioDao servicioDao;

    @Override
    public List<Servicio> findAll() {
        return servicioDao.findAll();
    }

    @Override
    public Optional<Servicio> findById(Long id) {
        return servicioDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        servicioDao.deleteById(id);
    }

    @Override
    public Servicio save(Servicio s) {
        return servicioDao.save(s);
    }

}

