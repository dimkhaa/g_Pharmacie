
package org.sid.stock.sb.entities;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class VenteMedicament implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idVenteMedicament;
	@NotEmpty
	private int quantite;
	@NotEmpty
	private int prix;
	@ManyToOne
	@JoinColumn(name = "idMedicaments")
	private Medicaments medicaments;
	
	@ManyToOne
	@JoinColumn(name = "vente")
	private Ventes vente;
	
	

	public VenteMedicament() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public VenteMedicament(Long idVenteMedicament, int quantite, int prix,
			Medicaments medicaments, Ventes vente) {
		super();
		this.idVenteMedicament = idVenteMedicament;
		this.quantite = quantite;
		this.prix= prix;
		this.medicaments = medicaments;
		this.vente = vente;
	}



	public Long getIdVenteMedicament() {
		return idVenteMedicament;
	}

	public void setIdVenteMedicament(Long idVenteMedicament) {
		this.idVenteMedicament = idVenteMedicament;
	}



	public int getQuantite() {
		return quantite;
	}



	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	public Medicaments getMedicaments() {
		return medicaments;
	}

	

	public int getPrix() {
		return prix;
	}



	public void setPrix(int prix) {
		this.prix = prix;
	}



	public void setMedicaments(Medicaments medicaments) {
		this.medicaments = medicaments;
	}



	public Ventes getVente() {
		return vente;
	}



	public void setVente(Ventes vente) {
		this.vente = vente;
	}
	
	
	

}
