
package integrador2.mg.conexion;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;
import javax.sql.DataSource;



public class ConnectionFactory {
    public DataSource datasource;
    
    /*public static Connection obtenerConexion(){
        Connection conexion= null;
        try{
            conexion= DriverManager.getConnection("jdbc:mysql://localhost/banco?useTimeZone=true&serverTimeZone=UTC",
                    "root","6427EnV@" );
        }catch(SQLException e){
            System.out.println("Error al obtener conexión" + e.getMessage());
        }
        return conexion;
    }*/
    public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/banco?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("6427EnV@");
		

		this.datasource = comboPooledDataSource;
	}
    
    public Connection recuperarConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
