package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Commande;
import fr.epsi.gamification.gestion.beans.CompositeKey;
import fr.epsi.gamification.gestion.beans.DetailCommande;
import fr.epsi.gamification.gestion.beans.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailCommandeRepository extends JpaRepository<DetailCommande, CompositeKey> {

    List<DetailCommande> findByCommande(Commande commande);

    //List<Produit> findByProduit(Produit produit);

    List<DetailCommande> findByProduit(Produit produit);


}
