import modelo.*;
import servicio.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        MotorIAService motorIA = new MotorIAService();
        PublicacionService pubService = new PublicacionService(motorIA);

        Usuario ana = authService.registrarUsuario("Ana", "Gómez", "ana@mail.com", "2657-441122", "clave123", "clave123");
        Usuario carlos = authService.autenticarConGoogle("Carlos", "Ruiz", "carlos.google@gmail.com");

        authService.iniciarSesion("ana@mail.com", "clave123");

        Publicacion avisoPerdido = pubService.publicarAnimal(
                ana, TipoPublicacion.PERDIDO, "Centro, Villa Mercedes", LocalDate.now().minusDays(1),
                "Se escapó cerca de la plaza, lleva collar rojo.",
                "Toby", "Perro", "Caniche", "Blanco", "Chico", "Macho", "Collar rojo", "/img/toby.jpg"
        );

        Publicacion avisoEncontrado = pubService.publicarAnimal(
                carlos, TipoPublicacion.ENCONTRADO, "Centro, Villa Mercedes", LocalDate.now(),
                "Encontrado caminando desorientado en la plaza.",
                "Desconocido", "Perro", "Caniche", "Blanco", "Chico", "Macho", "Sin chapita", "/img/hallado.jpg"
        );

        List<Publicacion> resultados = pubService.buscarPublicaciones(null, "Perro", "Villa Mercedes");
        System.out.println("\nPublicaciones activas encontradas: " + resultados.size());

        System.out.println("Visitante anónimo -> " + avisoPerdido.consultarDatosContacto(null));
        System.out.println("Usuario logueado  -> " + avisoPerdido.consultarDatosContacto(carlos));

        pubService.reportarPublicacion(carlos, avisoPerdido.getIdPublicacion(), 
                                       MotivoReporte.YA_REUNIDA, "Ya apareció el dueño.");
    }
}