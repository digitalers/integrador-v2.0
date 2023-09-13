package repositorio.clientes;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.clientes.Clientes;

public interface ClientesRepositorio {
    
    public void crearCliente(Clientes cliente) throws SQLException;

    public void removerCliente(Clientes cliente) throws SQLException;

    public ResultSet obtenerPorDni(String dni) throws SQLException;
    
}
