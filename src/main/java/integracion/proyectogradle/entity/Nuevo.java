package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="nuevos")

public class Nuevo implements Serializable {

    @Id
    private Long id_vehiculo;

    @Column
    private String color;
    @Column
    private String procedencia;
    @Column
    private String propietario;
    @Column
    private double valorventa;
    @Column
    private String garantia;

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public double getValorventa() {
        return valorventa;
    }

    public void setValorventa(double valorventa) {
        this.valorventa = valorventa;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
}

