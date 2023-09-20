package integrador2.mg.gestor;

import controller.ClienteController;
import controller.CuentaController;
import controller.TransaccionController;
import integrador2.mg.models.CuentaAhorro;
import integrador2.mg.models.CuentaCorriente;
import integrador2.mg.models.Domicilio;
import integrador2.mg.models.Titular;
import integrador2.mg.models.Transaccion;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Gestor {

    public static void main(String[] args) throws SQLException {
        
        ClienteController ccontroller = new ClienteController();
        CuentaController ctecontroller = new CuentaController();
        CuentaController cahcontroller = new CuentaController();
        TransaccionController trcontroller = new TransaccionController();
        Scanner sc = new Scanner(System.in);
        String nombre, apellido, dni, correo, calle, barrio, ciudad, provincia, codigoP, dniconsulta, dnimovim ;
        double importe, dinerocaja;
        int telef, altura;
        System.out.println("Bienvenido a DigitBank");
        System.out.println("Creación de usuario");
        System.out.println("Ingrese Documento Nacional de Identidad : ");
        dni = sc.nextLine();
        System.out.println("Ingrese Apellido : ");
        apellido = sc.nextLine();
        System.out.print("Ingrese Nombre : ");
        nombre = sc.nextLine();
 
        System.out.println("Datos del domicilio");
        System.out.println("Ingrese Calle : ");
        calle = sc.nextLine();
        System.out.println("Ingrese Altura : ");
        altura = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese Barrio :");
        barrio = sc.nextLine();
        //sc.next();
        System.out.println("Ingrese Ciudad : ");
        ciudad = sc.nextLine();
        //sc.next();
        System.out.println("Ingrese Provincia : ");
        provincia = sc.nextLine();
        // sc.next();
        System.out.println("Ingrese Código Postal");
        codigoP = sc.nextLine();
//sc.next();
        System.out.println("Ingrese Teléfono : ");
        telef = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese Email : ");
        correo = sc.nextLine();

        Titular cliente = new Titular(dni, apellido, nombre, new Domicilio(calle,
                altura, barrio,
                ciudad, provincia, codigoP), telef, correo);
        
       
        ccontroller.guardar(cliente);
        System.out.println(cliente);
        System.out.println("----------------------------------------------");
        System.out.println("Creación de Cuenta Corriente");
        System.out.print("Ingrese monto del saldo: ");
        importe = sc.nextDouble();

        CuentaCorriente ccte = new CuentaCorriente( cliente, importe);

        ctecontroller.guardarCCte(ccte);
        System.out.println("Datos de la Cuenta Corriente creada");
        System.out.println(ccte);
                System.out.println("----------------------------------------------");

        System.out.println("Realice el depósito");
        float importedeposito = sc.nextFloat();

        ccte.depositar(importedeposito);
        Transaccion movdeposito = new Transaccion(Transaccion.tipo_transaccion.deposito,
                LocalDateTime.now(),importedeposito,ccte.getNumero_cuenta(), 435453,
                ccte.getNumero_cuenta(), cliente.getIdTitular());
        trcontroller.MovDeposito(movdeposito);
        ctecontroller.actSaldoCcte(ccte);
        System.out.println("Su saldo actualizado es de $ " + ccte.getSaldo());
                System.out.println("----------------------------------------------");

        System.out.println("Realice la extracción de  dinero");
        float retiro = sc.nextFloat();
        sc.nextLine();
        ccte.retirar(retiro);
        ctecontroller.actSaldoCcte(ccte);
        Transaccion movretiro = new Transaccion(Transaccion.tipo_transaccion.extraccion,
                retiro, ccte.getNumero_cuenta(), 3434, ccte.getNumero_cuenta(),cliente.getIdTitular());
        trcontroller.MovRetiro(movretiro);
        
        System.out.println("--------------------------------------------------------");
        
        System.out.println("Creación de la Cuenta de Ahorro creada");
         System.out.print("Ingrese monto del saldo: ");
        dinerocaja = sc.nextDouble();
        CuentaAhorro cah = new CuentaAhorro(cliente, dinerocaja);
        cahcontroller.guardarCAh(cah);
        System.out.println("Datos de la Cuenta de Ahorro");
        System.out.println(cah);
        cah.infoCA();
                System.out.println("----------------------------------------------");

        System.out.println("Realice el depósito");
        float importedepositocaja = sc.nextFloat();

        cah.depositar(importedepositocaja);
        cahcontroller.actSaldoAh(cah);

        Transaccion movdepositoA = new Transaccion(Transaccion.tipo_transaccion.deposito,
                LocalDateTime.now(),importedepositocaja,cah.getNumero_cuenta(),
                9023, cah.getNumero_cuenta(), cliente.getIdTitular());
        trcontroller.MovDeposito(movdepositoA);
                System.out.println("----------------------------------------------");

        System.out.println("Realice la extracción de dinero");
        float retiroA = sc.nextFloat();
        cah.retirar(retiroA);
        cahcontroller.actSaldoAh(cah);

        Transaccion movretiroA = new Transaccion(Transaccion.tipo_transaccion.extraccion,
                retiro, cah.getNumero_cuenta(), 1212, cah.getNumero_cuenta(),cliente.getIdTitular());
        trcontroller.MovRetiro(movretiroA);
                System.out.println("----------------------------------------------");

        System.out.println("Ingrese DNI para realizar la consulta");
        dniconsulta= sc.next();
        sc.nextLine();
        ccontroller.consultar(dniconsulta);
                System.out.println("----------------------------------------------");

        System.out.println("Ingrese DNI para consultar movimientos de sus cuentas");
         dnimovim = sc.next();
               sc.nextLine();
               ccontroller.consultarMov(dnimovim);
                System.out.println("----------------------------------------------");

        
        System.out.println("Eliminar cliente");
        System.out.println("Ingrese DNI del cliente a eliminar");
        String dniE  = sc.nextLine();
        ccontroller.eliminar(dniE);
    }

}
