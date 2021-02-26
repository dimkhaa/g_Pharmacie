package org.sid.stock.sb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Admin implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idAdmin;
	private String login;
	private String password;
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}




	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
