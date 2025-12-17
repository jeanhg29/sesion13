package pe.isil.itam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "codigo", unique = true, nullable = false, length = 8)
    private String codigo;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Column(name = "area", length = 50)
    private String area;
    @Column(name = "contrasena", nullable = false, length = 100)
    private String contrasena;
    @Column(name = "estado_activo", nullable = false)
    private boolean activo;

    public Usuario () {
    }

    public Usuario (String codigo, String nombre, String apellido, String area , String contrasena, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
        this.contrasena = contrasena;
        this.activo = activo;
    }

    public Usuario (int idUsuario, String codigo, String nombre, String apellido, String area , String contrasena, boolean activo) {
        this.idUsuario = idUsuario;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
        this.contrasena = contrasena;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
