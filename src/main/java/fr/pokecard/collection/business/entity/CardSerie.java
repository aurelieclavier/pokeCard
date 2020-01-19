package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "CARD_SERIE")
public class CardSerie implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public CardSerie() {
	}

	/**
	 * Entities
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String publisher;

	@Column(name = "TOTAL_CARDS")
	private Integer totalCards;

	private String logo;

	/**
	 * 1 série de carte ne peut appartenir qu'à 1 set;
	 */
	@OneToMany(mappedBy = "cardSerie")
	private List<CardSet> cardSets = new ArrayList<>();

	/**
	 * Constructors
	 */
	public CardSerie(Integer id, String name, String publisher, Integer totalCards, String logo,
			List<CardSet> cardSets) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.totalCards = totalCards;
		this.logo = logo;
		this.cardSets = cardSets;
	}

	public CardSerie(String name) {
		this.name = name;
	}

	/**
	 * Getters and Setters
	 */
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

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getTotalCards() {
		return this.totalCards;
	}

	public void setTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<CardSet> getCardSets() {
		return this.cardSets;
	}

	public void setCardSets(List<CardSet> cardSets) {
		this.cardSets = cardSets;
	}

}