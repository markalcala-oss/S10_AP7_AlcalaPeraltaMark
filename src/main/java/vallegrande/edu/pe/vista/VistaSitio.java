package vallegrande.edu.pe.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaSitio extends JFrame {

    // 1. Atributos públicos para que el controlador los vea
    public JTable tabla;
    public DefaultTableModel modelo;
    public JTextField txtNombre, txtPais, txtAños,txtEstado;
    public JButton btnListar, btnAgregar, btnEliminar;

    public VistaSitio() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Mantenimiento de Sitios - MVC");
        setSize(600, 500); // Un poco más alto para que quepa el formulario
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        // --- PARTE SUPERIOR: FORMULARIO ---
        JPanel pnlFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Sitios"));

        pnlFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        pnlFormulario.add(txtNombre);

        pnlFormulario.add(new JLabel("Pais:"));
        txtPais = new JTextField();
        pnlFormulario.add(txtPais);

        pnlFormulario.add(new JLabel("Año:"));
        txtAños= new JTextField();
        pnlFormulario.add(txtAños);

        pnlFormulario.add(new JLabel("Estado:"));
        txtEstado= new JTextField();
        pnlFormulario.add(txtEstado);

        // --- PARTE CENTRAL: TABLA ---
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PAIS");
        modelo.addColumn("AÑO");
        modelo.addColumn("ESTADO");
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
