package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Categorie;
import fr.epsi.gamification.gestion.beans.Fournisseur;
import fr.epsi.gamification.gestion.beans.Produit;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.CategorieRepository;
import fr.epsi.gamification.gestion.repository.FournisseurRepository;
import fr.epsi.gamification.gestion.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class ProduitService implements WebServices<Produit> {

    @Autowired
    private final ProduitRepository produitRepository;

    @Autowired
    private final FournisseurRepository fournisseurRepository;

    @Autowired
    private final CategorieRepository categorieRepository;

    public ProduitService(ProduitRepository produitRepository, FournisseurRepository fournisseurRepository, CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Produit> get_all() {
        return produitRepository.findAll();
    }

    @Override
    public void add_one(Produit e) {
        produitRepository.save(e);
    }

    @Override
    public Produit update(int id, Produit e) {
        return produitRepository.findById(id)
                .map(p ->{
                    p.setNom(e.getNom());
                    p.setPrix(e.getPrix());
                    p.setStock(e.getStock());
                    p.setDisponibilite(e.getDisponibilite());
                    p.setFournisseur(e.getFournisseur());
                    p.setCategorie(e.getCategorie());
                    return produitRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Execption sur le produit non trouver"));
    }

    @Override
    public void remove(int id) {

        Produit produit = produitRepository.findById(id).get();

        if(produit != null)
            produitRepository.delete(produit);

    }

    @Override
    public Produit getById(int id) {
        return produitRepository.findById(id).get();
    }

    // Liste des produit Livrer par un fournisseur grace à l'ID

    public List<Produit> getProduitByFournisseur(int id_fournisseur)
    {
        Fournisseur fournisseur = fournisseurRepository.findById(id_fournisseur).get();

        return produitRepository.findByFournisseur(fournisseur);
    }

    // Liste produit d'une categorie

    public List<Produit> getProduitByCategorie(int ref_categorie)
    {
        Categorie categorie = categorieRepository.findById(ref_categorie).get();

        return produitRepository.findByCategorie(categorie);
    }
}
