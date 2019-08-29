package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inti.entities.Tache;
import com.inti.service.interfaces.ITacheService;

public class TacheController {
	@Autowired
	ITacheService tacheService;
	
	@RequestMapping(value = "taches", method = RequestMethod.GET)
	public List<Tache> findAll() {
		return tacheService.findAll(Tache.class);
	}
	
	@RequestMapping(value="taches", method = RequestMethod.POST)
	public void save(@RequestBody Tache tache) {
		tacheService.save(tache);
	}
}