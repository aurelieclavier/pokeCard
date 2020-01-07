package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.Account;
import fr.pokecard.collection.business.service.AccountService;
import fr.pokecard.collection.persistence.AccountRepository;

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

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/accounts")
	List<Account> getAllAccount() {
		return this.accountService.getAll();
	}

	@GetMapping("/accounts/{id}")
	public Account getOneById(@PathVariable Integer id) {
		return this.accountService.getOneById(id);
	}

	@PostMapping("/accounts/add")
	public void createAccount(@RequestBody final Account account) {
		this.accountService.create(account.getEmail(), account.getUsername(), account.getPassword());
	}

	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable Integer id) {
		this.accountService.delete(id);
	}

	@PutMapping("/accounts/{id}")
	public void updateAccount(@PathVariable Integer id, @RequestBody final Account account) {
		this.accountService.updateAccount(id, account);
	}

}
