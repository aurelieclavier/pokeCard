package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Card;

/**
 *
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

	Card findOneById(final Integer id);

	Card findOneByNameAndCode(final String name, final String code);

}