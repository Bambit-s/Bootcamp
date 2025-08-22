package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql2model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql2dao {
    private Connection connection;

    public Sql2dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql2model> obtenerTopClientes() throws SQLException {
        List<Sql2model> clientes = new ArrayList<>();
        String sql = """
                SELECT c.cliente_id, k.nombre, k.apellido, f.factura_id, SUM(f.cantidad) as suma_cantidad
                FROM
                    factura_detalle f
                    JOIN factura c ON c.id = f.factura_id
                    JOIN cliente k ON c.cliente_id = k.id
                GROUP BY
                    c.cliente_id,
                    k.nombre,
                    k.apellido,
                    f.factura_id
                ORDER BY suma_cantidad DESC
                LIMIT 10;""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql2model(
                        rs.getInt("cliente_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("factura_id"),
                        rs.getInt("suma_cantidad")));
            }
        }
        return clientes;
    }
}
