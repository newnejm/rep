package com.yesserp.sessionbean.tm.gestiondemandeformation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.tm.DemandeFormation;

/**
 * Session Bean implementation class GestionDemandeFomrmation
 */
@Stateless
@LocalBean
public class GestionDemandeFormation implements GestionDemandeFormationLocal {

    /**
     * Default constructor. 
     */
    public GestionDemandeFormation() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager entityManager;

	@Override
	public List<DemandeFormation> findDemandesById(Identite iden) {
		
		List<DemandeFormation> ld=new ArrayList<DemandeFormation>();
		int id;
		for (int i=0;i<iden.getDemandes().size();i++)
		{id=iden.getDemandes().get(i).getCode();
		Query q=entityManager.createQuery("from DemandeFormation i where i.code= :id").setParameter("id",id);
		for(int j=0;j<q.getResultList().size();j++)
		{
		 ld.add((DemandeFormation)q.getResultList().get(j));	
		}	
		
		
		}
				
		
		return ld;
	}

	@Override
	public void ajouterDemande(Identite iden, List<DemandeFormation> df) {
		for(int i=0;i<df.size();i++)
		   {
			   entityManager.persist(df.get(i));  
		   }
		   
		
		
		
		
	}

	@Override
	public void ajouter(Identite iden, List<DemandeFormation> df) {
		for(int i=0;i<df.size();i++)
		   {
			
			Query query = entityManager
					.createNativeQuery("insert into ga_identite_tm_dforrh (identites_numedoss,demandes_code)"
							+ " values(?,?)");
			
			query.setParameter(1,iden.getNumedoss());
			query.setParameter(2,df.get(i).getCode());
			
			query.executeUpdate();
			
			
			
			
			
			
			
			
			
		   }
		
	}

	@Override
	public void deleteDemande(Identite iden)
	{
		int code;
		  for(int i=0;i<iden.getDemandes().size();i++)
		  {
			    code=iden.getDemandes().get(i).getCode();
				entityManager.createQuery("delete from DemandeFormation o where o.code= :code").setParameter("code",code).executeUpdate();	

		  }
			
		
	}

	@Override
	public void updateFormation(Identite iden) {
		
		for(int i=0;i<iden.getDemandes().size();i++)
		{	
		Query q= entityManager.createQuery("update DemandeFormation o set o.reponse=:rep where o.code= :code");
		q.setParameter("rep","Mail envoyé");
		q.setParameter("code",iden.getDemandes().get(i).getCode());
		q.executeUpdate();
		}
		
		
	}
    
    
    

}
