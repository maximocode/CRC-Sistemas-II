package modelo;
import java.time.LocalDateTime;

public class PublicacionEncontrado extends Publicacion {
    private LocalDateTime fechaHoraHallazgo;

    public PublicacionEncontrado(Usuario autor, Mascota mascota, Ubicacion ubicacion, LocalDateTime fechaHoraHallazgo) {
        super(autor, mascota, ubicacion);
        this.fechaHoraHallazgo = fechaHoraHallazgo;
    }

    public void notificarHallazgo() {
        System.out.println("Hallazgo publicado para: " + mascota.getEspecie());
    }

    @Override
    public String getTipoPublicacion() { return "ENCONTRADO"; }
    public LocalDateTime getFechaHoraHallazgo() { return fechaHoraHallazgo; }
}