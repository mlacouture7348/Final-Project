package com.app.model;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//username cannot be null and must be unique
	@Column(nullable = false, unique = true)
	private String username;
	
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	private Collection < Role > roles;
	
	
	public User() {}

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(Long id, String username, String password, Collection < Role > roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Collection < Role > getRoles() {
		return roles;
	}
	
	public void setRoles(Collection < Role > roles) {
        this.roles = roles;
    }
	
	@Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", password='" + "*********" + '\'' +
            ", roles=" + roles +
            '}';
    }
	
}