package Entidades;

public class CuentaCorriente extends Cuenta {
    private double limiteDeDescubierto;
    private double tasaInteres;
    private String tipo = "Cuenta corriente";



    public CuentaCorriente() {
    }

    @Override
    public void retirarDinero() {
    }

    @Override
    public void depositarDinero() {
    }


    public double getLimiteDeDescubierto(
    ) {
        limiteDeDescubierto = 50000;
        return limiteDeDescubierto;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
}


