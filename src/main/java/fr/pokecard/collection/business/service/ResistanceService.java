package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Resistance;
import fr.pokecard.collection.business.entity.Type;
import fr.pokecard.collection.persistence.ResistanceRepository;
import fr.pokecard.collection.persistence.TypeRepository;

@Service
public class ResistanceService {

	@Autowired
	private ResistanceRepository resistanceRepository;

	@Autowired
	private TypeRepository typeRepository;

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

	public void saveResistanceHasType(String rate, String name) {
		Resistance resistance = this.resistanceRepository.findOneByRate(rate);
		Type type = this.typeRepository.findOneByName(name);

		if (resistance != null && type != null) {
			if (!resistance.getTypesResistance().contains(type)) {
				resistance.getTypesResistance().add(type);
				this.resistanceRepository.save(resistance);
			}
		}
	}
}
