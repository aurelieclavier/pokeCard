package fr.pokecard.collection.business.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable, UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public Account() {
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
	private String email;

	/**
	 *
	 */
	private String userName;

	/**
	 *
	 */
	private String password;

	/**
	 * Plusieurs compte peuvent avoir un rôle;
	 */
	@ManyToOne
	@JoinColumn(name = "ID_ROLE", nullable = false)
	private Role role;

	/**
	 * Création de la table de jointure ACCOUNT_has_CARD;
	 */
	@ManyToMany
	@JoinTable(name = "ACCOUNT_has_CARD")
	private List<Card> cards;

	/**
	 * Constructors
	 */
	public Account(Integer id, String email, String userName, String password, Role role, List<Card> cards) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.cards = cards;
	}

	public Account(String email, String userName, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public Account(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * Getters and setters
	 */
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(this.role);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}