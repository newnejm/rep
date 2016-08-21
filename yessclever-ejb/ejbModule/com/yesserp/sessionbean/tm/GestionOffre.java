package com.yesserp.sessionbean.tm;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.tm.Competence;
import com.yesserp.domain.tm.Diplome;
import com.yesserp.domain.tm.Offre;
import com.yesserp.domain.tm.Profile;

/**
 * Session Bean implementation class GestionOffre
 */
@Stateless
@LocalBean
public class GestionOffre implements GestionOffreLocal {

    /**
     * Default constructor. 
     */
    public GestionOffre() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
    EntityManager entityManager;
    
	

	@Override
	public List<Offre> findAllOffress() {
		
    Query q=entityManager.createQuery("from Offre");  
    return q.getResultList();
    

	}



	@Override
	public void ajouterOffre(Offre of,List<Diplome> ld,List<Profile> lp,List<Competence> lc)
	{ 
				
	   entityManager.persist(of);
	   
	   for(int i=0;i<ld.size();i++)
	   {
		   entityManager.persist(ld.get(i));  
	   }
	   
	   
	   for(int i=0;i<lp.size();i++)
	   {	   
	   entityManager.persist(lp.get(i));
	   }
       
	   for(int i=0;i<lc.size();i++)
	   {entityManager.persist(lc.get(i));}
	   
	
	}



	@Override
	public void ajouter(Offre of,List<Diplome> ld, List<Profile> lp,List<Competence> lc) {
		
	 //insertion diplome	
		for(int i=0;i<ld.size();i++)
		   {
			Query query = entityManager
					.createNativeQuery("insert into tm_offrrf_tm_diplrh (listoffre_code,listdiplome_code)"
							+ " values(?,?)");
			
			query.setParameter(1,of.getCode());
			query.setParameter(2,ld.get(i).getCode());
			
			query.executeUpdate();
			
		   }
		
		
		//insertion profile
		for (int i=0;i<lp.size();i++)
		{
		
		Query query2 = entityManager
				.createNativeQuery("insert into tm_offrrf_tm_profrh (listoffre_code,listprofile_code)"
						+ " values(?,?)");
		
		query2.setParameter(1,of.getCode());
		query2.setParameter(2,lp.get(i).getCode());
		
		query2.executeUpdate();
		
		}
		
		//insertion competence
		for (int i=0;i<lc.size();i++)
		{
		
		Query query2 = entityManager
				.createNativeQuery("insert into tm_offrrf_tm_comp (listoffre_code,listcompetence_code)"
						+ " values(?,?)");
		
		query2.setParameter(1,of.getCode());
		query2.setParameter(2,lc.get(i).getCode());
		
		query2.executeUpdate();
		
		}		
				
	}



	@Override
	public void deleteOffre(Offre of) {
		
		entityManager.createQuery("delete from Offre o where o.code= :code").setParameter("code",of.getCode()).executeUpdate();	
		
	}



	@Override
	public void updateOffre(Offre of)
	{
	  
	  Query q= entityManager.createQuery("update Offre o set o.valide=:rep where o.code= :code");
	  q.setParameter("rep","Mail envoyé");
	  q.setParameter("code",of.getCode());
	  q.executeUpdate();
	  
		
	}


	
	
	
	
	
	

}
