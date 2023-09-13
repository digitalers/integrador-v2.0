/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**

teniendo en cuenta que la primera tiene un límite de descubierto 
y la segunda tiene una tasa de interés. 

Implementa los constructores, getters, setters y toString correspondientes para todas las clases. 

Finalmente, crea un objeto de tipo CuentaCorriente y otro de tipo CuentaAhorro, 
y realiza algunas operaciones de depósito y retiro sobre ellos, 
mostrando el estado de las cuentas después de cada operación.

 */
public abstract class Cuenta {
    private int numeroDeCuenta;
    private double saldo;
    private String titular;
    private String tipo;

    public Cuenta() {
    }

    public void retirarDinero(){
    }
    
    public void depositarDinero(){
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
