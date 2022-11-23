package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.DetailCommande;
import fr.epsi.gamification.gestion.beans.Produit;
import fr.epsi.gamification.gestion.service.DetailCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamif/detail")
public class DetailCommandeController {

    @Autowired
    private final DetailCommandeService detailCommandeService;

    public DetailCommandeController(DetailCommandeService detailCommandeService) {
        this.detailCommandeService = detailCommandeService;
    }

   @GetMapping("/listeAll")
    public List<DetailCommande> liste(){

        return detailCommandeService.liste();
    }

    @GetMapping("/detailDuProduitNum/{ref_produit}")
    public List<Produit> detail_par_produit(@Validated @PathVariable int ref_produit)
    {
        return detailCommandeService.detail_par_produit(ref_produit);
    }

    @PostMapping("/ajouter")
    public String addDetail(@Validated @RequestBody DetailCommande detailCommande)
    {
        detailCommandeService.ajouterDetail(detailCommande);

        return "Detail commande ajouter avec succès";
    }

    /*@PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody DetailCommande detailCommande)
    {
        detailCommandeService.add_one(detailCommande);

        return "le détail de la commande à été ajouter avec succès";
    }

    @PutMapping("/{ref_detail}/update")
    public String update(@Validated @PathVariable int ref_detail, @RequestBody DetailCommande detailCommande)
    {
        detailCommandeService.update(ref_detail, detailCommande);

        return "Mise à jour du detail de la commande à été un succès";
    }

    @DeleteMapping("/{ref_detail}/remove")
    public String remove(@Validated @PathVariable int ref_detail)
    {
        detailCommandeService.remove(ref_detail);

        return "detail de la commande à été bien supprimer";
    }*/

    @GetMapping("/getById/{ref_commande}/{ref_produit}")
    public DetailCommande getById(@Validated @PathVariable int ref_commande, @PathVariable int ref_produit)
    {
        return detailCommandeService.getDetail(ref_commande, ref_produit);
    }
}
