package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	 * Entities
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name = "TOTAL_CARDS")
	private Integer totalCards;

	@Column(name = "RELEASE_DATE")
	private LocalDateTime releaseDate;

	private String symbol;

	private String logo;

	private String code;

	private String ptcgoCode;

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

	/**
	 * Constructors
	 */
	public CardSet(Integer id, String name, Integer totalCards, LocalDateTime releaseDate, String symbol, String logo,
			String code, String ptcgoCode, List<Card> cards, CardSerie cardSerie) {
		super();
		this.id = id;
		this.name = name;
		this.totalCards = totalCards;
		this.releaseDate = releaseDate;
		this.symbol = symbol;
		this.logo = logo;
		this.code = code;
		this.ptcgoCode = ptcgoCode;
		this.cards = cards;
		this.cardSerie = cardSerie;
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

	public Integer getTotalCards() {
		return this.totalCards;
	}

	public void setTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
	}

	public LocalDateTime getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPtcgoCode() {
		return this.ptcgoCode;
	}

	public void setPtcgoCode(String ptcgoCode) {
		this.ptcgoCode = ptcgoCode;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public CardSerie getCardSerie() {
		return this.cardSerie;
	}

	public void setCardSerie(CardSerie cardSerie) {
		this.cardSerie = cardSerie;
	}

}