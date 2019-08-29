package com.inti.dao.interfaces;

import java.util.List;

import com.inti.entities.Affaire;

public interface IAffaireDAO {
	List<Affaire> findAllByStatus(Class<?> c, int statut);
}
