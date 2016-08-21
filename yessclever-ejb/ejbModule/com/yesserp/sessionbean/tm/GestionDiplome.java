package com.yesserp.sessionbean.tm;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.tm.Diplome;
import com.yesserp.domain.tm.Offre;

/**
 * Session Bean implementation class GestionDiplome
 */
@Stateless
@LocalBean
public class GestionDiplome implements GestionDiplomeLocal {

    /**
     * Default constructor. 
     */
    public GestionDiplome() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager entityManager;
    

	@Override
	public void ajouterDiplome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Diplome> findDiplomesById(Offre of) {
		
	List<Diplome> ld=new ArrayList<Diplome>();	
	int id;
	for (int i=0;i<of.getListdiplome().size();i++)
	
	{
		id=of.getListdiplome().get(i).getCode();
		Query q=entityManager.createQuery("from Diplome d where d.code= :id").setParameter("id",id);
		for(int j=0;j<q.getResultList().size();j++)
		{
		 ld.add((Diplome)q.getResultList().get(j));	
		}
	}
	
    
    return ld;     
		
	}
	
	

	@Override
	public void deleteDiplome(Offre of) {
	  int code;
	  for(int i=0;i<of.getListdiplome().size();i++)
	  {
		    code=of.getListdiplome().get(i).getCode();
			entityManager.createQuery("delete from Diplome o where o.code= :code").setParameter("code",code).executeUpdate();	

	  }
		
	}

	

	
}
