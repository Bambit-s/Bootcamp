import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql9 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT fd.factura_id, SUM(fd.cantidad * p.precio * 1.10) as coniva10\r\n" + //
                    "FROM\r\n" + //
                    "    factura_detalle fd\r\n" + //
                    "    INNER JOIN factura f on f.id = fd.factura_id\r\n" + //
                    "    Inner join producto p on p.id = fd.producto_id\r\n" + //
                    "GROUP BY\r\n" + //
                    "    fd.factura_id\r\n" + //
                    "ORDER BY fd.factura_id;";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int factura_id = rs.getInt("factura_id");
                int coniva10 = rs.getInt("coniva10");
                System.out.println(
                        "Factura id: " + factura_id +
                                " | " + "Con IVA 10: " + coniva10);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}