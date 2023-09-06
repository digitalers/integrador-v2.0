package dbConnection;

import clases.Asignatura;
import clases.Carrera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsignaturaDB {
    public ArrayList<Asignatura> buscarAsignaturasCarrera(Carrera carrera) {
        Connection connection = ConnectionMySQL.getConnection();
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        int idCarrera = carrera.getIdCarrera();

        try {

            String query = "SELECT idasignatura,nombre from asignatura where idcarrera = ?"; // Ajusta la consulta SQL según tu estructura de tabla


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCarrera);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idAsignatura = resultSet.getInt("idAsignatura");
                String nombre = resultSet.getString("nombre");

                Asignatura asignatura = new Asignatura(idAsignatura, nombre);
                asignaturas.add(asignatura);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionMySQL.closeConnection(connection);
        }

        return asignaturas;
    }

    public void mostrarAsignaturas(ArrayList<Asignatura> asignaturas){
        System.out.println("ASIGNATURAS: ");

        for (Asignatura asignatura : asignaturas) {
            System.out.println("ID: " + asignatura.getIdAsignatura() + " NOMBRE: " + asignatura.getNombre());
        }
        System.out.println();
    }
}
