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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
@Entity
@Table(name = "POKEMON")
public class Pokemon implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Pokemon() {
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
	@Column(name = "NAME_FR")
	private String nameFr;

	/**
	 *
	 */
	@Column(name = "NAME_EN")
	private String nameEn;

	/**
	 *
	 */
	@Column(name = "NAME_JP")
	private String nameJp;

	/**
	 *
	 */
	private Integer level;

	/**
	 *
	 */
	private Float weight;

	/**
	 *
	 */
	private Float height;

	/**
	 *
	 */
	private Integer number;

	/**
	 *
	 */
	private String generation;

	/**
	 *
	 */
	@ManyToMany(mappedBy = "pokemons")
	@JsonIgnore
	private List<Card> cards = new ArrayList<>();

	/**
	 * Création de la table POKEMON_has_POWER; Un pokémon peut avoir 0 à n power;
	 */
	@ManyToMany
	@JoinTable(name = "POKEMON_has_POWER")
	private List<Power> powers;

	/**
	 * Création de la table POKEMON_has_TYPE; Un pokémon peut avoir de 0 à n type;
	 */
	@ManyToMany
	@JoinTable(name = "POKEMON_has_TYPE")
	private List<Type> typesPokemon;

	@OneToMany(mappedBy = "pokemonLowLevel")
	private List<Evolution> evolution = new ArrayList<>();

	public Pokemon(Integer id, String nameFr, String nameEn, String nameJp, Integer level, Float weight, Float height,
			Integer number, String generation, List<Card> cards, List<Power> powers, List<Type> typesPokemon,
			List<Evolution> evolution) {
		super();
		this.id = id;
		this.nameFr = nameFr;
		this.nameEn = nameEn;
		this.nameJp = nameJp;
		this.level = level;
		this.weight = weight;
		this.height = height;
		this.number = number;
		this.generation = generation;
		this.cards = cards;
		this.powers = powers;
		this.typesPokemon = typesPokemon;
		this.evolution = evolution;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameFr() {
		return this.nameFr;
	}

	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameJp() {
		return this.nameJp;
	}

	public void setNameJp(String nameJp) {
		this.nameJp = nameJp;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return this.height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getGeneration() {
		return this.generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public List<Power> getPowers() {
		return this.powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	public List<Type> getTypesPokemon() {
		return this.typesPokemon;
	}

	public void setTypesPokemon(List<Type> typesPokemon) {
		this.typesPokemon = typesPokemon;
	}

	public List<Evolution> getEvolution() {
		return this.evolution;
	}

	public void setEvolution(List<Evolution> evolution) {
		this.evolution = evolution;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}