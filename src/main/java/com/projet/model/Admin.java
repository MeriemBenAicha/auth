package com.projet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdmin;
	private String nameAdmin;
	private String emailAdmin;
	private String passwordAdmin;
	public Admin() {

	}
	public Long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNameAdmin() {
		return nameAdmin;
	}
	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	public String getPasswordAdmin() {
		return passwordAdmin;
	}
	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}



}
