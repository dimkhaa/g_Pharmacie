package org.sid.stock.sb.entities;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idLigneCommande;
	
	private int quantitemedoc;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idMedicament")
	private Medicaments medicaments;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	 private Boolean etat;
	

	public LigneCommande() {
		super();
		
	}
	

	public LigneCommande(Long idLigneCommande, int quantitemedoc,
			Medicaments medicaments, Commande commande) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.quantitemedoc = quantitemedoc;
		this.medicaments = medicaments;
		this.commande = commande;
	}


	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}


	public int getQuantitemedoc() {
		return quantitemedoc;
	}


	public void setQuantitemedoc(int quantitemedoc) {
		this.quantitemedoc = quantitemedoc;
	}
	
	
	public Medicaments getMedicaments() {
		return medicaments;
	}


	public void setMedicaments(Medicaments medicaments) {
		this.medicaments = medicaments;
	}

	
	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
	
	

}
