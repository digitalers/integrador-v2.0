
package integrador2.mg.models;


public class CuentaCorriente extends Cuenta{

    /*limite al descubierto*/
    private int descubierto = 5000;

    public CuentaCorriente(Titular titular, double saldo) {
        super(titular, saldo);
 
    }

   
    
    public int getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(int descubierto) {
        this.descubierto = descubierto;
    }
    

    @Override
    public void depositar(float monto) {
        setSaldo(getSaldo()+monto);
        System.out.println("Ha realizado un depósito de $ "+ monto +" de manera exitosa, su saldo actual es: $ " + getSaldo());
    }

    @Override
    public void retirar(float monto) {
        double saldo=getSaldo();
        if((saldo-monto)<=0){
            setSaldo(descubierto);
                    System.out.println("su saldo es insuficiente, tiene a su favor un límite "
                            + "al descubierto de: $ " + getSaldo());

            
        }else{
            setSaldo(saldo-monto);
                    System.out.println("Ha realizado la extracción de $ " + monto +
                            " de manera exitosa, su saldo actual es de: $ " + getSaldo());

        }
        
    }
    public void infoCcte(){
        System.out.println("Tipo de cuenta: Cuenta Corriente");
    }
}
