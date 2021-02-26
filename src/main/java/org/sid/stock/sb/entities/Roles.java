package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
@Entity
public class Roles implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idRoles;
	private String role;
	
	/* @OneToMany(mappedBy="roles")
	private List<Pharmacien> pharmacien;*/
	 

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Roles(Long idRoles, String roles /*List<Pharmacien> pharmacien*/) {
		super();
		this.idRoles = idRoles;
		this.role = roles;
		//this.pharmacien = pharmacien;
	}


	public Long getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(Long idRoles) {
		this.idRoles = idRoles;
	}


	public String getRoles() {
		return role;
	}


	public void setRoles(String roles) {
		this.role = roles;
	}


/*	public List<Pharmacien> getPharmacien() {
		return pharmacien;
	}


	public void setPharmacien(List<Pharmacien> pharmacien) {
		this.pharmacien = pharmacien;
	}*/
	
	
	

}
