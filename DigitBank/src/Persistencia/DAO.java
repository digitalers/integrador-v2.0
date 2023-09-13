package Persistencia;

import java.sql.*;

public class DAO {
    private static final String url = "jdbc:mysql://localhost:3306/banco";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection conector = null;
    private static Statement sentencia;
    private static ResultSet resultado;

    public static void conexion() throws SQLException {
        try {
            conector = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new SQLException("Error al conectar a la base de datos", e);

        }
    }

    public static void desconexion() throws SQLException {
        try {
            if (conector != null) {
                conector.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
             if (resultado != null){
                 resultado.close();
           }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void insertarActualizarEliminar(String query) throws SQLException {
        try {
            conexion();
            sentencia = conector.createStatement();
             int insercion = sentencia.executeUpdate(query);
            desconexion();
        }  catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        } finally {
            desconexion();

        }

    }

    public static ResultSet consultaMostrar(String query) throws SQLException {
        try {
            conexion();
            sentencia = conector.createStatement();
            resultado = sentencia.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
return resultado;
    }




}
