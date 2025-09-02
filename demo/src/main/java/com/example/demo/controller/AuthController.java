package com.example.demo.controller;

import com.example.demo.security.JwtService;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        User user = userService.register(body.get("username"), body.get("password"));
        return ResponseEntity.ok(Map.of("id", user.getId(), "username", user.getUsername()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        return userService.login(body.get("username"), body.get("password"))
                .map(user -> Map.of("token", jwtService.generateToken(user.getUsername())))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid credentials")));
    }
}
