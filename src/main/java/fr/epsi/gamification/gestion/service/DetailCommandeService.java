package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Commande;
import fr.epsi.gamification.gestion.beans.CompositeKey;
import fr.epsi.gamification.gestion.beans.DetailCommande;
import fr.epsi.gamification.gestion.beans.Produit;
import fr.epsi.gamification.gestion.repository.CommandeRepository;
import fr.epsi.gamification.gestion.repository.DetailCommandeRepository;
import fr.epsi.gamification.gestion.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

   /* public List<Produit> detail_par_produit(int ref_produit)
    {
        Produit produit = produitRepository.findById(ref_produit).get();

        return detailCommandeRepository.findByProduit(produit);
    }*/

    public void ajouterDetail(DetailCommande detailCommande)
    {
        detailCommandeRepository.save(detailCommande);
    }


    // Trouver tous les detail d'une commande grace à son ID

    public List<DetailCommande> getDetailByCommandeRef(int ref_commande)
    {
        Commande commande = commandeRepository.findById(ref_commande).get();

        return  detailCommandeRepository.findByCommande(commande);
    }

    public List<DetailCommande> getDetailByProduitRef(int ref_produit)
    {
        Produit produit = produitRepository.findById(ref_produit).get();

        return detailCommandeRepository.findByProduit(produit);
    }

    public DetailCommande updateQuantite(int ref_commande, int ref_produit, DetailCommande detail)
    {
        CompositeKey compositeKey = new CompositeKey(ref_commande, ref_produit);

        DetailCommande detailCommande = detailCommandeRepository.findById(compositeKey).get();

        if (detailCommande != null)
            detailCommande.setQuantite(detail.getQuantite());

        return detailCommandeRepository.save(detailCommande);
    }

    public DetailCommande updateRemise(int ref_commande, int ref_produit, DetailCommande detail)
    {
        CompositeKey compositeKey = new CompositeKey(ref_commande, ref_produit);

        DetailCommande detailCommande = detailCommandeRepository.findById(compositeKey).get();

        if (detailCommande != null)
            detailCommande.setRemise(detail.getRemise());

        return detailCommandeRepository.save(detailCommande);
    }

    public void remove(int ref_commande, int ref_produit)
    {
        CompositeKey compositeKey = new CompositeKey(ref_commande, ref_produit);

        DetailCommande detailCommande = detailCommandeRepository.findById(compositeKey).orElseThrow(()-> new RuntimeException("Introuvable"));

        if(detailCommande != null)
            detailCommandeRepository.delete(detailCommande);
    }

    // Liste des produits disponibles

    public List<Produit> listeProduitDispo(int ref_commande)
    {
        Commande commande = commandeRepository.findById(ref_commande).get();

        List<DetailCommande> liste_detail = detailCommandeRepository.findByCommande(commande);

        List<Produit> produits = new ArrayList<>();

        for (DetailCommande d: liste_detail)
        {
            if(d.getProduit().getDisponibilite().equals("disponible"))
                produits.add(d.getProduit());
        }

        return produits;
    }



}
