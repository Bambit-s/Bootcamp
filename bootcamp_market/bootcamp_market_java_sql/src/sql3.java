import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql3 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT\r\n" + //
                    "    f.moneda_id,\r\n" + //
                    "    m.nombre as moneda_nombre,\r\n" + //
                    "    COUNT(*) as cantidad_facturas\r\n" + //
                    "FROM factura f\r\n" + //
                    "    LEFT JOIN moneda m ON f.moneda_id = m.id\r\n" + //
                    "GROUP BY\r\n" + //
                    "    f.moneda_id,\r\n" + //
                    "    m.nombre\r\n" + //
                    "ORDER BY cantidad_facturas DESC;";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String moneda_nombre = rs.getString("moneda_nombre");
                int cantidad_facturas = rs.getInt("cantidad_facturas");
                System.out.println(
                        "Moneda nombre: " + moneda_nombre +
                                " | " + "Cantidad facturas: " + cantidad_facturas);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}