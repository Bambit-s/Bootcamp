package com.roshka.bootcamp.model;

public class Sql9model {
    private int facturaId;
    private int conIvaDiez;

    public Sql9model(int facturaId, int conIvaDiez) {
        this.facturaId = facturaId;
        this.conIvaDiez = conIvaDiez;
    }

    public int getFacturaId() { return facturaId; }
    public int getConIvaDiez() { return conIvaDiez; }

}
