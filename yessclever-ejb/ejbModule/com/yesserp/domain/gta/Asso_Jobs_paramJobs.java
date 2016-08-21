package com.yesserp.domain.gta;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Asso_Jobs_paramJobs {
	private Asso_Jobs_paramJobsPK asso_Jobs_paramJobsPK;
	private Jobs jobs;
	private ParametreJobs excute;
	
	public Asso_Jobs_paramJobs() {
	
	}
	public Asso_Jobs_paramJobs(Jobs jobs, ParametreJobs excute) {
		this.getAsso_Jobs_paramJobsPK().setId_job(jobs.getId_jobs());
		this.getAsso_Jobs_paramJobsPK().setId_job_excute(excute.getId_jobs_excute());
		/*this.jobs = jobs;
		this.excute = excute;*/
	}
@EmbeddedId
	public Asso_Jobs_paramJobsPK getAsso_Jobs_paramJobsPK() {
		if(asso_Jobs_paramJobsPK==null){
		Asso_Jobs_paramJobsPK asso_Jobs_paramJobsPK=new Asso_Jobs_paramJobsPK();
		
		}return 
				asso_Jobs_paramJobsPK;
	}

	public void setAsso_Jobs_paramJobsPK(Asso_Jobs_paramJobsPK asso_Jobs_paramJobsPK) {
		this.asso_Jobs_paramJobsPK = asso_Jobs_paramJobsPK;
	}
	
	


@ManyToOne
	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	@ManyToOne
	public ParametreJobs getExcute() {
		return excute;
	}

	public void setExcute(ParametreJobs excute) {
		this.excute = excute;
	}
	
	

}
