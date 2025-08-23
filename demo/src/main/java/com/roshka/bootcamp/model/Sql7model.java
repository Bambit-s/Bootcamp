package com.roshka.bootcamp.model;
import java.sql.Date;

public class Sql7model {
    private Date fechaEmision;
    private String nombre;
    private String apellido;
    private String productName;
    private int cantidad;
    private String facturaNombre;

    public Sql7model(Date fechaEmision, String nombre, String apellido, String productName ,int cantidad, String facturaNombre) {
        this.fechaEmision = fechaEmision;
        this.nombre = nombre;
        this.apellido = apellido;
        this.productName = productName;
        this.cantidad = cantidad;
        this.facturaNombre = facturaNombre;
    }

    public Date getFechaEmision() { return fechaEmision; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getProductName() { return productName; }
    public int getCantidad() { return cantidad; }
    public String getFacturaNombre() { return facturaNombre; }

}
