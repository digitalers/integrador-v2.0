package excepciones;

import java.sql.SQLException;

public class Excepciones extends SQLException {
    
    public Excepciones(String error) {
        super(error);
    }
}
