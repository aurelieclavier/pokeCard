package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Rarity;

@Repository
public interface RarityRepository extends JpaRepository<Rarity, Integer> {
	Rarity findOneByLabel(final String label);
}
