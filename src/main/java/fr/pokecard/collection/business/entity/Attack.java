package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "ATTACK")
public class Attack implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Attack() {
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
	private String description;

	/**
	 *
	 */
	private String damage;

	/**
	 * Création de la table ATTACK_has_TYPE; Une attaque peut avoir de 0 à n type;
	 */
	@ManyToMany
	@JoinTable(name = "ATTACK_has_TYPE")
	private List<Type> typesAttack;

	/**
	 *
	 */
	@ManyToMany(mappedBy = "attacks")
	@JsonIgnore
	private List<Card> cards = new ArrayList<>();

	public Attack(Integer id, String name, String description, String damage, List<Type> typesAttack,
			List<Card> cards) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.typesAttack = typesAttack;
		this.cards = cards;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDamage() {
		return this.damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public List<Type> getTypes() {
		return this.typesAttack;
	}

	public void setTypes(List<Type> types) {
		this.typesAttack = types;
	}

	public List<Type> getTypesAttack() {
		return this.typesAttack;
	}

	public void setTypesAttack(List<Type> typesAttack) {
		this.typesAttack = typesAttack;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}