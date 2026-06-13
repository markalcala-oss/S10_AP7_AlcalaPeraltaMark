package vallegrande.edu.pe;

import vallegrande.edu.pe.controlador.MenuPrincipalController;
import vallegrande.edu.pe.vista.MenuPrincipalView;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos la Vista del Menú Principal
        MenuPrincipalView vistaMenu = new MenuPrincipalView();

        // 2. Instanciamos el Controlador del Menú y le pasamos la vista
        MenuPrincipalController controladorMenu = new MenuPrincipalController(vistaMenu);

        // 3. Configuramos y mostramos el Menú
        vistaMenu.setLocationRelativeTo(null);
        vistaMenu.setVisible(true);
    }
}