package com.projet.service;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.projet.model.Role;
import com.projet.model.Utilisateur;
import com.projet.repository.RoleRepository;
import com.projet.repository.UtilisateurRepository;


@Service
@Transactional  //dés que on finit la méthoe il ya un commit
public class AccountServiceImpl implements AccountService {
	 //l'injection de dépendance se fait par @Autowired ou un constructeur 
	private UtilisateurRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder ;
	private RoleRepository roleRepository ;
	
	public AccountServiceImpl(UtilisateurRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder,RoleRepository roleRepository) {
		this.userRepository= userRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder ;
		this.roleRepository=roleRepository;
	}
	

	

	@Override
	public Utilisateur saveUser(String username , String password, String confirmedPassword) {
		Utilisateur user =userRepository.findByUsername(username);
		if(user != null)throw new RuntimeException("user already exists");
		if(!password.equals(confirmedPassword))throw new RuntimeException("please confirm your password");
		Utilisateur utilisateur= new Utilisateur();
		utilisateur.setUsername(username);
		utilisateur.setPassword(bCryptPasswordEncoder.encode(password));
		userRepository.save(utilisateur);
		addRoleToUser(username,"USER");
		return utilisateur;
	}
	




	@Override
	public Role save(Role role) {
		
	return roleRepository.save(role);
	}



	@Override
	public void addRoleToUser(String username, String rolename) {
		Utilisateur appUser = userRepository.findByUsername(username);
		Role appRole =roleRepository.findByRoleName(rolename);
		appUser.getRoles().add(appRole);
			
		
	}




	@Override
	public Utilisateur loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}





} 
