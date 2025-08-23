package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql8model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql8dao {
    private Connection connection;

    public Sql8dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql8model> obtenerTopClientes() throws SQLException {
        List<Sql8model> clientes = new ArrayList<>();
        String sql = """
                SELECT factura_detalle.factura_id, ROUND(
                        SUM(
                            producto.precio * factura_detalle.cantidad
                        )
                    ) as totalfactura
                From
                    factura_detalle
                    INNER JOIN factura ON factura.id = factura_detalle.factura_id
                    INNER JOIN producto ON producto.id = factura_detalle.producto_id
                GROUP BY
                    factura_detalle.factura_id
                ORDER BY totalfactura desc;""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql8model(
                        rs.getInt("factura_id"),
                        rs.getInt("totalfactura")));
            }
        }
        return clientes;
    }
}
