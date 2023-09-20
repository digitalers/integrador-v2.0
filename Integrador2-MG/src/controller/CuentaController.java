
package controller;

import dao.CuentaDao;
import integrador2.mg.conexion.ConnectionFactory;
import integrador2.mg.models.CuentaAhorro;
import integrador2.mg.models.CuentaCorriente;
import java.sql.Connection;


public class CuentaController {
    private CuentaDao cuentadao;
    
    
    public CuentaController(){
            Connection connection = new ConnectionFactory().recuperarConexion();
            this.cuentadao= new CuentaDao(connection);
}
    
    public void guardarCCte(CuentaCorriente ccte){
        this.cuentadao.guardar(ccte);
    }
    public void actSaldoCcte(CuentaCorriente ccte){
        this.cuentadao.actSaldo(ccte);
    }
    
    public void guardarCAh(CuentaAhorro cah){
        this.cuentadao.guardar(cah);
    }
    public void actSaldoAh(CuentaAhorro cah){
        this.cuentadao.actSaldo(cah);
    }
}
