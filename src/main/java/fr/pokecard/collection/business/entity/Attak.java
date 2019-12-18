package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "ATTAK")
public class Attak implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Attak() {
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
	private String description;

	/**
	 *
	 */
	private String damage;

	/**
	 * Récupération de la variable défini dans Pokemon.java; 1 à n attaque peut être
	 * attribué à 0 ou n Pokémon;
	 */
	@ManyToMany(mappedBy = "attaks")
	private List<Pokemon> pokemons = new ArrayList<>();

	/**
	 * Création de la table ATTAK_has_TYPE; Une attaque peut avoir de 0 à n type;
	 */
	@ManyToMany
	@JoinTable(name = "ATTAK_has_TYPE")
	private List<Type> typesAttak;

	public Attak(Integer id, String name, String description, String damage, List<Type> types, List<Pokemon> pokemons) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.typesAttak = types;
		this.pokemons = pokemons;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDamage() {
		return this.damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public List<Type> getTypes() {
		return this.typesAttak;
	}

	public void setTypes(List<Type> types) {
		this.typesAttak = types;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

}