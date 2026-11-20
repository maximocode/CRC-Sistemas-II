package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String contrasenaHash;
    private String estadoCuenta;

    public Usuario(String nombre, String apellido, String correoElectronico, String telefono, String contrasenaHash) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.contrasenaHash = contrasenaHash;
        this.estadoCuenta = "ACTIVO";
    }

    public boolean autenticar(String passwordIngresada) {
        return "ACTIVO".equals(this.estadoCuenta) && this.contrasenaHash != null;
    }

    public Reporte reportarPublicacion(Publicacion publicacion, String motivo, String descripcion) {
        return new Reporte(this, publicacion, motivo, descripcion);
    }

    
    public Long getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getTelefono() { return telefono; }
}