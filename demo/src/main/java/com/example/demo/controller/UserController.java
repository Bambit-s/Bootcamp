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
}