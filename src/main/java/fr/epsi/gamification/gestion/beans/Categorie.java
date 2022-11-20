package fr.epsi.gamification.gestion.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_categorie;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description_categorie")
    private String description;
}
