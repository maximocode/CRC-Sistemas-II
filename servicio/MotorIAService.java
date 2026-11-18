package servicio;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class MotorIAService {
    private List<CoincidenciaIA> historialCoincidencias = new ArrayList<>();
    private long secuenciaCoincidencia = 1L;
    private static final double UMBRAL_NOTIFICACION = 70.0;

    public List<CoincidenciaIA> buscarCoincidencias(Publicacion nuevaPub, List<Publicacion> todasLasPublicaciones) {
        List<CoincidenciaIA> detectadas = new ArrayList<>();

        for (Publicacion existente : todasLasPublicaciones) {
            if (existente.getEstado() != EstadoPublicacion.ACTIVA) continue;
            if (existente.getTipo() == nuevaPub.getTipo()) continue; // Compara PERDIDO vs ENCONTRADO

            double similitud = calcularSimilitud(nuevaPub, existente);
            if (similitud >= UMBRAL_NOTIFICACION) {
                Publicacion perdida = (nuevaPub.getTipo() == TipoPublicacion.PERDIDO) ? nuevaPub : existente;
                Publicacion encontrada = (nuevaPub.getTipo() == TipoPublicacion.ENCONTRADO) ? nuevaPub : existente;

                CoincidenciaIA match = new CoincidenciaIA(secuenciaCoincidencia++, perdida, encontrada, similitud);
                historialCoincidencias.add(match);
                detectadas.add(match);
                notificarPosibleCoincidencia(match);
            }
        }
        return detectadas;
    }

    private void notificarPosibleCoincidencia(CoincidenciaIA match) {
        match.setNotificada(true);
        System.out.println("[NOTIFICACIÓN IA] ¡Posible coincidencia (" + match.getPorcentajeSimilitud() + "%)! " +
                "Aviso Perdido #" + match.getPublicacionPerdida().getIdPublicacion() +
                " con Aviso Encontrado #" + match.getPublicacionEncontrada().getIdPublicacion() +
                " -> Notificando a: " + match.getPublicacionPerdida().getAutor().getEmail());
    }

    private double calcularSimilitud(Publicacion p1, Publicacion p2) {
        double puntaje = 0.0;
        Animal a1 = p1.getAnimal();
        Animal a2 = p2.getAnimal();

        if (a1.getEspecie().equalsIgnoreCase(a2.getEspecie())) puntaje += 35.0;
        if (a1.getRaza().equalsIgnoreCase(a2.getRaza())) puntaje += 25.0;
        if (a1.getColor().equalsIgnoreCase(a2.getColor())) puntaje += 20.0;
        if (p1.getZonaUbicacion().equalsIgnoreCase(p2.getZonaUbicacion())) puntaje += 20.0;

        return puntaje;
    }
}