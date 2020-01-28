package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Pokemon;
import fr.pokecard.collection.persistence.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository pokemonRepository;

	public List<Pokemon> getAll() {
		return this.pokemonRepository.findAll();
	}

	public Pokemon getPokemonById(Integer id) {
		return this.pokemonRepository.findOneById(id);
	}

	public Pokemon getPokemonByName(Integer number, String name) {
		return this.pokemonRepository.findOneByNumberAndNameEn(number, name);
	}
}
