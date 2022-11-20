package fr.epsi.gamification.gestion.service;

import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    private final CommandeService commandeService;

    public CommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    
}
