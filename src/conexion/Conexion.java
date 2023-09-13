package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    protected static Connection connection;
    protected static Statement query;

    public static void crearConexion() {
        try {
            final String user = "root";
            final String database = "simulador_banco";

            String urlConnection = String.format("jdbc:mysql://127.0.0.1/%s?user=%s", database, user);

            connection = DriverManager.getConnection(urlConnection);

            System.out.println("TE has conectado con exito");
            
        }
        catch (SQLException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
