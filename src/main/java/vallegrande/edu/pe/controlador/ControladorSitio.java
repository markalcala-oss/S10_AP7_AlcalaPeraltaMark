package vallegrande.edu.pe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vallegrande.edu.pe.modelo.Sitio;
import vallegrande.edu.pe.modelo.SitioDAO;
import vallegrande.edu.pe.vista.VistaSitio;

public class ControladorSitio implements ActionListener {

    private final VistaSitio vista;
    private final SitioDAO dao;

    public ControladorSitio(VistaSitio v) {
        this.vista = v;
        this.dao = new SitioDAO();

        // Escuchamos los tres botones de la vista
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);

        // Listar automáticamente al abrir la ventana por primera vez
        listar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnListar) {
            listar();
        }
        if (e.getSource() == vista.btnAgregar) {
            agregar();
        }
        if (e.getSource() == vista.btnEliminar) {
            eliminar();
        }
    }

    public void listar() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tabla.getModel();
        modeloTabla.setRowCount(0); // Limpiar filas anteriores para no duplicar datos
        List<Sitio> lista = dao.listar();

        Object[] fila = new Object[5];
        for (Sitio user : lista) {
            fila[0] = user.getId();
            fila[1] = user.getNombre();
            fila[2] = user.getPais();
            fila[3] = user.getAños();
            fila[4] = user.getEstado();
            modeloTabla.addRow(fila);
        }
    }

    public void agregar() {
        // 1. Capturar y limpiar espacios en blanco de los textos ingresados
        String nom = vista.txtNombre.getText().trim();
        String pais = vista.txtPais.getText().trim();
        String año = vista.txtAños.getText().trim();
        String estado = vista.txtEstado.getText().trim();

        // 2. Validación obligatoria: Evita registrar campos vacíos
        if (nom.isEmpty() || pais.isEmpty() || año.isEmpty() || estado.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Crear un objeto NUEVO y limpio para esta inserción específica
        Sitio u = new Sitio();
        u.setNombre(nom);
        u.setPais(pais);
        u.setAños(año);
        u.setEstado(estado);

        // 4. Enviar al DAO para intentar guardarlo en MySQL
        int r = dao.agregar(u);

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Sitio agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            listar(); // Refrescar la tabla de forma automática e inmediata
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar en la Base de Datos.\nRevisa la consola de IntelliJ.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila de la tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            int id = Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id);
            JOptionPane.showMessageDialog(vista, "Sitio eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            listar(); // Refrescar la tabla automáticamente tras la eliminación
        }
    }

    private void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtPais.setText("");
        vista.txtAños.setText("");
        vista.txtEstado.setText("");
        vista.txtNombre.requestFocus(); // Coloca el cursor en el primer campo listo para el siguiente registro
    }
}