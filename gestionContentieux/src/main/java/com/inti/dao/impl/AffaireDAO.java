package com.inti.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.inti.dao.interfaces.IAffaireDAO;
import com.inti.entities.Affaire;

public class AffaireDAO extends ManagerDAO<Affaire> implements IAffaireDAO {

	@Override
	public List<Affaire> findAllByStatus(Class<?> c, int statut) {
		List<Affaire> liste = null;

		try {
			s.getTransaction().begin();
			Query queryHQL = s.createQuery(" FROM "+c.getName()+" WHERE statut="+statut);
			liste = queryHQL.list();
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return liste;
	}
}
