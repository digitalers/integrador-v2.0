package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerificarJDBC {
    public static void main(String[] args) {
        // URL de conexión a la base de datos (cámbiala según tu configuración)
        String jdbcUrl = "jdbc:mysql://localhost:3306/bd_appestudiantil";
        String usuario = "root";
        String contraseña = "";

        try {
            // Intentar cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar conectarse a la base de datos
            Connection conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

            // Si llegamos hasta aquí, la librería JDBC se agregó correctamente y la conexión funcionó
            System.out.println("La librería JDBC se agregó correctamente y la conexión fue exitosa.");

            // Realizar una consulta SELECT a la tabla de estudiantes
            Statement statement = conexion.createStatement();
            String consulta = "SELECT * FROM estudiante";
            ResultSet resultado = statement.executeQuery(consulta);

            // Imprimir los resultados de la consulta
            while (resultado.next()) {
                int id = resultado.getInt("idestudiante");
                String nombre = resultado.getString("nombre");
                // Agrega más columnas según la estructura de tu tabla de estudiantes

                System.out.println("ID: " + id + ", Nombre: " + nombre);
                // Imprime otros campos si es necesario
            }

            // Cierra la conexión y el resultado
            resultado.close();
            statement.close();
            conexion.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el controlador JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo establecer la conexión a la base de datos.");
            e.printStackTrace();
        }
    }
}
