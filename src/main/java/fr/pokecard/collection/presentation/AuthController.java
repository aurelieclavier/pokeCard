package fr.pokecard.collection.presentation;

import org.springframework.web.bind.annotation.RestController;

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

//	@GetMapping("/login")
//	public String login(String userName, String password) {
//		return userName;
//	}
//
//	@GetMapping("/disconnected")
//	public String disconnected(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "redirect:/";
//	}
//
//	@GetMapping("/public/createAccount")
//	public String create() {
//		return "public/createAccount";
//	}
//
//	@PostMapping("/public/form")
//	public String save(@Valid Account account, BindingResult result) {
//		if (result.hasErrors()) {
//			return "public/createAccount";
//		} else {
////			this.accountServ.create(account.getEmail(), account.getUsername(), account.getPassword());
//			return "redirect:/";
//		}
//
//	}

}