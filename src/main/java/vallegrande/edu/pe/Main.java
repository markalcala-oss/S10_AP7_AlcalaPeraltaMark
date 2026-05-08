package vallegrande.edu.pe;

// Importamos la vista y el controlador del MENÚ
import vallegrande.edu.pe.controlador.MenuPrincipalController;
import vallegrande.edu.pe.vista.MenuPrincipalView;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos la Vista del Menú Principal
        MenuPrincipalView vistaMenu = new MenuPrincipalView();

        // 2. Instanciamos el Controlador del Menú y le pasamos la vista
        // Este controlador será el encargado de abrir VistaUsuario después
        MenuPrincipalController controladorMenu = new MenuPrincipalController(vistaMenu);

        // 3. Configuramos y mostramos el Menú
        vistaMenu.setLocationRelativeTo(null); // Centrar en pantalla
        vistaMenu.setVisible(true);
    }
}