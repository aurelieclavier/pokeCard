package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
@Entity
@Table(name = "CARD_SET")
public class CardSet implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public CardSet() {
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
	@Column(name = "TOTAL_SET")
	private Integer totalSet;

	/**
	 *
	 */
	@Column(name = "YEAR_START")
	private Integer yearStart;

	/**
	 *
	 */
	@Column(name = "YEAR_END")
	private Integer yearEnd;

	/**
	 * 1 set ne peut contenir que 1 même carte;
	 */
	@OneToMany(mappedBy = "cardSet")
	@JsonIgnore
	private List<Card> cards = new ArrayList<>();

	/**
	 * 1 set ne peut avoir qu'une série de carte;
	 */
	@ManyToOne
	private CardSerie cardSerie;

	public CardSet(Integer id, String name, Integer totalSet, Integer yearStart, Integer yearEnd, List<Card> cards,
			CardSerie cardSerie) {
		super();
		this.id = id;
		this.name = name;
		this.totalSet = totalSet;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.cards = cards;
		this.cardSerie = cardSerie;
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

	public Integer getTotalSet() {
		return this.totalSet;
	}

	public void setTotalSet(Integer totalSet) {
		this.totalSet = totalSet;
	}

	public Integer getYearStart() {
		return this.yearStart;
	}

	public void setYearStart(Integer yearStart) {
		this.yearStart = yearStart;
	}

	public Integer getYearEnd() {
		return this.yearEnd;
	}

	public void setYearEnd(Integer yearEnd) {
		this.yearEnd = yearEnd;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCard(List<Card> cards) {
		this.cards = cards;
	}

	public CardSerie getCardSerie() {
		return this.cardSerie;
	}

	public void setCardSerie(CardSerie cardSerie) {
		this.cardSerie = cardSerie;
	}

}