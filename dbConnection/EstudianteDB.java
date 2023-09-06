package dbConnection;

import clases.Carrera;
import clases.Estudiante;
import clases.Matricula;
import com.mysql.cj.jdbc.exceptions.SQLError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EstudianteDB {



    public Estudiante buscarEstudiantePorId(int idEstudiante) {

        Estudiante estudiante = null;
        Connection connection = ConnectionMySQL.getConnection();

        try {
            String query = "SELECT e.*, m.estado, e.idCarrera, c.nombre, c.sede FROM estudiante e " +
                    "INNER JOIN matricula m ON e.idMatricula = m.idMatricula "+
                    "INNER JOIN carrera c ON e.idCarrera = c.idCarrera " +
                    "WHERE e.idEstudiante = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idEstudiante);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("idestudiante");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                int dni = resultSet.getInt("dni");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                int idCarrera = resultSet.getInt("idCarrera");
                String nombreCarrera = resultSet.getString("c.nombre");
                String sedeCarrera = resultSet.getString("sede");
                String universidad = resultSet.getString("universidad");
                Date fechaIngreso = resultSet.getDate("fechaIngreso");
                float promedio = resultSet.getFloat("promedio");



                int idMatricula = resultSet.getInt("idMatricula");
                String estado = resultSet.getString("estado");
                Matricula matricula = new Matricula(idMatricula,estado);
                Carrera carrera = new Carrera(idCarrera, nombreCarrera,sedeCarrera);
                estudiante = new Estudiante(nombre, apellido, dni, direccion, telefono, id, carrera, universidad, fechaIngreso, promedio, matricula);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionMySQL.closeConnection(connection);
        }

        return estudiante;
    }

    public ArrayList<Estudiante> buscarEstudiantes() {
        Connection connection = ConnectionMySQL.getConnection();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Estudiante estudiante = null;

        try {

            String query = "SELECT e.*, m.estado, e.idCarrera, c.nombre, c.sede FROM estudiante e " +
                    "INNER JOIN matricula m ON e.idMatricula = m.idMatricula "+
                    "INNER JOIN carrera c ON e.idCarrera = c.idCarrera order by idEstudiante"; // Ajusta la consulta SQL según tu estructura de tabla

            //String query = "SELECT idestudiante, nombre FROM estudiante";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idestudiante");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                int dni = resultSet.getInt("dni");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                int idCarrera = resultSet.getInt("idCarrera");
                String nombreCarrera = resultSet.getString("c.nombre");
                String sedeCarrera = resultSet.getString("sede");
                String universidad = resultSet.getString("universidad");
                Date fechaIngreso = resultSet.getDate("fechaIngreso");
                float promedio = resultSet.getFloat("promedio");
                int idMatricula = resultSet.getInt("idMatricula");
                String estado = resultSet.getString("estado");
                Matricula matricula = new Matricula(idMatricula,estado);
                Carrera carrera = new Carrera(idCarrera, nombreCarrera,sedeCarrera);
                estudiante = new Estudiante(nombre, apellido, dni, direccion, telefono, id, carrera, universidad, fechaIngreso, promedio, matricula);

                estudiantes.add(estudiante);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMySQL.closeConnection(connection);
        }

        return estudiantes;
    }

    public boolean registrarEstudiante(Estudiante estudiante) {
        Connection connection = ConnectionMySQL.getConnection();

        try {

            // Query SQL para insertar un estudiante en la base de datos
            String query = "INSERT INTO estudiante (idEstudiante, nombre,apellido,dni,direccion,telefono,idCarrera,universidad,fechaIngreso,promedio,idMatricula) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, estudiante.getIdEstudiante());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setString(3, estudiante.getApellido());
            preparedStatement.setInt(4, estudiante.getDni());
            preparedStatement.setString(5, estudiante.getDireccion());
            preparedStatement.setString(6, estudiante.getTelefono());
            preparedStatement.setInt(7, estudiante.getCarrera().getIdCarrera());
            preparedStatement.setString(8, estudiante.getUniversidad());
            preparedStatement.setDate(9, new java.sql.Date(estudiante.getFechaIngreso().getTime()));
            preparedStatement.setFloat(10, estudiante.getPromedio());
            preparedStatement.setInt(11, 0);



            int rowsAffected = preparedStatement.executeUpdate();

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

    public boolean eliminarEstudiante(int idEstudiante) {
        Connection connection = ConnectionMySQL.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            // Query SQL para eliminar un estudiante de la base de datos por su ID
            String query = "DELETE FROM estudiante WHERE idEstudiante = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, idEstudiante);

            int rowsAffected = preparedStatement.executeUpdate();

            // Comprobar si se ha eliminado correctamente
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

        return false; // Fallo en la eliminación
    }

    public boolean modificarEstudiante(int idEstudiante, String nuevaDireccion) {
        Connection connection = ConnectionMySQL.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            // Query SQL para actualizar la dirección de un estudiante en la base de datos
            String query = "UPDATE estudiante SET direccion = ? WHERE idEstudiante = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nuevaDireccion);
            preparedStatement.setInt(2, idEstudiante);

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
