package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaDao extends JpaRepository<Venta,Long> {
}

