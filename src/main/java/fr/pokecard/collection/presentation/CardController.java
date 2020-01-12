package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.Card;
import fr.pokecard.collection.business.entity.CardSerie;
import fr.pokecard.collection.business.entity.CardSet;
import fr.pokecard.collection.business.entity.CardType;
import fr.pokecard.collection.business.entity.Rarity;
import fr.pokecard.collection.business.entity.Resistence;
import fr.pokecard.collection.business.entity.Retreat;
import fr.pokecard.collection.business.entity.Weakness;
import fr.pokecard.collection.business.service.CardSerieService;
import fr.pokecard.collection.business.service.CardService;
import fr.pokecard.collection.business.service.CardSetService;
import fr.pokecard.collection.business.service.CardTypeService;
import fr.pokecard.collection.business.service.RarityService;
import fr.pokecard.collection.business.service.ResistenceService;
import fr.pokecard.collection.business.service.RetreatService;
import fr.pokecard.collection.business.service.WeaknessService;

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

	/**
	 * Injection dependencies
	 */
	@Autowired
	private CardService cardService;

	@Autowired
	private RarityService rarityService;

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private CardSerieService cardSerieService;

	@Autowired
	private CardSetService cardSetService;

	@Autowired
	private WeaknessService weaknessService;

	@Autowired
	private ResistenceService resistenceService;

	@Autowired
	private RetreatService retreatService;

	/**
	 * Mapping
	 */
	@GetMapping("/cards")
	List<Card> getAllCards() {
		return this.cardService.getAll();
	}

	@GetMapping("/cards/{id}")
	public Card getOneById(@PathVariable Integer id) {
		return this.cardService.getOneById(id);
	}

	@GetMapping("/cards/rarity")
	List<Rarity> getAllRarity() {
		return this.rarityService.getAll();
	}

	@GetMapping("/cards/type")
	List<CardType> getAllCardsType() {
		return this.cardTypeService.getAll();
	}

	@GetMapping("/cards/serie")
	List<CardSerie> getAllSerie() {
		return this.cardSerieService.getAll();
	}

	@GetMapping("/cards/set")
	List<CardSet> getAllSet() {
		return this.cardSetService.getAll();
	}

	@GetMapping("/cards/weakness")
	List<Weakness> getAllWeakness() {
		return this.weaknessService.getALl();
	}

	@GetMapping("/cards/resistence")
	List<Resistence> getAllResistence() {
		return this.resistenceService.getAll();
	}

	@GetMapping("/cards/retreat")
	List<Retreat> getAllRetreat() {
		return this.retreatService.getAll();
	}
}