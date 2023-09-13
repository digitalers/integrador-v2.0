/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Entidades.Clientes;
import Persistencia.ClientesDAO;
import java.util.Scanner;
import java.sql.SQLException;

public class NuevoCliente {

    public static void NuevoCliente() {

        Scanner sc = new Scanner(System.in);
        Clientes cliente = new Clientes();
        System.out.println("Ingresa los datos del cliente");
        System.out.println("nombre completo: ");
        cliente.setNombre(sc.nextLine());
        System.out.println("Dni: ");
        cliente.setDni(sc.nextLine());
        System.out.println("Direccion: ");
        cliente.setDireccion(sc.nextLine());
        System.out.println("Telefono: ");
        cliente.setTelefono(sc.nextLine());
        System.out.println("Email: ");
        cliente.setEmail(sc.nextLine());

        try {
            ClientesDAO.insertarCliente(cliente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
