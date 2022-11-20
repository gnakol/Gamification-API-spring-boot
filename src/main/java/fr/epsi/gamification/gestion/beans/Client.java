package fr.epsi.gamification.gestion.beans;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

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


}
