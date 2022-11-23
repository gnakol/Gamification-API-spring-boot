package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.Produit;
import fr.epsi.gamification.gestion.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/listeAll")
    public List<Produit> liste()
    {
        return produitService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody Produit produit)
    {
        produitService.add_one(produit);

        return "Produit ajouter avec succès";
    }

    @PutMapping("/{ref_produit}/update")
    public String update(@Validated @PathVariable int ref_produit, @RequestBody Produit produit)
    {
        produitService.update(ref_produit, produit);

        return "Mise à jour du produit effectuer avec succès";
    }

    @DeleteMapping("/{ref_produit}/remove")
    public String remove(@Validated @PathVariable int ref_produit)
    {
        produitService.remove(ref_produit);

        return "Produit supprimer avec succès";
    }

    @GetMapping("/{ref_produit}/getById")
    public Produit getById(@Validated @PathVariable int ref_produit)
    {
        return produitService.getById(ref_produit);
    }
}
