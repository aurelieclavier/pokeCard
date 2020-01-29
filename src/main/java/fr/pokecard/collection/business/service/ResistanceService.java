package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Resistance;
import fr.pokecard.collection.persistence.ResistanceRepository;

@Service
public class ResistanceService {

	@Autowired
	private ResistanceRepository resistanceRepository;

	public List<Resistance> getAll() {
		return this.resistanceRepository.findAll();
	}

	public void saveData(String rate) {
		Resistance resistance = this.resistanceRepository.findOneByRate(rate);
		if (resistance == null) {
			Resistance newResistance = new Resistance(rate);
			this.resistanceRepository.save(newResistance);
		}
	}
}
