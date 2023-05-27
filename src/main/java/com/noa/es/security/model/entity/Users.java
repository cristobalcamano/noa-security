package com.noa.es.security.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String users;
	private String password;
	
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // we need to duplicate the physical information
    private List<UserXRol> roles;
	/*
	@OneToMany(mappedBy="users")
    private List<UserXRol> roles;
	*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserXRol> getRoles() {
		return roles;
	}
	public void setRoles(List<UserXRol> roles) {
		this.roles = roles;
	}

}
