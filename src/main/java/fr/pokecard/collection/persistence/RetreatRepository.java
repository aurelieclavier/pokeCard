package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Retreat;

/**
 *
 */
@Repository
public interface RetreatRepository extends JpaRepository<Retreat, Integer> {
	Retreat findOneByValue(final Integer value);
}