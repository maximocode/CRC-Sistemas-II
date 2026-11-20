package modelo;

import java.time.LocalDateTime;

public class Reporte {
    private Long idReporte;
    private Usuario denunciante;
    private Publicacion publicacionReportada;
    private String motivo;
    private String descripcionAdicional;
    private LocalDateTime fecha;
    private String estado;

    public Reporte(Usuario denunciante, Publicacion publicacionReportada, String motivo, String descripcionAdicional) {
        this.denunciante = denunciante;
        this.publicacionReportada = publicacionReportada;
        this.motivo = motivo;
        this.descripcionAdicional = descripcionAdicional;
        this.fecha = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }
}