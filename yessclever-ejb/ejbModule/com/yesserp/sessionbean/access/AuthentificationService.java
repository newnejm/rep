package com.yesserp.sessionbean.access;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.access.Utilisateur;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
public class AuthentificationService implements AuthentificationServiceRemote, AuthentificationServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public AuthentificationService() {
        // TODO Auto-generated constructor stub
    }

	public Utilisateur authenticate(String login, String password) {
		
		Utilisateur found = null;
		String jpql = "select u from Utilisateur u where u.login=:login and u.password=:password";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try{
			found = (Utilisateur) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
	}

	public boolean loginExists(String login) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from Utilisateur u where u.login=:login";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		exists = (Boolean)query.getSingleResult();
		return exists;
	}
}
