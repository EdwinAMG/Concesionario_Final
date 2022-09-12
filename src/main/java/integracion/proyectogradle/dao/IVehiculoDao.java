package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculoDao extends JpaRepository<Vehiculo,Long> {
}

