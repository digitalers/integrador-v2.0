package Persistencia;

import Entidades.Clientes;
import Entidades.Cuenta;
import Entidades.CuentaAhorro;
import Entidades.CuentaCorriente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Persistencia.DAO.*;

public class CuentasDAO {

    public static void insertarCuentaAhorro(CuentaAhorro cuenta) throws SQLException {
        try {
            if (cuenta == null) {
                throw new Exception("Indique una cuenta");
            }
            String query = "INSERT INTO Cuenta(TIPO, SALDO, LIMITEDEDESCUBIERTO, TASADEINTERES) VALUES ('"
                    + cuenta.getTipo() + "','" + cuenta.getSaldo() + "','"
                    + cuenta.getLimiteDeDescubierto() + "','" + cuenta.getTasaInteres() +"')";
            insertarActualizarEliminar(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertarCuentaCorriente(CuentaCorriente cuenta) throws SQLException {
        try {
            if (cuenta == null) {
                throw new Exception("Indique una cuenta");
            }
            String query = "INSERT INTO Cuenta(TIPO, SALDO, LIMITEDEDESCUBIERTO, TASADEINTERES) VALUES ('"
                    + cuenta.getTipo() + "','" + cuenta.getSaldo() + "','"
                    + cuenta.getLimiteDeDescubierto() + "','" + cuenta.getTasaInteres() +"')";
            insertarActualizarEliminar(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static int obtenerUltimoIdGenerado() throws SQLException {
        try {
            String query = "SELECT LAST_INSERT_ID()";
            ResultSet resultSet = DAO.consultaMostrar(query); // Utiliza el método consultaMostrar del DAO
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener el último ID generado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el último ID generado: " + e.getMessage());
            return -1; // Devuelve un valor negativo en caso de error
        }
    }


    public static void ingresarDineroPorDNI(Clientes cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad a ingresar: ");
        double cantidad = scanner.nextDouble();

        try {
            // Realizar un JOIN entre las tablas Cliente y Cuenta usando la columna CUENTA
            String consultaSaldo = "SELECT SALDO FROM Cliente AS C INNER JOIN Cuenta AS CU ON C.CUENTA = CU.ID WHERE C.DNI = '" + cliente.getDni() + "'";
            ResultSet resultSetSaldo = consultaMostrar(consultaSaldo);

            if (resultSetSaldo.next()) {
                double saldoActual = resultSetSaldo.getDouble("SALDO");

                // Verificar que la cantidad ingresada sea válida (positiva)
                if (cantidad > 0) {
                    double nuevoSaldo = saldoActual + cantidad;

                    // Actualizar el saldo en la tabla Cuenta
                    String actualizarSaldo = "UPDATE Cuenta SET SALDO = " + nuevoSaldo + " WHERE ID = (SELECT CUENTA FROM Cliente WHERE DNI = '" + cliente.getDni() + "')";
                    insertarActualizarEliminar(actualizarSaldo);
                    System.out.println("Ingreso exitoso. Nuevo saldo: " + nuevoSaldo);
                } else {
                    System.err.println("La cantidad a ingresar debe ser positiva.");
                }
            } else {
                System.err.println("No se pudo obtener el saldo de la cuenta del cliente.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void retirarDineroPorDNI(Clientes cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();

        try {
            // Realizar un JOIN entre las tablas Cliente y Cuenta usando la columna CUENTA
            String consultaSaldo = "SELECT SALDO FROM Cliente AS C INNER JOIN Cuenta AS CU ON C.CUENTA = CU.ID WHERE C.DNI = '" + cliente.getDni() + "'";
            ResultSet resultSetSaldo = consultaMostrar(consultaSaldo);

            if (resultSetSaldo.next()) {
                double saldoActual = resultSetSaldo.getDouble("SALDO");

                // Verificar si hay suficiente saldo para realizar el retiro
                if (saldoActual >= cantidad) {
                    double nuevoSaldo = saldoActual - cantidad;

                    // Actualizar el saldo en la tabla Cuenta
                    String actualizarSaldo = "UPDATE Cuenta SET SALDO = " + nuevoSaldo + " WHERE ID = (SELECT CUENTA FROM Cliente WHERE DNI = '" + cliente.getDni() + "')";
                    insertarActualizarEliminar(actualizarSaldo);
                    System.out.println("Retiro exitoso. Nuevo saldo: " + nuevoSaldo);
                } else {
                    System.err.println("Saldo insuficiente para realizar el retiro.");
                }
            } else {
                System.err.println("No se pudo obtener el saldo de la cuenta del cliente.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarClientes(Clientes cliente) {
        String query = "SELECT * FROM CLIENTE WHERE DNI = '" + cliente.getDni() + "'";

        try {
            ResultSet resultSet = consultaMostrar(query);

            while (resultSet.next()) {
                String nombre = resultSet.getString("NOMBRECOMPLETO");
                String dni = resultSet.getString("DNI");
                String direccion = resultSet.getString("DIRECCION");
                String telefono = resultSet.getString("TELEFONO");
                String email = resultSet.getString("EMAIL");

                System.out.println("Nombre: " + nombre);
                System.out.println("DNI: " + dni);
                System.out.println("Dirección: " + direccion);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Email: " + email);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al mostrar los clientes: " + e.getMessage(), e);
        }
    }

}
