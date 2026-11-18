public class Mascota {
    private int idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    private String tamaño;
    private String descripcion;
    private String urlFoto;
    private estadoMascota estado;

    public Mascota(int idMascota, String nombre, String especie, String raza, 
                   String color, String descripcion, String urlFoto, estadoMascota estado) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.estado = estado;
    }

    public String getIdMascota() { return idMascota; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public String getColor() { return color; }
    public String getDescripcion() { return descripcion; }
    public String getUrlFoto() { return urlFoto; }
    public estadoMascota getEstado() { return estado; }
    public void setEstado(estadoMascota estado) { this.estado = estado; }



}
