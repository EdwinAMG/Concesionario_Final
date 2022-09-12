package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tecnicos")

public class Tecnico implements Serializable {

    @Id
    private Long id_persona;
    @Column
    private String especialidad;
    @Column
    private int experiencia;
    @Column
    private double salario;
    @Column
    private byte vehiculosreparados;

    public Long getId_persona() {
        return id_persona;
    }
    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public byte getVehiculosreparados() {
        return vehiculosreparados;
    }
    public void setVehiculosreparados(byte vehiculosreparados) {
        this.vehiculosreparados = vehiculosreparados;
    }
}
