package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Attack;
import fr.pokecard.collection.business.entity.Type;
import fr.pokecard.collection.persistence.AttackRepository;
import fr.pokecard.collection.persistence.TypeRepository;

@Service
public class AttackService {

	@Autowired
	private AttackRepository attackRepository;

	@Autowired
	private TypeRepository typeRepository;

	public List<Attack> getAll() {
		return this.attackRepository.findAll();
	}

	public void saveData(String name, String description, String damage) {
		Attack attack = this.attackRepository.findOneByNameAndDamageAndDescription(name, damage, description);
		if (attack == null) {
			Attack newAttack = new Attack(name, description, damage);
			this.attackRepository.save(newAttack);
		} else {
			System.out.println(name + " NAME");
			System.out.println(damage + " DAMAGE");
		}
	}

	public void attackHasType(String nameAttack, String nameType, String damage, String description) {
		Attack attack = this.attackRepository.findOneByNameAndDamageAndDescription(nameAttack, damage, description);
		Type type = this.typeRepository.findOneByName(nameType);

		if (attack != null && type != null) {
			if (!attack.getTypesAttack().contains(type)) {
				attack.getTypesAttack().add(type);
				this.attackRepository.save(attack);
			} else {
				System.out.println("type : " + nameType);
				System.out.println("attack : " + nameAttack);
				System.out.println("description : " + description);
				System.out.println("damage : " + damage);
			}
		}
	}
}
