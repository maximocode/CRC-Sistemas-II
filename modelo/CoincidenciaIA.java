package modelo;

import java.time.LocalDateTime;

 public class CoincidenciaIA {
    private Long idCoincidencia;
    private PublicacionPerdido publicacionPerdida;
    private PublicacionEncontrado publicacionEncontrada;
    private double porcentajeSimilitud;
    private LocalDateTime fechaCotejo;
    private String estadoNotificacion;

    public CoincidenciaIA(PublicacionPerdido perdida, PublicacionEncontrado encontrada, double porcentajeSimilitud) {
        this.publicacionPerdida = perdida;
        this.publicacionEncontrada = encontrada;
        this.porcentajeSimilitud = porcentajeSimilitud;
        this.fechaCotejo = LocalDateTime.now();
        this.estadoNotificacion = "PENDIENTE";
    }

    public boolean evaluarUmbral(double umbralMinimo) {
        return this.porcentajeSimilitud >= umbralMinimo;
    }

    public Notificacion desencadenarAlertas() {
        this.estadoNotificacion = "NOTIFICADA";
        String msg = "¡Posible coincidencia (" + porcentajeSimilitud + "%) detectada para tu mascota!";
        return new Notificacion(this, publicacionPerdida.getAutor(), msg, "EMAIL_Y_APP");
    }
}