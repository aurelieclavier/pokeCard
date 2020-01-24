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

	@Autowired
	private RarityService rarityService;

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private CardSubtypeService cardSubtypeService;

	@Autowired
	private CardSetService cardSetService;

	@Autowired
	private RetreatService retreatService;

	public List<Card> getAll() {
		return this.cardRepository.findAll();
	}

	public Card getOneById(Integer id) {
		return this.cardRepository.findOneById(id);
	}

	public void saveData(String code, String setId, String name, Integer nationalPokedexNumber, String image,
			Integer hp, Integer cardNumber, String illustrator, String rarity, String cardType, String cardSubtype,
			String cardSet, Integer retreat) {

		int j = 0;
		Card card = this.cardRepository.findOneByNameAndCode(name, code);

		/*
		 * Get data if element exist If element not exist insert in BDD
		 */
		// Start
		Rarity rarityLabel = this.rarityRepository.findOneByLabel(rarity);
		if (rarityLabel == null) {
			this.rarityService.saveData(rarity);
			rarityLabel = this.rarityRepository.findOneByLabel(rarity);
		}

		CardType cardTypeName = this.cardTypeRepository.findOneByName(cardType);
		if (cardTypeName == null) {
			this.cardTypeService.saveData(cardType);
			cardTypeName = this.cardTypeRepository.findOneByName(cardType);
		}

		CardSubtype cardSubtypeName = this.cardSubtypeRepository.findOneByName(cardSubtype);
		if (cardSubtypeName == null) {
			this.cardSubtypeService.saveData(cardSubtype);
			cardSubtypeName = this.cardSubtypeRepository.findOneByName(cardSubtype);
		}

		Retreat retreatValue = this.retreatRepository.findOneByValue(retreat);
		if (retreatValue == null) {
			this.retreatService.saveData(retreat);
			retreatValue = this.retreatRepository.findOneByValue(retreat);
		}
		// End

		CardSet cardSetName = this.cardSetRepository.findOneByNameAndCode(cardSet, setId);

		if (card == null) {
			Card newCard = new Card(code, name, nationalPokedexNumber, image, hp, cardNumber, illustrator, rarityLabel,
					cardTypeName, cardSubtypeName, cardSetName, retreatValue);
			this.cardRepository.save(newCard);
		} else {
			System.out.println("----------------------------------------------------");
			System.out.println(code + " code");
			System.out.println(name + " name");
			System.out.println(setId + " setId");
			System.out.println(nationalPokedexNumber + "nationalPokedexNumber");
			System.out.println(image + " image");
			System.out.println(hp + " hp");
			System.out.println(cardNumber + " cardNumber");
			System.out.println(illustrator + " illustrator");
			System.out.println(rarity + " rarity");
			System.out.println(cardType + " cardType");
			System.out.println(cardSubtype + " cardSubtype");
			System.out.println(cardSet + " cardSet");
			System.out.println(retreat + " retreat");
			System.out.println("----------------------------------------------------");
		}
	}
}
