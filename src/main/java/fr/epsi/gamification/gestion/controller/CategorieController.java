package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.Categorie;
import fr.epsi.gamification.gestion.service.CategorieService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/listeAll")
    public List<Categorie> liste()
    {
        return categorieService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody Categorie categorie)
    {
        categorieService.add_one(categorie);

        return "Categorie d'article ajouter avec succès";
    }

    @PutMapping("/{ref_categorie}/update")
    public String update(@Validated @PathVariable int ref_categorie, @RequestBody Categorie categorie)
    {
        categorieService.update(ref_categorie, categorie);

        return "mise à jour categorie avec succès";
    }

    @DeleteMapping("/{ref_categorie}/remove")
    public String remove(@Validated @PathVariable int ref_categorie)
    {
        categorieService.remove(ref_categorie);

        return "Categorie supprimer avec succès";
    }

    @GetMapping("/{ref_categorie}/getById")
    public Categorie getById(@Validated @PathVariable int ref_categorie)
    {
        return categorieService.getById(ref_categorie);
    }
}
