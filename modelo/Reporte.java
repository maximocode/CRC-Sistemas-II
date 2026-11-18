package modelo;

import java.time.LocalDateTime;

public class Reporte {
    private Long idReporte;
    private MotivoReporte motivo;
    private String comentario;
    private LocalDateTime fechaReporte;
    private Usuario denunciante;
    private Publicacion publicacionReportada;

    public Reporte(Long idReporte, MotivoReporte motivo, String comentario, 
                   Usuario denunciante, Publicacion publicacionReportada) {
        this.idReporte = idReporte;
        this.motivo = motivo;
        this.comentario = comentario;
        this.fechaReporte = LocalDateTime.now();
        this.denunciante = denunciante;
        this.publicacionReportada = publicacionReportada;
    }

    public Long getIdReporte() { return idReporte; }
    public MotivoReporte getMotivo() { return motivo; }
    public String getComentario() { return comentario; }
    public LocalDateTime getFechaReporte() { return fechaReporte; }
    public Usuario getDenunciante() { return denunciante; }
    public Publicacion getPublicacionReportada() { return publicacionReportada; }
}