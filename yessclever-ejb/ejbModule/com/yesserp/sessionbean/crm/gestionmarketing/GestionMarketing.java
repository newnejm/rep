package com.yesserp.sessionbean.crm.gestionmarketing;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.Compagne;
import com.yesserp.domain.crm.Devise;
import com.yesserp.domain.crm.Marketing;
import com.yesserp.domain.crm.StatusCompagne;
import com.yesserp.domain.crm.StatusMarketing;

/**
 * Session Bean implementation class GestionMarketing
 */
@Stateless
@LocalBean
public class GestionMarketing implements GestionMarketingLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionMarketing() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterMarketing(Marketing marketing) {
		em.persist(marketing);
	}

	@Override
	public void supprimerMarketing(Marketing marketing) {
		Marketing marketingASupprimer = em.find(Marketing.class,
				marketing.getId());
		if (marketingASupprimer != null) {
			em.remove(marketingASupprimer);

		}
	}

	@Override
	public void modifierMarketing(Marketing marketing) {
		// TODO Auto-generated method stub
		em.merge(marketing);

	}

	@Override
	public List<Marketing> AfficherTousMarketing() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT M FROM Marketing M");
		return query.getResultList();
	}

	@Override
	public Marketing afficherMarketingParId(Long id) {
		Query query = em.createQuery("select M from Marketing M where M.id = :id");
		query.setParameter("id", id);

		return (Marketing) query.getSingleResult();
	}

	public List<Compagne> FindMarketingByCompagne(Marketing marketing) {
		Query q = em.createQuery("select i from Compagne i join i.marketing c where c.id = :id");
		q.setParameter("id", marketing.getId());
		List<Compagne> collection = null;
		try {
			collection = (List<Compagne>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return collection;
	}

	@Override
	public Devise ChercherDevise(String devise) {
		Query query = em.createQuery("select d from Devise d where d.nom = :devise");
	query.setParameter("devise", devise);


		return (Devise) query.getSingleResult();
		}

	@Override
	public List<Devise> afficherDevise() {
		Query query = em.createQuery("select d from Devise d");

		List<Devise> collection = null;
		try {
			collection = (List<Devise>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return collection;

	}
	@Override
	public StatusMarketing ChercherStatusMarketing(String status) {
		Query query = em.createQuery("select t from StatusMarketing t where t.Libelle = :status");
		query.setParameter("status",status);


        return (StatusMarketing) query.getSingleResult();
	}

}
