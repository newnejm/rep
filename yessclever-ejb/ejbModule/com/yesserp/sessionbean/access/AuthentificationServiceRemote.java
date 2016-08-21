package com.yesserp.sessionbean.access;

import javax.ejb.Remote;

import com.yesserp.domain.access.Utilisateur;

@Remote
public interface AuthentificationServiceRemote {

	Utilisateur authenticate(String login, String password);
	boolean loginExists(String login);
}
