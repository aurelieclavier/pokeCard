package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Account;
import fr.pokecard.collection.business.entity.Role;
import fr.pokecard.collection.persistence.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder bCrypt;

	public List<Account> getAll() {
		return this.accountRepository.findAll();
	}

	public Account getOneByUserName(String userName) {
		return this.accountRepository.findOneByUserName(userName);
	}

	public Account getOneById(Integer id) {
		return this.accountRepository.findOneById(id);
	}

	public void create(String email, String userName, String password) {
		final String hashedPassword = this.bCrypt.encode(password);
		Account account = new Account(email, userName, hashedPassword);
		account.setRole(new Role(1, "USER"));
		this.accountRepository.save(account);
	}

	public void delete(Integer id) {
		this.accountRepository.deleteById(id);
	}

	public void updateAccount(Integer id, Account account) {
		Account updatedAccount = this.getOneById(id);
		if (updatedAccount != null) {
			if (account.getPassword() != null) {
				updatedAccount.setPassword(account.getPassword());
			}
			if (account.getUsername() != null) {
				updatedAccount.setUsername(account.getUsername());
			}
			if (account.getEmail() != null) {
				updatedAccount.setEmail(account.getEmail());
			}
			this.accountRepository.save(updatedAccount);
		} else {
			System.out.println("ACCOUNT NOT EXIST !");
		}

	}
}
