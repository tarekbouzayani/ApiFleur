package com.fleur.service.impl;

import com.fleur.exception.ResourceNotFoundException;
import com.fleur.model.Fleur;
import com.fleur.repository.FleurRepository;
import com.fleur.service.FleurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FleurServiceImpl implements FleurService {

    private FleurRepository fleurRepository;

    public FleurServiceImpl(FleurRepository fleurRepository) {
        this.fleurRepository = fleurRepository;
    }

    @Override
    public Fleur saveFleur(Fleur fleur) {
        return fleurRepository.save(fleur);
    }

    @Override
    public List<Fleur> getAllFleurs() {
        return fleurRepository.findAll();
    }

    @Override
    public Fleur getFleurById(long id) {
        Optional<Fleur> fleur = fleurRepository.findById(id);
        if(fleur.isPresent()){
            return fleur.get();
        }
        else {
            throw new ResourceNotFoundException("Fleur","Id",id);
        }
    }

    @Override
    public Fleur updateFleur(Fleur fleur, long id) {

        // vérifier si la fleur existe dans la BD
        Fleur existingFleur = fleurRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Fleur", "Id", id));

        existingFleur.setName(fleur.getName());
        existingFleur.setDescription(fleur.getDescription());

        // enregistrer dans la BD
        fleurRepository.save(existingFleur);
        return existingFleur;
    }

    @Override
    public void deleteFleur(long id) {
        // vérifier si la fleur existe dans la BD
        fleurRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Fleur", "Id", id));

        fleurRepository.deleteById(id);
    }
}
