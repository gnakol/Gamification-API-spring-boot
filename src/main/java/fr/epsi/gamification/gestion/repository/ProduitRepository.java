package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Categorie;
import fr.epsi.gamification.gestion.beans.Fournisseur;
import fr.epsi.gamification.gestion.beans.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    List<Produit> findByFournisseur(Fournisseur fournisseur);

    List<Produit> findByCategorie(Categorie categorie);


}
