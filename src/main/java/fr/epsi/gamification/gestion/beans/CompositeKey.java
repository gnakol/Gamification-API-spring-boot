package fr.epsi.gamification.gestion.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositeKey implements Serializable {

    @Column(name = "reference_commande")
    private int ref_commande;

    @Column(name = "reference_produit")
    private  int ref_produit;

    public CompositeKey(){

    }

    public CompositeKey(int ref_detail, int ref_produit) {
        this.ref_commande = ref_detail;
        this.ref_produit = ref_produit;
    }

    public int getRef_commande() {
        return ref_commande;
    }

    public void setRef_commande(int ref_detail) {
        this.ref_commande = ref_detail;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }
}
