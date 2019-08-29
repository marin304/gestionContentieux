package com.inti.service.impl;

import java.util.List;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

public class AffaireService extends ManagerService<Affaire> implements IAffaireService {

	@Override
	public List<Affaire> findAllByStatus(Class<?> classe, int status) {
		return null;
	}

}