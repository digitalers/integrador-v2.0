package modelos.cuentas.cuentaCorriente;

import modelos.cuentas.Cuentas;

public class CuentaCorriente extends Cuentas {
    
    int limiteDeDinero;
    String tipoDeCuenta;

    public CuentaCorriente() {

    }

    public CuentaCorriente(int cliente_id, String numero, int saldo, String titular, int limiteDeDinero, String tipoDeCuenta) {
        super(cliente_id, numero, saldo, titular);
        this.limiteDeDinero = limiteDeDinero;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public int getLimiteDeDinero() {
        return limiteDeDinero;
    }

    public void setLimitDeDinero(int limiteDeDinero) {
        this.limiteDeDinero = limiteDeDinero;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }
}
