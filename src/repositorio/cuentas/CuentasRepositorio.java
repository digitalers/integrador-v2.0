package repositorio.cuentas;

import java.sql.ResultSet;

import excepciones.Excepciones;

public interface CuentasRepositorio<T> {

    public void crearCuenta(T cuenta) throws Excepciones;

    public void eliminarCuenta(int id) throws Excepciones;

    public void aumentarDinero(int id, int monto) throws Excepciones;

    public void retirarDinero(int id, int monto) throws Excepciones;

    public ResultSet obtenerTodasLasCuentas() throws Excepciones;

    public ResultSet obtenerPorDni(String dni) throws Excepciones;

    public void crearTransaccion(int cuentaOrigen, int cuentaDestino, String tipo, int saldo, int monto) throws Excepciones;

    public ResultSet obtenerTodasLasTransacciones() throws Excepciones;
}
