package modelo;

import java.time.LocalDateTime;

public class CoincidenciaIA {
    private Long idCoincidencia;
    private Publicacion publicacionPerdida;
    private Publicacion publicacionEncontrada;
    private double porcentajeSimilitud;
    private LocalDateTime fechaDeteccion;
    private boolean notificada;

    public CoincidenciaIA(Long idCoincidencia, Publicacion publicacionPerdida, 
                          Publicacion publicacionEncontrada, double porcentajeSimilitud) {
        this.idCoincidencia = idCoincidencia;
        this.publicacionPerdida = publicacionPerdida;
        this.publicacionEncontrada = publicacionEncontrada;
        this.porcentajeSimilitud = porcentajeSimilitud;
        this.fechaDeteccion = LocalDateTime.now();
        this.notificada = false;
    }

    public Long getIdCoincidencia() { return idCoincidencia; }
    public Publicacion getPublicacionPerdida() { return publicacionPerdida; }
    public Publicacion getPublicacionEncontrada() { return publicacionEncontrada; }
    public double getPorcentajeSimilitud() { return porcentajeSimilitud; }
    public boolean isNotificada() { return notificada; }
    public void setNotificada(boolean notificada) { this.notificada = notificada; }
}