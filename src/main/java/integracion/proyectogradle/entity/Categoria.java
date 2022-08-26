package integracion.proyectogradle.entity;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoria_id")
    private Long id;

    @Column
    //@OneToMany(targetEntity = ) --> Relación de 1
    private String descripcion;
    @Column
    private Boolean estado; //nunca se eliminan los registros de la bases de datos, se cambia el estado.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
