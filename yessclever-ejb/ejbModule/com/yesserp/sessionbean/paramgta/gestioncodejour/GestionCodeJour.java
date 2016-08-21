package com.yesserp.sessionbean.paramgta.gestioncodejour;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.Filtre;

/**
 * Session Bean implementation class GestionCodeJour
 */
@Stateless
@LocalBean
public class GestionCodeJour implements GestionCodeJourLocal {

	/**
	 * Default constructor.
	 */
	public GestionCodeJour() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterCodeJour(CodeJour codeJour) {

		entityManager.persist(codeJour);

	}

	@Override
	public void modifierCodeJour(CodeJour codeJour) {
		entityManager.merge(codeJour);

	}

	@Override
	public void supprimerCodeJour(CodeJour codeJour) {
		entityManager.remove(entityManager.merge(codeJour));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeJour> listeCodeJours() {
		Query query = entityManager.createQuery("SELECT cj FROM CodeJour cj order by idcj");
		return query.getResultList();
	}

	@Override
	public CodeJour findCodeJourByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT cj FROM CodeJour cj WHERE cj.codecj=:x");
		query.setParameter("x", code);
		return (CodeJour) query.getSingleResult();
	}

	@Override
	public CodeJour findCodeJourById(int id) {
		return entityManager.find(CodeJour.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCodeJourFromFilter(Filtre f) {
		Query query = entityManager
				.createQuery("select a.idcj from CodeJour a inner join a.filtres f where f=:x");
		query.setParameter("x", f);
		return query.getResultList();
		
	}

}
