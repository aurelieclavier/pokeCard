package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.Account;
import fr.pokecard.collection.business.service.AccountService;

/**
 *
 */
@RestController
public class AccountController {

	/**
	 * Default constructor
	 */
	public AccountController() {
	}

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	List<Account> getAllAccount() {
		return this.accountService.getAll();
	}

	@GetMapping("/accounts/{id}")
	public Account getOneById(@PathVariable Integer id) {
		return this.accountService.getOneById(id);
	}

	@PostMapping(path = "/accounts/add", consumes = "application/json")
	public void createAccount(@RequestBody Account account) {
		System.out.println("pouet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("pouet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("pouet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("pouet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("pouet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("pouet !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		this.accountService.create(account.getEmail(), account.getUsername(), account.getPassword());
	}

}
