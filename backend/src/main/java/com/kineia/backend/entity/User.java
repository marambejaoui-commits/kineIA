package com.kineia.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
}
