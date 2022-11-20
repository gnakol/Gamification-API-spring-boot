package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
