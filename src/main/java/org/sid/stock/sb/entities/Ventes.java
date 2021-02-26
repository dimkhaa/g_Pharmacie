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

import org.sid.stock.sb.dao.MedicamentsRep;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Ventes implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idVente;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateVente;
	private float montant;
	/*@DateTimeFormat(pattern="hh:mm:ss")
	private int heure;
	*/
	
	
	@OneToMany(mappedBy = "vente")
	private List<VenteMedicament> Ventemedicaments;
	
	

	public Ventes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Ventes(Date dateVente, float montant, Date date,
		 List<VenteMedicament> ventemedicaments) {
		super();
		this.dateVente = dateVente;
		
		this.montant = montant;

		Ventemedicaments = ventemedicaments;
	}

	
	


	public Ventes(Date dateVente, float montant) {
		super();
		this.dateVente = dateVente;
		this.montant = montant;
	}



	public Long getIdVente() {
		return idVente;
	}

	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}



	public Date getdateVente() {
		return dateVente;
	}



	public void setdateVente(Date dateVente) {
		this.dateVente = dateVente;
	}


	
	public float getMontant() {	
		return montant;
	}



	public void setMontant(float montant) {
		this.montant = montant;
	}



	public Date getDateVente() {
		return dateVente;
	}



	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}



	public List<VenteMedicament> getVentemedicaments() {
		return Ventemedicaments;
	}



	public void setVentemedicaments(List<VenteMedicament> ventemedicaments) {
		Ventemedicaments = ventemedicaments;
	}
	
	
	

}
