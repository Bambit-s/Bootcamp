package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.Sql7model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql7dao {
    private Connection connection;

    public Sql7dao(Connection connection) {
        this.connection = connection;
    }

    public List<Sql7model> obtenerTopClientes() throws SQLException {
        List<Sql7model> clientes = new ArrayList<>();
        String sql = """
                SELECT factura.fecha_emision, cliente.nombre, cliente.apellido, producto.nombre as product_name, factura_detalle.cantidad, factura_tipo.nombre as factura_nombre
                FROM
                    factura
                    Inner JOIN factura_detalle ON factura_detalle.factura_id = factura.id
                    Inner JOIN cliente ON factura.cliente_id = cliente.id
                    Inner JOIN factura_tipo ON factura.factura_tipo_id = factura_tipo.id
                    Inner JOIN producto ON factura_detalle.producto_id = producto.id""";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Sql7model(
                        rs.getDate("fecha_emision"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("product_name"),
                        rs.getInt("cantidad"),
                        rs.getString("factura_nombre")));
            }
        }
        return clientes;
    }
}
