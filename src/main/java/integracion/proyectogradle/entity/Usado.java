package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usados")

public class Usado implements Serializable {

    @Id
    private Long id_vehiculo;

    @Column
    private double kilometraje;
    @Column
    private double valorrenta;
    @Column
    private String estado;

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public double getValorrenta() {
        return valorrenta;
    }

    public void setValorrenta(double valorrenta) {
        this.valorrenta = valorrenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

