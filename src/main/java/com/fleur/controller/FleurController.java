package com.fleur.controller;

import com.fleur.model.Fleur;
import com.fleur.service.FleurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fleurs")
public class FleurController {

    private FleurService fleurService;

    public FleurController(FleurService fleurService) {
        this.fleurService = fleurService;
    }

    // Create Fleur REST API
    @PostMapping
    public ResponseEntity<Fleur> saveFleur(@RequestBody Fleur fleur){
        return new ResponseEntity<Fleur>(fleurService.saveFleur(fleur),HttpStatus.CREATED);
    }

    // Get get all fleurs REST API
    @GetMapping
    public List<Fleur> getAllFleurs(){
        return fleurService.getAllFleurs();
    }

    // Get get fleur by id REST API
    // http://localhost:8085/api/fleurs/1
    @GetMapping("{id}")
    public ResponseEntity<Fleur> getFleurById(@PathVariable("id") long id){
        return new ResponseEntity<Fleur>(fleurService.getFleurById(id),HttpStatus.OK);
    }

    // update fleur REST API
    // http://localhost:8085/api/fleurs/1
    @PutMapping("{id}")
    public ResponseEntity<Fleur> updateFleur(@PathVariable("id") long id,@RequestBody Fleur fleur){
        return new ResponseEntity<Fleur>(fleurService.updateFleur(fleur, id), HttpStatus.OK);
    }

    // delete fleur REST API
    // http://localhost:8085/api/fleurs/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFleur(@PathVariable("id") long id){
        fleurService.deleteFleur(id);
        return new ResponseEntity<String>("Fleur supprimée avec succès.", HttpStatus.OK);
    }


}
