package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentaService {
    public List<Venta> findAll();

    public Optional<Venta> findById(Long id);

    public void delete(Long id);

    public Venta save(Venta a);

}
