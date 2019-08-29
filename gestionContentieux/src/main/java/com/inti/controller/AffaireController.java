package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@CrossOrigin("*")
@RestController
public class AffaireController {
	@Autowired
	IAffaireService affaireService;
	
	@RequestMapping(value = "cases", method = RequestMethod.GET)
	public List<Affaire> findAll() {
		return affaireService.findAll(Affaire.class);
	}
	
	@RequestMapping(value="cases/{id}", method = RequestMethod.GET)
	public Affaire findOne(@PathVariable("id")Long idAffaire) {
		return affaireService.findOne(Affaire.class, idAffaire);
	}
	
	@RequestMapping(value="cases", method = RequestMethod.POST)
	public void save(@RequestBody Affaire affaire) {
		affaireService.save(affaire);
	}
	
	@RequestMapping(value = "board", method = RequestMethod.GET)
	public List<Affaire> findAllByStatus(int status) {
		return affaireService.findAllByStatus(Affaire.class, status);
	}
}