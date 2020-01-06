package fr.pokecard.collection.presentation;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import fr.pokecard.collection.business.entity.Account;

/**
 *
 */
@RestController
public class AuthController {

	/**
	 * Default constructor
	 */
	public AuthController() {
	}

	@GetMapping("/login")
	public String login(String userName, String password) {
		return userName;
	}

	@GetMapping("/disconnected")
	public String disconnected(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";
	}

	@GetMapping("/public/createAccount")
	public String create() {
		return "public/createAccount";
	}

	@PostMapping("/public/form")
	public String save(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "public/createAccount";
		} else {
//			this.accountServ.create(account.getEmail(), account.getUsername(), account.getPassword());
			return "redirect:/";
		}

	}

}