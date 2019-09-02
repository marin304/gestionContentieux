package com.inti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTache;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String titre, description;
	private boolean statutAudience;
	/*@OneToMany(mappedBy="tache")
	private Set<Utilisateur> listeAvocats=new HashSet<Utilisateur>();*/
	@ManyToOne
	private Affaire affaire;
	@ManyToOne
	private Tribunal tribunal;
	@OneToMany(mappedBy="tache")
	private Set<Phase> listePhases=new HashSet<Phase>();
	
	public Tache() {}

	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatutAudience() {
		return statutAudience;
	}

	public void setStatutAudience(boolean statutAudience) {
		this.statutAudience = statutAudience;
	}

	/*public Set<Utilisateur> getListeAvocats() {
		return listeAvocats;
	}

	public void setListeAvocats(Set<Utilisateur> listeAvocats) {
		this.listeAvocats = listeAvocats;
	}*/

	public Affaire getAffaire() {
		return affaire;
	}

	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	public Set<Phase> getListePhases() {
		return listePhases;
	}

	public void setListePhases(Set<Phase> listePhases) {
		this.listePhases = listePhases;
	}
}