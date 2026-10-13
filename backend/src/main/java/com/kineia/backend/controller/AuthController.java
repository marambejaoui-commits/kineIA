package com.kineia.backend.controller;

import com.kineia.backend.dto.request.LoginRequest;
import com.kineia.backend.dto.request.RegisterRequest; // Assure-toi d'avoir ce DTO
import com.kineia.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3001") // Port 3001 pour ton React
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    // AJOUTE CETTE MÉTHODE :
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request); // Appelle ton service pour enregistrer en MySQL
        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }
}