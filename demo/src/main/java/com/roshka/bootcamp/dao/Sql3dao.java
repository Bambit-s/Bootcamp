package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql3model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql3dao {
    private Connection connection;

    public Sql3dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql3model> obtenerTopClientes() throws SQLException {
        List<Sql3model> clientes = new ArrayList<>();
        String sql = """
                SELECT
                    f.moneda_id,
                    m.nombre as moneda_nombre,
                    COUNT(*) as cantidad_facturas
                FROM factura f
                    LEFT JOIN moneda m ON f.moneda_id = m.id
                GROUP BY
                    f.moneda_id,
                    m.nombre
                ORDER BY cantidad_facturas DESC;""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql3model(
                        rs.getInt("moneda_id"),
                        rs.getString("moneda_nombre"),
                        rs.getInt("cantidad_facturas")));
            }
        }
        return clientes;
    }
}
