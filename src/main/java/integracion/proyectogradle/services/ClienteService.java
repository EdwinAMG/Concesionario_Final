package integracion.proyectogradle.services;

import integracion.proyectogradle.dao.IClienteDao;
import integracion.proyectogradle.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public Cliente save(Cliente a) {
        return clienteDao.save(a);
    }

}