import java.time.LocalDate;

public class Aviso {
    private String idAviso;
    private TipoAviso tipo;
    private String ubicacion;
    private LocalDate fechaPublicacion;
    private boolean activo;
    private Usuario autor;
    private Mascota mascota;

    public Aviso(String idAviso, TipoAviso tipo, String ubicacion, Usuario autor, Mascota mascota) {
        this.idAviso = idAviso;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fechaPublicacion = LocalDate.now();
        this.activo = true;
        this.autor = autor;
        this.mascota = mascota;
    }

    /**
     * Devuelve los datos de contacto solo si el usuario que consulta está autenticado.
     */
    public String obtenerDatosContacto(Usuario solicitante) {
        if (solicitante != null && solicitante.isAutenticado()) {
            return "Contacto: " + autor.getNombre() + " | Tel: " + autor.getTelefono() + " | Email: " + autor.getEmail();
        }
        return "Inicia sesión para ver los datos de contacto.";
    }

    public void cerrarAviso() {
        this.activo = false;
        this.mascota.setEstado(EstadoMascota.REUNIDA);
    }

    // Accessors
    public String getIdAviso() { return idAviso; }
    public TipoAviso getTipo() { return tipo; }
    public String getUbicacion() { return ubicacion; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public boolean isActivo() { return activo; }
    public Usuario getAutor() { return autor; }
    public Mascota getMascota() { return mascota; }
}