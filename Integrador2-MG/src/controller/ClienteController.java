package controller;

import java.sql.*;
import dao.ClienteDao;
import integrador2.mg.conexion.ConnectionFactory;
import integrador2.mg.models.Titular;

public class ClienteController {

private ClienteDao clienteDao;

    public ClienteController() {
        Connection connection = new ConnectionFactory().recuperarConexion();
        this.clienteDao = new ClienteDao(connection);
    }


public void guardar(Titular cliente){
    this.clienteDao.guardar(cliente);
}
public void consultar( String dniconsulta) throws SQLException{
    this.clienteDao.consultaCuentasDni(dniconsulta);
}
public void consultarMov(String dnimovim) throws SQLException{
    this.clienteDao.consultaMovimDni(dnimovim);
}
public void eliminar(String dniE){
    this.clienteDao.EliminarCliente( dniE);
}
}
