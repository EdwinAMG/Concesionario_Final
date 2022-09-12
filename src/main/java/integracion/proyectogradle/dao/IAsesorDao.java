package integracion.proyectogradle.dao;

import integracion.proyectogradle.entity.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface IAsesorDao extends JpaRepository<Asesor,Long> {
}

