package vallegrande.edu.pe.vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {
    // Definimos los botones como públicos para que el controlador los use
    public JButton btnSitios, btnArqueologo, btnExpendicion, btnHallazgo;

    public MenuPrincipalView() {
        // 1. Configuración de la ventana
        setTitle("Pantalla Principal - Sistema MVC");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20)); // Espaciado entre zonas

        // 2. Encabezado (Título y Bienvenida)
        JPanel pnlHeader = new JPanel(new GridLayout(2, 1));
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN MVC", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel lblSubtitulo = new JLabel("<html><center>Bienvenido al sistema. Seleccione un módulo para gestionar la información.</center></html>", SwingConstants.CENTER);

        pnlHeader.add(lblTitulo);
        pnlHeader.add(lblSubtitulo);
        add(pnlHeader, BorderLayout.NORTH);

        // 3. Cuerpo (Botones de navegación)
        JPanel pnlBotones = new JPanel(new GridLayout(2, 2, 25, 25)); // 2 filas, 2 columnas
        pnlBotones.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        btnSitios = new JButton("Sitios");
        btnArqueologo = new JButton("Arqueologos");
        btnExpendicion = new JButton("Expediciones");
        btnHallazgo = new JButton("Hallazgos");

        // Personalización opcional de botones
        btnSitios.setFocusable(false);
        btnArqueologo.setFocusable(false);

        pnlBotones.add(btnSitios);
        pnlBotones.add(btnArqueologo);
        pnlBotones.add(btnExpendicion);
        pnlBotones.add(btnHallazgo);

        add(pnlBotones, BorderLayout.CENTER);

        // 4. Pie de página (Créditos)
        JLabel lblEquipo = new JLabel("Desarrollado por: Equipo 3 - POO II", SwingConstants.CENTER);
        lblEquipo.setPreferredSize(new Dimension(0, 40));
        lblEquipo.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        add(lblEquipo, BorderLayout.SOUTH);
    }
}
