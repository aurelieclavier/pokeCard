package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
@Entity
@Table(name = "RETREAT")
public class Retreat implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Retreat() {
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
	private Integer value;

	/**
	 *
	 */
	private String symbol;

	/**
	 * 1 carte ne peut recevoir que 1 retraite
	 */
	@OneToMany(mappedBy = "retreat")
	@JsonIgnore
	private List<Card> cards = new ArrayList<>();

	public Retreat(Integer id, Integer value, String symbol, List<Card> cards) {
		super();
		this.id = id;
		this.value = value;
		this.symbol = symbol;
		this.cards = cards;
	}

	public Retreat(Integer value) {
		this.value = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCard(List<Card> cards) {
		this.cards = cards;
	}

}