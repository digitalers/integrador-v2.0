
package dao;

import integrador2.mg.models.CuentaAhorro;
import integrador2.mg.models.CuentaCorriente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CuentaDao {
        private Connection connection;

        public CuentaDao(Connection connection){
        this.connection= connection;
    }
        public void guardar(CuentaCorriente ccte){
    try {
       String sql ="INSERT into cuenta(saldo,tipo_cuenta, adicional,cliente_idcliente )"
               + "values(?,?,?,?)"; 
       	try (PreparedStatement pstm = connection.prepareStatement
        (sql, Statement.RETURN_GENERATED_KEYS)) {
        pstm.setDouble(1, ccte.getSaldo());
        pstm.setString(2, "cuenta_corriente");
        pstm.setString(3, "limite_descub");
        pstm.setInt(4, ccte.getTitular().getIdTitular());
        
        pstm.execute();
        
        try(ResultSet rst= pstm.getGeneratedKeys()){
            while(rst.next()){
                ccte.setNumero_cuenta(rst.getInt(1));
            }
        }

    
} }catch(SQLException e){
    throw new RuntimeException(e);
}    

}
        ///actualizar saldo
        public void actSaldo(CuentaCorriente ccte){
            try{
                String sql = "UPDATE cuenta set saldo=? where tipo_cuenta= 'cuenta_corriente' and cliente_idcliente =?";
                try (PreparedStatement pstm = connection.prepareStatement
        (sql, Statement.RETURN_GENERATED_KEYS)) {
                    pstm.setDouble(1, ccte.getSaldo());
                    pstm.setInt(2, ccte.getTitular().getIdTitular());
                    pstm.execute();
                }}catch(SQLException e){
    throw new RuntimeException(e);
} 
            
        }
        ///////
         public void guardar(CuentaAhorro cah){
    try {
       String sql ="INSERT into cuenta(saldo,tipo_cuenta, adicional,cliente_idcliente )"
               + "values(?,?,?,?)"; 
       	try (PreparedStatement pstm = connection.prepareStatement
        (sql, Statement.RETURN_GENERATED_KEYS)) {
        pstm.setDouble(1, cah.getSaldo());
        pstm.setString(2, "cuenta_ahorro");
        pstm.setString(3, "interes");
        pstm.setInt(4, cah.getTitular().getIdTitular());
        
        pstm.execute();
        
        try(ResultSet rst= pstm.getGeneratedKeys()){
            while(rst.next()){
                cah.setNumero_cuenta(rst.getInt(1));
            }
        }

    
} }catch(SQLException e){
    throw new RuntimeException(e);
}    

}
         public void actSaldo(CuentaAhorro cah){
            try{
                String sql = "UPDATE cuenta set saldo=? where tipo_cuenta= 'cuenta_ahorro' and cliente_idcliente =?";
                try (PreparedStatement pstm = connection.prepareStatement
        (sql, Statement.RETURN_GENERATED_KEYS)) {
                    pstm.setDouble(1, cah.getSaldo());
                    pstm.setInt(2, cah.getTitular().getIdTitular());
                    pstm.execute();
                }}catch(SQLException e){
    throw new RuntimeException(e);
} 
            
        }
         
       
}
