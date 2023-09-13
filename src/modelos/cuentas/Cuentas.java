package modelos.cuentas;

import java.sql.SQLException;

import dto.cuentas.CuentasDTO;
import modelos.cuentas.cuentaCorriente.CuentaCorriente;

public abstract class Cuentas {
    private int cliente_id;
    private String numero;
    private int saldo;
    private String titular;

    public Cuentas() {
        
    }

    public Cuentas(int cliente_id, String numero, int saldo, String titular) {
        this.cliente_id = cliente_id;
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public String getNumero() {
        return numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public void depositar(int id, int monto) throws SQLException {
        CuentasDTO<CuentaCorriente> cuentasDTO = new CuentasDTO<CuentaCorriente>();
        cuentasDTO.aumentarDinero(id, monto);
    }

    public void retirar(int id, int monto) throws SQLException {
        CuentasDTO<CuentaCorriente> cuentasDTO = new CuentasDTO<CuentaCorriente>();
        cuentasDTO.aumentarDinero(id, monto);
    }  
}
