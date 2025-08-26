package com.roshka.bootcamp.dao;

import com.roshka.bootcamp.model.facturamodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class facturadao {
    private Connection connection;

    public facturadao(Connection connection) {
        this.connection = connection;
    }

    public facturamodel postfactura(int cliente_id, java.sql.Date fecha_emision, java.sql.Date fecha_vencimiento,
            int factura_tipo, int moneda, int producto_id, int cantidad) throws SQLException {

        String sqlFactura = """
                INSERT INTO factura (fecha_emision, fecha_vencimiento, cliente_id, factura_tipo_id, moneda_id)
                VALUES (?, ?, ?, ?, ?)
                RETURNING id;
                """;

        int maxIdfactura = 0;
        String sqlMaxIdfactura = "SELECT COALESCE(MAX(id), 0) AS max_id FROM factura_detalle";
        try (PreparedStatement stmtMax = connection.prepareStatement(sqlMaxIdfactura);
             ResultSet rs = stmtMax.executeQuery()) {
            if (rs.next()) {
                maxIdfactura = rs.getInt("max_id");
            }
        }

        try (PreparedStatement stmtFactura = connection.prepareStatement(sqlFactura)) {
            stmtFactura.setDate(1, fecha_emision);
            stmtFactura.setDate(2, fecha_vencimiento);
            stmtFactura.setInt(3, cliente_id);
            stmtFactura.setInt(4, factura_tipo);
            stmtFactura.setInt(5, moneda);

            try (ResultSet rs = stmtFactura.executeQuery()) {
                if (rs.next()) {
                    int facturaId = rs.getInt("id");

                    String sqlDetalle = """
                            INSERT INTO factura_detalle (id,producto_id, cantidad, factura_id)
                            VALUES (?, ?, ?, ?)
                            RETURNING id;
                            """;

                    try (PreparedStatement stmtDetalle = connection.prepareStatement(sqlDetalle)) {
                        
                        stmtDetalle.setInt(1, maxIdfactura+1);
                        stmtDetalle.setInt(2, producto_id);
                        stmtDetalle.setInt(3, cantidad);
                        stmtDetalle.setInt(4, facturaId);
                        stmtDetalle.executeUpdate();
                    }

                }
            }
        }

        return null;

    }
}
