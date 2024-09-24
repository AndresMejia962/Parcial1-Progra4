
package gestioninventario;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class UsuariosFrame extends JFrame{
    private UsuarioServicio usuarioServicio;

    public UsuariosFrame(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;

        setTitle("Lista de Usuarios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear panel
        JPanel panel = new JPanel(new BorderLayout());

        // Crear la tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Tipo ID", "Número ID", "Correo", "Teléfono", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable tablaUsuarios = new JTable(model);

        // Cargar los datos de los usuarios en la tabla
        List<Usuario> usuarios = usuarioServicio.obtenerTodosLosUsuarios();
        for (Usuario usuario : usuarios) {
            Object[] fila = {
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getTipoID(),
                usuario.getDocID(),
                usuario.getCorreo(),
                usuario.getTelefono(),
                usuario.getEstado() ? "Activo" : "Inactivo"
            };
            model.addRow(fila);
        }

        // Añadir la tabla a un JScrollPane para manejar el scroll
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel a la ventana
        add(panel);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true); // Hacer visible la ventana
    }
}
    
    

