package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.CardSerie;

/**
 *
 */
@Repository
public interface CardSerieRepository extends JpaRepository<CardSerie, Integer> {
	CardSerie findOneByName(final String name);
}