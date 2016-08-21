package com.yesserp.sessionbean.tm;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import com.yesserp.domain.tm.Offre;
import com.yesserp.domain.tm.Profile;

/**
 * Session Bean implementation class GestionProfile
 */
@Stateless
@LocalBean
public class GestionProfile implements GestionProfileLocal {

    /**
     * Default constructor. 
     */
    public GestionProfile() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager entityManager;
    

	@Override
	public void ajouterProfile() {
		// TODO Auto-generated method stub
		
	}

	

	
	@Override
	public List<Profile> findProfilesById(Offre of) {
		
		
		List<Profile> ld=new ArrayList<Profile>();	
		int id;
		for (int i=0;i<of.getListprofile().size();i++)
		
		{
			id=of.getListprofile().get(i).getCode();
			Query q=entityManager.createQuery("from Profile d where d.code= :id").setParameter("id",id);  

			for(int j=0;j<q.getResultList().size();j++)
			{
			 ld.add((Profile)q.getResultList().get(j));	
			}
		}
		
	    
	    return ld; 
		
		
		
	}




	@Override
	public void deleteProfile(Offre of) {
		int code;
		for (int i=0;i<of.getListprofile().size();i++)		
		{
			code=of.getListprofile().get(i).getCode();
			entityManager.createQuery("delete from Profile o where o.code= :code").setParameter("code",code).executeUpdate();	

			
		}
		
		
	}

}
