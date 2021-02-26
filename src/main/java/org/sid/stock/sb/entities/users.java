/*package org.sid.stock.sb.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class users implements Serializable {
	@Id
	private String username;
	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> roles;
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public users(String username, String password, boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
	
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}
	
	

}
*/