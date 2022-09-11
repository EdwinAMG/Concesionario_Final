package integracion.proyectogradle.services;

import integracion.proyectogradle.entity.Asesor;

import java.util.List;
import java.util.Optional;

public interface IAsesorService {
    public List<Asesor> findAll();

    public Optional<Asesor> findById(Long id);

    public void delete(Long id);

    public Asesor save(Asesor a);

}
