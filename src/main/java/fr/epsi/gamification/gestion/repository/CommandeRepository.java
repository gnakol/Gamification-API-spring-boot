package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
