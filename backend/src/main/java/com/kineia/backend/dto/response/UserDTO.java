package com.kineia.backend.dto.response;


import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String role; // "KINE" ou "PATIENT"
}