import java.util.ArrayList;
import java.util.List;

public class Usuario{
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String contraseña;
    private int Telefono;
    private boolean autenticado;
    private List<Aviso> avisosPublicados;

    public Usuario(String nombre, String apellido, String correo, String contraseña,int telefono){
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.Correo=correo;
        this.contraseña=contraseña;
        this.Telefono=telefono;
        this.autenticado = false;
        this.avisosPublicados = new ArrayList<>();
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        if (this.Correo.equalsIgnoreCase(correo) && this.contraseña.equals(contraseña)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    public void cerrarSesion() {
        this.autenticado = false;
    }

    public void agregarAviso(Aviso aviso) {
        if (aviso != null && !avisosPublicados.contains(aviso)) {
            avisosPublicados.add(aviso);
        }
    }

    public String getNombreCompleto() { return Nombre + Apellido; }
    public String getCorreo() { return Correo; }
    public int getTelefono(){return Telefono;}
    public void setTelefono(int telefono) { this.Telefono = telefono; }
    public void setNombre(String nombre){this.Nombre = nombre;}
    public boolean isAutenticado() { return autenticado; }
    public List<Aviso> getAvisosPublicados() { return avisosPublicados; }


}