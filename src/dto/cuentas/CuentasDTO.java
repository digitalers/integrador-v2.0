package dto.cuentas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import conexion.Conexion;
import excepciones.Excepciones;
import modelos.cuentas.cuentaAhorro.CuentaAhorro;
import modelos.cuentas.cuentaCorriente.CuentaCorriente;
import repositorio.cuentas.CuentasRepositorio;

public class CuentasDTO<T> extends Conexion implements CuentasRepositorio<T> {

    @Override
    public void crearCuenta(T cuenta) throws Excepciones {

        PreparedStatement query;

        try {
            if (cuenta instanceof CuentaCorriente) {
                CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;

                String sql = "INSERT INTO cuentas (cliente_id, numero, saldo, titular, limite_de_dinero, tipo_de_cuenta) VALUES (?, ?, ?, ?, ?, ?)";

                query = connection.prepareStatement(sql);
                
                query.setInt(1, cuentaCorriente.getCliente_id());
                query.setString(2, cuentaCorriente.getNumero());
                query.setInt(3, cuentaCorriente.getSaldo());
                query.setString(4, cuentaCorriente.getTitular());
                query.setInt(5, cuentaCorriente.getLimiteDeDinero());
                query.setString(6, cuentaCorriente.getTipoDeCuenta());

                query.executeUpdate();
                
                System.out.println("Cuenta corriente generada generada");
            }
            else if (cuenta instanceof CuentaAhorro) {
                CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;

                String sql = "INSERT INTO cuentas (cliente_id, numero, saldo, titular, tasa_de_interes, tipo_de_cuenta) VALUES (?, ?, ?, ?, ?, ?)";

                query = connection.prepareStatement(sql);
                

                query.setInt(1, cuentaAhorro.getCliente_id());
                query.setString(2, cuentaAhorro.getNumero());
                query.setInt(3, cuentaAhorro.getSaldo());
                query.setString(4, cuentaAhorro.getTitular());
                query.setInt(5, cuentaAhorro.getTasaDeInteres());
                query.setString(6, cuentaAhorro.getTipoDeCuenta());

                query.executeUpdate();
                
                System.out.println("Cuenta de ahorro generada");
            }
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public void eliminarCuenta(int id) throws SQLException {
        try {
            String sql = "DELETE FROM cuentas WHERE cliente_id = ?";

            PreparedStatement query = connection.prepareStatement(sql);

            query.setInt(1, id);
            query.executeUpdate();

            System.out.println();
            System.out.printf("La cuenta se ha eliminado con exito");
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public void aumentarDinero(int id, int monto) throws SQLException {
        try {
            String sql = "UPDATE cuentas SET saldo = saldo + ? WHERE id = ?";

            PreparedStatement query = connection.prepareStatement(sql);

            query.setInt(1, monto);
            query.setInt(2, id);

            query.executeUpdate();
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public void retirarDinero(int id, int monto) throws SQLException {
        try {
            String sql = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";

            PreparedStatement query = connection.prepareStatement(sql);

            query.setInt(1, monto);
            query.setInt(2, id);

            query.executeUpdate();
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public ResultSet obtenerPorDni(String dni) throws Excepciones {
        try {
            String sql = "SELECT * FROM clientes LEFT JOIN cuentas ON cuentas.cliente_id = clientes.id WHERE clientes.dni = ?";
            PreparedStatement query = connection.prepareStatement(sql);
            
            query.setString(1, dni);
            ResultSet result = query.executeQuery();
            
            return result;
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public ResultSet obtenerTodasLasCuentas() throws Excepciones {
        try {
            String sql = "SELECT *, COUNT(transacciones.id_cliente) AS maxTransacciones FROM cuentas LEFT JOIN clientes ON cuentas.cliente_id = clientes.id LEFT JOIN transacciones ON cuentas.cliente_id = transacciones.id_cliente GROUP BY cuentas.cliente_id";

            PreparedStatement query = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = query.executeQuery();
            return result;
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public void crearTransaccion(int cuentaOrigen, int cuentaDestino, String tipo, int saldo, int monto) throws SQLException {
        try {
            String sql = "INSERT INTO transacciones (fecha, hora, id_cliente, id_cuenta, tipo, monto) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement query = connection.prepareStatement(sql);

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now().withNano(0);

            query.setString(1, fecha.toString());
            query.setString(2, hora.toString());
            query.setInt(3, cuentaOrigen);
            query.setInt(4, cuentaDestino);
            query.setString(5, tipo);
            query.setInt(6, monto);

            query.executeUpdate();
            System.out.println();
            System.out.printf("\n\nSe realizó la operación con exito\n\n- Fecha: %s\n- Hora: %s\n- Tipo: %s\n\n", 
                fecha,
                hora,
                tipo
            );
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }

    @Override
    public ResultSet obtenerTodasLasTransacciones() throws SQLException {
        try {
            String sql = "SELECT * FROM transacciones";

            PreparedStatement query = connection.prepareStatement(sql);

            ResultSet result = query.executeQuery();
            return result;
        }
        catch (SQLException e) {
            throw new Excepciones(e.getMessage());
        }
    }
    
}
