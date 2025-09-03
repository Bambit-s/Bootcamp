package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String nombre, String apellido, int nro_cedula, String contrasena, int id_rol,
            LocalDate fecha_ingreso, String correo, int id_cargo, int id_equipo, LocalDate fecha_nacimiento,
            Period antiguedad, String telefono) {
        User user = new User();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setNro_cedula(nro_cedula);
        user.setId_rol(id_rol);
        user.setFecha_ingreso(fecha_ingreso);
        user.setContrasena(passwordEncoder.encode(contrasena));
        user.setCorreo(correo);
        user.setId_cargo(id_cargo);
        user.setId_equipo(id_equipo);
        user.setFecha_nacimiento(fecha_nacimiento);
        user.setAntiguedad(antiguedad);
        user.setTelefono(telefono);
        return userRepository.save(user);
    }

    public Optional<User> login(String correo, String contrasena) {
        return userRepository.findByCorreo(correo)
                .filter(user -> passwordEncoder.matches(contrasena, user.getContrasena()));
    }

    public Optional<User> findById(Long id_usuario) {
        return userRepository.findById(id_usuario);
    }

    public void deleteById(Long id_usuario) {
        userRepository.deleteById(id_usuario);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String nombre) {
        return userRepository.findByCorreo(nombre);
    }
}
