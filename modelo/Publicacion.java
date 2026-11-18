package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private Long idPublicacion;
    private TipoPublicacion tipo;
    private EstadoPublicacion estado;
    private String zonaUbicacion;
    private LocalDate fechaSuceso;
    private LocalDateTime fechaCreacion;
    private String descripcion;
    private Usuario autor;
    private Animal animal;
    private List<Reporte> reportes;

    public Publicacion(Long idPublicacion, TipoPublicacion tipo, String zonaUbicacion, 
                       LocalDate fechaSuceso, String descripcion, Usuario autor, Animal animal) {
        this.idPublicacion = idPublicacion;
        this.tipo = tipo;
        this.estado = EstadoPublicacion.ACTIVA;
        this.zonaUbicacion = zonaUbicacion;
        this.fechaSuceso = fechaSuceso;
        this.fechaCreacion = LocalDateTime.now();
        this.descripcion = descripcion;
        this.autor = autor;
        this.animal = animal;
        this.reportes = new ArrayList<>();
    }

    
    public String consultarDatosContacto(Usuario usuarioVisitante) {
        if (usuarioVisitante != null && usuarioVisitante.isSesionIniciada()) {
            return "Publicador: " + autor.getNombreCompleto() +
                   " | Teléfono: " + autor.getTelefono() +
                   " | Correo: " + autor.getEmail();
        }
        return "[Acceso restringido] Inicia sesión en PetFinder para ver los datos de contacto.";
    }

    public void registrarReporte(Reporte reporte) {
        this.reportes.add(reporte);
        if (this.reportes.size() >= 3) {
            this.estado = EstadoPublicacion.OCULTA_POR_REPORTE;
        }
    }

    public void marcarComoReunida() {
        this.estado = EstadoPublicacion.CERRADA;
    }

    
    public Long getIdPublicacion() { return idPublicacion; }
    public TipoPublicacion getTipo() { return tipo; }
    public EstadoPublicacion getEstado() { return estado; }
    public String getZonaUbicacion() { return zonaUbicacion; }
    public LocalDate getFechaSuceso() { return fechaSuceso; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public String getDescripcion() { return descripcion; }
    public Usuario getAutor() { return autor; }
    public Animal getAnimal() { return animal; }
    public List<Reporte> getReportes() { return reportes; }
}