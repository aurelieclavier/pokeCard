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

	public int saveData(String name, String description, String damage) {
		int j = 0;
		Attack attack = this.attakRepository.findOneByNameAndDamageAndDescription(name, damage, description);
		j = 1;
		if (attack == null) {
			Attack newAttack = new Attack(name, description, damage);
			this.attakRepository.save(newAttack);
		} else {
			System.out.println(name + " NAME");
			System.out.println(damage + " DAMAGE");
		}
		return j;
	}

}
