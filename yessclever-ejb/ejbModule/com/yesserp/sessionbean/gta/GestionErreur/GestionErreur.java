package com.yesserp.sessionbean.gta.GestionErreur;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.gta.Erreur;

/**
 * Session Bean implementation class GestionErreur
 */
@Stateless
@LocalBean
public class GestionErreur implements GestionErreurLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public GestionErreur() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterErreur(Erreur erreur) {
		entityManager.persist(erreur);
		
	}

	@Override
	public Erreur trouverErreurParcode(String code) {
		Query query = entityManager
				.createQuery("select c from Erreur c where c.code=:x");
		query.setParameter("x", code);
		return (Erreur) query.getSingleResult();
	}

	@Override
	public void modifierErreur(Erreur erreur) {
		entityManager.merge(erreur);
		
	}

	@Override
	public void supprimerErreur(Erreur erreur) {
		entityManager.remove(entityManager.merge(erreur));
		
	}

	@Override
	public List<Erreur> findAll() {
		Query query = entityManager.createQuery("select o from Erreur o ");
		return query.getResultList();
	}

}
