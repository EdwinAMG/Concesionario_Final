package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Usado;

import java.util.List;
import java.util.Optional;

public interface IUsadoService {
    public List<Usado> findAll();

    public Optional<Usado> findById(Long id);

    public void delete(Long id);

    public Usado save(Usado u);

}
