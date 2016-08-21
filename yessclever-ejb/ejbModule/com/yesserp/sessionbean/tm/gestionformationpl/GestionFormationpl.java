package com.yesserp.sessionbean.tm.gestionformationpl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.tm.FormationPl;

/**
 * Session Bean implementation class GestionFormationpl
 */
@Stateless
public class GestionFormationpl implements GestionFormationplLocal {

    /**
     * Default constructor. 
     */
    public GestionFormationpl() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager entityManager;

	@Override
	public List<FormationPl> findAll() {
		Query query = entityManager.createQuery("from FormationPl");
		return query.getResultList();
	}

	@Override
	public void updateFormation(String titre, Date debut, Date fin,
			String nvtitre, Date nvdebut, Date nvfin,String heuredebut,String heurefin) {
		Query q= entityManager.createQuery("update FormationPl o set o.libelle=:nvtitre,o.debut=:nvdebut,o.fin=:nvfin,o.heuredebut=:heuredebut,o.heurefin=:heurefin where o.libelle= :titre and o.debut=:debut and o.fin=:fin");
		q.setParameter("nvtitre",nvtitre);
		q.setParameter("nvdebut",nvdebut);
		q.setParameter("nvfin",nvfin);
		q.setParameter("heuredebut",heuredebut);
		q.setParameter("heurefin",heurefin);
		
		
		q.setParameter("titre",titre);
		q.setParameter("debut",debut);
		q.setParameter("fin",fin);
		q.executeUpdate();
		
		
		
	}

	@Override
	public void addFormation(FormationPl formation) {
		entityManager.persist(formation);
		
	}

	@Override
	public Identite findIdentite(String titre, Date debut, Date fin) {
		
				
		//Query q= entityManager.createQuery(" from FormationPl o where o.libelle= :titre and o.debut= :debut and o.fin= :fin ");
		Query q= entityManager.createQuery(" from FormationPl o where o.libelle= :titre ");
		q.setParameter("titre",titre);
		//q.setParameter("debut",debut);
		//q.setParameter("fin",fin);
    
	
		return ((FormationPl) q.getSingleResult()).getIdentite();
	}

	@Override
	public FormationPl findById(String titre, Date debut, Date fin) {
		
		
		
		Query q= entityManager.createQuery(" from FormationPl o where o.libelle= :titre and o.debut= :debut and o.fin= :fin");
		q.setParameter("titre",titre);
		q.setParameter("debut",debut);
		q.setParameter("fin",fin);
		return ((FormationPl) q.getSingleResult());
	}

	

}
