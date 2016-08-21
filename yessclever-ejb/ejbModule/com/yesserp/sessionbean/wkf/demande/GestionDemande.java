package com.yesserp.sessionbean.wkf.demande;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.wkf.Demande;
import com.yesserp.sessionbean.wkf.demande.GestionDemandeLocal;

@Stateless
@LocalBean
public class GestionDemande implements GestionDemandeLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionDemande() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterDemande(Demande demande) {

		em.persist(demande);
	}

	@Override
	public void supprimerDemande(Demande demande) {

		em.remove(em.merge(demande));

	}

	@Override
	public void modifierDemande(Demande demande) {

		em.merge(demande);

	}

	@Override
	public Demande trouverParId(Long id) {

		return em.find(Demande.class, id);
	}

	

}
