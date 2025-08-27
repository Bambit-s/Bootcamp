package com.example.demo.dao;

import java.sql.*;


public class DeleteUserDAO {
    private final String url = "jdbc:postgresql://localhost:5432/crud_de_usuario";
    private final String user = "postgres";
    private final String password = "12345678";

    
    public void deleteUser(int id) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
