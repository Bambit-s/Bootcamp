import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;

public class sql7 {

    public static void main(String[] args) {

        try (Connection connection = App.connectToDatabase()) {
            String sql = "SELECT factura.fecha_emision, cliente.nombre, cliente.apellido, producto.nombre as product_name, factura_detalle.cantidad, factura_tipo.nombre as factura_nombre\r\n"
                    + //
                    "FROM\r\n" + //
                    "    factura\r\n" + //
                    "    Inner JOIN factura_detalle ON factura_detalle.factura_id = factura.id\r\n" + //
                    "    Inner JOIN cliente ON factura.cliente_id = cliente.id\r\n" + //
                    "    Inner JOIN factura_tipo ON factura.factura_tipo_id = factura_tipo.id\r\n" + //
                    "    Inner JOIN producto ON factura_detalle.producto_id = producto.id";

            assert connection != null;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Date fecha_emision = rs.getDate("fecha_emision");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String product_name = rs.getString("product_name");
                int cantidad = rs.getInt("cantidad");
                String factura_nombre = rs.getString("factura_nombre");
                System.out.println(
                        "Fecha emision: " + fecha_emision +
                                " | " + "Nombre: " + nombre +
                                " | " + "Apellido: " + apellido +
                                " | " + "Producto Nombre: " + product_name +
                                " | " + "Cantidad: " + cantidad +
                                " | " + "Nombre Factura: " + factura_nombre);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}