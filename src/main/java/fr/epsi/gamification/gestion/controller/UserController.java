package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.User;
import fr.epsi.gamification.gestion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/gamif/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listeAll")
    public List<User> liste()
    {
        return userService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody User user) throws GeneralSecurityException {
        userService.add_one(user);

        return "Utilisateur ajouter avec succès";
    }

    @PutMapping("/{id_user}/update")
    public String update(@Validated @PathVariable int id_user, @RequestBody User user)
    {
        userService.update(id_user, user);

        return "mise à jour de l'utilisateur effectuer avec succès";
    }

    @DeleteMapping("/{id_user}/remove")
    public String remove(@Validated @PathVariable int id_user)
    {
        userService.remove(id_user);

        return "utilisateur supprimer avec succès";
    }

    @GetMapping("/{id_user}/getById")
    public User getById(@Validated @PathVariable int id_user)
    {
        return userService.getById(id_user);
    }

    @GetMapping("/listeUserByRole/{role_user}")
    public List<User> listeUserByRole(@Validated @PathVariable String role_user)
    {
        return userService.listeByRole(role_user);
    }

    @GetMapping("/getUserByMail/{mail}")
    public User getUserByMail(@Validated @PathVariable String mail)
    {
        return userService.getByEmail(mail);
    }

    @PostMapping("/verifPassword")
    public String verificationPassword(@Validated @RequestBody User user)
    {
        User user1 = userService.connexion(user);
        if (user1 != null)
            return "Mot de passde cohérent c'est bon";

        return "attention les mots de passe sont pas identiques";
    }
}
