package com.fleur.service.impl;

import com.fleur.exception.ResourceNotFoundException;
import com.fleur.model.Commande;
import com.fleur.model.Fleur;
import com.fleur.repository.CommandeRepository;
import com.fleur.service.CommandeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    private CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeById(long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        if(commande.isPresent()){
            return commande.get();
        }
        else {
            throw new ResourceNotFoundException("Commande","Id",id);
        }
    }

    @Override
    public Commande updateCommande(Commande commande, long id) {
        // vérifier si la commande existe dans la BD
        Commande existingCommande = commandeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Commande", "Id", id));

        existingCommande.setDate(commande.getDate());
        existingCommande.setDescription(commande.getDescription());

        // enregistrer dans la BD
        commandeRepository.save(existingCommande);
        return existingCommande;
    }

    @Override
    public void deleteCommande(long id) {
        // vérifier si la commande existe dans la BD
        commandeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Commande", "Id", id));

        commandeRepository.deleteById(id);
    }


}
