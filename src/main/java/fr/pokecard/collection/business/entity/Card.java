package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	/**
	 *
	 */
	private String name;

	/**
	 *
	 */
	private Integer pv;

	/**
	 *
	 */
	private String description;

	/**
	 *
	 */
	private String image;

	/**
	 *
	 */
	@Column(name = "CARD_NUMBER")
	private Integer cardNumber;

	/**
	 *
	 */
	private String illustrator;

	/**
	 * Recuperation de la variable cards défini dans Account.java pour mapper les
	 * deux tables;
	 */
	@ManyToMany(mappedBy = "cards")
	private List<Account> accounts = new ArrayList<>();

	/**
	 * Création de la table de jointure CARD_has_POKEMON;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_POKEMON")
	private List<Pokemon> pokemons;

	/**
	 * Jointure de la table Rarity; 1 carte ne peut avoir que 1 rarity;
	 */
	@OneToOne
	@JoinColumn(name = "ID_RARITY")
	private Rarity ratity;

	/**
	 * Jointure de la table CardType; 1 carte ne peut avoir que 1 type;
	 */
	@OneToOne
	@JoinColumn(name = "ID_CARD_TYPE")
	private CardType cardType;

	/**
	 * Jointure de la table Set; 1 carte ne peut être présente que dans 1 set;
	 */
	@OneToOne
	@JoinColumn(name = "ID_CARD_SET")
	private CardSet cardSet;

	/**
	 * Jointure de la table Retreat; 1 carte ne peut recevoir que 1 retraite;
	 */
	@OneToOne
	@JoinColumn(name = "ID_RETREAT")
	private Retreat retreat;

	/**
	 * Création de la table de jointure CARD_has_RESISTANCE; 1 résistance peut être
	 * attribuée à plusieurs cartes;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_RESISTANCE")
	private List<Resistance> resistances;

	/**
	 * Création de la table de jointure CARD_has_RESISTANCE; 1 résistance peut être
	 * attribuée à plusieurs cartes;
	 */
	@ManyToMany
	@JoinTable(name = "CARD_has_WEAKNESS")
	private List<Weakness> weaknesses;

	public Card(Integer id, String name, Integer pv, String description, String image, Integer cardNumber,
			String illustrator, List<Account> accounts, List<Pokemon> pokemons, Rarity ratity, CardType cardType,
			CardSet cardSet, Retreat retreat, List<Resistance> resistances, List<Weakness> weaknesses) {
		super();
		this.id = id;
		this.name = name;
		this.pv = pv;
		this.description = description;
		this.image = image;
		this.cardNumber = cardNumber;
		this.illustrator = illustrator;
		this.accounts = accounts;
		this.pokemons = pokemons;
		this.ratity = ratity;
		this.cardType = cardType;
		this.cardSet = cardSet;
		this.retreat = retreat;
		this.resistances = resistances;
		this.weaknesses = weaknesses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPv() {
		return this.pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Rarity getRatity() {
		return this.ratity;
	}

	public void setRatity(Rarity ratity) {
		this.ratity = ratity;
	}

	public CardType getCardType() {
		return this.cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public CardSet getSet() {
		return this.cardSet;
	}

	public void setSet(CardSet cardSet) {
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