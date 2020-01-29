package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Weakness;
import fr.pokecard.collection.persistence.WeaknessRepository;

@Service
public class WeaknessService {

	@Autowired
	private WeaknessRepository weaknessRepository;

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
}
