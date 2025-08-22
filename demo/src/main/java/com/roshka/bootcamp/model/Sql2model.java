package com.roshka.bootcamp.model;

public class Sql2model {
    private int clienteId;
    private String nombre;
    private String apellido;
    private int facturaId;
    private int sumaCantidad;

    public Sql2model(int clienteId, String nombre, String apellido, int facturaId, int sumaCantidad) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facturaId = facturaId;
        this.sumaCantidad = sumaCantidad;
    }

    public int getClienteId() { return clienteId; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getFacturaId() { return facturaId; }
    public int getSumaCantidad() { return sumaCantidad; }

    
}
