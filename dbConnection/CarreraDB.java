package dbConnection;

import clases.Carrera;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CarreraDB {
    public ArrayList<Carrera> buscarCarreras() {
        Connection connection = ConnectionMySQL.getConnection();
        ArrayList<Carrera> carreras = new ArrayList<>();
        Carrera carrera = null;

        try {

            String query = "SELECT idcarrera,nombre,sede from carrera"; // Ajusta la consulta SQL según tu estructura de tabla


            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCarrera = resultSet.getInt("idCarrera");
                String nombre = resultSet.getString("nombre");
                String sede = resultSet.getString("sede");

                carrera = new Carrera(idCarrera, nombre,sede);
                carreras.add(carrera);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMySQL.closeConnection(connection);
        }

        return carreras;
    }




}
