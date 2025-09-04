package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(unique = true, nullable = false)
    private int nro_cedula;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(nullable = false)
    private Integer id_rol;

    @Column(nullable = false)
    private LocalDate fecha_ingreso;

    @Transient
    private Period antiguedad;

    @Column(nullable = false)
    private int dias_vacaciones;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false)
    private String contrasena;

    private String telefono;

    private Integer id_equipo;

    private Integer id_cargo;

    // @Column(nullable = false)
    private LocalDate fecha_nacimiento;

    private Integer dias_vacaciones_restante;

    private Boolean requiere_cambio_contrasena;

    // --- Getters & Setters ---
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
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

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
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

    public Boolean isEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
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

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getDias_vacaciones_restante() {
        return dias_vacaciones_restante;
    }

    public void setDias_vacaciones_restante(Integer dias_vacaciones_restante) {
        this.dias_vacaciones_restante = dias_vacaciones_restante;
    }

    public Boolean isRequiere_cambio_contrasena() {
        return requiere_cambio_contrasena;
    }

    public void setRequiere_cambio_contrasena(Boolean requiere_cambio_contrasena) {
        this.requiere_cambio_contrasena = requiere_cambio_contrasena;
    }
}
