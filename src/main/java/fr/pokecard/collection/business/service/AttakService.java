package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Attack;
import fr.pokecard.collection.business.entity.Type;
import fr.pokecard.collection.persistence.AttakRepository;
import fr.pokecard.collection.persistence.TypeRepository;

@Service
public class AttakService {

	@Autowired
	private AttakRepository attakRepository;

	@Autowired
	private TypeRepository typeRepository;

	public List<Attack> getAll() {
		return this.attakRepository.findAll();
	}

	public void saveData(String name, String description, String damage) {
		Attack attack = this.attakRepository.findOneByNameAndDamageAndDescription(name, damage, description);
		if (attack == null) {
			Attack newAttack = new Attack(name, description, damage);
			this.attakRepository.save(newAttack);
		} else {
			System.out.println(name + " NAME");
			System.out.println(damage + " DAMAGE");
		}
	}

	public void attackHasType(String nameAttack, String nameType, String damage) {
		Attack attack = this.attakRepository.findOneByNameAndDamage(nameAttack, damage);
		Type type = this.typeRepository.findOneByName(nameType);

		if (attack != null && type != null) {
			if (!attack.getTypesAttack().contains(type)) {

				attack.getTypesAttack().add(type);
				this.attakRepository.save(attack);
			} else {
				System.out.println("name attack " + nameAttack);
				System.out.println("name type " + nameType);
				System.out.println("damage " + damage);
			}
		}
	}

}
