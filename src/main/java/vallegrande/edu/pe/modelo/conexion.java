package vallegrande.edu.pe.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    Connection con;

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/ExpArqueologicas"; // Cambia NOMBRE_DE_TU_BD
        String user = "root"; // Tu usuario de MySQL
        String pass = "hackaton"; // Tu contraseña de MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }
}
