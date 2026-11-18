public class Usuario{
    private String Nombre;
    private String Apellido;
    private String Correo;
    private int Telefono;

    public Usuario(String nombre, String apellido, String correo, int telefono){
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.Correo=correo;
        this.Telefono=telefono;
    }

    public String getNombreCompleto() { return Nombre + Apellido; }
    public String getCorreo() { return Correo; }
    public int getTelefono(){return Telefono;}
    public void setNombre(String nombre){this.Nombre = nombre;}


}