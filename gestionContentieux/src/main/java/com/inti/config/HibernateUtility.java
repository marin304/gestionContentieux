/*package com.inti.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory sf;

	
	 * Constructeur d�fini comme priv� pour interdire son appel et forcer � passer par la m�thode getSessionFactory
	 
	private HibernateUtility() {
		
	}

	 "synchronized" : il n'y aura pas deux ex�cutions simultan�es du code de la m�thode 
	public static synchronized SessionFactory getSessionFactory() {
		if(sf==null)
			sf=new Configuration().configure().buildSessionFactory(); // Pour demain (2/7), demander question sur statut m�thode buildSessionFactory
			
		return sf;
	}
}*/