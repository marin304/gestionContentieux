/*package com.inti.config;

import com.inti.service.impl.AffaireService;
import com.inti.service.impl.DocumentService;
import com.inti.service.impl.PhaseService;
import com.inti.service.impl.RoleService;
import com.inti.service.impl.TacheService;
import com.inti.service.impl.TribunalService;
import com.inti.service.impl.UtilisateurService;

public class FactoryService {
	public static Object methodeFactory(String a) {
		Object sortie=null;
		
		switch(a) {
		case "a":
			sortie=new AffaireService();
			break;
		case "d":
			sortie=new DocumentService();
			break;
		case "p":
			sortie=new PhaseService();
			break;
		case "r":
			sortie=new RoleService();
			break;
		case "t":
			sortie=new TacheService();
			break;
		case "b": // Tri(b)unal
			sortie=new TribunalService();
			break;
		case "u":
			sortie=new UtilisateurService();
			break;
		}
		
		return sortie;
	}
}
*/