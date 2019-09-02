package com.inti.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import com.inti.dao.interfaces.ITacheDAO;
import com.inti.entities.Tache;

public class TacheDAO extends ManagerDAO<Tache> implements ITacheDAO {
	
	@Override
	public List<Tache> findAllByDate(Class<?> c, Date date) {
		return (List<Tache>) s.createCriteria(Tache.class).add(Restrictions.ge("dateCreation", date));
	}
}
