package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Nuevo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INuevoDao extends JpaRepository<Nuevo,Long> {
}

