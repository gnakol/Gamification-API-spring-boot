package fr.epsi.gamification.gestion.repository;

import fr.epsi.gamification.gestion.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByRole(String role);

    User findByMail(String mail);

}
