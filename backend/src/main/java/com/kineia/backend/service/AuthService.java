package com.kineia.backend.service;

import com.kineia.backend.dto.request.LoginRequest;
import com.kineia.backend.dto.request.RegisterRequest;
import com.kineia.backend.entity.Kine;
import com.kineia.backend.entity.Patient;
import com.kineia.backend.entity.User;
import com.kineia.backend.repository.UserRepository;
import com.kineia.backend.security.JwtService; // Assure-toi d'importer ton JwtService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService; // Nécessaire pour le login

    // --- MÉTHODE LOGIN (Celle qui manquait) ---
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Vérification du mot de passe (on compare le clair avec le haché)
        if (passwordEncoder.matches(request.getMotDePasse(), user.getPassword())) {
            return jwtService.generateToken(user.getEmail());
        } else {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }
    }

    // --- MÉTHODE REGISTER ---
    @Transactional
    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé !");
        }

        User newUser;
        if ("kine".equalsIgnoreCase(request.getUserType())) {
            newUser = new Kine();
        } else {
            newUser = new Patient();
        }

        newUser.setNom(request.getNom());
        newUser.setPrenom(request.getPrenom());
        newUser.setEmail(request.getEmail());

        // Hachage avant sauvegarde
        newUser.setPassword(passwordEncoder.encode(request.getMotDePasse()));

        userRepository.save(newUser);
    }
}