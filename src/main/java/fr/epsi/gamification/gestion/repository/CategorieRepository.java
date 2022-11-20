package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
