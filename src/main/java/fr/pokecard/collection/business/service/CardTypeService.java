package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.CardType;
import fr.pokecard.collection.persistence.CardTypeRepository;

@Service
public class CardTypeService {

	@Autowired
	private CardTypeRepository cardTypeRepository;

	public List<CardType> getAll() {
		return this.cardTypeRepository.findAll();
	}

	public void saveData(String name) {
		CardType type = this.cardTypeRepository.findOneByName(name);
		if (type == null) {
			CardType newType = new CardType(name);
			this.cardTypeRepository.save(newType);
		}
	}
}
