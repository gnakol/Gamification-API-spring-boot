package fr.epsi.gamification.gestion.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "fournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fournisseur;

    @Column(name = "societe")
    private String societe;

    @Column(name = "contact")
    private String contact;

    @Column(name = "fonction")
    private String fonction;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Produit> produits;
}
