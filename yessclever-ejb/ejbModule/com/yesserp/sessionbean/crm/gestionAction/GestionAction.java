package com.yesserp.sessionbean.crm.gestionAction;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.Action;
import com.yesserp.domain.crm.SuivieAction;
import com.yesserp.domain.crm.TypeAction;
import com.yesserp.domain.crm.TypeCompagne;

/**
 * Session Bean implementation class GestionAction
 */
@Stateless
@LocalBean
public class GestionAction  implements GestionActionLocal{

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
    public GestionAction() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	  public void ajouterAction (Action action)
	  {
		  em.persist(action);
	  }
    
    @Override
	  public void ajouterTypeAction(TypeAction type)
	  {
    
		  em.persist(type);
	  }

	  @Override
	  public void supprimerAction(Action action)
	  {
			Action actionASupprimer = em.find(Action.class, action.getId());
	        if (actionASupprimer != null) 
	        {
	              em.remove(actionASupprimer);
	       
	        } 
	  }

		@Override
	  public void modifierAction(Action action)
	  {
			Action actionAModifier = em.find(Action.class, action.getId());
	        if (actionAModifier != null) 
	        	
	        {
			em.merge(actionAModifier);
			}
	  }

		@Override
		public List<Action> AfficherTousAction()
		{
			Query query = em.createQuery("select A FROM Action A");
	        return query.getResultList();
		}
		@Override
		public Action afficherActionParId(Long id)
		{
		    Action actionChercher= new Action();
            actionChercher.setId(id);
	       return em.find(Action.class, actionChercher.getId());
		}
		@Override
		public Action afficherActionParDescription(String description)
		{
			
			Query query = em.createQuery("select A from Action A where A.description = :description");
			query.setParameter("description",description);
	       return (Action) query.getSingleResult();	
		}
		@Override
		public List<SuivieAction> FindActionBySuivie(Action action)
		{
			Query q=em.createQuery("select i from SuivieAction i  join i.action c where c.id = :id");
			q.setParameter("id",action.getId());
			List<SuivieAction> collection=new ArrayList<SuivieAction>();
			try {
				collection= (List<SuivieAction>) q.getResultList();
			} catch (Exception e) {
				// TODO: handle exception
			}		
			return collection;
		}
		
		@Override
		public TypeAction ChercherTypeAction(String type) {
			Query query = em.createQuery("select t from TypeAction t where t.nom = :type");
			query.setParameter("type",type);


	        return (TypeAction) query.getSingleResult();
		}
		@Override
		public List<TypeAction> getTypes() {
			// TODO Auto-generated method stub
			Query query = em.createQuery("select t from TypeAction t");
			List<TypeAction> list = new ArrayList<TypeAction>();
			try {
				
				list= query.getResultList();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
			
		}
}
