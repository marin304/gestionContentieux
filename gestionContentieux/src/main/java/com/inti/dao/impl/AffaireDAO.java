package com.inti.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IAffaireDAO;
import com.inti.entities.Affaire;

@Repository
public class AffaireDAO extends ManagerDAO<Affaire> implements IAffaireDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Affaire> findAllByStatus(int statut) {
	
		return (List<Affaire>) sessionFactory.getCurrentSession().createCriteria(Affaire.class).add(Restrictions.eq("statut", statut)).list();
	}
}
