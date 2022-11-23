package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Produit;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class ProduitService implements WebServices<Produit> {

    @Autowired
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
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
}
