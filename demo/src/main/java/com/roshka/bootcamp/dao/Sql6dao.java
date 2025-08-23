package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql6model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql6dao {
    private Connection connection;

    public Sql6dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql6model> obtenerTopClientes() throws SQLException {
        List<Sql6model> clientes = new ArrayList<>();
        String sql = """
                SELECT
                    producto.proveedor_id,
                    proveedor.nombre as nombre_proveedor,
                    COUNT(*) as cantidad_veces
                FROM factura_detalle
                INNER JOIN producto ON factura_detalle.producto_id = producto.id
                INNER JOIN proveedor ON producto.proveedor_id = proveedor.id
                GROUP BY
                    producto.proveedor_id,
                    proveedor.nombre
                ORDER BY cantidad_veces DESC""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql6model(
                        rs.getInt("proveedor_id"),
                        rs.getString("nombre_proveedor"),
                        rs.getInt("cantidad_veces")));
            }
        }
        return clientes;
    }
}
