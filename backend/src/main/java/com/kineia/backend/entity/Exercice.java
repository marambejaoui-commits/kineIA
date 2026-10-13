package com.kineia.backend.entity;



import jakarta.persistence.*;
        import lombok.*;
        import java.util.List;

@Entity
@Table(name = "exercices")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idExercice;
    private String nomExercice;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "exercice")
    private List<Resultat> resultats;
}