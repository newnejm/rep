package com.yesserp.sessionbean.gf.demandeFrais;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gf.DemandeFrais;

/**
 * Session Bean implementation class gestionDemandeFrais
 */
@Stateless
@LocalBean
public class gestionDemandeFrais implements gestionDemandeFraisLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public gestionDemandeFrais() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterDemandeFrais(DemandeFrais demandeFrais) {
		entityManager.persist(demandeFrais);

	}

	@Override
	public void modifierDemandeFrais(DemandeFrais demandeFrais) {
		entityManager.merge(demandeFrais);

	}

	@Override
	public void supprimerDemandeFrais(DemandeFrais demandeFrais) {
		entityManager.remove(entityManager.merge(demandeFrais));

	}

	@Override
	public DemandeFrais findById(Long id) {
		return entityManager.find(DemandeFrais.class, id);
	}

	@Override
	public List<DemandeFrais> findAll() {
		Query query = entityManager
				.createQuery(" select d from DemandeFrais d");
		return query.getResultList();
	}

	@Override
	public List<DemandeFrais> findByEtat(String etat) {
		Query query = entityManager
				.createQuery("select d from DemandeFrais d where etatDemande LIKE :etat");
		query.setParameter("etat", etat);

		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<DemandeFrais> findByIdentite(Identite identite) {
		Query query = entityManager
				.createQuery("select d from DemandeFrais d join d.identite i where i.numedoss = :numedoss");
		query.setParameter("numedoss", identite.getNumedoss());
		List<DemandeFrais> demandesFrais = null;
		try {
			demandesFrais = (List<DemandeFrais>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (demandesFrais.size() > 0)
			return demandesFrais;
		return null;
	}

}
