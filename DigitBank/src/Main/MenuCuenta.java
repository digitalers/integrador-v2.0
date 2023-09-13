package Main;

import Entidades.Clientes;
import Entidades.Cuenta;
import Entidades.CuentaAhorro;
import Entidades.CuentaCorriente;

import java.util.Scanner;

public class MenuCuenta {
    Scanner sc = new Scanner(System.in);
    public boolean asignarCuenta(Clientes cliente) {
        boolean salir = false;
        while (!salir) {
            System.out.println("--------------------------");
            System.out.println("Elija el tipo de cuenta que desea crear:");
            System.out.println("1- Crear Cuenta de Ahorro");
            System.out.println("2- Crear Cuenta Corriente");
            System.out.println("10- Salir");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                System.out.println("Se ah creado correctamente la CA");
                salir = true;
                return true;}
            if (opcion == 2) {
                System.out.println("Se ah creado correctamente la CC");
                salir = true;
                return false;
            } else {
                System.out.println("Ingrese una opcion correcta");
            }
        }return false;
    }
}
