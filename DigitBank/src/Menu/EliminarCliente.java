/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;
import java.util.Scanner;

public class EliminarCliente {
    public static void EliminarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese DNI del cliente a Eliminar");
        // Aquí debes insertar el query 

        System.out.println("Desea Eliminar el Cliente (Y/N)");
        String opcion = sc.next().toUpperCase();
        
        switch (opcion) {
            case "Y":
                System.out.println("Se ha eliminado correctamente");
                break;
            case "N":
                System.out.println("Se cancela la eliminación");
                break;
            default:
                System.out.println("Ingrese Y para eliminar o N para NO eliminar el cliente");
                break;
        }
        sc.close();
    }
}
