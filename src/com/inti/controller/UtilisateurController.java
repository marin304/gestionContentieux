package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

//@Controller
@CrossOrigin("*")
@RestController
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll(Utilisateur.class);
	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id")Long idUtilisateur) {
		return utilisateurService.findOne(Utilisateur.class, idUtilisateur);
	}
	
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public void save(@RequestBody Utilisateur utilisateur) {
		utilisateurService.save(utilisateur);
	}
	
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") Long idUtilisateur,@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(Utilisateur.class, idUtilisateur);
		currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUtilisateur.setEmail(utilisateur.getEmail());
		currentUtilisateur.setListeRoles(utilisateur.getListeRoles());
		currentUtilisateur.setListeTaches(utilisateur.getListeTaches());
		
		utilisateurService.update(currentUtilisateur);
	}
	
	@RequestMapping(value="/users/{id}/activer", method = RequestMethod.PUT)
	public void activerUtilisateur(@PathVariable("id") Long idUtilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(Utilisateur.class, idUtilisateur);
		boolean isActive=currentUtilisateur.isEnabled();
		currentUtilisateur.setEnabled(!isActive);
		utilisateurService.update(currentUtilisateur);
	}
	
	@RequestMapping(value="/users/rechercher/{uname}", method = RequestMethod.GET)
	public Utilisateur rechercherParUSername(@PathVariable("uname") String username) {
		return utilisateurService.findOneByUsername(username);
	}
}
