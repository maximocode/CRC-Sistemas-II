package modelo;
import java.time.LocalDateTime;

public class Notificacion {
    private Long idNotificacion;
    private CoincidenciaIA coincidencia;
    private Usuario destinatario;
    private String mensaje;
    private LocalDateTime fechaHora;
    private String canalEnvio;
    private boolean estadoLeida;

    public Notificacion(CoincidenciaIA coincidencia, Usuario destinatario, String mensaje, String canalEnvio) {
        this.coincidencia = coincidencia;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.canalEnvio = canalEnvio;
        this.fechaHora = LocalDateTime.now();
        this.estadoLeida = false;
    }

    public void avisarAlUsuario() {
        System.out.println("Enviando alerta a " + destinatario.getCorreoElectronico() + ": " + mensaje);
    }
}
