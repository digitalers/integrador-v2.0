
package integrador2.mg.models;

import java.time.LocalDateTime;


public class Transaccion {
   public enum tipo_transaccion{
    deposito,
    extraccion
}
   private int idTransacciones;
         private  tipo_transaccion movimiento;
          private float monto;
          private LocalDateTime fecha_y_hora;
          private int cuenta_origen;
          private int cuenta_destino;
          private int cuenta_idcuenta;
          private int cuenta_cliente_idcliente;

    public Transaccion(tipo_transaccion movimiento, float monto, int cuenta_origen, int cuenta_destino) {
        this.movimiento = movimiento;
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
       
    }

    public Transaccion(tipo_transaccion movimiento, float monto, int cuenta_origen, int cuenta_destino, int cuenta_idcuenta, int cuenta_cliente_idcliente) {
        this.movimiento = movimiento;
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
        this.cuenta_idcuenta = cuenta_idcuenta;
        this.cuenta_cliente_idcliente = cuenta_cliente_idcliente;
    }

    public Transaccion(tipo_transaccion movimiento,LocalDateTime fecha_y_hora, float monto,  int cuenta_origen, int cuenta_destino, int cuenta_idcuenta, int cuenta_cliente_idcliente) {
        this.movimiento = movimiento;
        this.monto = monto;
        this.fecha_y_hora = fecha_y_hora;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
        this.cuenta_idcuenta = cuenta_idcuenta;
        this.cuenta_cliente_idcliente = cuenta_cliente_idcliente;
    }

    

    public int getIdTransacciones() {
        return idTransacciones;
    }

    public void setIdTransacciones(int idTransacciones) {
        this.idTransacciones = idTransacciones;
    }

    public tipo_transaccion getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(tipo_transaccion movimiento) {
        this.movimiento = movimiento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha_y_hora() {
        return fecha_y_hora;
    }

    public void setFecha_y_hora(LocalDateTime fecha_y_hora) {
        this.fecha_y_hora = fecha_y_hora;
    }

    public int getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(int cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public int getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

   

    public int getCuenta_idcuenta() {
        return cuenta_idcuenta;
    }

    public void setCuenta_idcuenta(int cuenta_idcuenta) {
        this.cuenta_idcuenta = cuenta_idcuenta;
    }

    public int getCuenta_cliente_idcliente() {
        return cuenta_cliente_idcliente;
    }

    public void setCuenta_cliente_idcliente(int cuenta_cliente_idcliente) {
        this.cuenta_cliente_idcliente = cuenta_cliente_idcliente;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "idTransaccion=" + idTransacciones + ", movimiento=" + movimiento + ", monto=" + monto + ", fecha_y_hora=" + fecha_y_hora + ", cuenta_origen=" + cuenta_origen + ", cuenta_destino=" + cuenta_destino + ", cuenta_idcuenta=" + cuenta_idcuenta + ", cuenta_cliente_idcliente=" + cuenta_cliente_idcliente + '}';
    }

    
                  
                  
                  
}
