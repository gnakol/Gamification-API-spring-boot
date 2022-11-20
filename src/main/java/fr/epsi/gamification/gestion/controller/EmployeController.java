package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.Employe;
import fr.epsi.gamification.gestion.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/listeAll")
    public List<Employe> liste()
    {
        return employeService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajout(@Validated @RequestBody Employe employe)
    {
        employeService.add_one(employe);

        return "Employe ajouter avec succès";
    }

    @PutMapping("/{id_employe}/update")
    public String update(@Validated @PathVariable int id_employe, @RequestBody Employe employe)
    {
        employeService.update(id_employe, employe);

        return "Mise à jour de l'employer effectuer avec succès";
    }

    @DeleteMapping("/{id_employe}/remove")
    public String remove(@Validated @PathVariable int id_employe)
    {
        employeService.remove(id_employe);

        return "Employe supprimer avec succès";
    }

    @GetMapping("/{id_employe}/getById")
    public Employe getById(@Validated @PathVariable int id_employe)
    {
        return employeService.getById(id_employe);
    }
}
