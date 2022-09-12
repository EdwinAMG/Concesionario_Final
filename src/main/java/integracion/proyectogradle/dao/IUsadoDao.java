package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Usado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsadoDao extends JpaRepository<Usado,Long> {
}

