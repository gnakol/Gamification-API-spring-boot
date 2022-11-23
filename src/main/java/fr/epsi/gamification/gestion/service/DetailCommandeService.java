package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.CompositeKey;
import fr.epsi.gamification.gestion.beans.DetailCommande;
import fr.epsi.gamification.gestion.beans.Produit;
import fr.epsi.gamification.gestion.repository.CommandeRepository;
import fr.epsi.gamification.gestion.repository.DetailCommandeRepository;
import fr.epsi.gamification.gestion.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailCommandeService {

    @Autowired
    private final DetailCommandeRepository detailCommandeRepository;

    @Autowired
    private final ProduitRepository produitRepository;

    @Autowired
    private final CommandeRepository commandeRepository;

    public DetailCommandeService(DetailCommandeRepository detailCommandeRepository, ProduitRepository produitRepository, CommandeRepository commandeRepository) {
        this.detailCommandeRepository = detailCommandeRepository;
        this.produitRepository = produitRepository;
        this.commandeRepository = commandeRepository;
    }

    public List<DetailCommande> liste()
    {
        return detailCommandeRepository.findAll();
    }

    public DetailCommande getDetail(int ref_commande, int ref_produit)
    {
        CompositeKey compositeKey = new CompositeKey(ref_commande, ref_produit);

        return this.detailCommandeRepository.findById(compositeKey).get();
    }

    // Connaitre les details sur un produit

    public List<Produit> detail_par_produit(int ref_produit)
    {
        Produit produit = produitRepository.findById(ref_produit).get();

        return detailCommandeRepository.findByProduit(produit);
    }

    public void ajouterDetail(DetailCommande detailCommande)
    {
        detailCommandeRepository.save(detailCommande);
    }



}
