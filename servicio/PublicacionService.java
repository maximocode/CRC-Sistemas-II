package servicio;

import modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PublicacionService {
    private List<Publicacion> publicaciones = new ArrayList<>();
    private MotorIAService motorIA;
    private long secPublicacion = 1L;
    private long secAnimal = 1L;
    private long secReporte = 1L;

    public PublicacionService(MotorIAService motorIA) {
        this.motorIA = motorIA;
    }

    public Publicacion publicarAnimal(Usuario autor, TipoPublicacion tipo, String zona, LocalDate fechaSuceso,
                                      String descripcion, String nombreAnimal, String especie, String raza,
                                      String color, String tamanio, String sexo, String senias, String urlFoto) {
        if (autor == null || !autor.isSesionIniciada()) {
            throw new SecurityException("Debe iniciar sesión para publicar un aviso.");
        }

        Animal animal = new Animal(secAnimal++, nombreAnimal, especie, raza, color, tamanio, sexo, senias, urlFoto);

        Publicacion nueva = new Publicacion(secPublicacion++, tipo, zona, fechaSuceso, descripcion, autor, animal);
        autor.agregarPublicacion(nueva);
        publicaciones.add(nueva);

        motorIA.buscarCoincidencias(nueva, publicaciones);

        return nueva;
    }

    public List<Publicacion> buscarPublicaciones(TipoPublicacion tipo, String especie, String zona) {
        return publicaciones.stream()
                .filter(p -> p.getEstado() == EstadoPublicacion.ACTIVA)
                .filter(p -> tipo == null || p.getTipo() == tipo)
                .filter(p -> especie == null || especie.isBlank() || p.getAnimal().getEspecie().equalsIgnoreCase(especie))
                .filter(p -> zona == null || zona.isBlank() || p.getZonaUbicacion().toLowerCase().contains(zona.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Publicacion> obtenerDetallePorId(Long idPublicacion) {
        return publicaciones.stream()
                .filter(p -> p.getIdPublicacion().equals(idPublicacion))
                .findFirst();
    }

    public Reporte reportarPublicacion(Usuario denunciante, Long idPublicacion, MotivoReporte motivo, String comentario) {
        if (denunciante == null || !denunciante.isSesionIniciada()) {
            throw new SecurityException("Debe iniciar sesión para reportar una publicación.");
        }
        Publicacion pub = obtenerDetallePorId(idPublicacion)
                .orElseThrow(() -> new IllegalArgumentException("Publicación no encontrada."));

        Reporte reporte = new Reporte(secReporte++, motivo, comentario, denunciante, pub);
        pub.registrarReporte(reporte);
        return reporte;
    }
}