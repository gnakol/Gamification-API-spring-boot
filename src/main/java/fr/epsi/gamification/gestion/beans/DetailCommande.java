package fr.epsi.gamification.gestion.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detailscommande")
public class DetailCommande {

    @EmbeddedId
    private CompositeKey ref_detail;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "remise")
    private float remise;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @MapsId("ref_produit")
    @JoinColumn(name = "reference_produit")
    @JsonIgnoreProperties({"categorie, fournisseur, detailCommandes"})
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @MapsId("ref_commande")
    @JoinColumn(name = "reference_commande")
    @JsonIgnoreProperties({"client, employe, detailCommandes"})
    private Commande commande;
}
