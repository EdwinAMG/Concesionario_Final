package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Tecnico;

import java.util.List;
import java.util.Optional;

public interface ITecnicoService {
    public List<Tecnico> findAll();

    public Optional<Tecnico> findById(Long id);

    public void delete(Long id);

    public Tecnico save(Tecnico t);


}
