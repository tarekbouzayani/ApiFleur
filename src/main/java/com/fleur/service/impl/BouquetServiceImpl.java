package com.fleur.service.impl;

import com.fleur.exception.ResourceNotFoundException;
import com.fleur.model.Bouquet;
import com.fleur.model.Commande;
import com.fleur.model.Fleur;
import com.fleur.repository.BouquetRepository;
import com.fleur.service.BouquetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BouquetServiceImpl implements BouquetService {

    private BouquetRepository bouquetRepository;

    public BouquetServiceImpl(BouquetRepository bouquetRepository) {
        this.bouquetRepository = bouquetRepository;
    }

    @Override
    public Bouquet saveBouquet(Bouquet bouquet) {
        return bouquetRepository.save(bouquet);
    }

    @Override
    public List<Bouquet> getAllBouquets() {
        return bouquetRepository.findAll();
    }

    @Override
    public Bouquet getBouquetById(long id) {
        Optional<Bouquet> bouquet = bouquetRepository.findById(id);
        if(bouquet.isPresent()){
            return bouquet.get();
        }
        else {
            throw new ResourceNotFoundException("Bouquet","Id",id);
        }
    }

    @Override
    public Bouquet updateBouquet(Bouquet bouquet, long id) {
        // vérifier si le bouquet existe dans la BD
        Bouquet existingBouquet = bouquetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bouquet", "Id", id));

        existingBouquet.setName(bouquet.getName());
        existingBouquet.setDescription(bouquet.getDescription());

        // enregistrer dans la BD
        bouquetRepository.save(existingBouquet);
        return existingBouquet;
    }

    @Override
    public void deleteBouquet(long id) {
        // vérifier si le bouquet existe dans la BD
        bouquetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bouquet", "Id", id));
        bouquetRepository.deleteById(id);
    }
}
