package modelo;

public class Animal {
    private Long idAnimal;
    private String nombre; // Puede ser "Desconocido" si fue encontrado
    private String especie; 
    private String raza;
    private String color;
    private String tamanio; 
    private String sexo;
    private String seniasParticulares;
    private String urlFoto;

    public Animal(Long idAnimal, String nombre, String especie, String raza, 
                  String color, String tamanio, String sexo, String seniasParticulares, String urlFoto) {
        this.idAnimal = idAnimal;
        this.nombre = (nombre == null || nombre.isBlank()) ? "Sin nombre" : nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.tamanio = tamanio;
        this.sexo = sexo;
        this.seniasParticulares = seniasParticulares;
        this.urlFoto = urlFoto;
    }

    
    public Long getIdAnimal() { return idAnimal; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public String getColor() { return color; }
    public String getTamanio() { return tamanio; }
    public String getSexo() { return sexo; }
    public String getSeniasParticulares() { return seniasParticulares; }
    public String getUrlFoto() { return urlFoto; }
}
