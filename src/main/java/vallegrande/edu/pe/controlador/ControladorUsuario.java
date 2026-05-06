package vallegrande.edu.pe.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vallegrande.edu.pe.modelo.usuario;
import vallegrande.edu.pe.modelo.usuarioDAO;
import vallegrande.edu.pe.vista.VistaUsuario;

public class ControladorUsuario implements ActionListener {

    private VistaUsuario vista;
    private usuarioDAO dao;
    private usuario u = new usuario();

    public ControladorUsuario(VistaUsuario v) {
        this.vista = v;
        this.dao = new usuarioDAO();
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
        List<usuario> lista = dao.listar();
        Object[] fila = new Object[3];
        for (usuario user : lista) {
            fila[0] = user.getId();
            fila[1] = user.getNombre();
            fila[2] = user.getCorreo();
            modeloTabla.addRow(fila);
        }
    }

    public void agregar() {
        String nom = vista.txtNombre.getText();
        String correo = vista.txtCorreo.getText();
        u.setNombre(nom);
        u.setCorreo(correo);
        int r = dao.agregar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario agregado con éxito");
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
            JOptionPane.showMessageDialog(vista, "Usuario eliminado");
        }
    }

    private void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtCorreo.setText("");
        vista.txtNombre.requestFocus();
    }
}
