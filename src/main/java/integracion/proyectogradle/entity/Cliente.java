package integracion.proyectogradle.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    @Id
    private Long id_persona;

    @Column
    private int compras;
    @Column
    private String tipo;

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

