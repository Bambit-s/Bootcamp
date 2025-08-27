package com.example.demo.model;
import java.sql.Date;

// import java.sql.Date;

public class RegistrationModel {
    String nombre;
    String apellido;
    int numeroSedula;
    String correo;
    int idRol;
    Date fecha_ingreso;// hoy
    int antiguedad = 0;//
    int dias_vacaciones = 0; //
    boolean estado = true; //
    String contrasena;
    String telefono;
    int idEquipo;
    int idCargo;
    Date fechaDeNacimento;
    int dias_vacaciones_restante = 0;//
    boolean requiere_cambio_contrasena = false;//

    // public RegistrationModel(String nombre) {
    // this.nombre = nombre;
    // }

    public RegistrationModel(String nombre, String apellido, int numeroSedula, String correo, int idRol,
            String contrasena, String telefono, int idEquipo, int idCargo, Date fechaDeNacimento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSedula = numeroSedula;
        this.correo = correo;
        this.idRol = idRol;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.idEquipo = idEquipo;
        this.idCargo = idCargo;
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

    public String getCorreo() {
        return correo;
    }
    public int getIdRol() {
        return idRol;
    }
    public Date getFechaIngreso(){
        long millis = System.currentTimeMillis();
        fecha_ingreso = new Date(millis);
        return fecha_ingreso;
    }

    public int getAntiguedad(){
        return antiguedad;
    }

    public int getDiasVacaciones(){
        return dias_vacaciones;
    }

    public boolean getEstado(){
        return estado;
    }

    public String getContasena() {
        return contrasena;
    }

    public int getEquipo() {
        return idEquipo;
    }

    public int getCargo() {
        return idCargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaDeNacimento() {
        return fechaDeNacimento;
    }
    
    public int getDiasVacacionesRestante() {
        return dias_vacaciones_restante;
    }
    
    public boolean getRequiereCambioContrasena() {
        return requiere_cambio_contrasena;
    }
}