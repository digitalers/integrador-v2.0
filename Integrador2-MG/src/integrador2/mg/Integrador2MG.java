
package integrador2.mg;
import java.sql.*;

import integrador2.mg.conexion.ConnectionFactory;


public class Integrador2MG {

   
    public static void main(String[] args) throws SQLException{
       ConnectionFactory conex = new ConnectionFactory();
       Connection connection = conex.recuperarConexion();
        		System.out.println("Cerrando conexion!!");
                        connection.close();

    }
    
}
