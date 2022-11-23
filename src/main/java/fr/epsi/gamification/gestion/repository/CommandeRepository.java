package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Client;
import fr.epsi.gamification.gestion.beans.Commande;
import fr.epsi.gamification.gestion.beans.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findByClient(Client client);

    List<Commande> findByEmploye(Employe employe);

}
