package fr.pokecard.collection.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.pokecard.collection.persistence.AccountRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return this.accountRepo.findOneByUserName(userName);
	}

}