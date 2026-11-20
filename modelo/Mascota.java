package modelo;

public class Mascota {
    private Long idMascota;
    private String especie;
    private String raza;
    private String tamano;
    private String edadAproximada;
    private String descripcionFisica;

    public Mascota(String especie, String raza, String tamano, String edadAproximada, String descripcionFisica) {
        this.especie = especie;
        this.raza = raza;
        this.tamano = tamano;
        this.edadAproximada = edadAproximada;
        this.descripcionFisica = descripcionFisica;
    }

    public String proveerDatosDescriptivos() {
        return especie + " (" + raza + "), tamaño " + tamano + " - " + descripcionFisica;
    }

    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public String getTamano() { return tamano; }
}