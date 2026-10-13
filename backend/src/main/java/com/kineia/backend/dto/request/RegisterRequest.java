package com.kineia.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // Génère automatiquement les getters/setters grâce à Lombok
public class RegisterRequest {

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format d'email invalide")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit faire au moins 6 caractères")
    private String motDePasse; // On garde le même nom que pour le Login

    @NotBlank(message = "Le type d'utilisateur est obligatoire")
    private String userType; // "patient" ou "kine"
}