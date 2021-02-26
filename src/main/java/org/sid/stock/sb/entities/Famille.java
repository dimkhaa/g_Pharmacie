package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Famille implements Serializable{
	
	@Id
	@GeneratedValue
 private Long idFamille;
 private String code;
 private String designation;
 @OneToMany(mappedBy="famille")
 private List<Medicaments> medicaments;

 
public Famille() {
	super();
	// TODO Auto-generated constructor stub
}


public Famille(String code, String designation,List<Medicaments> medicaments) {
	super();
	this.code=code;
	this.designation = designation;
	this.medicaments = medicaments;
}


public Long getIdFamille() {
	return idFamille;
}


public void setIdFamille(Long id) {
	this.idFamille = id;
}



public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public String getDesignation() {
	return designation;
}


public void setDesignation(String designation) {
	this.designation = designation;
}


public List<Medicaments> getMedicaments() {
	return medicaments;
}


public void setMedicaments(List<Medicaments> medicaments) {
	this.medicaments = medicaments;
}
 

 
}
