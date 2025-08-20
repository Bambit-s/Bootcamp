import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql3 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT c.cliente_id, k.nombre, k.apellido, f.factura_id, SUM(f.cantidad) as suma_cantidad\r\n"
                    + //
                    "FROM\r\n" + //
                    "    factura_detalle f\r\n" + //
                    "    JOIN factura c ON c.id = f.factura_id\r\n" + //
                    "    JOIN cliente k ON c.cliente_id = k.id\r\n" + //
                    "GROUP BY\r\n" + //
                    "    c.cliente_id,\r\n" + //
                    "    k.nombre,\r\n" + //
                    "    k.apellido,\r\n" + //
                    "    f.factura_id\r\n" + //
                    "ORDER BY suma_cantidad DESC\r\n" + //
                    "LIMIT 10;";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int factura_id = rs.getInt("factura_id");
                int suma_cantidad = rs.getInt("suma_cantidad");
                System.out.println(
                        "Id: " + id +
                                " | " + "Nombre: " + nombre +
                                " | " + "Apellido: " + apellido +
                                " | " + "Cantidad facturas: " + factura_id +
                                " | " + "Suma Cantidad: " + suma_cantidad);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}