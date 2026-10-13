package com.kineia.backend.entity;



import jakarta.persistence.*;
        import lombok.*;

@Entity
@Table(name = "commentaires")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idCommentaire;

    @Column(columnDefinition = "TEXT")
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "kine_id")
    private Kine kine;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}