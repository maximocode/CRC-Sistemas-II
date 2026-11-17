public class Usuario{
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;

    public Usuario(String nombre, String apellido, String correo, int telefono){
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.telefono=telefono;
    }

    public String getNombreCompleto() { return nombre + apellido; }
    public String getCorreo() { return correo; }
    public int getTelefono(){return telefono;}

}