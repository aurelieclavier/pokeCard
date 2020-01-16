package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Rarity;
import fr.pokecard.collection.persistence.RarityRepository;

@Service
public class RarityService {

	@Autowired
	private RarityRepository rarityRepository;

	public List<Rarity> getAll() {
		return this.rarityRepository.findAll();
	}

	public void saveData(String label) {
		Rarity rarity = this.rarityRepository.findOneByLabel(label);
		if (rarity == null && label != null && !label.isEmpty()) {
			Rarity newRarity = new Rarity(label);
			this.rarityRepository.save(newRarity);
		}
	}
}
