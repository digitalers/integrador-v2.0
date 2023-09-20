package dao;


import java.sql.*;

import integrador2.mg.models.Titular;

public class ClienteDao {

 
    private Connection connection;

    public ClienteDao(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Titular cliente) {
        try {
            String sql = "INSERT into cliente(dni,nombre,apellido,calle,altura,"
                    + "barrio,ciudad,provincia,codigo_postal, email, "
                    + "telefono) values(?,?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, cliente.getDni());
                pstm.setString(2, cliente.getNombre());
                pstm.setString(3, cliente.getApellido());
                pstm.setString(4, cliente.getDomicilio().getCalle());
                pstm.setInt(5, cliente.getDomicilio().getAltura());
                pstm.setString(6, cliente.getDomicilio().getBarrio());
                pstm.setString(7, cliente.getDomicilio().getCiudad());
                pstm.setString(8, cliente.getDomicilio().getProvincia());
                pstm.setString(9, cliente.getDomicilio().getCodigoPostal());
                pstm.setString(10, cliente.getEmail());
                pstm.setInt(11, cliente.getTelefono());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        cliente.setIdTitular(rst.getInt(1));
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void consultaCuentasDni(String dniconsulta) throws SQLException {

        try (PreparedStatement stm = connection.prepareStatement("SELECT  cliente.dni, "
                + "cuenta.tipo_cuenta ,cuenta.idcuenta, cuenta.saldo  FROM cuenta inner JOIN cliente "
                + "ON cuenta.cliente_idcliente=cliente.idcliente WHERE dni=?")) {

            stm.setString(1, dniconsulta);

            ResultSet result = stm.executeQuery();

            while (result.next()) {

                String dnic = result.getString("dni");
                String tipo = result.getString("tipo_cuenta");
                int num=result.getInt("idcuenta");
                Double saldo = result.getDouble("saldo");
                System.out.println("DNI del cliente " + dnic + " , tipo de cuenta: " + tipo +
                        " , número de cuenta N° " + num + ", saldo $ " + saldo + " \n");

                System.out.println("---------------------------------------------------");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public void consultaMovimDni(String dnimovim) throws SQLException {
        try (PreparedStatement pstm = connection.prepareStatement("SELECT cliente.dni, transacciones.idtransacciones, "
                + "transacciones.tipo_transaccion, transacciones.fecha_y_hora, transacciones.monto, "
                + "transacciones.cuenta_origen, transacciones.cuenta_destino FROM transacciones INNER JOIN cliente  "
                + "on transacciones.cuenta_cliente_idcliente= idcliente "
                + "WHERE dni=?")) {

            pstm.setInt(1, Integer.parseInt(dnimovim));

            ResultSet result = pstm.executeQuery();
            while (result.next()) {

                String dnic = result.getString("dni");
                int id_transac = result.getInt("idtransacciones");
                String tipo_movim = result.getString("tipo_transaccion");
                Date fecha_hs = result.getDate("fecha_y_hora");
                Float monto = result.getFloat("monto");
                int cuentaorig= result.getInt("cuenta_origen");
                                int cuentadest= result.getInt("cuenta_destino");

                System.out.println("DNI del cliente " + dnic 
                        + ", id de la transacción " + id_transac
                        + " , tipo de transacción " + tipo_movim + " , fecha y hora realizada:  "
                        + fecha_hs + ", importe realizado $ " + monto + ",  cuenta origen N °" +
                        cuentaorig + " , cuenta destino N° "+ cuentadest+ "\n");

                System.out.println("---------------------------------------------------");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public void EliminarCliente(String dniE) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM cliente WHERE dni = ?")) {
            stm.setInt(1, Integer.parseInt(dniE));
            stm.execute();
            System.out.println("Se ha realizado la eliminación del cliente con DNI N° " + dniE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
