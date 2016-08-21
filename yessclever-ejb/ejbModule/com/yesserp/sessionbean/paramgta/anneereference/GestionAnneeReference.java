package com.yesserp.sessionbean.paramgta.anneereference;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.AnneeReference;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionAnneeReference implements GestionAnneeReferenceLocal {

	/**
	 * Default constructor.
	 */
	public GestionAnneeReference() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutAnneeReference(AnneeReference anneeReference) {
		entityManager.persist(anneeReference);

	}

	@Override
	public void supprimerAnneeReference(AnneeReference anneeReference) {
		entityManager.remove(entityManager.merge(anneeReference));

	}

	@Override
	public void modifierAnneeReference(AnneeReference anneeReference) {
		entityManager.merge(anneeReference);

	}

	@Override
	public List<AnneeReference> listerAnneeReference() {
		Query query = entityManager.createQuery("SELECT l FROM AnneeReference l");
		return query.getResultList();
	}

	@Override
	public AnneeReference findAnneeReferenceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
