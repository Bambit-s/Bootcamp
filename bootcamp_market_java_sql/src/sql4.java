import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class sql4 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT producto.proveedor_id, COUNT(*) as cantidad_veces\r\n" + //
                    "FROM factura_detalle\r\n" + //
                    "    INNER JOIN producto ON factura_detalle.producto_id = producto.id\r\n" + //
                    "GROUP BY\r\n" + //
                    "    producto.proveedor_id\r\n" + //
                    "ORDER BY cantidad_veces DESC;";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int proveedor_id = rs.getInt("proveedor_id");
                int cantidad_veces = rs.getInt("cantidad_veces");
                System.out.println(
                        "Proveedor id: " + proveedor_id +
                                " | " + "Cantidad veces: " + cantidad_veces);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}