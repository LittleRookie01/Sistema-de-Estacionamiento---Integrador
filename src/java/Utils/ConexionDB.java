package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

public static Connection getConnection() {
        Connection con = null;
        String cadena = "jdbc:mysql://localhost/estacionamiento?user=root&password=";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadena);
            System.out.println("Conexion Satisfactoria");
        } catch (Exception e) {
            System.out.println("Error de Conexion");
        }

        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
    
}
