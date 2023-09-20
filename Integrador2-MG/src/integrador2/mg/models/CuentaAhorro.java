
package integrador2.mg.models;


public class CuentaAhorro extends Cuenta{
/*tasa de interés*/
    private float interes = 1f;
    private float monto;

    public CuentaAhorro(Titular titular, double saldo) {
        super(titular,saldo);
    }

   
    

    

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    

    @Override
    public void depositar(float monto) {
        
        setSaldo(getSaldo()+monto);
       
        System.out.println("Ha realizado un depósito de $ "+ monto +" de manera exitosa, su saldo actual es: $ " + getSaldo());
   
    }

    @Override
    public void retirar(float monto) {
        if(getSaldo()> monto){
        setSaldo(getSaldo()-monto);
            System.out.println("Ha realizado la extracción de $ " + monto +
                            " de manera exitosa, su saldo actual es de: $ " + getSaldo());
        }else{
            System.out.println("Fondos insuficientes. La extracción de dinero no puede realizarse");
        }
        }

    public void infoCA(){
        System.out.println("tipo de cuenta: Caja de Ahorro");
    }
    
    
  

 

    
    
}
