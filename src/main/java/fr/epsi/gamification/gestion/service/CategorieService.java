package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Categorie;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class CategorieService implements WebServices<Categorie> {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> get_all() {
        return categorieRepository.findAll();
    }

    @Override
    public void add_one(Categorie e)  {

        categorieRepository.save(e);
    }

    @Override
    public Categorie update(int id, Categorie e) {
        return categorieRepository.findById(id)
                .map(p ->{
                    p.setNom(e.getNom());
                    p.setDescription(e.getDescription());
                    return categorieRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("categorie indisponible"));
    }

    @Override
    public void remove(int id) {
        Categorie categorie = categorieRepository.findById(id).get();

        if(categorie != null)
            categorieRepository.delete(categorie);
    }

    @Override
    public Categorie getById(int id) {
        return categorieRepository.findById(id).get();
    }
}
