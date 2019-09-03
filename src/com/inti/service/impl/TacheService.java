package com.inti.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.dao.interfaces.ITacheDAO;
import com.inti.entities.Tache;
import com.inti.service.interfaces.ITacheService;

@Service
@Transactional
public class TacheService extends ManagerService<Tache> implements ITacheService {

	@Override
	public List<Tache> findAllByDate(Class<?> c, Date date) {
		return ((ITacheDAO) DAO).findAllByDate(Tache.class, date);
	}

}