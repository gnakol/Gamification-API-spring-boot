package fr.epsi.gamification.gestion.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ref_produit;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private float prix;

    @Column(name = "stock")
    private String stock;

    @Column(name = "disponibilite")
    private String disponibilite;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference_categorie")
    private Categorie categorie;
}
