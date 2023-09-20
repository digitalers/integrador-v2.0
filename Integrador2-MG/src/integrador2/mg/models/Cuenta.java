
package integrador2.mg.models;


public abstract class Cuenta {
 /*atributos numero, saldo y titular*/ 
    
    int numero_cuenta;
    Titular titular;
    double saldo;
    CuentaEnum tipo_cuenta;

    public Cuenta(Titular titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    
    

    



    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public CuentaEnum getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(CuentaEnum tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

   
    
    /*los métodos abstractos depositar y retirar*/
    public abstract void depositar(float monto);
    public abstract void retirar(float monto);

    @Override
    public String toString() {
        return "Cuenta{dni° " + titular.getDni() + " numero de cuenta = "+ numero_cuenta +
                " saldo=" + saldo + ", ID del titular=" + 
                titular.getIdTitular() + '}';
    }

   

    
    
    
   
}
