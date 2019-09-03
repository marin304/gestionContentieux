package com.inti.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inti.dao.interfaces.IDAO;

@Repository("daoGeneric")
public class ManagerDAO<T> implements IDAO<T> {
	//protected Session s = HibernateUtility.getSessionFactory().openSession();
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void save(T obj) {
		this.sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public void update(T obj) {
		/*try {
			s.getTransaction().begin();
			s.merge(obj);
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}*/
		this.sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	public void remove(T obj) {
		/*try {
			s.getTransaction().begin();
			s.delete(obj);
			s.getTransaction().commit();
			s.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
		}*/
		this.sessionFactory.getCurrentSession().delete(obj);
	}

	@Override
	public List<T> findAll(Class<?> c) {
		/*List<T> liste = null;

		try {
			s.getTransaction().begin();
			Query queryHQL = s.createQuery(" FROM " + c.getName());
			liste = queryHQL.list();
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return liste;*/
		
		return this.sessionFactory.getCurrentSession().createCriteria(c).list();
	}

	@Override
	public T findOne(Class<?> c, Long idObj) {
		/*s.getTransaction().begin();
		T t = (T) s.get(c, idObj);*/
		//return (T)s.get(c, idObj);
		
		return (T) this.sessionFactory.getCurrentSession().get(c, idObj);
	}
}