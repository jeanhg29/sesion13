package pe.isil.itam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activos")
public class Activo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activo")
    private int idActivo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "numero_serie")
    private String numSerie;
    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; //puede ser nulo

    public Activo() {

    }

    public Activo(int id_activo, String nombre, String tipo, String marca, String modelo, String numero_serie, Estado estado,
                  Usuario usuario) {
        this.idActivo = id_activo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numero_serie;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Activo(int id_activo, String nombre, String tipo, String marca, String modelo, String numero_serie, Estado estado) {
        this.idActivo = id_activo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numero_serie;
        this.estado = estado;

    }

    public Activo(String nombre, String tipo, String marca, String modelo, String numero_serie, Estado estado, Usuario usuario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numero_serie;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(int idActivo) {
        this.idActivo = idActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

