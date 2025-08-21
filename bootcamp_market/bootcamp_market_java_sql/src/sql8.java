import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql8 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT factura_detalle.factura_id, ROUND(\r\n" + //
                    "        SUM(\r\n" + //
                    "            producto.precio * factura_detalle.cantidad\r\n" + //
                    "        )\r\n" + //
                    "    ) as totalfactura\r\n" + //
                    "From\r\n" + //
                    "    factura_detalle\r\n" + //
                    "    INNER JOIN factura ON factura.id = factura_detalle.factura_id\r\n" + //
                    "    INNER JOIN producto ON producto.id = factura_detalle.producto_id\r\n" + //
                    "GROUP BY\r\n" + //
                    "    factura_detalle.factura_id\r\n" + //
                    "ORDER BY totalfactura;";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int factura_id = rs.getInt("factura_id");
                int totalfactura = rs.getInt("totalfactura");
                System.out.println(
                        "Factura id: " + factura_id +
                                " | " + "Total factura: " + totalfactura);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}