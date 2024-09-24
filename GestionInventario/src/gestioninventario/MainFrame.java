
package gestioninventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class MainFrame extends JFrame {
    private Usuario usuario;
    private UsuarioServicio usuarioServicio;
    public MainFrame(Usuario usuario, UsuarioServicio usuarioServicio) {
        this.usuario = usuario;  // Inicializar variable usuario
        this.usuarioServicio = usuarioServicio;  // Inicializar variable usuarioServicio
        
        // Verificación si se pasó correctamente
        if (usuarioServicio == null) {
            JOptionPane.showMessageDialog(null, "Error: Servicio de usuario no disponible.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Configuración de la ventana principal
        setTitle("Bienvenido al Sistema de Gestión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Mensaje de bienvenida
        JLabel labelBienvenido = new JLabel("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido());
        labelBienvenido.setBounds(100, 50, 300, 25);
        panel.add(labelBienvenido);

        // Botón para cerrar sesión
        JButton botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setBounds(150, 150, 150, 25);
        panel.add(botonCerrarSesion);

        // Acción al hacer clic en "Cerrar Sesión"
        botonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana principal
                new LoginFrame(new UsuarioServicio()); // Volver a la ventana de login
            }
        });
        
        // Botón para mostrar los usuarios en la consola
        JButton botonMostrarUsuarios = new JButton("Mostrar Usuarios");
        botonMostrarUsuarios.setBounds(150, 100, 150, 25);
        panel.add(botonMostrarUsuarios);

        // Acción al hacer clic en "Mostrar Usuarios"
        botonMostrarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar los usuarios en la UsuariosFrame
                new UsuariosFrame(usuarioServicio);
            }
        });
        
   

        // Añadir el panel a la ventana
        add(panel);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true); // Hacer visible la ventana
    }
}

