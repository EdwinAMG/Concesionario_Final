package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {
    public List<Vehiculo> findAll();

    public Optional<Vehiculo> findById(Long id);

    public void delete(Long id);

    public Vehiculo save(Vehiculo v);
}
