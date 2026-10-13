package com.kineia.backend.entity;



import jakarta.persistence.*;
        import lombok.*;
        import java.util.List;

@Entity
@Table(name = "programmes")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idProgramme; // ID métier du diagramme
    private String nomProgramme;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Un programme contient plusieurs exercices (Composition)
    @ManyToMany
    @JoinTable(
            name = "programme_exercices",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "exercice_id")
    )
    private List<Exercice> exercices;
}