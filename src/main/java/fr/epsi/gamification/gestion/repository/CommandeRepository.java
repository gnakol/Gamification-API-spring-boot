package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
