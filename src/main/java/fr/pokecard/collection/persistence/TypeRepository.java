package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Type;

/**
 *
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
	Type findOneByName(final String name);
}