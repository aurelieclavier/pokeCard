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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String brand;

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
	 *
	 */
	@Column(name = "TOTAL_CARD_SERIE")
	private Integer totalCardSerie;

	/**
	 *
	 */
	private String symbol;

	/**
	 * 1 série de carte ne peut appartenir qu'à 1 set;
	 */
	@OneToMany(mappedBy = "cardSerie")
	private List<CardSet> cardSets = new ArrayList<>();

	public CardSerie(Integer id, String name, String brand, Integer yearStart, Integer yearEnd, Integer totalCardSerie,
			String symbol, List<CardSet> cardSets) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.totalCardSerie = totalCardSerie;
		this.symbol = symbol;
		this.cardSets = cardSets;
	}

	public CardSerie(String name) {
		this.name = name;
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

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public Integer getTotalCardSerie() {
		return this.totalCardSerie;
	}

	public void setTotalCardSerie(Integer totalCardSerie) {
		this.totalCardSerie = totalCardSerie;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@JsonIgnore
	public List<CardSet> getSets() {
		return this.cardSets;
	}

	public void setSet(List<CardSet> cardSets) {
		this.cardSets = cardSets;
	}

}