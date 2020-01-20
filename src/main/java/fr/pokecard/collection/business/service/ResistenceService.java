package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Resistance;
import fr.pokecard.collection.persistence.ResistenceRepository;

@Service
public class ResistenceService {

	@Autowired
	private ResistenceRepository resistenceRepository;

	public List<Resistance> getAll() {
		return this.resistenceRepository.findAll();
	}
}
