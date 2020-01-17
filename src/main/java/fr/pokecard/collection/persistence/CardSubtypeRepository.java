package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.CardSubtype;

@Repository
public interface CardSubtypeRepository extends JpaRepository<CardSubtype, Integer> {
	CardSubtype findOneByName(final String name);
}
