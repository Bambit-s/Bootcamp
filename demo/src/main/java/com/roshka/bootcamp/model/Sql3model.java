package com.roshka.bootcamp.model;

public class Sql3model {
    private int monedaId;
    private String monedaNombre;
    private int cantidadFacturas;

    public Sql3model(int monedaId, String monedaNombre,  int cantidadFacturas) {
        this.monedaId = monedaId;
        this.monedaNombre = monedaNombre;
        this.cantidadFacturas = cantidadFacturas;
    }

    public int getMonedaId() { return monedaId; }
    public String getMonedaNombre() { return monedaNombre; }
    public int getCantidadFacturas() { return cantidadFacturas; }

    
}
