
package gestioninventario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class RegistroFrame extends JFrame{
    private UsuarioServicio usuarioServicio;
    
    public RegistroFrame(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;

        // Configuración de la ventana
        setTitle("Registrar Usuario");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Campos del formulario de registro

        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(50, 30, 100, 25);
        panel.add(labelNombre);

        JTextField campoNombre = new JTextField(20);
        campoNombre.setBounds(150, 30, 165, 25);
        panel.add(campoNombre);

        JLabel labelApellido = new JLabel("Apellido:");
        labelApellido.setBounds(50, 70, 100, 25);
        panel.add(labelApellido);

        JTextField campoApellido = new JTextField(20);
        campoApellido.setBounds(150, 70, 165, 25);
        panel.add(campoApellido);

        JLabel labelTipoID = new JLabel("Tipo ID:");
        labelTipoID.setBounds(50, 110, 100, 25);
        panel.add(labelTipoID);

        JTextField campoTipoID = new JTextField(20);
        campoTipoID.setBounds(150, 110, 165, 25);
        panel.add(campoTipoID);

        JLabel labelDocID = new JLabel("Número ID:");
        labelDocID.setBounds(50, 150, 100, 25);
        panel.add(labelDocID);

        JTextField campoDocID = new JTextField(20);
        campoDocID.setBounds(150, 150, 165, 25);
        panel.add(campoDocID);

        JLabel labelCorreo = new JLabel("Correo:");
        labelCorreo.setBounds(50, 190, 100, 25);
        panel.add(labelCorreo);

        JTextField campoCorreo = new JTextField(20);
        campoCorreo.setBounds(150, 190, 165, 25);
        panel.add(campoCorreo);

        JLabel labelTelefono = new JLabel("Teléfono:");
        labelTelefono.setBounds(50, 230, 100, 25);
        panel.add(labelTelefono);

        JTextField campoTelefono = new JTextField(20);
        campoTelefono.setBounds(150, 230, 165, 25);
        panel.add(campoTelefono);

        JLabel labelPassword = new JLabel("Contraseña:");
        labelPassword.setBounds(50, 270, 100, 25);
        panel.add(labelPassword);

        JPasswordField campoPassword = new JPasswordField(20);
        campoPassword.setBounds(150, 270, 165, 25);
        panel.add(campoPassword);

        JLabel labelEstado = new JLabel("Estado:");
        labelEstado.setBounds(50, 310, 100, 25);
        panel.add(labelEstado);

        JCheckBox checkBoxEstado = new JCheckBox("Activo", true); // El usuario se registra como activo por defecto
        checkBoxEstado.setBounds(150, 310, 100, 25);
        panel.add(checkBoxEstado);

        // Botón de Registrar
        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(150, 350, 165, 25);
        panel.add(botonRegistrar);

        // Acción al hacer clic en "Registrar"
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String apellido = campoApellido.getText();
                String tipoID = campoTipoID.getText();
                String docID = campoDocID.getText();
                String correo = campoCorreo.getText();
                String telefono = campoTelefono.getText();
                String password = new String(campoPassword.getPassword());
                boolean estado = checkBoxEstado.isSelected();
                
                // Validar que todos los campos requeridos estén llenos
        if (nombre.isEmpty() || apellido.isEmpty() || tipoID.isEmpty() || docID.isEmpty() || 
            correo.isEmpty() || telefono.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de registrar el usuario.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return; // Detener el proceso si faltan campos
        }

                // Crear un nuevo usuario (Se asigna un ID de manera básica)
                Usuario nuevoUsuario = new Usuario(usuarioServicio.buscarUltimoId() + 1, nombre, apellido, tipoID, docID, correo, telefono, estado, password);
                usuarioServicio.crearUsuario(nuevoUsuario);

                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
                dispose(); // Cerrar ventana de registro
            }
        });

        // Añadir el panel a la ventana
        add(panel);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true); // Hacer visible la ventana
    }
}
    

