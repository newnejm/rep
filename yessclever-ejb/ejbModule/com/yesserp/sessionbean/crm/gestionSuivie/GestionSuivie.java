package com.yesserp.sessionbean.crm.gestionSuivie;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.SuivieAction;

/**
 * Session Bean implementation class GestionSuivi
 */
@Stateless
@LocalBean
public class GestionSuivie implements GestionSuivieLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionSuivie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterSuivi(SuivieAction suivi) {
		em.persist(suivi);
	}

	@Override
	public void supprimerSuivi(SuivieAction suivi) {
		SuivieAction SuiviASupprimer = em.find(SuivieAction.class, suivi.getId());
		if (SuiviASupprimer != null) {
			em.remove(SuiviASupprimer);

		}
	}

	@Override
	public void modifierSuivi(SuivieAction suivi) {
		SuivieAction SuiviAModifier = em.find(SuivieAction.class, suivi.getId());
		if (SuiviAModifier != null)

		{
			em.merge(SuiviAModifier);
		}
	}

	@Override
	public List<SuivieAction> AfficherTousSuivie() {
		Query query = em.createQuery("select S FROM Suivie S");
		return query.getResultList();
	}

	@Override
	public SuivieAction afficherSuivieParId(Long id) {
		SuivieAction SuiviChercher = new SuivieAction();
		SuiviChercher.setId(id);
		return em.find(SuivieAction.class, SuiviChercher.getId());
	}

	@Override
	public SuivieAction afficherSuivieParDescription(String description) {
		Query query = em
				.createQuery("select S from Action S where S.description = :description");
		query.setParameter("description", description);
		return (SuivieAction) query.getSingleResult();
	}

}
