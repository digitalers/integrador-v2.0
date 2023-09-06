package dbConnection;

import clases.Carrera;
import clases.Estudiante;
import clases.Matricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MatriculaDB {
    public boolean matricularEstudiante(Matricula matricula,int id) {
        Connection connection = ConnectionMySQL.getConnection();
        try {

            // Query SQL para insertar un estudiante en la base de datos
            String query = "INSERT INTO matricula (idmatricula,estado,nombreInstituto,fechaMatriculacion) " +
                    " VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, matricula.getIdMatricula());
            preparedStatement.setString(2, matricula.getEstado());
            preparedStatement.setString(3, matricula.getNombreInstituto());
            preparedStatement.setDate(4, new java.sql.Date(matricula.getFechaMatriculacion().getTime()));


            int rowsAffected = preparedStatement.executeUpdate();

            if(!actualizarMatricula(id)){
                return false;
            }

            // Comprobar si se ha insertado correctamente
            if (rowsAffected > 0) {
                return true; // Éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMySQL.closeConnection(connection);
        }

        return false; // Fallo en la inserción
    }

    public boolean actualizarMatricula(int id) {
        Connection connection = ConnectionMySQL.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            // Query SQL para actualizar la dirección de un estudiante en la base de datos
            String query = "UPDATE estudiante SET idMatricula = ? WHERE idEstudiante = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id);

            int rowsAffected = preparedStatement.executeUpdate();

            // Comprobar si se ha actualizado correctamente
            if (rowsAffected > 0) {
                return true; // Éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionMySQL.closeConnection(connection);
        }

        return false; // Fallo en la actualización

    }






}
