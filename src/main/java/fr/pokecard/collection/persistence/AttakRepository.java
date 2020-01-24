package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Attack;

/**
 *
 */
@Repository
public interface AttakRepository extends JpaRepository<Attack, Integer> {
	Attack findOneByName(final String name);

	Attack findOneByDescription(final String description);

	Attack findOneByDamage(final String damage);

	Attack findOneByNameAndDamageAndDescription(final String name, final String damage, final String description);
}