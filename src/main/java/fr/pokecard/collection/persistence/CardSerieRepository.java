package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pokecard.collection.business.entity.CardSerie;

/**
 *
 */
public interface CardSerieRepository extends JpaRepository<CardSerie, Integer> {
	CardSerie findOneByName(final String name);
}