package com.inti.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.inti.entities.Tache;

public interface ITacheDAO {
	List<Tache> findAllByDate(Class<?> c, Date date);
}