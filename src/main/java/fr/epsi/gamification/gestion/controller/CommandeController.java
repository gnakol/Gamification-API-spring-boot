package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.Commande;
import fr.epsi.gamification.gestion.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamif/commande")
public class CommandeController {

    @Autowired
    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/listeAll")
    public List<Commande> liste()
    {
        return commandeService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody Commande commande)
    {

        commandeService.add_one(commande);

        return "Commande ajouter avec succès";
    }

    @PutMapping("/{ref_commande}/update")
    public String update(@Validated @PathVariable int ref_commande, @RequestBody Commande commande)
    {
        commandeService.update(ref_commande, commande);

        return "Mise à jour de la commande effectuer avec succcès";
    }

    @DeleteMapping("/{ref_commande}/remove")
    public String remove(@Validated @PathVariable int ref_commande)
    {
        commandeService.remove(ref_commande);

        return "commande supprimer avec succès";
    }

    @GetMapping("/{ref_commande}/getById")
    public Commande getById(@Validated @PathVariable int ref_commande)
    {
        return commandeService.getById(ref_commande);
    }

    @GetMapping("/commandesClientByID/{id_client}")
    public List<Commande> commandesByClientID(@Validated @PathVariable int id_client)
    {
        return commandeService.commandesByClientID(id_client);
    }

    @GetMapping("/commandesEmployeByID/{id_employe}")
    public List<Commande> commandesByEmployeID(@Validated @PathVariable int id_employe)
    {
        return commandeService.commandesByEmployeID(id_employe);
    }
}
