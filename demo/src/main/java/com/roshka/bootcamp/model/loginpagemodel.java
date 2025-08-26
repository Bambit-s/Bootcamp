package com.roshka.bootcamp.model;

public class loginpagemodel {
    
    private int id;
    private String nombre;
    private String apellido;
    private String nro_cedula;
    private String telefono;

    public loginpagemodel(int id,String nombre, String apellido, String nro_cedula, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_cedula = nro_cedula;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getNroCedula() { return nro_cedula; }
    public String getTelefono() { return telefono; }
}
