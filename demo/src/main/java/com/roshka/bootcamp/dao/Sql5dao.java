package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql5model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql5dao {
    private Connection connection;

    public Sql5dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql5model> obtenerTopClientes() throws SQLException {
        List<Sql5model> clientes = new ArrayList<>();
        String sql = """
                WITH
                    counts AS (
                        SELECT factura_detalle.producto_id, COUNT(*) as all_products
                        FROM factura_detalle
                            INNER JOIN factura ON factura_detalle.factura_id = factura.id
                        GROUP BY
                            factura_detalle.producto_id
                    )
                SELECT producto_id, all_products
                FROM counts
                WHERE
                    all_products = (
                        SELECT MAX(all_products)
                        FROM counts
                    );""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql5model(
                        rs.getInt("producto_id"),
                        rs.getString("all_products")));
            }
        }
        return clientes;
    }
}
