package servicio;

import modelo.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AuthService {
    private List<Usuario> usuariosRegistrados = new ArrayList<>();
    private long secuenciaId = 1L;

    public Usuario registrarUsuario(String nombre, String apellido, String email, 
                                    String telefono, String password, String confirmacionPassword) {
        validarDatosRegistro(nombre, apellido, email, password, confirmacionPassword);

        String hash = generarHashSeguro(password);
        Usuario nuevo = new Usuario(secuenciaId++, nombre, apellido, email.toLowerCase().trim(), 
                                    telefono, hash, ProveedorAuth.LOCAL);
        usuariosRegistrados.add(nuevo);
        return nuevo;
    }

    public Usuario iniciarSesion(String email, String password) {
        if (email == null || password == null || email.isBlank() || password.isBlank()) {
            throw new IllegalArgumentException("Debe ingresar correo y contraseña.");
        }
        String hashIngresado = generarHashSeguro(password);
        for (Usuario u : usuariosRegistrados) {
            if (u.getEmail().equalsIgnoreCase(email.trim()) 
                && u.getPasswordHash().equals(hashIngresado)
                && "ACTIVO".equals(u.getEstadoCuenta())) {
                u.setSesionIniciada(true);
                return u;
            }
        }
        throw new SecurityException("Credenciales inválidas o cuenta inactiva.");
    }

    public Usuario autenticarConGoogle(String nombre, String apellido, String email) {
        Optional<Usuario> existente = usuariosRegistrados.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();

        Usuario usuario = existente.orElseGet(() -> {
            Usuario nuevoGoogle = new Usuario(secuenciaId++, nombre, apellido, 
                                              email.toLowerCase(), "No especificado", 
                                              "OAUTH_GOOGLE", ProveedorAuth.GOOGLE);
            usuariosRegistrados.add(nuevoGoogle);
            return nuevoGoogle;
        });

        usuario.setSesionIniciada(true);
        return usuario;
    }

    private void validarDatosRegistro(String nombre, String apellido, String email, 
                                      String pass, String confirmPass) {
        if (nombre == null || nombre.isBlank() || apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("Nombre y apellido son obligatorios.");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("El formato del correo electrónico no es válido.");
        }
        boolean existeEmail = usuariosRegistrados.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email.trim()));
        if (existeEmail) {
            throw new IllegalStateException("El correo ya se encuentra registrado en PetFinder.");
        }
        if (pass == null || pass.length() < 6 || !pass.equals(confirmPass)) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres y coincidir.");
        }
    }

    private String generarHashSeguro(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash de contraseña", e);
        }
    }
}