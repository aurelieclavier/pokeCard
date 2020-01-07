package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.CardSet;
import fr.pokecard.collection.persistence.CardSetRepository;

@Service
public class CardSetService {

	@Autowired
	private CardSetRepository cardSetRepository;

	public List<CardSet> getAll() {
		return this.cardSetRepository.findAll();
	}

}
