package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "TYPE")
public class Type implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Type() {
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
	private String symbol;

	/**
	 * Récupération de la variable défini dans Pokemon.java; 1 à n type peut être
	 * attribué à 0 ou n Pokémon;
	 */
	@ManyToMany(mappedBy = "typesPokemon")
	private List<Pokemon> pokemons = new ArrayList<>();

	/**
	 * Récupération de la variable définie dans Attak.java; 0 à n type peut être
	 * défini pour 0 à n attaque;
	 */
	@ManyToMany(mappedBy = "typesAttak")
	private List<Attak> attaks = new ArrayList<>();

	/**
	 * Récupération de la variable typesResistence définie dans Resistence.java; 0 à
	 * n type peut être défini pour 0 à n resistence;
	 */
	@ManyToMany(mappedBy = "typesResistence")
	private List<Resistence> resistences = new ArrayList<>();

	/**
	 * Récupération de la variable typesWeakness définie dans Weakness.java; 0 à n
	 * type peut être défini pour 0 à n weakness;
	 */
	@ManyToMany(mappedBy = "typesWeakness")
	private List<Weakness> weaknesses = new ArrayList<>();

	public Type(Integer id, String name, String symbol, List<Pokemon> pokemons, List<Attak> attaks,
			List<Resistence> resistences, List<Weakness> weaknesses) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.pokemons = pokemons;
		this.attaks = attaks;
		this.resistences = resistences;
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

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public List<Attak> getAttaks() {
		return this.attaks;
	}

	public void setAttaks(List<Attak> attaks) {
		this.attaks = attaks;
	}

	public List<Resistence> getResistences() {
		return this.resistences;
	}

	public void setResistences(List<Resistence> resistences) {
		this.resistences = resistences;
	}

	public List<Weakness> getWeaknesses() {
		return this.weaknesses;
	}

	public void setWeaknesses(List<Weakness> weaknesses) {
		this.weaknesses = weaknesses;
	}

}