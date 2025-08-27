package com.example.demo.dao;

import java.sql.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class RegistraitionDAO {
    private final String url = "jdbc:postgresql://localhost:5432/crud_de_usuario";
    private final String user = "postgres";
    private final String password = "12345678";

    public void registration(String nombre, String apellido, int nro_cedula, String correo, int id_rol,
            Date fecha_ingreso,
            String contrasena, String telefono, int idEquipo, int idCargo, Date fechaDeNacimento,
            int dias_vacaciones_restante, boolean requiere_cambio_contrasena) {
        String hashed = PasswordUtil.hashPassword(contrasena);

        String sql = "INSERT INTO usuarios (id_usuario, nombre,apellido,nro_cedula, id_rol, fecha_ingreso, contrasena) VALUES (?,?,?,?,?,?,?)";

        int newId = getMaxId() + 1;

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newId);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setInt(4, nro_cedula);
            pstmt.setInt(5, id_rol);
            pstmt.setDate(6, fecha_ingreso);
            pstmt.setString(7, hashed);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getMaxId() {
        int maxId = 0;
        String sql = "SELECT MAX(id_usuario) AS max_id FROM usuarios";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                maxId = rs.getInt("max_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxId;
    }

    public class PasswordUtil {

        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public static String hashPassword(String plainPassword) {
            return encoder.encode(plainPassword);
        }

        public static boolean matches(String plainPassword, String hashedPassword) {
            return encoder.matches(plainPassword, hashedPassword);
        }
    }
}
