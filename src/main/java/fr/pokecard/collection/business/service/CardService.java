package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Card;
import fr.pokecard.collection.persistence.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	public List<Card> getAll() {
		return this.cardRepository.findAll();
	}

	public Card getOneById(Integer id) {
		return this.cardRepository.findOneById(id);
	}

	public void saveData(String code, String name, Integer nationalPokedexNumber, String image, Integer hp,
			Integer cardNumber, String illustrator) {
		Card card = this.cardRepository.findOneByName(name);
		if (card == null) {
			Card newCard = new Card(code, name, nationalPokedexNumber, image, hp, cardNumber, illustrator);
			this.cardRepository.save(newCard);
		}
	}
}
