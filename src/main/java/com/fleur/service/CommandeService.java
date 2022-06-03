package com.fleur.service;

import com.fleur.model.Commande;

import java.util.List;

public interface CommandeService {

    Commande saveCommande(Commande commande);
    List<Commande> getAllCommandes();
    Commande getCommandeById(long id);
    Commande updateCommande(Commande commande, long id);
    void deleteCommande(long id);
}
