package pe.isil.itam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_activo")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private int idEstado;
    @Column(name = "nombre", unique = true)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    public Estado() {
    }

    public int getId() {
        return idEstado;
    }

    public void setId(int id) {
        this.idEstado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
