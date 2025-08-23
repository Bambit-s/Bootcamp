package com.roshka.bootcamp.model;

public class Sql6model {
    private int proveedorId;
    private String nombreProveedor;
    private int cantidadVeces;

    public Sql6model(int proveedorId, String nombreProveedor,  int cantidadVeces) {
        this.proveedorId = proveedorId;
        this.nombreProveedor = nombreProveedor;
        this.cantidadVeces = cantidadVeces;
    }

    public int getProveedorId() { return proveedorId; }
    public String getNombreProveedor() { return nombreProveedor; }
    public int getCantidadVeces() { return cantidadVeces; }

}
