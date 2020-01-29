package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Type;
import fr.pokecard.collection.business.entity.Weakness;
import fr.pokecard.collection.persistence.TypeRepository;
import fr.pokecard.collection.persistence.WeaknessRepository;

@Service
public class WeaknessService {

	@Autowired
	private WeaknessRepository weaknessRepository;

	@Autowired
	private TypeRepository typeRepository;

	public List<Weakness> getALl() {
		return this.weaknessRepository.findAll();
	}

	public void saveData(String rate) {
		Weakness weakness = this.weaknessRepository.findOneByRate(rate);
		if (weakness == null) {
			Weakness newWeakness = new Weakness(rate);
			this.weaknessRepository.save(newWeakness);
		}
	}

	public void saveWeaknessHasType(String rate, String name) {
		Weakness weakness = this.weaknessRepository.findOneByRate(rate);
		Type type = this.typeRepository.findOneByName(name);

		if (weakness != null && type != null) {
			if (!weakness.getTypesWeakness().contains(type)) {
				weakness.getTypesWeakness().add(type);
				this.weaknessRepository.save(weakness);
			}
		}
	}
}
