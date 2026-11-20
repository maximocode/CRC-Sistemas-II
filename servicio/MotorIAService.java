package servicio;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class MotorIAService {
    private static final double UMBRAL_SIMILITUD = 70.0;

    public List<CoincidenciaIA> buscarCoincidencias(PublicacionPerdido perdida, List<PublicacionEncontrado> encontradas) {
        List<CoincidenciaIA> resultados = new ArrayList<>();

        for (PublicacionEncontrado enc : encontradas) {
            double similitud = calcularSimilitud(perdida, enc);
            CoincidenciaIA coincidencia = new CoincidenciaIA(perdida, enc, similitud);

            if (coincidencia.evaluarUmbral(UMBRAL_SIMILITUD)) {
                Notificacion alerta = coincidencia.desencadenarAlertas();
                alerta.avisarAlUsuario();
                resultados.add(coincidencia);
            }
        }
        return resultados;
    }

    private double calcularSimilitud(PublicacionPerdido p, PublicacionEncontrado e) {
        double puntos = 0.0;
        if (p.getMascota().getEspecie().equalsIgnoreCase(e.getMascota().getEspecie())) puntos += 30.0;
        if (p.getMascota().getRaza().equalsIgnoreCase(e.getMascota().getRaza())) puntos += 25.0;
        if (p.getMascota().getTamano().equalsIgnoreCase(e.getMascota().getTamano())) puntos += 15.0;
        if (p.getUbicacion().getZonaGeograficaBarrio().equalsIgnoreCase(e.getUbicacion().getZonaGeograficaBarrio())) puntos += 30.0;
        return puntos;
    }
}