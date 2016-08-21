package com.yesserp.sessionbean.paramgta.gestionrubriquepaie;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.RubriquePaie;

/**
 * Session Bean implementation class GestionRubriquePaie
 */
@Stateless
@LocalBean
public class GestionRubriquePaie implements GestionRubriquePaieLocal {

    /**
     * Default constructor. 
     */
    public GestionRubriquePaie() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="yessclever")
    EntityManager entityManager;
	@Override
	public void ajouterRubriquePaie(RubriquePaie rubriquePaie) {
		entityManager.persist(rubriquePaie);
		
	}
	@Override
	public void modifierRubriquePaie(RubriquePaie rubriquePaie) {
		entityManager.merge(rubriquePaie);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RubriquePaie> listeRubriquePaie() {
		Query query = entityManager.createQuery("select rp from RubriquePaie rb");
		return query.getResultList();
	}

}
