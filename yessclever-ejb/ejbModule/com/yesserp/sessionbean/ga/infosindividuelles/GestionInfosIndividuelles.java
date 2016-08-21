package com.yesserp.sessionbean.ga.infosindividuelles;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.InfosIndividuelles;

/**
 * Session Bean implementation class GestionInfosIndividuelles
 */
@Stateless
@LocalBean
public class GestionInfosIndividuelles implements
		GestionInfosIndividuellesLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionInfosIndividuelles() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterInfosIndividuelles(InfosIndividuelles individuelles) {
		em.persist(individuelles);
	}

	@Override
	public void supprimerInfosIndividuelles(InfosIndividuelles individuelles) {
		em.remove(em.merge(individuelles));
	}

	@Override
	public void modifierInfosIndividuelles(InfosIndividuelles individuelles) {
		em.merge(individuelles);
	}

	@Override
	public InfosIndividuelles trouverParId(Long id) {
		InfosIndividuelles individuelles = em
				.find(InfosIndividuelles.class, id);
		return individuelles;
	}

	@Override
	public InfosIndividuelles trouverParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from InfosIndividuelles i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		List<InfosIndividuelles> li = null;
		try {
			li = (List<InfosIndividuelles>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li.get(li.size() - 1);
		return null;

	}

}
