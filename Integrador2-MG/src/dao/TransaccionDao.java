
package dao;

import integrador2.mg.models.Titular;
import integrador2.mg.models.Transaccion;
import integrador2.mg.models.Transaccion.tipo_transaccion;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;


public class TransaccionDao {
        private Connection connection;
    

        public TransaccionDao(Connection connection){
        this.connection= connection;
    }
        public void depositocuenta(Transaccion movim){
    try {
       String sql ="INSERT into transacciones("
               + "tipo_transaccion,"
               + "fecha_y_hora,"
               + "monto,"
               + "cuenta_origen,"
               + "cuenta_destino,"
               + "cuenta_idcuenta,"
               + "cuenta_cliente_idcliente) values(?,?,?,?,?,?,?)"; 
       	try (PreparedStatement pstm = connection.prepareStatement
        (sql, Statement.RETURN_GENERATED_KEYS)) {
        pstm.setString(1, "deposito");
        pstm.setObject(2, LocalDateTime.now());

        pstm.setFloat(3, movim.getMonto());
        pstm.setInt(4, movim.getCuenta_origen());
        pstm.setInt(5, movim.getCuenta_destino());
        pstm.setInt(6, movim.getCuenta_idcuenta());
        pstm.setInt(7, movim.getCuenta_cliente_idcliente());
        
        pstm.execute();
        
        try(ResultSet rst= pstm.getGeneratedKeys()){
            while(rst.next()){
                movim.setIdTransacciones(rst.getInt(1));
            }
        }

    
} }catch(SQLException e){
    throw new RuntimeException(e);
}    

}
        
        public void retirocuenta(Transaccion mov){
    try {
       String sql ="INSERT into transacciones(tipo_transaccion, fecha_y_hora, monto,"
               + " cuenta_origen, cuenta_destino,"
               + "cuenta_idcuenta, cuenta_cliente_idcliente) values(?,?,?,?,?,?,?)"; 
       	try (PreparedStatement pstm = connection.prepareStatement
        (sql, Statement.RETURN_GENERATED_KEYS)) {
        pstm.setString(1,"extraccion"); 
                pstm.setObject(2, LocalDateTime.now());
        pstm.setFloat(3, mov.getMonto());
        pstm.setInt(4, mov.getCuenta_origen());
        pstm.setInt(5, mov.getCuenta_destino());
        pstm.setInt(6, mov.getCuenta_idcuenta());
        pstm.setInt(7, mov.getCuenta_cliente_idcliente());
        
        pstm.execute();
        
        try(ResultSet rst= pstm.getGeneratedKeys()){
            while(rst.next()){
                mov.setIdTransacciones(rst.getInt(1));
            }
        }

    
} }catch(SQLException e){
    throw new RuntimeException(e);
}    

}
}
