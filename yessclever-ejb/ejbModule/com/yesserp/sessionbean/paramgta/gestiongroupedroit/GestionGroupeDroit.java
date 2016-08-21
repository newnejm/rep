package com.yesserp.sessionbean.paramgta.gestiongroupedroit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gtaparam.GroupeDroit;

/**
 * Session Bean implementation class GroupeDroit
 */
@Stateless
@LocalBean
public class GestionGroupeDroit implements GestionGroupeDroitLocal {

	/**
	 * Default constructor.
	 */
	public GestionGroupeDroit()
	{
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterGroupeDroit(GroupeDroit groupeDroit) 
	{
	
		entityManager.persist(groupeDroit);
	}

	@Override
	public void modifierGroupeDroit(GroupeDroit groupeDroit) 
	{
		entityManager.merge(groupeDroit);

	}

}
