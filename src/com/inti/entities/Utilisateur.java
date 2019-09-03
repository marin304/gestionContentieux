package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur, prenomUtilisateur;
	private String email;
	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled=true; 
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="id_user", referencedColumnName="idUtilisateur"), inverseJoinColumns=@JoinColumn(name="id_role", referencedColumnName="idRole"))
	private Set<Role> listeRoles=new HashSet<>();
	@OneToMany(mappedBy="utilisateur" ,fetch = FetchType.EAGER)
	private Set<Tache> listeTaches=new HashSet<Tache>();

	public Utilisateur() {}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getListeRoles() {
		return listeRoles;
	}

	public void setListeRoles(Set<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}

	public Set<Tache> getListeTaches() {
		return listeTaches;
	}

	public void setListeTaches(Set<Tache> listeTaches) {
		this.listeTaches = listeTaches;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}