package com.fleur.service;

import com.fleur.model.Bouquet;

import java.util.List;

public interface BouquetService {

    Bouquet saveBouquet(Bouquet bouquet);
    List<Bouquet> getAllBouquets();
    Bouquet getBouquetById(long id);
    Bouquet updateBouquet(Bouquet bouquet, long id);
    void deleteBouquet(long id);
}
