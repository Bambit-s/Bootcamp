import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql6 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "WITH\r\n" + //
                    "    counts AS (\r\n" + //
                    "        SELECT factura_detalle.producto_id, COUNT(*) as all_products\r\n" + //
                    "        FROM factura_detalle\r\n" + //
                    "            INNER JOIN factura ON factura_detalle.factura_id = factura.id\r\n" + //
                    "        GROUP BY\r\n" + //
                    "            factura_detalle.producto_id\r\n" + //
                    "    )\r\n" + //
                    "SELECT producto_id, all_products\r\n" + //
                    "FROM counts\r\n" + //
                    "WHERE\r\n" + //
                    "    all_products = (\r\n" + //
                    "        SELECT min(all_products)\r\n" + //
                    "        FROM counts\r\n" + //
                    "    );";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int producto_id = rs.getInt("producto_id");
                int all_products = rs.getInt("all_products");
                System.out.println(
                        "Producto id: " + producto_id +
                                " | " + "All products: " + all_products);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}