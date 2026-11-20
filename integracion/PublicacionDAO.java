package integracion;

import java.util.List;


public interface PublicacionDAO {
    void create(Publicacion publicacion);
    Publicacion retrieve(Long idPublicacion);
    List<Publicacion> findAllActivas();
    void update(Publicacion publicacion);
}
