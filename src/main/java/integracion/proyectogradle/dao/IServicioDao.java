package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioDao extends JpaRepository<Servicio,Long> {
}

