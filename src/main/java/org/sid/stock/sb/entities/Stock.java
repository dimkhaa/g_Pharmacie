package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Stock implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idStock;
	private String libelle;
	private int quantie;
	
	@OneToMany(mappedBy ="stock")
	private List<StockMedoc> stockmedocs;
	
	

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Stock(Long idStock, String libelle, int quantie,
			List<StockMedoc> stockmedocs) {
		super();
		this.idStock = idStock;
		this.libelle = libelle;
		this.quantie = quantie;
		this.stockmedocs = stockmedocs;
	}



	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public int getQuantie() {
		return quantie;
	}



	public void setQuantie(int quantie) {
		this.quantie = quantie;
	}



	public List<StockMedoc> getStockmedocs() {
		return stockmedocs;
	}



	public void setStockmedocs(List<StockMedoc> stockmedocs) {
		this.stockmedocs = stockmedocs;
	}
	
	
	
	

}
