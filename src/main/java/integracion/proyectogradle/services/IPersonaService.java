package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> findAll();

    public Optional<Persona> findById(Long id);

    public void delete(Long id);

    public Persona save(Persona p);

}
