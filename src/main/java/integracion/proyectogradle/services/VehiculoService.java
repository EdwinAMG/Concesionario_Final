package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IVehiculoDao;
import integracion.proyectogradle.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    private IVehiculoDao vehiculoDao;

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoDao.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Long id) {
        return vehiculoDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        vehiculoDao.deleteById(id);
    }

    @Override
    public Vehiculo save(Vehiculo v) {
        return vehiculoDao.save(v);
    }

}

