package fr.epsi.gamification.gestion.controller;

import fr.epsi.gamification.gestion.beans.Client;
import fr.epsi.gamification.gestion.service.ClientService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamif/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/liste")
    public List<Client> liste(){

        return clientService.get_all();
    }

    @PostMapping("/ajouter")
    public String ajouter(@Validated @RequestBody Client client)
    {
        clientService.add_one(client);

        return "Client ajouter avec succes";
    }

    @PutMapping("/{id_client}/update")
    public String update(@Validated @PathVariable int id_client, @RequestBody Client client)
    {
        clientService.update(id_client, client);

        return "Client mise à jour avec success";
    }

    @DeleteMapping("/{id_client}/remove")
    public String remove(@Validated @PathVariable int id_client)
    {
        clientService.remove(id_client);

        return "Client supprimer avec succès";
    }

    @GetMapping("/{id_client}/getById")
    public Client getByIdClient(@Validated @PathVariable int id_client)
    {
        return clientService.getById(id_client);
    }




}
