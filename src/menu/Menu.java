package menu;

import java.sql.SQLException;

import menu.crear.cliente.ClienteOPT;
import menu.crear.cuenta.CuentaOPT;
import menu.items.Items;

public class Menu {
    int item = Items.getItems(
        "BIENVENIDO A TU BANCO",
        "Cuentas bancarias",
        "Registrar cliente"
    );

    public Menu() throws SQLException {
        
        switch(item) {
            case 1: {
                new CuentaOPT();
                break;
            }
            case 2: {
                new ClienteOPT();
                break;
            }
            case 3: {
                break;
            }
        }
        

    }
}
