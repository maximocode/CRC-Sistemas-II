package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Publicacion {
    protected Long identificador;
    protected LocalDateTime fechaPublicacion;
    protected String estadoAviso;
    protected Usuario autor;
    protected Mascota mascota;
    protected Ubicacion ubicacion;
    protected List<Fotografia> fotografias;
    protected List<Reporte> reportes;

    public Publicacion(Usuario autor, Mascota mascota, Ubicacion ubicacion) {
        this.autor = autor;
        this.mascota = mascota;
        this.ubicacion = ubicacion;
        this.fechaPublicacion = LocalDateTime.now();
        this.estadoAviso = "ACTIVA";
        this.fotografias = new ArrayList<>();
        this.reportes = new ArrayList<>();
    }

    public void registrarAviso() {
        this.estadoAviso = "ACTIVA";
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estadoAviso = nuevoEstado;
    }

    public void agregarFotografia(Fotografia foto) {
        this.fotografias.add(foto);
    }

    public void recibirReporte(Reporte reporte) {
        this.reportes.add(reporte);
        if (this.reportes.size() >= 3) {
            cambiarEstado("OCULTA_POR_REPORTE");
        }
    }

    public String exponerDetalle(boolean sesionIniciada) {
        String contacto = sesionIniciada ? autor.getTelefono() : "Inicia sesión para ver el contacto";
        return mascota.proveerDatosDescriptivos() + " | Zona: " + ubicacion.getZonaGeograficaBarrio() + " | Contacto: " + contacto;
    }

    public abstract String getTipoPublicacion();
    public Usuario getAutor() { return autor; }
    public Mascota getMascota() { return mascota; }
    public Ubicacion getUbicacion() { return ubicacion; }
    public List<Fotografia> getFotografias() { return fotografias; }
}