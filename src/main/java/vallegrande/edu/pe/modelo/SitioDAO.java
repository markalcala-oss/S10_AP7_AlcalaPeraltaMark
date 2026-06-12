package vallegrande.edu.pe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SitioDAO {
    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Sitio> datos = new ArrayList<>();
        String sql = "select * from usuario"; // Cambia 'usuarios' por el nombre de tu tabla
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sitio u = new Sitio();
                u.setId(rs.getInt("id")); // "id" debe ser el nombre de la columna en MySQL
                u.setNombre(rs.getString("nombre"));
                u.setPais(rs.getString("Pais"));
                u.setPais(rs.getString("Años"));
                u.setPais(rs.getString("Estado"));
                datos.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e);
        }
        return datos;
    }

    public int agregar(Sitio u) {
        String sql = "insert into usuario(nombre, Pais, Años ,Estado) values(?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPais());
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
