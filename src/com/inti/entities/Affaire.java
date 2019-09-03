package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Affaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAffaire;
	private String reference;
	private String titre, description;
	private int statut;
	
	@OneToMany(mappedBy="affaire")
	private Set<Tache> listeTaches=new HashSet<Tache>();
	@OneToMany(mappedBy="affaire")
	private Set<Document> listeDocuments=new HashSet<Document>();
	
	public Affaire() {}

	public Long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Set<Tache> getListeTaches() {
		return listeTaches;
	}

	public void setListeTaches(Set<Tache> listeTaches) {
		this.listeTaches = listeTaches;
	}

	public Set<Document> getListeDocuments() {
		return listeDocuments;
	}

	public void setListeDocuments(Set<Document> listeDocuments) {
		this.listeDocuments = listeDocuments;
	}
}