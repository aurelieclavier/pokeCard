package fr.pokecard.collection.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.pokecard.collection.business.entity.Evolution;
import fr.pokecard.collection.business.entity.Pokemon;
import fr.pokecard.collection.business.entity.Power;
import fr.pokecard.collection.business.service.EvolutionService;
import fr.pokecard.collection.business.service.PokemonService;
import fr.pokecard.collection.business.service.PowerService;

/**
 *
 */
@RestController
public class PokemonController {

	/**
	 * Default constructor
	 */
	public PokemonController() {
	}

	@Autowired
	private PokemonService pokemonService;

	@Autowired
	private PowerService powerService;

	@Autowired
	private EvolutionService evolutionService;

	@GetMapping("/pokemons")
	List<Pokemon> getAllPokemons() {
		return this.pokemonService.getAll();
	}

	@GetMapping("pokemons/{id}")
	public Pokemon getOneById(@PathVariable Integer id) {
		return this.pokemonService.getPokemonById(id);
	}

	@GetMapping("/pokemons/power")
	List<Power> getAllPowersPokemons() {
		return this.powerService.getAll();
	}

	@GetMapping("pokemons/evolution")
	List<Evolution> getAllEvolution() {
		return this.evolutionService.getAll();
	}

}