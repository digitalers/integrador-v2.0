/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.util.Scanner;

/**
 *
 * @author alexx
 */
public class TransferirDinero {

    public static void TransferirDinero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese DNI de cliente");

        System.out.println("Ingrese DNI de cuenta destino");

        System.out.println("Desea transferir? (Y/N");
        String opcion = sc.next().toUpperCase();
        switch (opcion) {
            case "Y":
                System.out.println("Se ah transferido correctamente correctamente");
                break;
            case "N":
                System.out.println("Se ah cancelado");
                break;
            default:
                System.out.println("Ingrese Y para continuar o N para cancelar");
                break;
        }
    }
}
