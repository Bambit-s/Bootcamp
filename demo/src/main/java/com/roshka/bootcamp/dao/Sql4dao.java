package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql4model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql4dao {
    private Connection connection;

    public Sql4dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql4model> obtenerTopClientes() throws SQLException {
        List<Sql4model> clientes = new ArrayList<>();
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
                clientes.add(new Sql4model(
                        rs.getInt("proveedor_id"),
                        rs.getString("nombre_proveedor"),
                        rs.getInt("cantidad_veces")));
            }
        }
        return clientes;
    }
}
