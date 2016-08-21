package com.yesserp.sessionbean.ga.mail;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Mail;

/**
 * Session Bean implementation class GestionMail
 */
@Stateless
@LocalBean
public class GestionMail implements GestionMailLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionMail() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterMail(Mail mail) {

		em.persist(mail);
	}

	@Override
	public void supprimerMail(Mail mail) {

		em.remove(em.merge(mail));

	}

	@Override
	public void modifierMail(Mail mail) {

		em.merge(mail);

	}

	@Override
	public Mail trouverParId(Long id) {

		return em.find(Mail.class, id);
	}

	@Override
	public List<Mail> trouverMailsParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Mail i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		List<Mail> li = null;
		try {
			li = (List<Mail>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
