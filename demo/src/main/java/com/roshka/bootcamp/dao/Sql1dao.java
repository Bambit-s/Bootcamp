package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql1model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql1dao {
    private Connection connection;

    public Sql1dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql1model> obtenerTopClientes() throws SQLException {
        List<Sql1model> clientes = new ArrayList<>();
        String sql = """
                SELECT c.id, c.nombre, c.apellido, COUNT(f.id) as cantidad_facturas
                FROM factura f
                         JOIN cliente c ON f.cliente_id = c.id
                GROUP BY c.id, c.nombre, c.apellido
                ORDER BY cantidad_facturas DESC
                LIMIT 10;
                """;

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql1model(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("cantidad_facturas")));
            }
        }
        return clientes;
    }
}
