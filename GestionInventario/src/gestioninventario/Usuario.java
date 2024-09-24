
package gestioninventario;

/**
 *
 * @author Andres Mejia Vergara
 */
public class Usuario {
        // Atributo privado
    private int id;
    private String nombre; 
    private String apellido;
    private String tipoid;
    private String docid;
    private String correo;
    private String telefono;
    private boolean estado;
    private String password;

    // Constructor vacío (opcional)
    public Usuario() {
    }

    // Constructor con parámetros id (opcional)
    public Usuario(int id,String nombre,String apellido,String tipoid,String docid,String correo,String telefono,boolean estado,String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoid = tipoid;
        this.docid = docid;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
        this.password = password;
    }

    // Getter para obtener el valor de id
    public int getId() {
        return id;
    }

    // Setter para asignar el valor de id
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter para obtener el valor de nombre
    public String getNombre() {
        return nombre;
    }
    
    // Setter para asignar el valor de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter para obtener el valor de apellido
    public String getApellido() {
        return apellido;
    }
    
    // Setter para obtener el valor de nombre
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    // Getter para obtener el valor de Tipo de id
    public String getTipoID() {
        return tipoid;
    }
    
    // Setter para obtener el valor de Tipo de id
    public void setTipoID(String tipoid) {
        this.tipoid = tipoid;
    }
    
    // Getter para obtener el valor de Numero de documento
    public String getDocID() {
        return docid;
    }
    
    // Setter para obtener el valor de Numero de documento
    public void setDocID(String docid) {
        this.docid = docid;
    }
    
    // Getter para obtener el valor de Correo electronico
    public String getCorreo() {
        return correo;
    }
    
    // Setter para obtener el valor de Correo electronico
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    // Getter para obtener el valor de Telefono
    public String getTelefono() {
        return telefono;
    }
    
    // Setter para obtener el valor de Telefono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    // Getter para obtener el valor booleano de estado
    public boolean getEstado() {
        return estado;
    }
    
    // Setter para obtener el valor booleano de estado
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    // Getter para la contraseña
    public String getPassword() {
        return password;
    }
    
    // Setter para la contraseña
    public void setPassword(String password) {
        this.password = password;
    }
}