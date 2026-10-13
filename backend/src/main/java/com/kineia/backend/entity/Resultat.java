package com.kineia.backend.entity;



import jakarta.persistence.*;
        import lombok.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "resultats")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idResultat;
    private Float score;
    private LocalDateTime dateResultat;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;
}