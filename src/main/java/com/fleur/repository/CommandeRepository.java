package com.fleur.repository;

import com.fleur.model.Commande;
import com.fleur.model.Fleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
