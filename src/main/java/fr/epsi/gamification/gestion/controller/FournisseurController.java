package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.Fournisseur;
import fr.epsi.gamification.gestion.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamif/fournisseur")
public class FournisseurController {

    @Autowired
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/listeAll")
    public List<Fournisseur> liste()
    {
        return fournisseurService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody Fournisseur fournisseur)
    {
        fournisseurService.add_one(fournisseur);

        return "Fournisseur ajouter avec succès";
    }

    @PutMapping("/{id_fournisseur}/update")
    public String update(@Validated @PathVariable int id_fournisseur,  @RequestBody Fournisseur fournisseur){
        fournisseurService.update(id_fournisseur, fournisseur);

        return "Mise à jour du fournisseur effectuer succès";
    }

    @DeleteMapping("/{id_fournisseur}/remove")
    public String remove(@Validated @PathVariable int id_fournisseur)
    {
        fournisseurService.remove(id_fournisseur);

        return "Fournisseur supprimer avec succès";
    }

    @GetMapping("/{id_fournisseur}/getById")
    public Fournisseur getById(@Validated @PathVariable int id_fournisseur)
    {
        return fournisseurService.getById(id_fournisseur);
    }
}
