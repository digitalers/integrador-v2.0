/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
/*
 teniendo en cuenta que la primera tiene un límite de descubierto y la segunda tiene una tasa de interés
*/
public class CuentaAhorro extends Cuenta{
    
    private double tasaInteres;
    private double limiteDeDescubierto;
    private String tipo = "Cuenta de ahorro";


    public CuentaAhorro() {
    }

    @Override
    public void retirarDinero(){
    }
    
    @Override
    public void depositarDinero(){
    }

    public double getTasaInteres() {
        tasaInteres=10;
        return tasaInteres;
           }

    public double getLimiteDeDescubierto() {
        return limiteDeDescubierto;
    }

    public String getTipo() {
        return tipo;
    }
}
