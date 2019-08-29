package com.inti.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.inti.config.HibernateUtility;
import com.inti.dao.interfaces.IDAO;

public class ManagerDAO<T> implements IDAO<T> {
	protected Session s = HibernateUtility.getSessionFactory().openSession();

	@Override
	public void save(T obj) {
		try {
			s.getTransaction().begin();
			s.persist(obj);
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(T obj) {
		try {
			s.getTransaction().begin();
			s.merge(obj);
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(T obj) {
		try {
			s.getTransaction().begin();
			s.delete(obj);
			s.getTransaction().commit();
			s.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> findAll(Class<?> c) {
		List<T> liste = null;

		try {
			s.getTransaction().begin();
			Query queryHQL = s.createQuery(" FROM " + c.getName());
			liste = queryHQL.list();
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return liste;
	}

	@Override
	public T findOne(Class<?> c, Long idObj) {
		s.getTransaction().begin();
		T t = (T) s.get(c, idObj);

		return t;
	}
}