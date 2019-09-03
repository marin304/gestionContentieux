package com.inti.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IUtilisateurDAO;
import com.inti.entities.Utilisateur;

@Repository
public class UtilisateurDAO extends ManagerDAO<Utilisateur> implements IUtilisateurDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Utilisateur findOneByUsername(String username) {
		return (Utilisateur) this.sessionFactory.getCurrentSession().createCriteria(Utilisateur.class).add(Restrictions.eq("username", username)).uniqueResult();
	}
}