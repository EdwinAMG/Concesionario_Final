package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Servicio;

import java.util.List;
import java.util.Optional;

public interface IServicioService {
    public List<Servicio> findAll();

    public Optional<Servicio> findById(Long id);

    public void delete(Long id);

    public Servicio save(Servicio a);

}
