package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String libelle;
	/*@OneToMany(mappedBy="role")
	private Set<Utilisateur> listeAvocats=new HashSet<Utilisateur>();*/
	@ManyToMany(mappedBy="role")
	private Set<Utilisateur> listeAvocats=new HashSet<Utilisateur>();
	
	public Role() {
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Utilisateur> getListeAvocats() {
		return listeAvocats;
	}

	public void setListeAvocats(Set<Utilisateur> listeAvocats) {
		this.listeAvocats = listeAvocats;
	}
}