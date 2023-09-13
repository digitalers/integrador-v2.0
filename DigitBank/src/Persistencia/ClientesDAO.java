package Persistencia;

import Entidades.Clientes;
import Entidades.Cuenta;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO extends DAO {
    public static void insertarCliente(Clientes cliente) throws SQLException {
        try {
            if (cliente == null) {
                throw new Exception("Indique un usuario");
            }
            String query = "INSERT INTO Cliente (NOMBRECOMPLETO, DNI, DIRECCION, TELEFONO, EMAIL, CUENTA) VALUES ('"
                    + cliente.getNombre() + "','" + cliente.getDni() + "','"
                    + cliente.getDireccion() + "','" + cliente.getTelefono() + "','" + cliente.getEmail() + "',55)";
            insertarActualizarEliminar(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void asignarCuenta(Clientes cliente, Cuenta cuenta) throws SQLException {
        try {
            if (cliente == null || cuenta == null) {
                throw new Exception("Indique un cliente y una cuenta válidos");
            }
            int numeroDeCuenta = CuentasDAO.obtenerUltimoIdGenerado();
            cuenta.setNumeroDeCuenta(numeroDeCuenta);
            System.out.println("el numero de cuenta es :"+numeroDeCuenta);
            String query = "UPDATE banco.cliente SET CUENTA = " + cuenta.getNumeroDeCuenta() + " WHERE DNI = '" + cliente.getDni() + "'";
            insertarActualizarEliminar(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarCliente(Clientes cliente) {
        try {
            if (cliente == null) {
                throw new Exception("Indique un usuario");
            }
            String query = "DELETE FROM Cliente WHERE DNI = " + cliente.getDni();
            insertarActualizarEliminar(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //metodo para corroborar la existencia de un cliente
    public static boolean existeCliente(Clientes cliente) {
        try {
            if (cliente == null || cliente.getDni() == null || cliente.getDni().isEmpty()) {
                throw new IllegalArgumentException("El DNI del cliente no puede estar vacío.");
            }
            String query = "SELECT COUNT(*) FROM Cliente WHERE DNI = '" + cliente.getDni() + "'";
            ResultSet busqueda = DAO.consultaMostrar(query);

            if (busqueda.next()) {
                int count = busqueda.getInt(1);
                return count > 0; // Si el contador es mayor que cero, el cliente existe
            }
            return false; // Si no se encontraron resultados
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                desconexion();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

//mostrar clientes buscando por dni:
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
