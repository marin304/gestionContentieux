package com.inti.service.interfaces;

import java.util.List;

public interface IService<T> {
	void save(T obj);

	void update(T obj);

	void remove(T obj);

	List<T> findAll(Class<?> classe);

	T findOne(Class<?> classe, Long idObj);
}