package com.inti.service.interfaces;

import java.util.Date;
import java.util.List;

import com.inti.entities.Tache;

public interface ITacheService extends IService<Tache> {
	List<Tache> findAllByDate(Class<?> c, Date date);
}