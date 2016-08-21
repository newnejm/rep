package com.yesserp.sessionbean.paramgta.gestionFormuleCompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.FormuleCompteur;
import com.yesserp.domain.gtaparam.ParamClass;
import com.yesserp.domain.gtaparam.ValeurCompteur;

/**
 * Session Bean implementation class GestionFormuleCompteur
 */
@Stateless
@LocalBean
public class GestionFormuleCompteur implements GestionFormuleCompteurLocal {

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public GestionFormuleCompteur() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterFormuleCompteur(FormuleCompteur formuleCompteur) {
		// TODO Auto-generated method stub
		entityManager.persist(formuleCompteur);

	}

	@Override
	public void modifierFormuleCompteur(FormuleCompteur formuleCompteur) {
		// TODO Auto-generated method stub
		entityManager.merge(formuleCompteur);

	}

	@Override
	public FormuleCompteur findFormuleCompteurByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FormuleCompteur> listeFormuleCompteurs() {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("select cpt from FormuleCompteur cpt");
		return query.getResultList();
	}

	@Override
	public FormuleCompteur getFormuleByCompteur(Compteur cmp) {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("select f  from FormuleCompteur f inner join f.compteur c where c=:x ");
		query.setParameter("x", cmp);
		return (FormuleCompteur) query.getSingleResult();
	}

	@Override
	public FormuleCompteur getFormuleByContrat(ContratGta contratGta) {
		Query query = entityManager
				.createQuery("	select f from FormuleCompteur f inner join f.classeEmp e inner join e.contratGta c where c=:x");
		query.setParameter("x", contratGta);
		return (FormuleCompteur) query.getSingleResult();
	
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public ClasseEmp getClasseEmpByFormule(FormuleCompteur fc ) {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("	select c from ClasseEmp c  inner join c.formuleCompteur f  where f=:x");
		query.setParameter("x", fc);
		return (ClasseEmp) query.getSingleResult();
	
	}

	@Override
	public void ajouterParmClass(ParamClass paramClass) {
		
		entityManager.persist(paramClass);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ParamClass getParmByCompteur(Compteur c, Date d) {
		// TODO Auto-generated method stub
	
		Query query = entityManager
				.createQuery("	select c from ParamClass c  inner join c.formuleCompteur  f inner join f.compteur cp  where cp=:cmp and :d between f.dateEffet and f.dateFin");
		query.setParameter("d", d);
		query.setParameter("cmp", c);
		
		query.setMaxResults(1);
		List<ParamClass> results = query.getResultList();
		ParamClass foundEntity = null;
		if(!results.isEmpty()){
		   
		    foundEntity = results.get(0);
		}
		return (ParamClass) foundEntity;
	
		}

}
