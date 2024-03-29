package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Evolution;

/**
 *
 */
@Repository
public interface EvolutionRepository extends JpaRepository<Evolution, Integer> {

}