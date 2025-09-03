package com.example.demo.controller;

import com.example.demo.security.JwtService;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.ok("User with id " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        int nro_cedula = Integer.parseInt(body.get("nro_cedula"));
        int id_rol = Integer.parseInt(body.get("id_rol"));
        int id_cargo = Integer.parseInt(body.get("id_cargo"));
        int id_equipo = Integer.parseInt(body.get("id_equipo"));
        LocalDate fecha_ingreso = LocalDate.parse(body.get("fecha_ingreso"));
        LocalDate fecha_nacimiento = LocalDate.parse(body.get("fecha_nacimiento"));
        Period antiguedad = Period.between(fecha_ingreso, LocalDate.now());

        User user = userService.register(
                body.get("nombre"),
                body.get("apellido"),
                nro_cedula,
                body.get("contrasena"),
                id_rol,
                fecha_ingreso,
                body.get("correo"),
                id_cargo,
                id_equipo,
                fecha_nacimiento,
                antiguedad,
                body.get("telefono"));

        return ResponseEntity.ok(Map.of(
                "id_usuario", user.getId_usuario(),
                "nombre", user.getNombre()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        return userService.login(body.get("correo"), body.get("contrasena"))
                .map(user -> Map.of("token", jwtService.generateToken(user.getCorreo())))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid credentials")));
    }
}
