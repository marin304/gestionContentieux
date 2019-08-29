package com.inti.service.impl;

import java.util.List;

import com.inti.dao.impl.ManagerDAO;
import com.inti.dao.interfaces.IDAO;
import com.inti.service.interfaces.IService;

public class ManagerService<T> implements IService<T> {
	IDAO<T> DAO = new ManagerDAO<T>();

	@Override
	public void save(T obj) {
		DAO.save(obj);
	}

	@Override
	public void update(T obj) {
		DAO.update(obj);
	}

	@Override
	public void remove(T obj) {
		DAO.remove(obj);
	}

	@Override
	public List<T> findAll(Class<?> classe) {
		return DAO.findAll(classe);
	}

	@Override
	public T findOne(Class<?> classe, Long idObj) {
		return DAO.findOne(classe, idObj);
	}
}
