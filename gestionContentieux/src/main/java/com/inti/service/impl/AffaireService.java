package com.inti.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.dao.interfaces.IAffaireDAO;
import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@Service
@Transactional
public class AffaireService extends ManagerService<Affaire> implements IAffaireService {

	@Override
	public List<Affaire> findAllByStatus(Class<?> classe, int status) {
		return ((IAffaireDAO) DAO).findAllByStatus(classe, status);
	}

}