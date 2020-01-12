package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Power;
import fr.pokecard.collection.persistence.PowerRepository;

@Service
public class PowerService {

	@Autowired
	private PowerRepository powerRepository;

	public List<Power> getAll() {
		return this.powerRepository.findAll();
	}
}
