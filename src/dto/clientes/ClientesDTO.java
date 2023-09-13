package dto.clientes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import excepciones.Excepciones;
import modelos.clientes.Clientes;
import repositorio.clientes.ClientesRepositorio;

public class ClientesDTO extends Conexion implements ClientesRepositorio {

    @Override
    public void crearCliente(Clientes cliente) throws Excepciones {

        try {
            String sql = "INSERT INTO clientes (nombre, apellido, dni, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement query = connection.prepareStatement(sql);

            query.setString(1, cliente.getNombre());
            query.setString(2, cliente.getApellido());
            query.setString(3, cliente.getDni());
            query.setString(4, cliente.getDireccion());
            query.setString(5, cliente.getTelefono());
            query.setString(6, cliente.getEmail());

            query.executeUpdate();

            System.out.println();
            System.out.printf("El cliente %s %s en la base de datos", cliente.getNombre(), cliente.getApellido());
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public void removerCliente(Clientes cliente) throws Excepciones {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("null");
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public ResultSet obtenerPorDni(String dni) throws Excepciones {
        try {
            String sql = "SELECT * FROM clientes WHERE dni = ?";

            PreparedStatement query = connection.prepareStatement(sql);

            query.setString(1, dni);

            ResultSet result = query.executeQuery();
            return result;
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }
    
}
