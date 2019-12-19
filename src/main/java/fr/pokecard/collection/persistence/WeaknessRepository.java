package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Weakness;

/**
 *
 */
@Repository
public interface WeaknessRepository extends JpaRepository<Weakness, Integer> {

}