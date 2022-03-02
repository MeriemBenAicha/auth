package com.projet.service;


import com.projet.model.Role;

import com.projet.model.Utilisateur;

public interface AccountService {
	public Utilisateur loadUserByUsername(String username);
	public Utilisateur saveUser (String username ,String password ,String confirmedPassword);
	public Role save(Role role);
	public void addRoleToUser(String username ,String rolename);

}
