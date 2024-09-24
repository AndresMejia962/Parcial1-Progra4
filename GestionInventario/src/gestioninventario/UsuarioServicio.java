
package gestioninventario;

import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Andres Mejia Vergara
 */
public class UsuarioServicio {
     // Miembro de la clase UsuarioRepositorio
    private UsuarioRepositorio usuarioRepositorio;

    // Constructor para inicializar el repositorio
    public UsuarioServicio() {
        this.usuarioRepositorio = new UsuarioRepositorio();  // Instancia de UsuarioRepositorio
    }

    // Método para crear un usuario
    public void crearUsuario(Usuario usuario) {
        UsuarioRepositorio.crearUsuario(usuario);
    }

    // Método para modificar un usuario
    public void modificarUsuario(Usuario usuario) {
        UsuarioRepositorio.modificarUsuarioPorId(usuario.getId(), usuario.getNombre(), usuario.getApellido(), 
                                                  usuario.getTipoID(), usuario.getDocID(), usuario.getCorreo(),
                                                  usuario.getTelefono(), usuario.getEstado(), usuario.getPassword());
    }

    // Método para obtener un usuario por correo
    public Usuario buscarUsuarioPorCorreo(String correo) {
        return UsuarioRepositorio.buscarUsuarioPorCorreo(correo);
    }
    
    //Metodo para obtener un usuario por su Id
    public Usuario buscarUsuarioPorId(int id){
        return UsuarioRepositorio.buscarUsuarioPorId(id);
    }
    
    // Método para obtener todos los usuarios (Nuevo Método)
    public List<Usuario> obtenerTodosLosUsuarios() {
        return UsuarioRepositorio.obtenerTodosLosUsuarios();  // Llama al repositorio para obtener la lista de usuarios
    }

    // Método para mostrar todos los usuarios
    public void mostrarUsuarios() {
        UsuarioRepositorio.mostrarUsuarios();
    }

    // Método para activar un usuario
    public boolean activarUsuario(int id) {
        return UsuarioRepositorio.activarUsuarioPorId(id);
    }

    // Método para inactivar un usuario
    public boolean inactivarUsuario(int id) {
        return UsuarioRepositorio.inactivarUsuarioPorId(id);
    }
    
     // Método para validar usuario (correo y contraseña)
    public boolean validarUsuario(Usuario usuario) {
        return validarCorreo(usuario.getCorreo()) && validarPassword(usuario.getPassword());
    }

    // Validar el correo con una expresión regular
    private boolean validarCorreo(String correo) {
        String regexCorreo = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regexCorreo, correo);
    }

    // Validar la contraseña: mínimo 8 caracteres, al menos un número y un carácter especial
    private boolean validarPassword(String contrasena) {
        if (contrasena.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres.");
            return false;
        }
        // Verificar si contiene al menos un número
        if (!contrasena.matches(".*\\d.*")) {
            System.out.println("La contraseña debe contener al menos un número.");
            return false;
        }
        // Verificar si contiene al menos un carácter especial
        if (!contrasena.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("La contraseña debe contener al menos un carácter especial.");
            return false;
        }
        return true;
    }

    // Método para buscar el último ID registrado
    public int buscarUltimoId() {
        return UsuarioRepositorio.obtenerUltimoId();
    }
}


