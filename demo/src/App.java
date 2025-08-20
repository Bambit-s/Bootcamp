import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
        String user = "postgres";
        String password = "12345678";

        String sql1 = "SELECT c.id, c.nombre, c.apellido, COUNT(f.id) as cantidad_facturas\r\n" + //
                "FROM factura f\r\n" + //
                "    JOIN cliente c ON f.cliente_id = c.id\r\n" + //
                "GROUP BY\r\n" + //
                "    c.id,\r\n" + //
                "    c.nombre,\r\n" + //
                "    c.apellido\r\n" + //
                "ORDER BY cantidad_facturas DESC\r\n" + //
                "LIMIT 10;";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                String email = rs.getString("apellido");
                int cantidad_facturas = rs.getInt("cantidad_facturas");
                System.out.println(id + " | " + name + " | " + email + "|" + cantidad_facturas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
