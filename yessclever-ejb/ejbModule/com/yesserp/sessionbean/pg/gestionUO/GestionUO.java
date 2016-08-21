package com.yesserp.sessionbean.pg.gestionUO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.pg.Societe;
import com.yesserp.domain.pg.Unite_organisationnelle;

@Stateless
@LocalBean
public class GestionUO implements  GestionUOLocal{
    public GestionUO() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
    @Override
    public void ajouterUnite_organisationnelle(Unite_organisationnelle i) {
		em.persist(i);
	}


	@Override
	public void supprimerUnite_organisationnelle(Unite_organisationnelle i) {
		
		
		i = em.merge(i);
		em.remove(i);
	
	}


	@Override
	public void modifierUnite_organisationnelle(Unite_organisationnelle i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Unite_organisationnelle> AfficherTousUnite_organisationnelle() {
		Query query = em.createQuery("SELECT c FROM Unite_organisationnelle c");
        return query.getResultList();
	}

	
	
	
	
	@Override
	public List<Unite_organisationnelle> findUnite_organisationnelleBySociete(Societe societe) {
		Query query = em
				.createQuery("SELECT c FROM Unite_organisationnelle c WHERE c.societe=:x");
		query.setParameter("x", societe);
		return query.getResultList();
		
	}
	
	
	
	
	
	
	
	
	/*
	@Override
	public List<Unite_organisationnelle> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Unite_organisationnelle i where nom = :nom");
		q.setParameter("nom",nom);
		List<Unite_organisationnelle> li=null;
		try {
			li= (List<Unite_organisationnelle>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Unite_organisationnelle> trouverParNumUnite_organisationnelle(String numUnite_organisationnelle) {
		
		Query q=em.createQuery("select from Unite_organisationnelle i where numUnite_organisationnelle = :numUnite_organisationnelle");
		q.setParameter("numUnite_organisationnelle",numUnite_organisationnelle);
		List<Unite_organisationnelle> li=null;
		try {
			li= (List<Unite_organisationnelle>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	*/
	
}
