package com.yesserp.sessionbean.gta.gestiondatecalculGta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.DateCalculGta;

/**
 * Session Bean implementation class GestionDateCalcul
 */
@Stateless
@LocalBean
public class GestionDateCalcul implements GestionDateCalculLocal {

    /**
     * Default constructor. 
     */
    public GestionDateCalcul() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext
	EntityManager entityManager;


	@Override
	public void ajouterDateCalculGta(DateCalculGta dateCalculGta) {
		entityManager.persist(dateCalculGta);
		
	}

	@Override
	public void supprimerDateCalculGta(DateCalculGta dateCalculGta) {
		entityManager.remove(entityManager.merge(dateCalculGta));
		
	}

	@Override
	public void modifierDateCalculGta(DateCalculGta dateCalculGta) {
		entityManager.merge(dateCalculGta);
		
	}

	@Override
	public DateCalculGta findDateCalculGtaById(int id) {
		return entityManager.find(DateCalculGta.class,id);
	}

	@Override
	public List<DateCalculGta> findAllDateCalculGta() {
		Query query = entityManager
				.createQuery("select d from DateCalculGta d ");
		return query.getResultList();
		
	}

}
