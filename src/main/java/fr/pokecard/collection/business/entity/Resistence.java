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
@Table(name = "RESISTENCE")
public class Resistence implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Resistence() {
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
	private Integer rate;

	/**
	 * Plusieurs carte peuvent avoir la même résistance;
	 */
	@ManyToMany(mappedBy = "resistences")
	@JsonIgnore
	private List<Card> cards;

	/**
	 * 1 résitance peut avoir plusieurs type;
	 */
	@ManyToMany
	@JoinTable(name = "RESISTENCE_has_TYPE")
	private List<Type> typesResistence;

	public Resistence(Integer id, Integer rate, List<Card> cards, List<Type> typesResistence) {
		super();
		this.id = id;
		this.rate = rate;
		this.cards = cards;
		this.typesResistence = typesResistence;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Type> getTypesResistence() {
		return this.typesResistence;
	}

	public void setTypesResistence(List<Type> typesResistence) {
		this.typesResistence = typesResistence;
	}

}