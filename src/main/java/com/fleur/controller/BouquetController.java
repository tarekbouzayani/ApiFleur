package com.fleur.controller;

import com.fleur.model.Bouquet;
import com.fleur.model.Fleur;
import com.fleur.service.BouquetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bouquets")
public class BouquetController {

    private BouquetService bouquetService;

    public BouquetController(BouquetService bouquetService) {
        this.bouquetService = bouquetService;
    }

    // Create Bouquet REST API
    @PostMapping
    public ResponseEntity<Bouquet> saveBouquet(@RequestBody Bouquet bouquet){
        return new ResponseEntity<Bouquet>(bouquetService.saveBouquet(bouquet), HttpStatus.CREATED);
    }

    // Get get all bouquets REST API
    @GetMapping
    public List<Bouquet> getAllBouquets(){
        return bouquetService.getAllBouquets();
    }

    // Get get bouquet by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Bouquet> getBouquetById(@PathVariable("id") long id){
        return new ResponseEntity<Bouquet>(bouquetService.getBouquetById(id),HttpStatus.OK);
    }

    // update bouquet REST API
    // http://localhost:8085/api/bouquets/1
    @PutMapping("{id}")
    public ResponseEntity<Bouquet> updateBouquet(@PathVariable("id") long id,@RequestBody Bouquet bouquet){
        return new ResponseEntity<Bouquet>(bouquetService.updateBouquet(bouquet, id), HttpStatus.OK);
    }

    // delete bouquet REST API
    // http://localhost:8085/api/bouquets/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBouquet(@PathVariable("id") long id){
        bouquetService.deleteBouquet(id);
        return new ResponseEntity<String>("Bouquet supprimé avec succès.", HttpStatus.OK);
    }

}
