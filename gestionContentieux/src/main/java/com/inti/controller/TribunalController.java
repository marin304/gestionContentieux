package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.inti.entities.Tribunal;
import com.inti.service.interfaces.ITribunalService;

@Controller
public class TribunalController {
	@Autowired
	ITribunalService tribunalService;

	@RequestMapping(value = "courts", method = RequestMethod.GET)
	public List<Tribunal> findAll() {
		return tribunalService.findAll(Tribunal.class);
	}
	
	@RequestMapping(value="courts/{id}", method = RequestMethod.GET)
	public Tribunal findOne(@PathVariable("id") Long idTribunal) {
		return tribunalService.findOne(Tribunal.class, idTribunal);
	}
}