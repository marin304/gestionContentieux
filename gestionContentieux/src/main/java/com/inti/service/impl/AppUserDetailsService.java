package com.inti.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.model.UtilisateurDetail;
import com.inti.service.interfaces.IAppUserDetailsService;
import com.inti.service.interfaces.IUtilisateurService;

@Service
@Transactional
public class AppUserDetailsService implements IAppUserDetailsService {
	@Autowired
	IUtilisateurService utilisateurService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user=utilisateurService.findOneByUsername(username);
		Set<Role> roles=user.getListeRoles();
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getLibelle()));
			System.out.println("Role : "+role.getLibelle());
		}
		
		UtilisateurDetail userDetail=new UtilisateurDetail();
		userDetail.setUser(user);
		userDetail.setAuthorities(authorities);
		
		return userDetail;
	}

	@Override
	public Utilisateur findOneByUserName(String username) {
		return utilisateurService.findOneByUsername(username);
	}
}