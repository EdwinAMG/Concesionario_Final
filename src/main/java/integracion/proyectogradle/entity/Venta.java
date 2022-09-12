package integracion.proyectogradle.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ventas")

public class Venta implements Serializable {

    @Id
    private Long id_venta;

    @Column
    private String asesor_id_persona;
    @Column
    private String cliente_id_persona;
    @Column
    private String nuevo_id_vehiculo;
    @Column
    private Date fecha;
    @Column
    private String tipotransaccion;
    @Column
    private int cuotas;
    @Column
    private double valor;
    @Column
    private String estado;

    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public String getAsesor_id_persona() {
        return asesor_id_persona;
    }

    public void setAsesor_id_persona(String asesor_id_persona) {
        this.asesor_id_persona = asesor_id_persona;
    }

    public String getCliente_id_persona() {
        return cliente_id_persona;
    }

    public void setCliente_id_persona(String cliente_id_persona) {
        this.cliente_id_persona = cliente_id_persona;
    }

    public String getNuevo_id_vehiculo() {
        return nuevo_id_vehiculo;
    }

    public void setNuevo_id_vehiculo(String nuevo_id_vehiculo) {
        this.nuevo_id_vehiculo = nuevo_id_vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

