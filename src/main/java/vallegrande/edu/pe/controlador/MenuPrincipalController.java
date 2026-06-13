package vallegrande.edu.pe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vallegrande.edu.pe.vista.MenuPrincipalView;
import vallegrande.edu.pe.vista.VistaSitio;

public class MenuPrincipalController implements ActionListener {

    private final MenuPrincipalView vistaMenu;

    public MenuPrincipalController(MenuPrincipalView vistaMenu) {
        this.vistaMenu = vistaMenu;

        // Conectamos los botones de tu MenuPrincipalView
        this.vistaMenu.btnSitios.addActionListener(this);
        this.vistaMenu.btnArqueologo.addActionListener(this);
        this.vistaMenu.btnExpendicion.addActionListener(this);
        this.vistaMenu.btnHallazgo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMenu.btnSitios) {
            System.out.println("Abriendo módulo arqueologicos...");

            // 1. Creamos la ventana de los Sitios
            VistaSitio vSitio = new VistaSitio();

            // 2. 🔥 ESTA LÍNEA LE DA VIDA AL BOTÓN AGREGAR DE LA OTRA VENTANA
            new ControladorSitio(vSitio);

            // 3. Mostramos la ventana
            vSitio.setLocationRelativeTo(null);
            vSitio.setVisible(true);
        }
    }
}