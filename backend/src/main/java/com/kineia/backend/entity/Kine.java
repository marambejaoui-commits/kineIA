package com.kineia.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "kines")
@Entity
@PrimaryKeyJoinColumn(name="user_id")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Kine extends User{
    private Integer code;

    @OneToMany(mappedBy = "kine",cascade = CascadeType.PERSIST)
    private List<Patient> patients;

    @OneToMany(mappedBy = "kine")
    private List<Commentaire> commentaires;

}
