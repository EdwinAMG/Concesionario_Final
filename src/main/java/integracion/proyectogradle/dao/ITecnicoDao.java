package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITecnicoDao extends JpaRepository<Tecnico,Long> {
}
