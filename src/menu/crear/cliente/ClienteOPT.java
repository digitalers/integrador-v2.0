package menu.crear.cliente;

import java.util.Scanner;

import dto.clientes.ClientesDTO;
import excepciones.Excepciones;
import modelos.clientes.Clientes;

public class ClienteOPT {
    public ClienteOPT() throws Excepciones {
        Scanner scanner = new Scanner(System.in);
        
        String nombre;
        String apellido;
        String direccion;
        String email;
        String telefono;
        String dni;

        System.out.println("Escribe tu nombre");
        nombre = scanner.nextLine();

        System.out.println("Escribe tu apellido");
        apellido = scanner.nextLine();

        System.out.println("Escribe tu dirección");
        direccion = scanner.nextLine();

        System.out.println("Escribe tu email");
        email = scanner.nextLine();

        System.out.println("Escribe tu teléfono");
        telefono = scanner.nextLine();

        System.out.println("Escribe tu dni");
        dni = scanner.nextLine();

        Clientes cliente = new Clientes();

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setDni(dni);

        ClientesDTO clientes = new ClientesDTO();
        clientes.crearCliente(cliente);

        scanner.close();
    }
}
