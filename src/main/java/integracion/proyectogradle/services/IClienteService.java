package integracion.proyectogradle.services;
import integracion.proyectogradle.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> findAll();

    public Optional<Cliente> findById(Long id);

    public void delete(Long id);

    public Cliente save(Cliente a);

}