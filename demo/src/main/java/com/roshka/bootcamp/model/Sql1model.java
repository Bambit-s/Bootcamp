package com.roshka.bootcamp.model;

public class Sql1model {
    private int id;
    private String nombre;
    private String apellido;
    private int cantidadFacturas;

    public Sql1model(int id, String nombre, String apellido, int cantidadFacturas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantidadFacturas = cantidadFacturas;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getCantidadFacturas() { return cantidadFacturas; }

    
}
