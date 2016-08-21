package com.yesserp.sessionbean.access;

import javax.ejb.Local;

import com.yesserp.domain.access.Utilisateur;

@Local
public interface AuthentificationServiceLocal {

	Utilisateur authenticate(String login, String password);
	boolean loginExists(String login);
}
