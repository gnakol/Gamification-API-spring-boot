package fr.epsi.gamification.gestion.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;

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

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Commande> commandes;


}
