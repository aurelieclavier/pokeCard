package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Retreat;
import fr.pokecard.collection.persistence.RetreatRepository;

@Service
public class RetreatService {

	@Autowired
	private RetreatRepository retreatRepository;

	public List<Retreat> getAll() {
		return this.retreatRepository.findAll();
	}
}
