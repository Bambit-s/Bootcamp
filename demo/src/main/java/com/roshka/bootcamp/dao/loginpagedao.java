package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.loginpagemodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginpagedao {
    private Connection connection;

    public loginpagedao(Connection connection) {
        this.connection = connection;
    }

    public loginpagemodel loginuser(String nombre, String apellido, String nroCedula, String telefono)
            throws SQLException {

        String sql = """
                SELECT *
                FROM cliente
                WHERE nombre = ? AND apellido = ? AND nro_cedula = ? AND telefono = ?
                LIMIT 1;
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, nroCedula);
            stmt.setString(4, telefono);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new loginpagemodel(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("nro_cedula"),
                            rs.getString("telefono"));
                }
            }
        }

        return null;
    }
}
