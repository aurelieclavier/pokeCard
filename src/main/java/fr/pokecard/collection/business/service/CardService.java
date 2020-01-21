package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Card;
import fr.pokecard.collection.business.entity.CardSet;
import fr.pokecard.collection.business.entity.CardSubtype;
import fr.pokecard.collection.business.entity.CardType;
import fr.pokecard.collection.business.entity.Rarity;
import fr.pokecard.collection.business.entity.Retreat;
import fr.pokecard.collection.persistence.CardRepository;
import fr.pokecard.collection.persistence.CardSetRepository;
import fr.pokecard.collection.persistence.CardSubtypeRepository;
import fr.pokecard.collection.persistence.CardTypeRepository;
import fr.pokecard.collection.persistence.RarityRepository;
import fr.pokecard.collection.persistence.RetreatRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardSetRepository cardSetRepository;

	@Autowired
	private RetreatRepository retreatRepository;

	@Autowired
	private RarityRepository rarityRepository;

	@Autowired
	private CardTypeRepository cardTypeRepository;

	@Autowired
	private CardSubtypeRepository cardSubtypeRepository;

	public List<Card> getAll() {
		return this.cardRepository.findAll();
	}

	public Card getOneById(Integer id) {
		return this.cardRepository.findOneById(id);
	}

	public void saveData(String code, String setId, String name, Integer nationalPokedexNumber, String image,
			Integer hp, Integer cardNumber, String illustrator, String rarity, String cardType, String cardSubtype,
			String cardSet, Integer retreat) {
		Card card = this.cardRepository.findOneByName(name);

		Rarity rarityLabel = this.rarityRepository.findOneByLabel(rarity);
		CardType cardTypeName = this.cardTypeRepository.findOneByName(cardType);
		CardSubtype cardSubtypeName = this.cardSubtypeRepository.findOneByName(cardSubtype);
		CardSet cardSetName = this.cardSetRepository.findOneByNameAndCode(cardSet, setId);
		Retreat retreatValue = this.retreatRepository.findOneByValue(retreat);

		if (card == null && rarityLabel != null && cardTypeName != null && cardSetName != null
				&& retreatValue != null) {
			Card newCard = new Card(code, name, nationalPokedexNumber, image, hp, cardNumber, illustrator, rarityLabel,
					cardTypeName, cardSubtypeName, cardSetName, retreatValue);
			this.cardRepository.save(newCard);
		}
	}
}
