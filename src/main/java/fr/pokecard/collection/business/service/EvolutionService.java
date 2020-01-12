package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Evolution;
import fr.pokecard.collection.persistence.EvolutionRepository;

@Service
public class EvolutionService {

	@Autowired
	private EvolutionRepository evolutionRepository;

	public List<Evolution> getAll() {
		return this.evolutionRepository.findAll();
	}
}
