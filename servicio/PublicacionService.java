package servicio;

import modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import integracion.PublicacionDAO;

public class PublicacionService {
    private final PublicacionDAO publicacionDAO;
    private final MotorIAService motorIAService;

    public PublicacionService(PublicacionDAO publicacionDAO, MotorIAService motorIAService) {
        this.publicacionDAO = publicacionDAO;
        this.motorIAService = motorIAService;
    }

    public Publicacion publicarAnimal(Publicacion nuevaPublicacion, List<PublicacionEncontrado> encontradasActivas) {
        nuevaPublicacion.registrarAviso();
        publicacionDAO.create(nuevaPublicacion);

        if (nuevaPublicacion instanceof PublicacionPerdido) {
            motorIAService.buscarCoincidencias((PublicacionPerdido) nuevaPublicacion, encontradasActivas);
        }
        return nuevaPublicacion;
    }
}