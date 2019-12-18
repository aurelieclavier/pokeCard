package fr.pokecard.collection.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@OneToOne(mappedBy = "cardSet")
	private Card card;

	/**
	 * 1 set ne peut avoir qu'une série de carte;
	 */
	@OneToOne
	@JoinColumn(name = "ID_CARD_SERIE")
	private CardSerie cardSerie;

	public CardSet(Integer id, String name, Integer totalSet, Integer yearStart, Integer yearEnd, Card card,
			CardSerie cardSerie) {
		super();
		this.id = id;
		this.name = name;
		this.totalSet = totalSet;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.card = card;
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

	public Card getCard() {
		return this.card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public CardSerie getCardSerie() {
		return this.cardSerie;
	}

	public void setCardSerie(CardSerie cardSerie) {
		this.cardSerie = cardSerie;
	}

}