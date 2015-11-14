package com.social.manager.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Roles implements Serializable{

	private static final long serialVersionUID = 8008280586667757943L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String roleName;
	
	//@JsonBackReference
	@ManyToMany(mappedBy="roles",cascade=CascadeType.ALL)
	//@JoinColumn(name = "USER_ID")
	private Set<User> users = new HashSet<User>();

	public Roles(){}
	
	public Roles(String roleName) {
		this.roleName = roleName;
	}

	public Roles(Long role_id, String roleName) {
		this.id = role_id;
		this.roleName = roleName;
	}

	public Roles(Set<User> users) {
		this.users = users;
	}

	public Roles(Long role_id, String roleName, Set<User> users) {
		this.id = role_id;
		this.roleName = roleName;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long role_id) {
		this.id = role_id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<User> getUsers()
	{
		return users;
	}
	
}
