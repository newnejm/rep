package com.yesserp.sessionbean.gs;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.*;
import com.yesserp.type.gs.TypeNotif;

/**
 * Session Bean implementation class GestionNotif
 */
@Stateless
@LocalBean
public class GestionNotif implements GestionNotifLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionNotif() {
		// TODO Auto-generated constructor stub
	}

	public void create(String nom, TypeNotif type, String description) {
		Notification n = new Notification(nom, type, description);
		em.persist(n);
	}

	public List<Notification> consulter(Date date) {

		List<Notification> ln = null;
		ln = em.createQuery("SELCT n FROM Notification n WHERE n.date = :date")
				.setParameter("date", date).getResultList();
		return ln;
	}
}
