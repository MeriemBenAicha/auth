package com.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



import com.projet.model.Utilisateur;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	//User findByemailUser(String emailUser);
	public Utilisateur findByUsername (String username);
	

}

