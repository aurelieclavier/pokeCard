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

/**
 *
 */
@Entity
@Table(name = "RESISTANCE")
public class Resistance implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Resistance() {
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
	@ManyToMany(mappedBy = "resistances")
	private List<Card> cards;

	/**
	 * 1 résitance peut avoir plusieurs type;
	 */
	@ManyToMany
	@JoinTable(name = "RESITANCE_has_TYPE")
	private List<Type> typesResistance;

	public Resistance(Integer id, Integer rate, List<Card> cards, List<Type> typesResistance) {
		super();
		this.id = id;
		this.rate = rate;
		this.cards = cards;
		this.typesResistance = typesResistance;
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

	public List<Type> getTypesResistance() {
		return this.typesResistance;
	}

	public void setTypesResistance(List<Type> typesResistance) {
		this.typesResistance = typesResistance;
	}

}