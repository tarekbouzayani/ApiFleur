package com.fleur.repository;

import com.fleur.model.Bouquet;
import com.fleur.model.Fleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouquetRepository extends JpaRepository<Bouquet, Long> {
}
