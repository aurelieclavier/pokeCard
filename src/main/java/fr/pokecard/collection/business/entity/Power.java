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
@Table(name = "POWER")
public class Power implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Power() {
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
	private String title;

	/**
	 *
	 */
	private String content;

	/**
	 * Récupération de la variable powers défini dans Pokemon.java; Plusieurs power
	 * pour 1 à n Pokemon;
	 */
	@ManyToMany(mappedBy = "powers")
	private List<Pokemon> pokemons = new ArrayList<>();

	public Power(Integer id, String title, String content, List<Pokemon> pokemons) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pokemons = pokemons;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

}