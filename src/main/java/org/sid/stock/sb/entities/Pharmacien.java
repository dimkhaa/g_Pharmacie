package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
public class Pharmacien implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idPharmacien;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String login;
	private String password;
	private boolean active;
	private String role;
	@OneToMany
	@JoinColumn(name="idPharmacien")
	private Collection<Roles> roles;
	

	public Pharmacien() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Pharmacien(String nom, String prenom, String adresse,
			String telephone, String login, String password, boolean active, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
		this.active=active;
		this.role=role;
	}



	public Long getIdPharmacien() {
		return idPharmacien;
	}

	public void setIdPharmacien(Long idPharmacien) {
		this.idPharmacien = idPharmacien;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Collection<Roles> getRoles() {
		return roles;
	}



	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	
	
	

}
