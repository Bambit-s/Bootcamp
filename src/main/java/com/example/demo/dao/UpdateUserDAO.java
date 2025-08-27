package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModelIndex;

import java.sql.*;

@Repository
public class UpdateUserDAO {
    private final String url = "jdbc:postgresql://localhost:5432/crud_de_usuario";
    private final String user = "postgres";
    private final String password = "12345678";

    public UserModelIndex showDetails(int id) {
        String sql = "SELECT id_usuario, nombre, apellido FROM usuarios WHERE id_usuario = ?";
        UserModelIndex usermodel = null;

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usermodel = new UserModelIndex(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usermodel;
    }

    public void updateUser(UserModelIndex userModel) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ? WHERE id_usuario = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userModel.getNombre());
            pstmt.setString(2, userModel.getApellido());
            pstmt.setInt(3, userModel.getId_usuario());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
