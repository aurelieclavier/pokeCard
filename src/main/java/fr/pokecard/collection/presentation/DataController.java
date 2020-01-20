package fr.pokecard.collection.presentation;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.pokecard.collection.business.service.AttakService;
import fr.pokecard.collection.business.service.CardSerieService;
import fr.pokecard.collection.business.service.CardService;
import fr.pokecard.collection.business.service.CardSetService;
import fr.pokecard.collection.business.service.CardSubtypeService;
import fr.pokecard.collection.business.service.CardTypeService;
import fr.pokecard.collection.business.service.RarityService;
import fr.pokecard.collection.business.service.TypeService;

@RestController
public class DataController {

	@Autowired
	private TypeService typeService;

	@Autowired
	private CardService cardService;

	@Autowired
	private RarityService rarityService;

	@Autowired
	private CardSetService cardSetService;

	@Autowired
	private CardSerieService cardSerieService;

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private CardSubtypeService cardSubtypeService;

	@Autowired
	private AttakService attakService;

	/**
	 * Default constructor
	 */
	public DataController() {
	}

	/*
	 * OK !!!
	 */
	@GetMapping("data/serie")
	public void getDataSerie() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_SERIE = "https://api.pokemontcg.io/v1/sets";

		try {
			JsonNode rootsets = mapper.readTree(new URL(JSON_POKEMON_API_SERIE));
			JsonNode setNode = rootsets.path("sets");
			if (setNode.isArray()) {
				for (JsonNode set : setNode) {
					String serie = set.findPath("series").asText();
					this.cardSerieService.saveData(serie);
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération des series");
		}
	}

	/*
	 * OK !!!
	 */
	@GetMapping("/data/set")
	public void getDataSet() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_SET = "https://api.pokemontcg.io/v1/sets";

		try {
			JsonNode rootsets = mapper.readTree(new URL(JSON_POKEMON_API_SET));
			JsonNode setNode = rootsets.path("sets");
			if (setNode.isArray()) {
				for (JsonNode set : setNode) {
					String code = set.findPath("code").asText();
					String ptcgoCode = set.findPath("ptcgoCode").asText();
					String name = set.findPath("name").asText();
					Integer totalCards = set.findPath("totalCards").asInt();
					String symbol = set.findPath("symbolUrl").asText();
					String logo = set.findPath("logoUrl").asText();
					String serie = set.findPath("series").asText();
					String releaseDate = set.findPath("releaseDate").asText();
					// Define a format for date object
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					// convert String to LocalDateTime
					LocalDate localDate = LocalDate.parse(releaseDate, formatter);

					this.cardSetService.saveData(name, totalCards, localDate, symbol, logo, code, ptcgoCode, serie);

				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération des sets");
			System.out.println(e);
		}

	}

	/*
	 * OK !!!
	 */
	@GetMapping("/data/type")
	public void getDataType() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_TYPES = "https://api.pokemontcg.io/v1/types";

		try {
			JsonNode rootTypes = mapper.readTree(new URL(JSON_POKEMON_API_TYPES));
			JsonNode typeNode = rootTypes.path("types");

			for (JsonNode type : typeNode) {
				this.typeService.saveData(type.toString().substring(1, type.toString().length() - 1));
			}

		} catch (Exception e) {
			System.out.println("Erreur de récupération des types");
		}
	}

	/*
	 * OK !!!
	 */
	@GetMapping("/data/supertype")
	public void getDataSuperType() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_SUPERTYPES = "https://api.pokemontcg.io/v1/supertypes";

		try {
			JsonNode rootSuperTypes = mapper.readTree(new URL(JSON_POKEMON_API_SUPERTYPES));
			JsonNode superTypeNode = rootSuperTypes.path("supertypes");

			for (JsonNode superType : superTypeNode) {
				this.cardTypeService.saveData(superType.toString().substring(1, superType.toString().length() - 1));
			}

		} catch (Exception e) {
			System.out.println("Erreur de récupération des supers types");
		}
	}

	/*
	 * OK !!!
	 */
	@GetMapping("/data/subtype")
	public void getDataSubType() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_SUBTYPES = "https://api.pokemontcg.io/v1/subtypes";

		try {
			JsonNode rootSubTypes = mapper.readTree(new URL(JSON_POKEMON_API_SUBTYPES));
			JsonNode subTypeNode = rootSubTypes.path("subtypes");

			for (JsonNode subType : subTypeNode) {
				this.cardSubtypeService.saveData(subType.toString().substring(1, subType.toString().length() - 1));
			}

		} catch (Exception e) {
			System.out.println("Erreur de récupération des sous types");
		}
	}

	/*
	 * OK !!!
	 */
	@GetMapping("/data/rarity")
	public void getDataRarity() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards";
		try {
			JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
			JsonNode cardNode = rootCards.path("cards");
			if (cardNode.isArray()) {
				for (JsonNode card : cardNode) {
					String rarity = card.findPath("rarity").asText();
					this.rarityService.saveData(rarity);
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération des cartes");
		}
	}

	@GetMapping("data/attack")
	public void getDataAttack() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards";

		try {
			JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
			JsonNode cardNode = rootCards.path("cards");

			if (cardNode.isArray()) {
				for (JsonNode card : cardNode) {
					JsonNode attack = card.path("attacks");

					if (attack.isArray()) {
						System.out.println("ATTACKS IS AN ARRAY !");
						String attackName = attack.findPath("name").asText();
						String attackDescription = attack.findPath("text").asText();
						String attackDamage = attack.findPath("damage").asText();
						this.attakService.saveData(attackName, attackDescription, attackDamage);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@GetMapping("/data/card")
	public static void getDataCard() {

		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards";

		try {
			JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
			JsonNode cardNode = rootCards.path("cards");

//			System.out.println("card : " + cardNode);

			if (cardNode.isArray()) {
				System.out.println("Is this node an Array? " + cardNode.isArray());

				for (JsonNode card : cardNode) {
					String name = card.path("name").asText();
					Integer pokedexNumber = card.path("nationalPokedexNumber").asInt();
					String image = card.path("imageUrlHiRes").asText();
					String evolution = card.path("evolvesFrom").asText();
					String hp = card.path("hp").asText();
					String number = card.path("number").asText();
					String artist = card.path("artist").asText();
					String rarity = card.findPath("rarity").asText();
					String serie = card.findPath("series").asText();
					String set = card.findPath("set").asText();
					String setCode = card.findPath("setCode").asText();

					System.out.println(card.toString().substring(1, card.toString().length() - 1) + "\n" + "\n");

//					System.out.println(
//							"*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
//					System.out.println("name : " + name);
//					System.out.println("pokedex number : " + pokedexNumber);
//					System.out.println("image : " + image);
//					System.out.println("evolution : " + evolution);
//					System.out.println("hp : " + hp);
//					System.out.println("number : " + number);
//					System.out.println("artist : " + artist);
//					System.out.println("rarity : " + rarity);
//					System.out.println("serie : " + serie);
//					System.out.println("set : " + set);
//					System.out.println("set code : " + setCode);
//
//					System.out.println(
//							"*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération des cartes");
		}

	}
}
