package com.projet.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projet.model.Utilisateur;
import com.projet.service.AccountService;


@Service //cette classe doit exécuter lors de démarrage de l'app
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	AccountService accountService ;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   Utilisateur utilisateur= accountService.loadUserByUsername(username);
		if(utilisateur==null) throw new UsernameNotFoundException("invalid user");
		Collection<GrantedAuthority> authorities= new ArrayList<>();
		utilisateur.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		
		return new User(utilisateur.getUsername(),utilisateur.getPassword(),  authorities);
	}

}
