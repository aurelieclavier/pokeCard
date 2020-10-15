package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
@Entity
@Table(name = "CARD")
public class Card implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Card() {
	}

	/**
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	private String name;

	@Column(name = "NATIONAL_POKEDEX_NUMBER")
	private Integer nationalPokedexNumber;

	private String image;

	private Integer hp;

	private String description;

	@Column(name = "CARD_NUMBER")
	private Integer cardNumber;

	private String illustrator;

	/**
	 * Recuperation de la variable cards défini dans Account.java pour mapper les
	 * deux tables;
	 */
	@ManyToMany(mappedBy = "cards")
	@JsonIgnore
	private List<Account> accounts = new ArrayList<>();

	/**
	 * Création de la table de jointure CARD_has_POKEMON;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_POKEMON")
	private List<Pokemon> pokemons;

	/**
	 * Création de la table CARD_has_ATTACK; Une carte peut avoir de 0 à n attaque;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_ATTACK")
	private List<Attack> attacks;

	/**
	 * Jointure de la table Rarity; 1 carte ne peut avoir que 1 rarity;
	 */
	@ManyToOne
	private Rarity rarity;

	/**
	 * Jointure de la table CardType; 1 carte ne peut avoir que 1 type;
	 */
	@ManyToOne
	private CardType cardType;

	/**
	 *
	 */
	@ManyToOne
	private CardSubtype cardSubtype;

	/**
	 * Jointure de la table Set; 1 carte ne peut être présente que dans 1 set;
	 */
	@ManyToOne
	private CardSet cardSet;

	/**
	 * Jointure de la table Retreat; 1 carte ne peut recevoir que 1 retraite;
	 */
	@ManyToOne
	private Retreat retreat;

	/**
	 * Création de la table de jointure CARD_has_RESISTANCE; 1 résistance peut être
	 * attribuée à plusieurs cartes;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_RESISTANCE")
	@JsonIgnore
	private List<Resistance> resistances;

	/**
	 * Création de la table de jointure CARD_has_WEAKNESS; 1 résistance peut être
	 * attribuée à plusieurs cartes;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_WEAKNESS")
	@JsonIgnore
	private List<Weakness> weaknesses;

	public Card(Integer id, String code, String name, Integer nationalPokedexNumber, String image, Integer hp,
			String description, Integer cardNumber, String illustrator, List<Account> accounts, List<Pokemon> pokemons,
			List<Attack> attacks, Rarity rarity, CardType cardType, CardSubtype cardSubtype, CardSet cardSet,
			Retreat retreat, List<Resistance> resistances, List<Weakness> weaknesses) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.nationalPokedexNumber = nationalPokedexNumber;
		this.image = image;
		this.hp = hp;
		this.description = description;
		this.cardNumber = cardNumber;
		this.illustrator = illustrator;
		this.accounts = accounts;
		this.pokemons = pokemons;
		this.attacks = attacks;
		this.rarity = rarity;
		this.cardType = cardType;
		this.cardSubtype = cardSubtype;
		this.cardSet = cardSet;
		this.retreat = retreat;
		this.resistances = resistances;
		this.weaknesses = weaknesses;
	}

	public Card(String code, String name, Integer nationalPokedexNumber, String image, Integer hp, Integer cardNumber,
			String illustrator, Rarity rarity, CardType cardType, CardSubtype cardSubtype, CardSet cardSet,
			Retreat retreat) {
		this.code = code;
		this.name = name;
		this.nationalPokedexNumber = nationalPokedexNumber;
		this.image = image;
		this.hp = hp;
		this.cardNumber = cardNumber;
		this.illustrator = illustrator;
		this.rarity = rarity;
		this.cardType = cardType;
		this.cardSubtype = cardSubtype;
		this.cardSet = cardSet;
		this.retreat = retreat;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNationalPokedexNumber() {
		return this.nationalPokedexNumber;
	}

	public void setNationalPokedexNumber(Integer nationalPokedexNumber) {
		this.nationalPokedexNumber = nationalPokedexNumber;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getHp() {
		return this.hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIllustrator() {
		return this.illustrator;
	}

	public void setIllustrator(String illustrator) {
		this.illustrator = illustrator;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public List<Attack> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
	}

	public Rarity getRarity() {
		return this.rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public CardType getCardType() {
		return this.cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public CardSubtype getCardSubtype() {
		return this.cardSubtype;
	}

	public void setCardSubtype(CardSubtype cardSubtype) {
		this.cardSubtype = cardSubtype;
	}

	public CardSet getCardSet() {
		return this.cardSet;
	}

	public void setCardSet(CardSet cardSet) {
		this.cardSet = cardSet;
	}

	public Retreat getRetreat() {
		return this.retreat;
	}

	public void setRetreat(Retreat retreat) {
		this.retreat = retreat;
	}

	public List<Resistance> getResistances() {
		return this.resistances;
	}

	public void setResistances(List<Resistance> resistances) {
		this.resistances = resistances;
	}

	public List<Weakness> getWeaknesses() {
		return this.weaknesses;
	}

	public void setWeaknesses(List<Weakness> weaknesses) {
		this.weaknesses = weaknesses;
	}

}