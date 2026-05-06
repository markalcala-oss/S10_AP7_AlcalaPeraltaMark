package vallegrande.edu.pe;

import vallegrande.edu.pe.controlador.ControladorUsuario;
import vallegrande.edu.pe.vista.VistaUsuario;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos la Vista
        VistaUsuario vista = new VistaUsuario();

        // 2. Instanciamos el Controlador y le pasamos la vista
        ControladorUsuario controlador = new ControladorUsuario(vista);

        // 3. Mostramos la ventana
        vista.setVisible(true);
        vista.setLocationRelativeTo(null); // Para que aparezca al centro
    }
}