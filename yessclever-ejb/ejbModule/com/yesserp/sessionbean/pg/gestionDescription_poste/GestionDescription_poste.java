package com.yesserp.sessionbean.pg.gestionDescription_poste;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Description_poste;


@Stateless
@LocalBean
public class GestionDescription_poste implements GestionDescription_posteLocal{
	

	
    public GestionDescription_poste() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterDescription_poste(Description_poste i) {
		em.persist(i);
	}


	@Override
	public void supprimerDescription_poste(Description_poste i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierDescription_poste(Description_poste i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Description_poste> AfficherTousDescription_poste() {
		
		Query query = em.createQuery("SELECT c FROM Description_poste c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Description_poste> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Description_poste i where nom = :nom");
		q.setParameter("nom",nom);
		List<Description_poste> li=null;
		try {
			li= (List<Description_poste>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Description_poste> trouverParNumDescription_poste(String numDescription_poste) {
		
		Query q=em.createQuery("select from Description_poste i where numDescription_poste = :numDescription_poste");
		q.setParameter("numDescription_poste",numDescription_poste);
		List<Description_poste> li=null;
		try {
			li= (List<Description_poste>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
