package fr.pokecard.collection.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pokecard.collection.business.entity.Account;

/**
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findOneByUserName(final String username);

	Account findOneById(final Integer id);

}