package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModelIndex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IndexDAO {

    private final String url = "jdbc:postgresql://localhost:5432/crud_de_usuario";
    private final String user = "postgres";
    private final String password = "12345678";

    public List<UserModelIndex> getAllUsers() {
        List<UserModelIndex> users = new ArrayList<>();
        String sql = "SELECT id_usuario,nombre,apellido FROM usuarios";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                UserModelIndex usermodel = new UserModelIndex(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"));
                // usermodel.setNombre(rs.getString("nombre"));
                // usermodel.setNombre(rs.getString("apellido"));
                users.add(usermodel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}