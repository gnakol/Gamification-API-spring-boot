package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Client;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements WebServices<Client> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> get_all() {
        return clientRepository.findAll();
    }

    @Override
    public void add_one(Client e) {

        clientRepository.save(e);

    }

    @Override
    public Client update(int id, Client e) {

        return clientRepository.findById(id)
                .map(p ->{
                    p.setSociete(e.getSociete());
                    p.setContact(e.getContact());
                    p.setFonction(e.getFonction());
                    p.setVille(e.getVille());
                    p.setPays(e.getPays());
                    p.setPhoto(e.getPhoto());
                    return clientRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("desoler ce client n'existe pas"));
    }

    @Override
    public void remove(int id) {

        Client client = clientRepository.findById(id).get();

        if(client != null)
            clientRepository.delete(client);

    }

    @Override
    public Client getById(int id) {
        return clientRepository.findById(id).get();
    }
}
