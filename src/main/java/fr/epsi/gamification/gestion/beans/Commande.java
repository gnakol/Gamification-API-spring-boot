package fr.epsi.gamification.gestion.beans;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ref_commande;

    @Column(name = "date_commande")
    private Date date_commande;

    @Column(name = "date_livraison")
    private Date date_livraison;

    @Column(name = "ville_livraison")
    private String ville_livraison;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_employe")
    private Employe employe;


}
