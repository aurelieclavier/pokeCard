package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.Type;
import fr.pokecard.collection.business.service.TypeService;

/**
 *
 */
@RestController
public class TypeController {

	/**
	 * Default constructor
	 */
	public TypeController() {
	}

	@Autowired
	private TypeService typeService;

	@GetMapping("/type")
	List<Type> getAllType() {
		return this.typeService.getAll();
	}

}