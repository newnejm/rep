package com.yesserp.sessionbean.mail;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.yesserp.domain.mail.Provider;

/**
 * Session Bean implementation class MailCRUD
 */
@Stateless
@LocalBean
public class MailCRUD implements MailCRUDLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public MailCRUD() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Provider provider) {
		em.persist(provider);
	}

	@Override
	public void delete(Provider provider) {
		provider = this.consulter(provider.getName());
		em.remove(provider);
	}

	@Override
	public Provider consulter(String name) {
		Provider p;
		try {
			p = (Provider) em
					.createQuery(
							"SELECT p FROM Provider p where p.name = :name")
					.setParameter("id", name).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return p;
	}

	@Override
	public List<Provider> consulter() {
		ArrayList<Provider> c = (ArrayList<Provider>) em.createQuery(
				"SELECT p FROM  Provider p").getResultList();
		return c;
	}
}