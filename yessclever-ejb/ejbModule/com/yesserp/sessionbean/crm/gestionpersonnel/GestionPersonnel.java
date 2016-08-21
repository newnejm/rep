package com.yesserp.sessionbean.crm.gestionpersonnel;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.*;

/**
 * Session Bean implementation class GestionPersonnel
 */
@Stateless
@LocalBean
public class GestionPersonnel implements GestionPersonnelLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
    public GestionPersonnel() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public List<CommercialInterne> getListePersonnel(){
		Query query=em.createQuery("SELECT p FROM CommercialInterne p");
		return query.getResultList();
	}
    
    @Override
	public CommercialInterne Chercherpersonnel(String nompersonnel) {
		
		Query query = em.createQuery("select t from CommercialInterne t where t.nom = :nom");
		query.setParameter("nom",nompersonnel);


        return (CommercialInterne) query.getSingleResult();	
	}
}
