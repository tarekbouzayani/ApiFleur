package com.fleur.controller;

import com.fleur.model.Bouquet;
import com.fleur.model.Commande;
import com.fleur.model.Fleur;
import com.fleur.service.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/commandes")
public class CommandeController {

    private CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    // Create Commande REST API
    @PostMapping
    public ResponseEntity<Commande> saveCommande(@RequestBody Commande commande){
        return new ResponseEntity<Commande>(commandeService.saveCommande(commande), HttpStatus.CREATED);
    }

    // Get get all commandes REST API
    @GetMapping
    public List<Commande> getAllCommandes(){
        return commandeService.getAllCommandes();
    }

    // Get get Commande by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable("id") long id){
        return new ResponseEntity<Commande>(commandeService.getCommandeById(id),HttpStatus.OK);
    }

    // update Commande REST API
    // http://localhost:8085/api/commandes/1
    @PutMapping("{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable("id") long id,@RequestBody Commande commande){
        return new ResponseEntity<Commande>(commandeService.updateCommande(commande, id), HttpStatus.OK);
    }

    // delete Commande REST API
    // http://localhost:8085/api/commandes/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCommande(@PathVariable("id") long id){
        commandeService.deleteCommande(id);
        return new ResponseEntity<String>("Commande supprimée avec succès.", HttpStatus.OK);
    }

}
