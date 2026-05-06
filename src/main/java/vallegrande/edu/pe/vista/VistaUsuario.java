package vallegrande.edu.pe.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaUsuario extends JFrame {

    // 1. Atributos públicos para que el controlador los vea
    public JTable tabla;
    public DefaultTableModel modelo;
    public JTextField txtNombre, txtCorreo;
    public JButton btnListar, btnAgregar, btnEliminar;

    public VistaUsuario() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Mantenimiento de Usuarios - MVC");
        setSize(600, 500); // Un poco más alto para que quepa el formulario
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        // --- PARTE SUPERIOR: FORMULARIO ---
        JPanel pnlFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Usuario"));

        pnlFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        pnlFormulario.add(txtNombre);

        pnlFormulario.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        pnlFormulario.add(txtCorreo);

        // --- PARTE CENTRAL: TABLA ---
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CORREO");
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // --- PARTE INFERIOR: BOTONES ---
        JPanel pnlBotones = new JPanel();
        btnListar = new JButton("Actualizar");
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");

        pnlBotones.add(btnListar);
        pnlBotones.add(btnAgregar);
        pnlBotones.add(btnEliminar);

        // AGREGAR TODO AL CONTENEDOR PRINCIPAL
        add(pnlFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(pnlBotones, BorderLayout.SOUTH);
    }
}
