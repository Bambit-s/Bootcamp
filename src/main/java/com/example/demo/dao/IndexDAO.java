package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class IndexDAO {

    private final String url = "jdbc:postgresql://localhost:5432/crud_de_usuario";
    private final String user = "postgres";
    private final String password = "12345678";

    public void getAllUsers() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}