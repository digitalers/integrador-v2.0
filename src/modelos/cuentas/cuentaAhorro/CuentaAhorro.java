package modelos.cuentas.cuentaAhorro;

import modelos.cuentas.Cuentas;

public class CuentaAhorro extends Cuentas {

    int tasaDeInteres;
    String tipoDeCuenta;

    public CuentaAhorro() {
        
    }

    public CuentaAhorro(int cliente_id, String numero, int saldo, String titular, int tasaDeInteres, String tipoDeCuenta) {
        super(cliente_id, numero, saldo, titular);
        this.tasaDeInteres = tasaDeInteres;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public int getTasaDeInteres() {
        return tasaDeInteres;
    }

    public void setTasaDeInteres(int tasaDeInteres) {
        this.tasaDeInteres = tasaDeInteres;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }
}
