package modelo;
import java.time.LocalDateTime;

public class PublicacionPerdido extends Publicacion {
    private LocalDateTime fechaHoraExtravio;

    public PublicacionPerdido(Usuario autor, Mascota mascota, Ubicacion ubicacion, LocalDateTime fechaHoraExtravio) {
        super(autor, mascota, ubicacion);
        this.fechaHoraExtravio = fechaHoraExtravio;
    }

    public void notificarBusqueda() {
        System.out.println("Búsqueda activa publicada para: " + mascota.getEspecie());
    }

    @Override
    public String getTipoPublicacion() { return "PERDIDO"; }
    public LocalDateTime getFechaHoraExtravio() { return fechaHoraExtravio; }
}