package fr.pokecard.collection.business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 */
@Entity
@Table(name = "EVOLUTION")
public class Evolution implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Evolution() {
	}

	/**
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Récupération de la variable evolution définie dans Pokemon.java 1 pokémon
	 * peut avoir plusieurs evolution;
	 */
	@ManyToOne()
	@JoinColumn(name = "ID_POKEMON_EVOLUTION", referencedColumnName = "id")
	@JsonIgnoreProperties("evolution")
	private Pokemon evolutionPokemon;

	/**
	 * 1 evolution pour 1 pokémon;
	 */
	@OneToOne
	@JoinColumn(name = "ID_POKEMON", referencedColumnName = "id")
	@JsonIgnoreProperties("evolution")
	private Pokemon pokemonEvolution;

	public Evolution(Integer id, Pokemon evolutionPokemon, Pokemon pokemonEvolution) {
		super();
		this.id = id;
		this.evolutionPokemon = evolutionPokemon;
		this.pokemonEvolution = pokemonEvolution;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pokemon getEvolutionPokemon() {
		return this.evolutionPokemon;
	}

	public void setEvolutionPokemon(Pokemon evolutionPokemon) {
		this.evolutionPokemon = evolutionPokemon;
	}

	public Pokemon getPokemonEvolution() {
		return this.pokemonEvolution;
	}

	public void setPokemonEvolution(Pokemon pokemonEvolution) {
		this.pokemonEvolution = pokemonEvolution;
	}

}