package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.access.Habilitation;


/**
 * Session Bean implementation class HabilitationService
 */
@Stateless
public class HabilitationService implements HabilitationServiceRemote, HabilitationServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public HabilitationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creeHabilitation(Habilitation habilitation) {
		
		em.persist(habilitation);
		
	}

	@Override
	public void modifierHabilitation(Habilitation habilitation) {
		
		em.merge(habilitation);
		
	}

	@Override
	public void supprimerHabilitation(Habilitation habilitation) {
		
		em.remove(em.merge(habilitation));
		
	}

	@Override
	public Habilitation trouverHabilitationById(int id) {
		// TODO Auto-generated method stub
		return em.find(Habilitation.class, id);
	}

	@Override
	public List<Habilitation> listHabilitations() {
		// TODO Auto-generated method stub
		return em.createQuery("select h from Habilitation h", Habilitation.class).getResultList();

	}

}
