package vallegrande.edu.pe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {
    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<usuario> datos = new ArrayList<>();
        String sql = "select * from usuario"; // Cambia 'usuarios' por el nombre de tu tabla
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario u = new usuario();
                u.setId(rs.getInt("id")); // "id" debe ser el nombre de la columna en MySQL
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                datos.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e);
        }
        return datos;
    }

    public int agregar(usuario u) {
        String sql = "insert into usuario(nombre, correo) values(?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e);
            return 0;
        }
    }

    // Método para eliminar un usuario por ID
    public void eliminar(int id) {
        String sql = "delete from usuario where id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e);
        }
    }
}
