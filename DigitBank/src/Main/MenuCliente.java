package Main;

import Entidades.Clientes;
import Entidades.Cuenta;
import Entidades.CuentaAhorro;
import Entidades.CuentaCorriente;
import Persistencia.ClientesDAO;
import Persistencia.CuentasDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuCliente {
    MenuCuenta menuCuenta = new MenuCuenta();
    Scanner sc = new Scanner(System.in);

    public void menuCrearCliente() {
        Clientes cliente = new Clientes();
        System.out.println("Ingresa los datos del cliente");

            System.out.println("Nombre completo: ");
            cliente.setNombre(sc.nextLine());
            System.out.println("Dni: ");
            cliente.setDni(sc.nextLine());
            System.out.println("Direccion: ");
            cliente.setDireccion(sc.nextLine());
            System.out.println("Telefono: ");
            cliente.setTelefono(sc.nextLine());
            System.out.println("Email: ");
            cliente.setEmail(sc.nextLine());
            if (menuCuenta.asignarCuenta(cliente)) {
                CuentaAhorro cuentaAhorro = new CuentaAhorro();
                cliente.setCuenta(cuentaAhorro);
                cuentaAhorro.setTitular(cliente.getNombre());
                System.out.println("Insertar dinero que sera saldo de su cuenta: ");
                cuentaAhorro.setSaldo(sc.nextDouble());
                try {
                    ClientesDAO.insertarCliente(cliente);
                    CuentasDAO.insertarCuentaAhorro(cuentaAhorro);
                    ClientesDAO.asignarCuenta(cliente,cuentaAhorro);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                CuentaCorriente cuentaCorriente = new CuentaCorriente();
                cliente.setCuenta(cuentaCorriente);
                cuentaCorriente.setTitular(cliente.getNombre());
                System.out.println("Insertar dinero que sera saldo de su cuenta: ");
                cuentaCorriente.setSaldo(sc.nextDouble());
                try {
                    ClientesDAO.insertarCliente(cliente);
                    CuentasDAO.insertarCuentaCorriente(cuentaCorriente);
                    ClientesDAO.asignarCuenta(cliente,cuentaCorriente);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /*public void buscarYEliminarCliente() {
        System.out.println("Inserte su DNI");
        String numero = sc.nextLine();
        Clientes cliente = new Clientes();
        cliente.setDni(numero);

        if (ClientesDAO.existeCliente(cliente)) {
            ClientesDAO.eliminarCliente(cliente);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("El cliente con el DNI proporcionado no existe en la base de datos.");
        }
    }
    public void buscarYMostrarCliente(){
        System.out.println("Inserte su DNI");
        String numero = sc.nextLine();
        Clientes cliente = new Clientes();
        cliente.setDni(numero);
        if (ClientesDAO.existeCliente(cliente)) {
            ClientesDAO.mostrarClientes(cliente);

        } else {
            System.out.println("El cliente con el DNI proporcionado no existe en la base de datos.");
        }
    }
    }

*/