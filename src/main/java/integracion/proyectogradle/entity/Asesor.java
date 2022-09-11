package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="asesores")

public class Asesor implements Serializable {

    @Id
    private Long id_persona;

    @Column
    private double comision;
    @Column
    private double salario;
    @Column
    private byte gestionesactivas;
    @Column
    private byte gestionescompletadas;

    public Long getId_persona() {
        return id_persona;
    }
    public void setId_persona(Long id) {
        this.id_persona = id;
    }
    public double getComision() {
        return comision;
    }
    public void setComision(double comision) {
        this.comision = comision;
    }
    public byte getGestionesactivas() {
        return gestionesactivas;
    }
    public void setGestionesactivas(byte gestionesactivas) {
        this.gestionesactivas = gestionesactivas;
    }
    public byte getGestionescompletadas() {
        return gestionescompletadas;
    }
    public void setGestionescompletadas(byte gestionescompletadas) {
        this.gestionescompletadas = gestionescompletadas;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

}

