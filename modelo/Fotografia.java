package modelo;

public class Fotografia {
    private Long idFotografia;
    private String archivoImagen;
    private String estadoValidez;
    private String patronVisualVector;

    public Fotografia(String archivoImagen, String patronVisualVector) {
        this.archivoImagen = archivoImagen;
        this.patronVisualVector = patronVisualVector;
        this.estadoValidez = "VALIDA";
    }

    public String mostrarAspectoReal() { return archivoImagen; }
    public String suministrarPatronAIA() { return patronVisualVector; }
}
