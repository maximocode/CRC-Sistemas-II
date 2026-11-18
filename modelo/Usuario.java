package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String passwordHash;
    private ProveedorAuth proveedorAuth;
    private String estadoCuenta; // "ACTIVO", "INACTIVO"
    private boolean sesionIniciada;
    private List<Publicacion> publicaciones;

    public Usuario(Long idUsuario, String nombre, String apellido, String email, 
                   String telefono, String passwordHash, ProveedorAuth proveedorAuth) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.passwordHash = passwordHash;
        this.proveedorAuth = proveedorAuth;
        this.estadoCuenta = "ACTIVO"; // Paso 5 flujo Registrarse
        this.sesionIniciada = false;
        this.publicaciones = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion pub) {
        if (pub != null && !publicaciones.contains(pub)) {
            publicaciones.add(pub);
        }
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Accessors y Mutators
    public Long getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getPasswordHash() { return passwordHash; }
    public ProveedorAuth getProveedorAuth() { return proveedorAuth; }
    public String getEstadoCuenta() { return estadoCuenta; }
    public void setEstadoCuenta(String estadoCuenta) { this.estadoCuenta = estadoCuenta; }
    public boolean isSesionIniciada() { return sesionIniciada; }
    public void setSesionIniciada(boolean sesionIniciada) { this.sesionIniciada = sesionIniciada; }
    public List<Publicacion> getPublicaciones() { return publicaciones; }
}