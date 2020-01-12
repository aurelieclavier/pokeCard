package fr.pokecard.collection.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.business.entity.Type;
import fr.pokecard.collection.persistence.TypeRepository;

@Service
public class TypeService {

	@Autowired
	private TypeRepository typeRepository;

	public List<Type> getAll() {
		return this.typeRepository.findAll();
	}
}
