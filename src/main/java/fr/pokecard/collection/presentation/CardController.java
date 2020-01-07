package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.CardSerie;
import fr.pokecard.collection.business.entity.CardSet;
import fr.pokecard.collection.business.entity.CardType;
import fr.pokecard.collection.business.entity.Rarity;
import fr.pokecard.collection.business.service.CardSerieService;
import fr.pokecard.collection.business.service.CardSetService;
import fr.pokecard.collection.business.service.CardTypeService;
import fr.pokecard.collection.business.service.RarityService;

/**
 *
 */
@RestController
public class CardController {

	/**
	 * Default constructor
	 */
	public CardController() {
	}

	@Autowired
	private RarityService rarityService;

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private CardSerieService cardSerieService;

	@Autowired
	private CardSetService cardSetService;

	@GetMapping("cards/rarity")
	List<Rarity> getAllRarity() {
		return this.rarityService.getAll();
	}

	@GetMapping("cards/type")
	List<CardType> getAllType() {
		return this.cardTypeService.getAll();
	}

	@GetMapping("cards/serie")
	List<CardSerie> getAllSerie() {
		return this.cardSerieService.getAll();
	}

	@GetMapping("cards/set")
	List<CardSet> getAllSet() {
		return this.cardSetService.getAll();
	}

}