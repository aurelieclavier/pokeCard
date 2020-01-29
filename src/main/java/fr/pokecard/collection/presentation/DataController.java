package fr.pokecard.collection.presentation;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.pokecard.collection.business.service.AttakService;
import fr.pokecard.collection.business.service.CardSerieService;
import fr.pokecard.collection.business.service.CardService;
import fr.pokecard.collection.business.service.CardSetService;
import fr.pokecard.collection.business.service.CardSubtypeService;
import fr.pokecard.collection.business.service.CardTypeService;
import fr.pokecard.collection.business.service.PokemonService;
import fr.pokecard.collection.business.service.RarityService;
import fr.pokecard.collection.business.service.ResistanceService;
import fr.pokecard.collection.business.service.RetreatService;
import fr.pokecard.collection.business.service.TypeService;
import fr.pokecard.collection.business.service.WeaknessService;

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

	@Autowired
	private RetreatService retreatService;

	@Autowired
	private PokemonService pokemonService;

	@Autowired
	private ResistanceService resistanceService;

	@Autowired
	private WeaknessService weaknessService;

	/**
	 * Default constructor
	 */
	public DataController() {
	}

	/*
	 * OK !!!
	 */
	@GetMapping("data/serie")
	public void getDataSerie(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_SERIE = "https://api.pokemontcg.io/v1/sets?page=" + i + "&pageSize="
					+ pageSize;
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
	}

	/*
	 * OK !!!
	 */
	@GetMapping("data/set")
	public void getDataSet(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_SET = "https://api.pokemontcg.io/v1/sets?page=" + i + "&pageSize=" + pageSize;
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
				System.out.println("Erreur de récupération des sets " + e);
			}
		}
	}

	/*
	 *
	 */
	@GetMapping("/data/retreat")
	public void getDataRetreat() {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_TYPES = "https://api.pokemontcg.io/v1/cards";
		try {
			JsonNode rootRetreats = mapper.readTree(new URL(JSON_POKEMON_API_TYPES));
			JsonNode retreatNode = rootRetreats.path("cards");

			for (JsonNode retreat : retreatNode) {
				Integer value = retreat.findPath("convertedRetreatCost").asInt();
				this.retreatService.saveData(value);
			}
		} catch (Exception e) {
			System.out.println(e + "Erreur de récupération des retraites");
		}
	}

	/*
	 * OK !!!
	 */
	@GetMapping("data/type")
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
			System.out.println(e + "Erreur de récupération des types");
		}
	}

	/*
	 * OK !!!
	 */
	@GetMapping("data/supertype")
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
	@GetMapping("data/subtype")
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
	@GetMapping("data/rarity")
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

	/*
	 * OK !!!
	 */
	@GetMapping("data/attack")
	public void getDataAttack(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + i + "&pageSize="
					+ pageSize;
			try {
				JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
				JsonNode cardNode = rootCards.path("cards");
				if (cardNode.isArray()) {
					for (JsonNode card : cardNode) {
						JsonNode attack = card.path("attacks");
						if (attack.isArray()) {
							String attackName = attack.findPath("name").asText();
							String attackDescription = attack.findPath("text").asText();
							String attackDamage = attack.findPath("damage").asText();
							this.attakService.saveData(attackName, attackDescription, attackDamage);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Erreur de récupération des attaques : " + e);
			}
		}

	}

	@GetMapping("data/resistance")
	public void getDataResistance(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + i + "&pageSize="
					+ pageSize;

			try {
				JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
				JsonNode cardNode = rootCards.path("cards");
				if (cardNode.isArray()) {
					for (JsonNode card : cardNode) {
						JsonNode resistance = card.path("resistances");
						if (resistance.isArray()) {
							String rate = resistance.findPath("value").asText();
							this.resistanceService.saveData(rate);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Erreur de récupération des résistances. " + e);
			}
		}
	}

	@GetMapping("data/resistanceHasType")
	public void getDataResistanceHasType(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + i + "&pageSize="
					+ pageSize;

			try {
				JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
				JsonNode cardNode = rootCards.path("cards");
				if (cardNode.isArray()) {
					for (JsonNode card : cardNode) {
						JsonNode resistance = card.path("resistances");
						if (resistance.isArray()) {
							String rate = resistance.findPath("value").asText();
							String type = resistance.findPath("type").asText();

							this.resistanceService.saveResistanceHasType(rate, type);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Erreur de récupération des résistances. " + e);
			}
		}
	}

	@GetMapping("data/weakness")
	public void getDataWeakness(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + i + "&pageSize="
					+ pageSize;

			try {
				JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
				JsonNode cardNode = rootCards.path("cards");
				if (cardNode.isArray()) {
					for (JsonNode card : cardNode) {
						JsonNode weakness = card.path("weaknesses");
						if (weakness.isArray()) {
							String weaknesses = weakness.findPath("value").asText();
							this.weaknessService.saveData(weaknesses);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Erreur de récupération des faiblesses. " + e);
			}
		}
	}

	@GetMapping("data/weaknessHasType")
	public void getDataWeaknessHasType(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {
		int max = 12;
		for (int i = 1; i <= max; i++) {
			final ObjectMapper mapper = new ObjectMapper();
			final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + i + "&pageSize="
					+ pageSize;

			try {
				JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
				JsonNode cardNode = rootCards.path("cards");
				if (cardNode.isArray()) {
					for (JsonNode card : cardNode) {
						JsonNode weakness = card.path("weaknesses");
						if (weakness.isArray()) {
							String rate = weakness.findPath("value").asText();
							String type = weakness.findPath("type").asText();
							this.weaknessService.saveWeaknessHasType(rate, type);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Erreur de récupération des faiblesses. " + e);
			}
		}
	}

	@GetMapping("data/card")
	public void getDataCard(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {

		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + page + "&pageSize="
				+ pageSize;

		try {
			JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
			JsonNode cardNode = rootCards.path("cards");
			if (cardNode.isArray()) {
				for (JsonNode card : cardNode) {
					String code = card.path("id").asText();
					String name = card.path("name").asText();
					Integer nationalPokedexNumber = card.path("nationalPokedexNumber").asInt();
					String image = card.path("imageUrlHiRes").asText();
					Integer hp = card.path("hp").asInt();
					Integer cardNumber = card.path("number").asInt();
					String illustrator = card.path("artist").asText();
					String rarity = card.path("rarity").asText();
					String cardType = card.path("supertype").asText();
					String cardSubtype = card.path("subtype").asText();
					String cardSet = card.path("set").asText();
					Integer retreat = card.path("convertedRetreatCost").asInt();

					int tiretPosition = code.indexOf("-");
					String setId;
					if (tiretPosition != -1) {
						setId = code.substring(0, tiretPosition);
					} else {
						setId = code;
					}

					this.cardService.saveData(code, setId, name, nationalPokedexNumber, image, hp, cardNumber,
							illustrator, rarity, cardType, cardSubtype, cardSet, retreat);
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération des cartes : " + e);
		}
	}

	@GetMapping("data/cardhaspokemon")
	public void getDataCardHasPokemon(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {

		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + page + "&pageSize="
				+ pageSize;

//		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards/dp6-90";
		System.out.println(JSON_POKEMON_API_CARDS + " API");
		try {
			JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
			JsonNode cardNode = rootCards.path("cards");
			if (cardNode.isArray()) {
				for (JsonNode card : cardNode) {

					String cardType = card.path("supertype").asText();
					String code = card.path("id").asText();
					String name = card.path("name").asText();
					Integer numberPokemon = card.path("nationalPokedexNumber").asInt();

					if (cardType.equals("Pokémon")) {
						this.cardService.cardHasPokemon(code, numberPokemon, name);
					}

				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération id pokemon et id cartes " + e);
		}
	}

	@GetMapping("data/attackhastype")
	public void getDataAttackHasType(@RequestParam(defaultValue = "page") String page,
			@RequestParam(defaultValue = "pageSize") String pageSize) {

//		int max = 12;
//		for (int i = 1; i <= max; i++) {
		final ObjectMapper mapper = new ObjectMapper();
		final String JSON_POKEMON_API_CARDS = "https://api.pokemontcg.io/v1/cards?page=" + page + "&pageSize="
				+ pageSize;
//		final String JSON_POKEMON_API_TYPES = "https://api.pokemontcg.io/v1/types";

		try {
			JsonNode rootCards = mapper.readTree(new URL(JSON_POKEMON_API_CARDS));
//			JsonNode rootTypes = mapper.readTree(new URL(JSON_POKEMON_API_TYPES));
			JsonNode cardNode = rootCards.path("cards");
//			JsonNode typeNode = rootTypes.path("types");

			if (cardNode.isArray()) {
				for (JsonNode card : cardNode) {

					JsonNode attack = card.path("attacks");

//					System.out.println("COST : " + cost);
					System.out.println("ATTACK : " + attack);

					if (attack.isArray()) {

						System.out.println("ATTACK IS ARRAY");

						JsonNode cost = attack.path("cost");
						System.out.println("COST : " + cost.toString());

						if (cost.isArray()) {

							System.out.println("COST IS ARRAY");

							for (JsonNode type : cost) {

								System.out.println(type.toString());
								String name = attack.findPath("name").asText();
								String damage = attack.findPath("damage").asText();
								System.out.println("NAME " + name);
								System.out.println("DAMAGE " + damage);
								System.out.println("COST : " + type);
//								this.attakService.attackHasType(cost, name, damage);

							}

						}

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur de récupération des attaques : " + e);
		}
	}

}
//}
