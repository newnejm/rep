package com.yesserp.sessionbean.ga.infosphysiques;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.InfosPhysiques;

/**
 * Session Bean implementation class GestionInfosPhysiques
 */
@Stateless
@LocalBean
public class GestionInfosPhysiques implements GestionInfosPhysiquesLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionInfosPhysiques() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterInfosPhysiques(InfosPhysiques physiques) {

		em.persist(physiques);
	}

	@Override
	public void supprimerInfosPhysiques(InfosPhysiques physiques) {
		em.remove(em.merge(physiques));

	}

	@Override
	public void modifierInfosPhysiques(InfosPhysiques physiques) {
		em.merge(physiques);
	}

	@Override
	public InfosPhysiques trouverParId(Long id) {
		InfosPhysiques physiques = em.find(InfosPhysiques.class, id);
		return physiques;
	}

	@Override
	public InfosPhysiques trouverParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from InfosPhysiques i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		List<InfosPhysiques> li = null;
		try {
			li = (List<InfosPhysiques>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li.get(li.size() - 1);
		return null;
	}

}
