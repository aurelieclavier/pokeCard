package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
@Entity
@Table(name = "WEAKNESS")
public class Weakness implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Weakness() {
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
	private String rate;

	/**
	 * Plusieurs carte peuvent avoir la même faiblesse;
	 */
	@ManyToMany(mappedBy = "weaknesses")
	@JsonIgnore
	private List<Card> cards;

	/**
	 * 1 faiblesse peut avoir plusieurs type;
	 */
	@ManyToMany
	@JoinTable(name = "WEAKNESS_has_TYPE")
	@JsonIgnore
	private List<Type> typesWeakness;

	public Weakness(Integer id, String rate, List<Card> cards, List<Type> typesWeakness) {
		super();
		this.id = id;
		this.rate = rate;
		this.cards = cards;
		this.typesWeakness = typesWeakness;
	}

	public Weakness(String rate) {
		this.rate = rate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRate() {
		return this.rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Type> getTypesWeakness() {
		return this.typesWeakness;
	}

	public void setTypesWeakness(List<Type> typesWeakness) {
		this.typesWeakness = typesWeakness;
	}

}