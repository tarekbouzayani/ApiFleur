package com.fleur.service;

import com.fleur.model.Fleur;

import java.util.List;

public interface FleurService {

    Fleur saveFleur(Fleur fleur);
    List<Fleur> getAllFleurs();
    Fleur getFleurById(long id);
    Fleur updateFleur(Fleur fleur, long id);
    void deleteFleur(long id);
}
