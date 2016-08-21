package com.yesserp.sessionbean.paramgta.gestiongroupeselect;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.List_Identity;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.Imputation;

/**
 * Session Bean implementation class gestionGroupeSelect
 */
@Stateless
@LocalBean
public class gestionGroupeSelect implements gestionGroupeSelectLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;
	
    public gestionGroupeSelect() {
    	
    }

	@Override
	public void ajouterGroupeSelect(GroupeIdentity groupeSelect) {
		try{
		entityManager.persist(groupeSelect);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierGroupeSelect(GroupeIdentity groupeSelect) {
		try {entityManager.merge(groupeSelect);}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerGroupeSelect(GroupeIdentity groupeSelect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GroupeIdentity findGroupeSelectByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupeIdentity findGroupeSelecteById(int id) {
		// TODO Auto-generated method stub
				return null;
	}
	@Override
	public void ajouterListeidentity(List_Identity list_Identity,
			List<Identite> identites) {
		try {
			ArrayList<Identite> teArrayList = (ArrayList<Identite>) identites;
			for (int i = 0; i < teArrayList.size(); i++) {
				Identite identite = teArrayList.get(i);
				identite.setListIdentity(list_Identity);
				//affectation.setEmbauche(embauche);
			entityManager.persist(identite);
					System.out.println("lajout liste identite est se fait avec succe");
					
			
					
					
			
				//em.persist(affectation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public List<Identite> findidentiteByGroupeIdentity(
			GroupeIdentity groupeIdentity) {
		Query query = entityManager
				.createQuery("SELECT imp FROM Identite imp WHERE :groupeIdentity MEMBER OF imp.groupeIdentity");
		query.setParameter("groupeIdentity", groupeIdentity);
		return query.getResultList();
	}
	@Override
	public List<GroupeIdentity> listeGroupeSelect() {
		Query query = entityManager.createQuery("select imp from GroupeIdentity imp");
		return query.getResultList();
	}

	@Override
	public List<GroupeIdentity> findListGroupeSelecteById(int id) {
		Query query = entityManager
				.createQuery("SELECT gi FROM GroupeIdentity gi WHERE gi.id=:x");
		
		query.setParameter("x", id);
		return query.getResultList();
	}

	@Override
	public void ajouterListToGroupe(List_Identity list_Identities,
			GroupeIdentity groupeIdentity) {
		
			try {
			groupeIdentity.setGroupelistIdentity(list_Identities);
				//contrat.setEmbauche(embauche);
			entityManager.persist(groupeIdentity);
				//em.persist(contrat);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	@Override
	public void ajouterListToGroupe2(List_Identity list_Identities) {
		
			try {
				
			entityManager.persist(list_Identities);
				//em.persist(contrat);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	@Override
	public void ajouterListToGroupe2(List_Identity list_Identities,
			List<Identite> identites) {
		// TODO Auto-generated method stub
		
	}
		
	

/*	@Override
	public void ajouterListeidentitytogroupe(GroupeIdentity groupeIdentity,
			List<List_Identity> list_Identities) {
		try {
			ArrayList<List_Identity> teArrayList = (ArrayList<List_Identity>) list_Identities;
			for (int i = 0; i < teArrayList.size(); i++) {
				List_Identity identite = teArrayList.get(i);
				identite
				//affectation.setEmbauche(embauche);
				entityManager.persist(identite);
				//em.persist(affectation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

}
