package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

public class UserModelIndex {
    private int id_usuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @Min(value = 1000000, message = "El nro_cedula es demasiado corto")
    @Max(value = 999999999, message = "El nro_cedula es demasiado largo")
    private int nro_cedula;

    @Email(message = "Correo inválido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @Positive(message = "id_rol debe ser positivo")
    @Size(max = 7, message = "este es no id role")
    private int id_rol;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de ingreso es obligatoria")
    private LocalDate fecha_ingreso;

    private Period antiguedad;

    @Min(value = 0, message = "Los días de vacaciones no pueden ser negativos")
    private int dias_vacaciones;

    private boolean estado;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasena;

    @Pattern(regexp = "^[0-9\\-+() ]{7,20}$", message = "Teléfono inválido")
    private String telefono;

    @Positive(message = "id_equipo debe ser positivo")
    @Size(max=36, message = "Este es no equipo")
    private int id_equipo;

    @Positive(message = "id_cargo debe ser positivo")
    @Size(max=55, message = "Este es no cargo")
    private int id_cargo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fecha_nacimiento;

    @Min(value = 0, message = "Los días restantes no pueden ser negativos")
    private int dias_vacaciones_restante;

    private boolean requiere_cambio_contrasena;

    public UserModelIndex() {
    }

    // --- Getters & Setters ---
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNro_cedula() {
        return nro_cedula;
    }

    public void setNro_cedula(int nro_cedula) {
        this.nro_cedula = nro_cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Period getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Period antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getDias_vacaciones() {
        return dias_vacaciones;
    }

    public void setDias_vacaciones(int dias_vacaciones) {
        this.dias_vacaciones = dias_vacaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getDias_vacaciones_restante() {
        return dias_vacaciones_restante;
    }

    public void setDias_vacaciones_restante(int dias_vacaciones_restante) {
        this.dias_vacaciones_restante = dias_vacaciones_restante;
    }

    public boolean isRequiere_cambio_contrasena() {
        return requiere_cambio_contrasena;
    }

    public void setRequiere_cambio_contrasena(boolean requiere_cambio_contrasena) {
        this.requiere_cambio_contrasena = requiere_cambio_contrasena;
    }
}
