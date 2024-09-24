package gestioninventario;
import javax.swing.SwingUtilities;
/**
 *
 * @author Andres Mejia Vergara
 */
public class GestionInventario {

  
     public static void main(String[] args) {
        // Inicializar el servicio de usuario
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        Usuario usuario1 = new Usuario(1, "Andres", "Mejia", "CC", "123456789", "andres@gmail.com", "1234567890", true, "Password123!");
        usuarioServicio.crearUsuario(usuario1);
        // Mostrar la pantalla de login
        SwingUtilities.invokeLater(() -> new LoginFrame(usuarioServicio));
    }
}