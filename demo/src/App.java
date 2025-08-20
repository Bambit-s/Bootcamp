import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static Connection connectToDatabase() {
        try {
            String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
            String user = "postgres";
            String password = "12345678";

            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.err.println("Error connection: " + e.getMessage());
            return null;
        }
    }
}