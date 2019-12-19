package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Attak;

/**
 *
 */
@Repository
public interface AttakRepository extends JpaRepository<Attak, Integer> {

}