package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="servicios")

public class Servicio implements Serializable {

    @Id
    private Long id_servicio;

    @Column
    private String usado_id_vehiculo;
    @Column
    private String cliente_id_persona;
    @Column
    private String tecnico_id_persona;
    @Column
    private Date fechainicio;
    @Column
    private Date fechafinalizacion;
    @Column
    private String tiposervicio;
    @Column
    private double valorservicio;
    @Column
    private String observaciones;

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getUsado_id_vehiculo() {
        return usado_id_vehiculo;
    }

    public void setUsado_id_vehiculo(String usado_id_vehiculo) {
        this.usado_id_vehiculo = usado_id_vehiculo;
    }

    public String getCliente_id_persona() {
        return cliente_id_persona;
    }

    public void setCliente_id_persona(String cliente_id_persona) {
        this.cliente_id_persona = cliente_id_persona;
    }

    public String getTecnico_id_persona() {
        return tecnico_id_persona;
    }

    public void setTecnico_id_persona(String tecnico_id_persona) {
        this.tecnico_id_persona = tecnico_id_persona;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinalizacion() {
        return fechafinalizacion;
    }

    public void setFechafinalizacion(Date fechafinalizacion) {
        this.fechafinalizacion = fechafinalizacion;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public double getValorservicio() {
        return valorservicio;
    }

    public void setValorservicio(double valorservicio) {
        this.valorservicio = valorservicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

