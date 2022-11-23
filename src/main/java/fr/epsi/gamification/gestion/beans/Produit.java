package fr.epsi.gamification.gestion.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_produit")
    private int ref_produit;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private float prix;

    @Column(name = "stock")
    private String stock;

    @Column(name = "disponibilite")
    private String disponibilite;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "reference_categorie")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<DetailCommande> detailCommandes;

}
