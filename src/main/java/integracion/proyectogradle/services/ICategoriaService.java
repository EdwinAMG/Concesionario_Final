package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    public List<Categoria> findAll();

    public Optional<Categoria> findById(Long id);

    public void delete(Long id);

    public Categoria save(Categoria c);



}
