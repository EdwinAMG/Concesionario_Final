package integracion.proyectogradle.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    @Id
    private Long id_persona;

    @Column
    private double compras;
    @Column
    private double tipo;

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public double getCompras() {
        return compras;
    }

    public void setCompras(double compras) {
        this.compras = compras;
    }
    public double getTipo() {
        return compras;
    }
    public void setTipo(double tipo) {
        this.tipo = tipo;
    }
}

