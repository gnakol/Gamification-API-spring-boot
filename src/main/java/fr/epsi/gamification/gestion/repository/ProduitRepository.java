package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
