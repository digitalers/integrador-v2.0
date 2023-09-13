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
public class IngresarDinero {

    public static void IngresarDinero() {
        System.out.println("Ingrese DNI del cliente");

        System.out.println("Ingrese cantidad a ingresar");

        Scanner sc = new Scanner(System.in);

        System.out.println("Desea confirmar el ingreso? (Y/N)");
        String opcion = sc.next().toUpperCase();

        switch (opcion) {
            case "Y":
                System.out.println("Se acredito el saldo en su cuenta");
                break;
            case "N":
                System.out.println("Se cancela la operacion");
                break;
            default:
                System.out.println("Ingrese Y para continuar o N cancelar");
                break;
        }
        sc.close();
    }
}
