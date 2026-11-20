package modelo;

public class Ubicacion {
    private Long idUbicacion;
    private String zonaGeograficaBarrio;
    private String direccionReferencia;
    private String coordenadas;

    public Ubicacion(String zonaGeograficaBarrio, String direccionReferencia, String coordenadas) {
        this.zonaGeograficaBarrio = zonaGeograficaBarrio;
        this.direccionReferencia = direccionReferencia;
        this.coordenadas = coordenadas;
    }

    public String especificarPuntoGeografico() {
        return zonaGeograficaBarrio + " (" + coordenadas + ")";
    }

    public String getZonaGeograficaBarrio() { return zonaGeograficaBarrio; }
}
