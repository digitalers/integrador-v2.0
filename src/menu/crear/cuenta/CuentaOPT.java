package menu.crear.cuenta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.clientes.ClientesDTO;
import dto.cuentas.CuentasDTO;
import menu.items.Items;
import modelos.cuentas.cuentaAhorro.CuentaAhorro;
import modelos.cuentas.cuentaCorriente.CuentaCorriente;
import utils.numeroDeCuenta.NumeroDeCuenta;
import utils.random.Random;

public class CuentaOPT {
    int option;
    
    Scanner scanner;

    public CuentaOPT() throws SQLException {
        option = Items.getItems(
            "CUENTAS BANCARIAS",
            "Crear cuenta bancaria",
            "Ingresar a mi cuenta bancaria",
            "Eliminar una cuenta bancaria",
            "Ver todas las transacciones"
        );


        switch(option) {
            case 1: {
                scanner = new Scanner(System.in);

                System.out.println("Introduce tu número de documento");
                String dni = scanner.nextLine();
                
                ClientesDTO clientesDTO = new ClientesDTO();
                ResultSet result = clientesDTO.obtenerPorDni(dni);

                if (result.next()) {
                    option = Items.getItems(
                        "¿CREAR CUENTA BANCARIA?",
                        "Sí",
                        "No"
                    );

                    if (option == 1) {
                        option = Items.getItems(
                            "ELIGE TU TIPO DE CUENTA",
                            "Cuenta corriente",
                            "Cuenta de ahorro"
                        );

                        String numeroDeCuenta = NumeroDeCuenta.numero();

                        int saldo = new Random(50_000, 1_000_000).random();

                        String titular = result.getString("nombre") + " " + result.getString("apellido");
                        
                        switch(option) {
                            case 1: {
                                int limiteDeDinero = new Random(10_000, 100_000).random();

                                CuentaCorriente cuentaCorriente = new CuentaCorriente(
                                    result.getInt("id"),
                                    numeroDeCuenta, 
                                    saldo, 
                                    titular,
                                    limiteDeDinero,
                                    "CORRIENTE"
                                );

                                CuentasDTO<CuentaCorriente> cuentasDTO = new CuentasDTO<CuentaCorriente>();

                                cuentasDTO.crearCuenta(cuentaCorriente);
                                break;
                            }
                            case 2: {
                                int tasaDeInteres = new Random(5, 90).random();

                                CuentaAhorro cuentaAhorro = new CuentaAhorro(
                                    result.getInt("id"),
                                    numeroDeCuenta, 
                                    saldo, 
                                    titular,
                                    tasaDeInteres,
                                    "AHORRO"
                                );

                                CuentasDTO<CuentaAhorro> cuentasDTO = new CuentasDTO<CuentaAhorro>();

                                cuentasDTO.crearCuenta(cuentaAhorro);
                                break;
                            }
                        }
                    }
                }
                else {
                    System.out.println("No se encontraron resultados");
                }

                break;
            }
            case 2: {
                scanner = new Scanner(System.in);

                System.out.println("Ingresá tu número de documento");
                String dni = scanner.nextLine();

                CuentasDTO<?> cuentasDTO;
                cuentasDTO = new CuentasDTO<>();
                ResultSet result;
                result = cuentasDTO.obtenerPorDni(dni);

                
                if (result.next()) {
                    int clienteId;
                    String tipoDeCuenta;
                    int saldo = result.getInt("cuentas.saldo");

                    clienteId = result.getInt("clientes.id");
                    tipoDeCuenta = result.getString("cuentas.tipo_de_cuenta");

                    String title = String.format("BIENVENIDO %s %s A TU CUENTA BANCARIA\n\n- Dinero disponible: $%d\n- Tipo de cuenta: %s\n- Número de cuenta: %s",
                        result.getString("clientes.nombre"),
                        result.getString("clientes.apellido"),
                        saldo,
                        tipoDeCuenta,
                        result.getString("cuentas.numero")
                    );

                    option = Items.getItems(
                        title,
                        "Ingresar dinero",
                        "Retirar dinero",
                        "Transferir dinero",
                        "Eliminar mi cuenta bancaria"
                    );

                    switch(option) {
                        case 1: {
                            scanner = new Scanner(System.in);
                            System.out.println("Escribe el monto a ingresar");

                            int monto = scanner.nextInt();

                            switch(tipoDeCuenta) {
                                case "CORRIENTE": {
                                    CuentaCorriente cuentaCorriente = new CuentaCorriente();
                                    cuentaCorriente.depositar(clienteId, monto);
                                    break;
                                }
                                case "AHORRO": {
                                    CuentaAhorro cuentaAhorro = new CuentaAhorro();
                                    cuentaAhorro.depositar(clienteId, monto);
                                    break;
                                }
                            }

                            System.out.println();
                            System.out.printf("Has depositado $%d de saldo\n\n- Saldo anterior: %d\n- Saldo actual: %d",
                                monto,
                                saldo,
                                saldo + monto
                            );

                            cuentasDTO = new CuentasDTO<>();
                            cuentasDTO.crearTransaccion(clienteId, clienteId, "DEPÓSITO", saldo, monto);

                            break;
                        }
                        case 2: {
                            scanner = new Scanner(System.in);
                            System.out.println("Escribe el monto a retirar");

                            int monto = scanner.nextInt();

                            if (monto <= saldo) { 
                                switch(tipoDeCuenta) {
                                    case "CORRIENTE": {
                                        CuentaCorriente cuentaCorriente = new CuentaCorriente();
                                        cuentaCorriente.retirar(clienteId, monto);
                                        break;
                                    }
                                    case "AHORRO": {
                                        CuentaAhorro cuentaAhorro = new CuentaAhorro();
                                        cuentaAhorro.retirar(clienteId, monto);
                                        break;
                                    }
                                }

                                System.out.println();
                                System.out.printf("Has retirado $%d de saldo\n\n- Saldo anterior: $%d\n- Saldo actual: $%d",
                                    monto,
                                    saldo,
                                    saldo - monto
                                );

                                cuentasDTO = new CuentasDTO<>();
                                cuentasDTO.crearTransaccion(clienteId, clienteId, "RETIRO", saldo, monto);
                            }
                            else {
                                System.out.println("El monto es mayor a tu saldo actual");
                            }

                            break;
                        }
                        case 3: {
                            cuentasDTO = new CuentasDTO<>();
                            result = cuentasDTO.obtenerTodasLasCuentas();

                            scanner = new Scanner(System.in);
                            System.out.println("* TRANSFERIR DINERO");

                            int max = 0;

                            while (result.next()) {
                                max++;
                            }

                            Object[] cuentas = new Object[max];

                            // ArrayList<Integer> clientes_id = new ArrayList<Integer>();

                            int pos = 0;

                            result.beforeFirst();

                            while (result.next()) {
                                cuentas[pos] = result.getString("clientes.nombre") + " " + result.getString("clientes.apellido");
                                // clientes_id.add(result.getInt("clientes.id"));
                                pos++;
                            }

                            option = Items.getItems(
                                title,
                                cuentas
                            );

                            switch(option) {
                                case 0: {
                                    break;
                                }
                                default: {
                                    scanner = new Scanner(System.in);
                                    System.out.println("Escribe el monto de dinero que quieres transferir a " + cuentas[option - 1]);
                                    
                                    int monto = scanner.nextInt();

                                    if (monto <= saldo) { 
                                        switch(tipoDeCuenta) {
                                            case "CORRIENTE": {
                                                CuentaCorriente cuentaCorriente = new CuentaCorriente();

                                                cuentaCorriente.depositar(option, monto);
                                                cuentaCorriente.retirar(clienteId, monto);
                                                break;
                                            }
                                            case "AHORRO": {
                                                CuentaAhorro cuentaAhorro = new CuentaAhorro();

                                                cuentaAhorro.depositar(option, monto);
                                                cuentaAhorro.retirar(clienteId, monto);
                                                break;
                                            }
                                        }

                                        cuentasDTO = new CuentasDTO<>();
                                        cuentasDTO.crearTransaccion(clienteId, option, "TRANSFERENCIA", saldo, monto);
                                    }
                                    else {
                                        System.out.println();
                                        System.out.printf("El monto introducido $%d supera tu saldo actual $%d.",
                                            monto,
                                            saldo
                                        );
                                    }

                                    break;
                                }
                            }
                            
                            break;
                        }
                        case 4: {
                            option = Items.getItems(
                                "¿ESTÁS SEGURO DE ELIMINAR TU CUENTA BANCARIA?",
                                "Sí",
                                "No"
                            );

                            if (option == 1) {
                                cuentasDTO = new CuentasDTO<>();
                                cuentasDTO.eliminarCuenta(clienteId);
                            }

                            break;
                        }
                    }
                }
                else {
                    System.out.println("No se han encontrado resultados");
                }
                break;
            }
            case 3: {
                CuentasDTO<?> cuentasDTO;
                cuentasDTO =  new CuentasDTO<>();

                ResultSet result = cuentasDTO.obtenerTodasLasCuentas();

                int max = 0;

                while (result.next()) {
                    max++;
                }

                
                Object[] cuentas = new Object[max];
                ArrayList<Integer> cuentasIds = new ArrayList<Integer>();

                
                int pos = 0;
                result.beforeFirst();
                
                while (result.next()) {
                    
                    String items = String.format("%s %s - %s (%s) (Transaccines: %d)", 
                        result.getString("clientes.nombre"),
                        result.getString("clientes.apellido"),
                        result.getString("cuentas.numero"),
                        result.getString("cuentas.tipo_de_cuenta"),
                        result.getInt("maxTransacciones")
                    );
                    
                    cuentas[pos] = items;
                    cuentasIds.add(result.getInt("clientes.id"));
                    pos++;
                }

                option = Items.getItems(
                    "ELIMINAR UNA CUENTA BANCARIA",
                    cuentas
                );

                switch(option) {
                    case 0: {
                        break;
                    }
                    default: {
                        int id = cuentasIds.get(option - 1);

                        option = Items.getItems(
                            "¿ESTÁS SEGURO DE ELIMINAR LA CUENTA CON ID #" + id + "?",
                            "Sí",
                            "No"
                        );

                        switch(option) {
                            case 1: {
                                cuentasDTO = new CuentasDTO<>();
                                cuentasDTO.eliminarCuenta(id);
                                break;
                            }
                        }
                    }
                }
                
                break;
            }
            case 4: {
                
                CuentasDTO<?> cuentasDTO = new CuentasDTO<>();
                ResultSet result = cuentasDTO.obtenerTodasLasTransacciones();
                
                System.out.println();

                while (result.next()) {
                    System.out.println("-----------------------------");
                    System.out.println();
                    System.out.printf("#%d TRANSACCION\n\n- Origen: #%d\n- Destino: #%d\n- Fecha: %s\n- Hora: %s\n- Monto: $%d\n- Tipo de operación: %s\n", 
                        result.getInt("id"),
                        result.getInt("id_cliente"),
                        result.getInt("id_cuenta"),
                        result.getString("fecha"),
                        result.getString("hora"),
                        result.getInt("monto"),
                        result.getString("tipo")
                    );

                    System.out.println();
                    System.out.println("-----------------------------");
                }
                
                System.out.println();
                break;
            }
        }
    }
}
