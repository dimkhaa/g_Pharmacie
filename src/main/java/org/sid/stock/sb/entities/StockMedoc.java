package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class StockMedoc implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idStockMedoc;
	private int quantite;
	private String alertQuantite;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMvt;
	
	@ManyToOne
	@JoinColumn(name = "idMedicament")
	private Medicaments medicament;
	
	@ManyToOne
	@JoinColumn(name="idStock")
	private Stock stock;
	
	

	public StockMedoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public StockMedoc(int quantite, String alertQuantite, Date dateMvt,
			Medicaments medicament, Stock stock) {
		super();
		this.quantite = quantite;
		this.alertQuantite = alertQuantite;
		this.dateMvt = dateMvt;
		this.medicament = medicament;
		this.stock = stock;
	}


	public Long getIdStockMedoc() {
		return idStockMedoc;
	}

	public void setIdStockMedoc(Long idStockMedoc) {
		this.idStockMedoc = idStockMedoc;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getAlertQuantite() {
		return alertQuantite;
	}


	public void setAlertQuantite(String alertQuantite) {
		this.alertQuantite = alertQuantite;
	}


	public Date getDateMvt() {
		return dateMvt;
	}


	public void setDateMvt(Date dateMvt) {
		this.dateMvt = dateMvt;
	}


	public Medicaments getMedicament() {
		return medicament;
	}


	public void setMedicament(Medicaments medicament) {
		this.medicament = medicament;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	

}
