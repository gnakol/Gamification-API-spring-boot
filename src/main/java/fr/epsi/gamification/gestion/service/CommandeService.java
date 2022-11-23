package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Commande;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements WebServices<Commande> {

    @Autowired
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Commande> get_all() {
        return commandeRepository.findAll();
    }

    @Override
    public void add_one(Commande e) {
        commandeRepository.save(e);
    }

    @Override
    public Commande update(int id, Commande e) {
        return commandeRepository.findById(id)
                .map(p ->{
                    p.setDate_commande(e.getDate_commande());
                    p.setDate_livraison(e.getDate_livraison());
                    p.setVille_livraison(e.getVille_livraison());
                    p.setClient(e.getClient());
                    p.setEmploye(e.getEmploye());
                    return commandeRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Desoler commande non trouver par cet id"));
    }

    @Override
    public void remove(int id) {

        Commande commande = commandeRepository.findById(id).get();

        if(commande != null)
            commandeRepository.delete(commande);

    }

    @Override
    public Commande getById(int id) {
        return commandeRepository.findById(id).get();
    }
}
