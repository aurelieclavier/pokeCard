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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	 * Récupération de la variable définie dans Attack.java; 0 à n type peut être
	 * défini pour 0 à n attaque;
	 */
	@ManyToMany(mappedBy = "typesAttack")
	@JsonIgnore
	private List<Attack> attacks = new ArrayList<>();

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

	public Type(Integer id, String name, String symbol, List<Attack> attacks, List<Resistence> resistences,
			List<Weakness> weaknesses) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
//		this.pokemons = pokemons;
		this.attacks = attacks;
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

//	public List<Pokemon> getPokemons() {
//		return this.pokemons;
//	}
//
//	public void setPokemons(List<Pokemon> pokemons) {
//		this.pokemons = pokemons;
//	}

	public List<Attack> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Attack> attacks) {
		this.attacks = attacks;
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