import conexion.Conexion;
import menu.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Conexion.crearConexion();
        
        new Menu();
    }
}
