/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *//*

package Menu;

import java.util.Scanner;


public class Menu {
    private boolean salir = false;
    private Scanner sc = new Scanner(System.in);
    public void mostrarMenu() {
        while (!salir) {
            System.out.println("Bienvenido a DigitBank");
            System.out.println("1- Ingresar nuevo cliente");
            System.out.println("2- Eliminar cliente por DNI");
            System.out.println("3- Consultar datos de cliente");
            System.out.println("4- Actualizar datos de cliente");
            System.out.println("5- Buscar Cuentas");
            System.out.println("6- Ingresar Dinero");
            System.out.println("7- Retirar Dinero"); // verificar la cantidad
            System.out.println("8- Transferir Dinero");
            System.out.println("9- Consultar transacciones"); // ingrese DNI 
            System.out.println("10- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    NuevoCliente.NuevoCliente();
                    break;
                case 2:
                    EliminarCliente.EliminarCliente();
                    break;
                case 3:
                    ConsultarDatos.ConsultarDatos();
                    break;
                case 4:
                    ActualizarDatos.ActualizarDatos();
                    break;
                case 5:
                    BuscarCuenta.BuscarCuenta();
                    break;
                case 6:
                    IngresarDinero.IngresarDinero();
                    break;
                case 7:
                    RetirarDinero.RetirarDinero();
                    break;
                case 8:
                    TransferirDinero.TransferirDinero();
                    break;
                case 9:
                    ConsultarTransaccion.ConsultarTransaccion();
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente");
            }
        }
    }
}

*/
