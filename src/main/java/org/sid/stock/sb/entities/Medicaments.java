package org.sid.stock.sb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
@Entity
public class Medicaments implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idMedicament;
	@NotNull
	private String libelle;
	@NotNull
	private int prixAchat;
	@NotNull
	private int prixVente;
	@NotNull
	@NumberFormat
	private int quantite;
	@ManyToOne
	@JoinColumn(name = "idFamille")
	@NotNull
	private Famille famille;
	
		
	
	public Medicaments() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Medicaments(String libelle, int prixAchat,
			int prixVente, int quantite, Famille famille) {
		super();
		this.libelle = libelle;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.quantite=quantite;
		this.famille = famille;
	}
	
	


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public int getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}


	public int getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	public Famille getFamille() {
		return famille;
	}


	public void setFamille(Famille famille) {
		this.famille = famille;
	}


	public Long getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(Long idMedicament) {
		this.idMedicament = idMedicament;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	
	
}
