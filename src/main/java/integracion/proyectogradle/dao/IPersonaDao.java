package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona,Long> {
}

