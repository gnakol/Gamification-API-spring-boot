package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.User;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements WebServices<User> {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> get_all() {
        return userRepository.findAll();
    }

    // Scripter le mote de passe de chaque utilisateur site

    public String crypte(String password) throws GeneralSecurityException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        byte byteData[] = messageDigest.digest();

        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < byteData.length; i++)
            stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        return stringBuffer.toString();
    }

    @Override
    public void add_one(User e) throws GeneralSecurityException {
        e.setPassword(crypte(e.getPassword()));
        userRepository.save(e);
    }

    @Override
    public User update(int id, User e) {
        return userRepository.findById(id)
                .map(p ->{
                    p.setNom(e.getNom());
                    p.setPrenom(e.getPrenom());
                    p.setMail(e.getMail());
                    p.setPassword(e.getPassword());
                    p.setRole(e.getRole());
                    return userRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Utilisateur non trouver"));
    }

    @Override
    public void remove(int id) {
        User user = userRepository.findById(id).get();

        if(user != null)
            userRepository.delete(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).get();
    }


    // Liste des user par role
    public List<User> listeByRole(String role_user)
    {
        return userRepository.findByRole(role_user);
    }

    // Recuperer un user par email

    public User getByEmail(String mail)
    {
        return userRepository.findByMail(mail);
    }

    // Trouver un user grace ?? son email(login) et mot de passe

    public User connexion(User user)
    {
        User personne = this.getByEmail(user.getMail());

        if (personne != null)
        {
            if (Objects.equals(user.getPassword(), personne.getPassword()))
                return personne;
        }
        return null;
    }
}
