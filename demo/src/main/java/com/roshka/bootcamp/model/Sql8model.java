package com.roshka.bootcamp.model;

public class Sql8model {
    private int facturaId;
    private int totalFactura;

    public Sql8model(int facturaId, int totalFactura) {
        this.facturaId = facturaId;
        this.totalFactura = totalFactura;
    }

    public int getFacturaId() { return facturaId; }
    public int getTotalFactura() { return totalFactura; }

}
