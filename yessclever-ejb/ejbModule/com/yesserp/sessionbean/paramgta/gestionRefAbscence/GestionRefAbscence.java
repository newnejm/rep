package com.yesserp.sessionbean.paramgta.gestionRefAbscence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.RefAbscence;




@Stateless
@LocalBean
public class GestionRefAbscence implements GestionRefAbscenceLocal{
	

	
    public GestionRefAbscence() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterRefAbscence(RefAbscence i) {
		em.persist(i);
	}


	@Override
	public void supprimerRefAbscence(RefAbscence i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierRefAbscence(RefAbscence i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<RefAbscence> AfficherTousRefAbscence() {
		
		Query query = em.createQuery("SELECT c FROM RefAbscence c");
        return query.getResultList();
	}

	/*

	@Override
	public List<RefAbscence> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from RefAbscence i where nom = :nom");
		q.setParameter("nom",nom);
		List<RefAbscence> li=null;
		try {
			li= (List<RefAbscence>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<RefAbscence> trouverParNumRefAbscence(String numRefAbscence) {
		
		Query q=em.createQuery("select from RefAbscence i where numRefAbscence = :numRefAbscence");
		q.setParameter("numRefAbscence",numRefAbscence);
		List<RefAbscence> li=null;
		try {
			li= (List<RefAbscence>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	@Override
	public List<RefAbscence> findRefAbscenceByDescJourneeType(DescJourneeType descJourneeType){
		Query query = em
				.createQuery("select p from RefAbscence p where p.descJourneeType = :dt");
		query.setParameter("dt", descJourneeType);
		return query.getResultList();
	}

	
}
