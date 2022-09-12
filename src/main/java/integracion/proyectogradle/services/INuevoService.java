package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Nuevo;

import java.util.List;
import java.util.Optional;

public interface INuevoService {
    public List<Nuevo> findAll();

    public Optional<Nuevo> findById(Long id);

    public void delete(Long id);

    public Nuevo save(Nuevo n);

}
