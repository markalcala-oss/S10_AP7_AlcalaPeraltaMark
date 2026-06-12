package vallegrande.edu.pe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vallegrande.edu.pe.vista.MenuPrincipalView;
import vallegrande.edu.pe.vista.VistaSitio;
// import vallegrande.edu.pe.controlador.UsuarioController;

public class MenuPrincipalController implements ActionListener {

    private MenuPrincipalView vistaMenu;

    public MenuPrincipalController(MenuPrincipalView vistaMenu) {
        this.vistaMenu = vistaMenu;

        // Escuchar los botones del menú
        this.vistaMenu.btnSitios.addActionListener(this);
        this.vistaMenu.btnSitios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMenu.btnSitios) {
            // 1. Instanciar la vista de Usuarios que ya hiciste
            VistaSitio vistaSitio = new VistaSitio();

            // 2. Instanciar su controlador (aquí se une con el trabajo de tu equipo)
            // UsuarioController cUsuario = new UsuarioController(vUsuario);

            // 3. Mostrar la ventana
            vistaSitio.setVisible(true);

            // Opcional: Ocultar el menú principal
            // vistaMenu.setVisible(false);
        }

        if (e.getSource() == vistaMenu.btnSitios) {
            // Lo mismo para productos cuando tus compañeros lo tengan listo
            System.out.println("Abriendo módulo arqueologicos...");
        }
    }
}