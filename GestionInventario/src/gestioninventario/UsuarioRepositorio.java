
package gestioninventario;

import java.util.ArrayList;
import java.util.List;


public class UsuarioRepositorio {
    // Array estático para almacenar los usuarios registrados
    private static final Usuario[] usuarios = new Usuario[10]; // Tamaño inicial de 10 usuarios
    private static int contadorUsuarios = 0; // Contador para llevar el registro de usuarios
    
    public static void crearUsuario(Usuario usuario) {
        if (contadorUsuarios < usuarios.length) {
            usuarios[contadorUsuarios] = usuario; // Agregar el usuario al array
            contadorUsuarios++;
        }else{
            System.out.println("No se pueden agregar más usuarios, el repositorio está lleno.");
        }
            
    }
    
    // Método para mostrar todos los usuarios registrados
    public static void mostrarUsuarios() {
        System.out.println("Lista de usuarios registrados:");
        for (int i = 0; i < contadorUsuarios; i++) {
            Usuario usuario = usuarios[i];
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Apellido: " + usuario.getApellido() + ", Tipo de ID: " + usuario.getTipoID() + ", Documento: " + usuario.getDocID() + ", Correo electronico: " + usuario.getCorreo() + ", Telefono: " + usuario.getTelefono() + ", Estado: " + (usuario.getEstado() ? "Activo" : "Inactivo"));
        }
    }
    
    // Método para obtener todos los usuarios registrados
    public static List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        for (int i = 0; i < contadorUsuarios; i++) {
            listaUsuarios.add(usuarios[i]);  // Agregar solo los usuarios que están registrados
        }
        return listaUsuarios;
    }
    
    // Método para buscar un usuario por su correo
    public static Usuario buscarUsuarioPorCorreo(String correo) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getCorreo().equalsIgnoreCase(correo)) { // Comparación insensible a mayúsculas
                return usuarios[i];
            }
        }
        return null; // Si no encuentra el usuario, devuelve null
    }
    
    // Método para buscar un usuario por su id
    public static Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null; // Si no encuentra el usuario, devuelve null
    }
    
    // Método para modificar un usuario por su id
    public static boolean modificarUsuarioPorId(int id, String nuevoNombre, String nuevoApellido, String nuevoTipoID, String nuevoDocID, String nuevoCorreo,
            String nuevoTelefono, boolean nuevoEstado, String nuevoPassword) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNombre(nuevoNombre);
            usuario.setApellido(nuevoApellido);
            usuario.setTipoID(nuevoTipoID);
            usuario.setDocID(nuevoDocID);
            usuario.setCorreo(nuevoCorreo);
            usuario.setTelefono(nuevoTelefono);
            usuario.setEstado(nuevoEstado);
            usuario.setPassword(nuevoPassword);
            return true;
        } 
            return false;
    }
    
    
    // Método para activar un usuario por su ID
    public static boolean activarUsuarioPorId(int id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuario.setEstado(true);  // Activa el usuario
            System.out.println("Usuario con ID " + id + " activado correctamente.");
            return true;
        } else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
            return false;
        }
    }
    
    // Método para inactivar un usuario por su ID
    public static boolean inactivarUsuarioPorId(int id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuario.setEstado(false);  // Inactiva el usuario
            System.out.println("Usuario con ID " + id + " inactivado correctamente.");
            return true;
        } else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
            return false;
        }
    }
    
    // Método para obtener el último ID de usuario registrado
    public static int obtenerUltimoId() {
        if (contadorUsuarios == 0) {
            return 0;
        }
        return usuarios[contadorUsuarios - 1].getId();
    }
}
