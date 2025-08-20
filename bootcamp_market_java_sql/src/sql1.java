import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql1 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT c.id, c.nombre, c.apellido, COUNT(f.id) as cantidad_facturas\r\n" + //
                    "FROM factura f\r\n" + //
                    "    JOIN cliente c ON f.cliente_id = c.id\r\n" + //
                    "GROUP BY\r\n" + //
                    "    c.id,\r\n" + //
                    "    c.nombre,\r\n" + //
                    "    c.apellido\r\n" + //
                    "ORDER BY cantidad_facturas DESC\r\n" + //
                    "LIMIT 10;";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cantidad_facturas = rs.getInt("cantidad_facturas");
                System.out.println(
                        "Id: " + id +
                                " | " + "Nombre: " + nombre +
                                " | " + "Apellido: " + apellido +
                                " | " + " Cantidad facturas: " + cantidad_facturas);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}