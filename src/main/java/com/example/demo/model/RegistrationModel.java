package com.example.demo.model;

import java.sql.Date;

public class RegistrationModel {

    String nombre;
    String apellido;
    int numeroSedula;
    String correoElectronico;
    String contasena;
    String telefono;
    int equipo;
    int cargo;
    Date fechaDeNacimento;

    public RegistrationModel(String nombre, String apellido, int numeroSedula, String correoElectronico,
            String contasena, String telefono, int equipo, int cargo, Date fechaDeNacimento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSedula = numeroSedula;
        this.correoElectronico = correoElectronico;
        this.contasena = contasena;
        this.telefono = telefono;
        this.equipo = equipo;
        this.cargo = cargo;
        this.fechaDeNacimento = fechaDeNacimento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumeroSedula() {
        return numeroSedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContasena() {
        return contasena;
    }

    public int getEquipo() {
        return equipo;
    }

    public int getCargo() {
        return cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaDeNacimento() {
        return fechaDeNacimento;
    }
}