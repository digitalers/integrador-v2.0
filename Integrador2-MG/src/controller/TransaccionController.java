
package controller;

import dao.TransaccionDao;
import integrador2.mg.conexion.ConnectionFactory;
import integrador2.mg.models.Transaccion;

import java.sql.Connection;


public class TransaccionController {
        private TransaccionDao transacciondao;

          public TransaccionController(){
            Connection connection = new ConnectionFactory().recuperarConexion();
            this.transacciondao= new TransaccionDao(connection);
}
    
    public void MovDeposito(Transaccion mov){
        this.transacciondao.depositocuenta(mov);
    }
    public void MovRetiro(Transaccion mov){
        this.transacciondao.retirocuenta(mov);
        
    }
}
