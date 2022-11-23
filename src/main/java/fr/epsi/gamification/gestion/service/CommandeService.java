package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Client;
import fr.epsi.gamification.gestion.beans.Commande;
import fr.epsi.gamification.gestion.beans.Employe;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.ClientRepository;
import fr.epsi.gamification.gestion.repository.CommandeRepository;
import fr.epsi.gamification.gestion.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements WebServices<Commande> {

    @Autowired
    private final CommandeRepository commandeRepository;

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final EmployeRepository employeRepository;

    public CommandeService(CommandeRepository commandeRepository, ClientRepository clientRepository, EmployeRepository employeRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.employeRepository = employeRepository;
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

    // Liste des commandes d'un client grace à son ID
    public List<Commande> commandesByClientID(int id_client)
    {
        Client client = clientRepository.findById(id_client).get();

        return  commandeRepository.findByClient(client);
    }

    // Liste des commandes gerer par un employe grace à son ID

    public List<Commande> commandesByEmployeID(int id_employe)
    {
        Employe employe = employeRepository.findById(id_employe).get();

        return  commandeRepository.findByEmploye(employe);
    }
}
