package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.CardSubtype;
import fr.pokecard.collection.persistence.CardSubtypeRepository;

@Service
public class CardSubtypeService {

	@Autowired
	private CardSubtypeRepository cardSubtypeRepository;

	public List<CardSubtype> getAll() {
		return this.cardSubtypeRepository.findAll();
	}

	public void saveData(String name) {
		CardSubtype subtype = this.cardSubtypeRepository.findOneByName(name);
		if (subtype == null) {
			CardSubtype newSubtype = new CardSubtype(name);
			this.cardSubtypeRepository.save(newSubtype);
		}
	}
}
