package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idFournisseur;
	private String nom;
	private String adresse;
	private String ville;
	private String telephone;
	private String email;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Commande> commande;
	
	
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Fournisseur(Long idFournisseur, String nom, String adresse,
			String ville, String telephone, String email,
			List<Commande> commande) {
		super();
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
		this.commande = commande;
	}



	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Commande> getCommande() {
		return commande;
	}



	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}
	
	
	

}
