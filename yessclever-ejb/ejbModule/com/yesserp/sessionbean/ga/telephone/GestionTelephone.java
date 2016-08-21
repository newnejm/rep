package com.yesserp.sessionbean.ga.telephone;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Telephone;

/**
 * Session Bean implementation class GestionTelephone
 */
@Stateless
@LocalBean
public class GestionTelephone implements GestionTelephoneLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionTelephone() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterTelephone(Telephone telephone) {

		em.persist(telephone);
	}

	@Override
	public void supprimerTelephone(Telephone telephone) {

		em.remove(em.merge(telephone));

	}

	@Override
	public void modifierTelephone(Telephone telephone) {
		em.merge(telephone);

	}

	@Override
	public Telephone trouverParId(Long id) {

		return em.find(Telephone.class, id);
	}

	@Override
	public List<Telephone> trouverTelephonesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Telephone i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		List<Telephone> li = null;
		try {
			li = (List<Telephone>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
