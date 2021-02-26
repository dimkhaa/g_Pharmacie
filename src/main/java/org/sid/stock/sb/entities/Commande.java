package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idCommande;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateCommande;
	@Transient
	private int montant;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> lignecommandes ;
	
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Long idCommande, Date dateCommande, int montant, Fournisseur fournisseur,
			List<LigneCommande> lignecommandes) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.montant = montant;
		this.fournisseur = fournisseur;
		this.lignecommandes = lignecommandes;
	}



	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}



	public Date getDateCommande() {
		return dateCommande;
	}



	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}



	public int getMontant() {
		int montant=0;
		if(!lignecommandes.isEmpty()){
			for(LigneCommande ligneCommande : lignecommandes){
				int montantLigne = ((LigneCommande) ligneCommande).getQuantitemedoc() *(ligneCommande.getMedicaments().getPrixAchat());
				montant+= montantLigne;
			}
			
		}
		
		return montant;
	}



	public void setMontant(int montant) {
		
		this.montant = montant;
	}



	public Fournisseur getFournisseur() {
		return fournisseur;
	}



	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}



	public List<LigneCommande> getLignecommandes() {
		return lignecommandes;
	}



	public void setLignecommandes(List<LigneCommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}
	
	
	

}
