package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.Rarity;
import fr.pokecard.collection.business.service.RarityService;

/**
*
*/
@RestController
public class RarityController {
	/**
	 * Default constructor
	 */
	public RarityController() {
	}

	@Autowired
	private RarityService rarityService;

	@GetMapping("/rarity")
	List<Rarity> getAllRarity() {
		return this.rarityService.getAll();
	}
}
