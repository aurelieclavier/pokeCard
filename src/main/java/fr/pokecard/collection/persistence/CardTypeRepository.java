package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.CardType;

/**
 *
 */
@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Integer> {

}