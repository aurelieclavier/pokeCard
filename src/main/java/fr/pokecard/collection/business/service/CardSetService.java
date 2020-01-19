package fr.pokecard.collection.business.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.CardSerie;
import fr.pokecard.collection.business.entity.CardSet;
import fr.pokecard.collection.persistence.CardSerieRepository;
import fr.pokecard.collection.persistence.CardSetRepository;

@Service
public class CardSetService {

	@Autowired
	private CardSetRepository cardSetRepository;

	@Autowired
	private CardSerieRepository cardSerieRepository;

	public List<CardSet> getAll() {
		return this.cardSetRepository.findAll();
	}

	public void saveData(String name, Integer totalCards, LocalDate releaseDate, String symbol, String logo,
			String code, String ptcgoCode, String nameSerie) {
		CardSerie serie = this.cardSerieRepository.findOneByName(nameSerie);
		if (serie != null) {
			CardSet newSet = new CardSet(name, totalCards, releaseDate, symbol, logo, code, ptcgoCode, serie);
			this.cardSetRepository.save(newSet);
		}

	}

}
