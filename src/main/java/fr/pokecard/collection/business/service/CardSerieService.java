package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.CardSerie;
import fr.pokecard.collection.persistence.CardSerieRepository;

@Service
public class CardSerieService {

	@Autowired
	private CardSerieRepository cardSerieRepository;

	public List<CardSerie> getAll() {
		return this.cardSerieRepository.findAll();
	}
}
