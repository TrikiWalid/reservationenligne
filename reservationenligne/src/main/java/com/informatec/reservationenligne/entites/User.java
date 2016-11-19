package com.informatec.reservationenligne.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeUser;
	@Size(min = 3, message = "Name must be at least 3 characters!")
	@Column(unique = true)
	// @UniqueUsername(message = "Such username already exists!")
	private String nomUser;
	private String prenomUser;
	private String loginUser;
	@Size(min = 5, message = "Le mot de passe doit etre composer au moins de 5 caractères !")
	private String mdpUser;
	@Size(min = 1, message = "email invalid!")
	@Email(message = "email invalid!!")
	private String email;
	private boolean enabled;

	@ManyToMany(mappedBy = "users")
	private List<Role> roles;

	public User() {
		super();
	}

	public User(String nomUser, String prenomUser, String loginUser,
			String mdpUser, String email) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.loginUser = loginUser;
		this.mdpUser = mdpUser;
		this.email = email;
	}

	public Long getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(Long codeUser) {
		this.codeUser = codeUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getMdpUser() {
		return mdpUser;
	}

	public void setMdpUser(String mdpUser) {
		this.mdpUser = mdpUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
