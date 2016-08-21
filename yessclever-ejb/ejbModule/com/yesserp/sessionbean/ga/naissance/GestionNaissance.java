package com.yesserp.sessionbean.ga.naissance;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Naissance;

/**
 * Session Bean implementation class GestionNaissance
 */
@Stateless
@LocalBean
public class GestionNaissance implements GestionNaissanceLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionNaissance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterNaissance(Naissance naissance) {
		em.persist(naissance);

	}

	@Override
	public void supprimerNaissance(Naissance naissance) {
		em.remove(em.merge(naissance));

	}

	@Override
	public void modifierNaissance(Naissance naissance) {
		em.merge(naissance);

	}

	@Override
	public Naissance trouverParId(Long id) {

		return em.find(Naissance.class, id);
	}

	@Override
	public Naissance trouverParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Naissance i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		List<Naissance> li = null;
		try {
			li = (List<Naissance>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li.get(li.size() - 1);
		return null;

	}

}
