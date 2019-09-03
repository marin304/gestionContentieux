package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.dao.interfaces.IDAO;
import com.inti.service.interfaces.IService;

@Service
@Transactional
public class ManagerService<T> implements IService<T> {

	@Autowired
	@Qualifier("daoGeneric")
	protected IDAO<T> DAO;

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
