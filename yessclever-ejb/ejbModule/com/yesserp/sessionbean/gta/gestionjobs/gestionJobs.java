package com.yesserp.sessionbean.gta.gestionjobs;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.access.Assignment;
import com.yesserp.domain.ga.Administrateur;
import com.yesserp.domain.gta.Asso_Jobs_paramJobs;
import com.yesserp.domain.gta.Erreur;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.Jobs;
import com.yesserp.domain.gta.Jobscreate;
import com.yesserp.domain.gta.ParametreJobs;

@Stateless
@LocalBean
public class gestionJobs implements gestionJobsLocal {

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void addJobs(Jobs jobs) {
		entityManager.persist(jobs);

	}

	@Override
	public void deleteJobs(Jobs jobs) {
		entityManager.merge(jobs);
	}

	@Override
	public void modifierJobs(Jobs jobs) {
		entityManager.merge(jobs);

	}

	@Override
	public void addnewJobs(Jobs jobs, ParametreJobs param_Jobs_Excute) {
		Query query = entityManager
				.createNativeQuery("insert into Asso_Jobs_paramJobs (id_job,id_job_excute)"
						+ "values(?,?)");
		query.setParameter(1, jobs.getId_jobs());
		query.setParameter(2, param_Jobs_Excute.getId_jobs_excute());
		
		query.executeUpdate();

	}
	@Override
	public List<Jobscreate> listeJobs() {
		Query query = entityManager.createQuery("select imp from Jobscreate imp");
		return query.getResultList();
	}

	@Override
	public void addparam(ParametreJobs param_Jobs_Excute) {
		entityManager.persist(param_Jobs_Excute);
		
	}

	@Override
	public void addnewJobs(Administrateur admin,
			ParametreJobs param_Jobs_Excute, Date date_create,
			String Statut,int gp_id) {
		/*Query query = entityManager
				.createNativeQuery("insert into Jobscreate (id_admin,id_param_jobs,date_create,statut,id_groupe)"
						+ "values(?,?,?,?,?)");
		query.setParameter(1, admin.getId_admin());
		query.setParameter(2, param_Jobs_Excute.getId_jobs_excute());
		query.setParameter(3, date_create);
		query.setParameter(4, Statut);
		query.setParameter(5, gp_id);
		
		query.executeUpdate();*/
		Jobscreate jobscreate=new Jobscreate( admin,
				 param_Jobs_Excute,  date_create,
				 Statut);
		Jobscreate jobscreate2=new Jobscreate(admin, param_Jobs_Excute, date_create, Statut);
		entityManager.persist(jobscreate);
		

		
	}

	@Override
	public void addAdmin(Administrateur admin) {
		entityManager.persist(admin);
		
	}

	@Override
	public Administrateur trouveradminbyid(int code) {
		Query query = entityManager
				.createQuery("select c from Administrateur c where c.id_admin=:x");
		query.setParameter("x", code);
		return (Administrateur) query.getSingleResult();
	}

	@Override
	public void modifierJobscreate(Jobscreate jobscreate) {
		entityManager.merge(jobscreate);
		
	}
	@Override
	public void ajouterJobscreate(Jobscreate jobscreate) {
		entityManager.persist(jobscreate);
		
	}





}
