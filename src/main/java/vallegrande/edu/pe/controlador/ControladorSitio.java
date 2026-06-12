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

    private VistaSitio vista;
    private SitioDAO dao;
    private Sitio u = new Sitio();

    public ControladorSitio(VistaSitio v) {
        this.vista = v;
        this.dao = new SitioDAO();
        // Escuchamos los tres botones de la vista
        this.vista.btnListar.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnListar) {
            listar();
        }
        if (e.getSource() == vista.btnAgregar) {
            agregar();
            listar();
        }
        if (e.getSource() == vista.btnEliminar) {
            eliminar();
            listar();
        }
    }

    public void listar() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tabla.getModel();
        modeloTabla.setRowCount(0);
        List<Sitio> lista = dao.listar();
        Object[] fila = new Object[3];
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
        String nom = vista.txtNombre.getText();
        String pais = vista.txtPais.getText();
        String año = vista.txtAños.getText();
        String estado = vista.txtEstado.getText();
        u.setNombre(nom);
        u.setPais(pais);
        int r = dao.agregar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Sitio agregado con éxito");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar");
        }
    }

    public void eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila de la tabla");
        } else {
            int id = Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id);
            JOptionPane.showMessageDialog(vista, "SITIO eliminado");
        }
    }

    private void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtPais.setText("");
        vista.txtNombre.requestFocus();
    }
}
