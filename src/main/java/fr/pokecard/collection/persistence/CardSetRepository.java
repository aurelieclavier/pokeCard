package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.CardSet;

/**
 *
 */
@Repository
public interface CardSetRepository extends JpaRepository<CardSet, Integer> {
	CardSet findOneByName(final String nameSet);

	CardSet findOneByNameAndCode(final String nameSet, final String code);
}