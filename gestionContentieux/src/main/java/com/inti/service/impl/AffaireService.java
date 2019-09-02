package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.dao.interfaces.IAffaireDAO;
import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@Service
@Transactional
public class AffaireService extends ManagerService<Affaire> implements IAffaireService {
	
	@Autowired
	IAffaireDAO DAO;

	@Override
	public List<Affaire> findAllByStatus(int status) {
		return DAO.findAllByStatus(status);
	}

}