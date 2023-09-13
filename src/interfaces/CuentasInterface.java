package interfaces;

import java.sql.SQLException;

public interface CuentasInterface {
    public void depositar(int id, int monto) throws SQLException;

    public void retirar(int id,  int monto) throws SQLException;
}
