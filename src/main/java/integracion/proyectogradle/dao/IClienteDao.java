package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente,Long> {
}
