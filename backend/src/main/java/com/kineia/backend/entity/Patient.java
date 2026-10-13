package com.kineia.backend.entity;



import jakarta.persistence.*;
        import lombok.*;
        import java.util.List;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Patient extends User {

    private Integer idPatient;

    @ManyToOne
    @JoinColumn(name = "kine_id")
    private Kine kine;

    @OneToMany(mappedBy = "patient")
    private List<Resultat> resultats;

    @OneToMany(mappedBy = "patient")
    private List<Programme> programmes;
}
