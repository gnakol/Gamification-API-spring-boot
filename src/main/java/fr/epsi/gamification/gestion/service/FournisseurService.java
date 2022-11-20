package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Fournisseur;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class FournisseurService implements WebServices<Fournisseur> {

    @Autowired
    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public List<Fournisseur> get_all() {
        return fournisseurRepository.findAll();
    }

    @Override
    public void add_one(Fournisseur e)  {
        fournisseurRepository.save(e);

    }

    @Override
    public Fournisseur update(int id, Fournisseur e) {
        return fournisseurRepository.findById(id)
                .map(p ->{
                    p.setSociete(e.getSociete());
                    p.setContact(e.getSociete());
                    p.setFonction(e.getFonction());
                    p.setVille(e.getVille());
                    p.setPays(e.getPays());
                    return fournisseurRepository.save(e);
                }).orElseThrow(() -> new RuntimeException("Attention problème niveau fournisseur introuvable"));
    }

    @Override
    public void remove(int id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).get();

        if (fournisseur != null)
            fournisseurRepository.delete(fournisseur);
    }

    @Override
    public Fournisseur getById(int id) {
        return fournisseurRepository.findById(id).get();
    }
}
