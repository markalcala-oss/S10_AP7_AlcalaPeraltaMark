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

    // 1. Método LISTAR (Mapeado exactamente con las columnas de tu MySQL)
    public List<Sitio> listar() {
        List<Sitio> datos = new ArrayList<>();
        String sql = "select * from sitio"; // 🔥 CORREGIDO: 'sitio' en singular
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sitio u = new Sitio();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("Nombres")); // 🔥 CORREGIDO: Tu columna es 'Nombres' con N mayúscula y S al final
                u.setPais(rs.getString("Pais"));
                u.setAños(rs.getString("Años"));
                u.setEstado(rs.getString("Estado"));
                datos.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e);
        }
        return datos;
    }

    // 2. Método AGREGAR (CORREGIDO: Mapeado con la tabla 'sitio' y la columna 'Nombres')
    public int agregar(Sitio u) {
        // 🔥 CORREGIDO: Tabla 'sitio' y columna 'Nombres' idénticas a tu script
        String sql = "insert into sitio(Nombres, Pais, Años, Estado) values(?, ?, ?, ?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPais());
            ps.setString(3, u.getAños());
            ps.setString(4, u.getEstado());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e);
            return 0;
        }
    }

    // 3. Método ELIMINAR (CORREGIDO: Cambiado a la tabla 'sitio')
    public void eliminar(int id) {
        String sql = "delete from sitio where id = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e);
        }
    }
}