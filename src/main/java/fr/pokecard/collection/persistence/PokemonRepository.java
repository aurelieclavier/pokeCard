package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Pokemon;

/**
 *
 */
@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

	Pokemon findOneById(final Integer id);

}