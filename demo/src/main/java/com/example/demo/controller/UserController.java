package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map; // Добавлен импорт Map
import java.util.Optional; // Добавлен импорт Optional

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing token");
        }

        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);

        Optional<User> userOptional = userService.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(Map.of(
                    "id", user.getId_usuario(),
                    "nombre", user.getNombre(),
                    "apellido", user.getApellido(),
                    "correo", user.getCorreo(),
                    "telefono", user.getTelefono(),
                    "id_rol", user.getId_rol(),
                    "id_cargo", user.getId_cargo(),
                    "id_equipo", user.getId_equipo(),
                    "token", token // возвращаем токен тоже
            ));
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(HttpServletRequest request, @RequestBody User updatedData) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing token");
        }

        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);

        Optional<User> userOptional = userService.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Обновляем только нужные поля (можно сделать проверку)
            user.setNombre(updatedData.getNombre());
            user.setApellido(updatedData.getApellido());
            user.setCorreo(updatedData.getCorreo());
            user.setTelefono(updatedData.getTelefono());
            user.setId_rol(updatedData.getId_rol());
            user.setId_cargo(updatedData.getId_cargo());
            user.setId_equipo(updatedData.getId_equipo());

            User savedUser = userService.save(user);

            return ResponseEntity.ok(Map.of(
                    "id", savedUser.getId_usuario(),
                    "nombre", savedUser.getNombre(),
                    "apellido", savedUser.getApellido(),
                    "correo", savedUser.getCorreo(),
                    "telefono", savedUser.getTelefono(),
                    "id_rol", savedUser.getId_rol(),
                    "id_cargo", savedUser.getId_cargo(),
                    "id_equipo", savedUser.getId_equipo(),
                    "token", token));
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

}