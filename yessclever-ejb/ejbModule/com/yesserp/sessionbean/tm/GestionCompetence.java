package com.yesserp.sessionbean.tm;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.tm.Competence;
import com.yesserp.domain.tm.Offre;


/**
 * Session Bean implementation class GestionCompetence
 */
@Stateless
@LocalBean
public class GestionCompetence implements GestionCompetenceLocal {

    /**
     * Default constructor. 
     */
    public GestionCompetence() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager entityManager;
    
    
	@Override
	public void ajouterCompetence() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Competence> findCompetencesById(Offre of) {
		List<Competence> lc=new ArrayList<Competence>();	
		int id;
		
		for (int i=0;i<of.getListcompetence().size();i++)
			
		{ id=of.getListcompetence().get(i).getCode();
		  Query q=entityManager.createQuery("from Competence d where d.code= :id").setParameter("id",id);  
		  for(int j=0;j<q.getResultList().size();j++)
			{
			 lc.add((Competence)q.getResultList().get(j));	
			}	
			
			
		}
		
		return lc;
		
		
		
	}

	@Override
	public void deleteCompetence(Offre of) {
		
		
		int code;
		for (int i=0;i<of.getListcompetence().size();i++)		
		{
			code=of.getListcompetence().get(i).getCode();
			entityManager.createQuery("delete from Competence o where o.code= :code").setParameter("code",code).executeUpdate();	

			
		}
		
		
		
		
		
		
		
		
		
	}

}
