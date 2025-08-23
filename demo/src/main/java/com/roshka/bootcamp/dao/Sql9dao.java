package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql9model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql9dao {
    private Connection connection;

    public Sql9dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql9model> obtenerTopClientes() throws SQLException {
        List<Sql9model> clientes = new ArrayList<>();
        String sql = """
                SELECT fd.factura_id, SUM(fd.cantidad * p.precio * 1.10) as coniva10
                FROM
                    factura_detalle fd
                    INNER JOIN factura f on f.id = fd.factura_id
                    Inner join producto p on p.id = fd.producto_id
                GROUP BY
                    fd.factura_id
                ORDER BY fd.factura_id;""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql9model(
                        rs.getInt("factura_id"),
                        rs.getInt("coniva10")));
            }
        }
        return clientes;
    }
}
