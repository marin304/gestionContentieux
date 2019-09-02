package com.inti.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.inti.entities.Utilisateur;

public interface IAppUserDetailsService extends UserDetailsService {
	Utilisateur findOneByUserName(String username);
}