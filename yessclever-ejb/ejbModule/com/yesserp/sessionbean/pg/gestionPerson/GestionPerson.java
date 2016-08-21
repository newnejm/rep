package com.yesserp.sessionbean.pg.gestionPerson;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Person;


@Stateless
@LocalBean
public class GestionPerson implements GestionPersonLocal{
	

	
    public GestionPerson() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterPerson(Person i) {
		em.persist(i);
	}


	@Override
	public void supprimerPerson(Person i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierPerson(Person i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Person> AfficherTousPerson() {
		
		Query query = em.createQuery("SELECT c FROM Person c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Person> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Person i where nom = :nom");
		q.setParameter("nom",nom);
		List<Person> li=null;
		try {
			li= (List<Person>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Person> trouverParNumPerson(String numPerson) {
		
		Query q=em.createQuery("select from Person i where numPerson = :numPerson");
		q.setParameter("numPerson",numPerson);
		List<Person> li=null;
		try {
			li= (List<Person>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
