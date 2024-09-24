
package gestioninventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author andre
 */
public class LoginFrame extends JFrame{
    private UsuarioServicio usuarioServicio;
    
    public LoginFrame(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;

        // Configuración de la ventana
        setTitle("Login de Usuario");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Crear elementos de la interfaz
        JLabel labelCorreo = new JLabel("Correo:");
        labelCorreo.setBounds(50, 30, 100, 25);
        panel.add(labelCorreo);

        JTextField campoCorreo = new JTextField(20);
        campoCorreo.setBounds(150, 30, 165, 25);
        panel.add(campoCorreo);

        JLabel labelPassword = new JLabel("Contraseña:");
        labelPassword.setBounds(50, 70, 100, 25);
        panel.add(labelPassword);

        JPasswordField campoPassword = new JPasswordField(20);
        campoPassword.setBounds(150, 70, 165, 25);
        panel.add(campoPassword);

        JButton botonLogin = new JButton("Ingresar");
        botonLogin.setBounds(150, 110, 165, 25);
        panel.add(botonLogin);

        // Acción al hacer clic en el botón de Ingresar
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = campoCorreo.getText();
                String password = new String(campoPassword.getPassword());

                Usuario usuario = usuarioServicio.buscarUsuarioPorCorreo(correo);
                if (usuario != null && usuario.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + usuario.getNombre());
                    dispose(); // Cerrar ventana de login
                    new MainFrame(usuario,usuarioServicio); // Mostrar la ventana principal
                } else {
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
                }
            }
        });
        
        // Botón de Registro
        JButton botonRegistro = new JButton("Registrar");
        botonRegistro.setBounds(150, 150, 165, 25);
        panel.add(botonRegistro);

        // Acción al hacer clic en "Registrar"
        botonRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroFrame(usuarioServicio); // Abrir ventana de registro
            }
        });

        // Añadir el panel a la ventana
        add(panel);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true); // Hacer visible la ventana
    }
}

  

    

