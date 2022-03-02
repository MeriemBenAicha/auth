package com.projet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name = "users")

public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	//private String emailUser;
	private String password;
	@ManyToMany(fetch =FetchType.EAGER)
	private Collection <Role>roles =new ArrayList<>();
	public Utilisateur(Long id,String username,String password,Collection<Role> roles) {
		this.id=id;
		this.username=username;
		this.password=password;
		this.roles= roles;
	}
	public Utilisateur(){
		
	}

	public  Long getId() {
		return id;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
