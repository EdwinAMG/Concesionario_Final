package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IVentaDao;
import integracion.proyectogradle.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaDao ventaDao;

    @Override
    public List<Venta> findAll() {
        return ventaDao.findAll();
    }

    @Override
    public Optional<Venta> findById(Long id) {
        return ventaDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        ventaDao.deleteById(id);
    }

    @Override
    public Venta save(Venta v) {
        return ventaDao.save(v);
    }

}

