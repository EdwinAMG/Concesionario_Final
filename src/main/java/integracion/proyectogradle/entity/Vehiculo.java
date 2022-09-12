package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="vehiculos")

public class Vehiculo implements Serializable {
    @Id
    private Long id_vehiculo;
    @Column
    private String matricula;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private String vehiculo_type;

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVehiculo_type() {
        return vehiculo_type;
    }

    public void setVehiculo_type(String vehiculo_type) {
        this.vehiculo_type = vehiculo_type;
    }
}

