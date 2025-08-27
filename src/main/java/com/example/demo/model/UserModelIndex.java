package com.example.demo.model;

public class UserModelIndex {
    private int id_usuario;
    private String nombre;
    private String apellido;

    public UserModelIndex(int id_usuario, String nombre, String apellido) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}