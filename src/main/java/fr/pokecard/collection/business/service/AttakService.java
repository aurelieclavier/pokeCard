package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Attack;
import fr.pokecard.collection.persistence.AttakRepository;

@Service
public class AttakService {

	@Autowired
	private AttakRepository attakRepository;

	public List<Attack> getAll() {
		return this.attakRepository.findAll();
	}

}
