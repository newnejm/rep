package com.yesserp.domain.gta;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yesserp.domain.ga.Administrateur;
@Table(name="Jobscreate")
@Entity
public class Jobscreate {
	private JobsPK jobsPK;
	private Administrateur admin;
	private ParametreJobs Parametrejobs;
	private GroupeIdentity groupeIdentity;
	private Date dateCreate;
	private String statut;
	private Integer id_groupe;
	private List<PlanifJobs>planifJobs;
	

	public Jobscreate() {
		super();
	}
	
	

/*public Jobscreate(Administrateur admin, ParametreJobs parametrejobs,
			GroupeIdentity groupeIdentity, Date dateCreate, String statut) {
	this.getJobsPK().setAdminId(admin.getId_admin());
	this.getJobsPK().setParamId(parametrejobs.getId_jobs_excute());
	this.getJobsPK().setGroupeId(groupeIdentity.getId());
	this.setAdmin(admin);
	this.setExcute(parametrejobs);
	this.setGroupeIdentity(groupeIdentity);
	this.setStatut(statut);
	this.dateCreate = dateCreate;
	}*/



	public Jobscreate(Administrateur admin, ParametreJobs param_Jobs_Excute,
			Date date_create2, String statut2) {
		this.getJobsPK().setAdminId(admin.getId_admin());
		this.getJobsPK().setParamId(param_Jobs_Excute.getId_jobs_excute());
		this.setAdmin(admin);
		this.setExcute(param_Jobs_Excute);
		this.setStatut(statut2);
		this.dateCreate = date_create2;
	
	}

	@EmbeddedId
	public JobsPK getJobsPK() {
		if (jobsPK==null) {
			jobsPK=new JobsPK();
		}
		return jobsPK;
	}
	
	public void setJobsPK(JobsPK jobsPK) {
		this.jobsPK = jobsPK;
	}
	@ManyToOne
	@JoinColumn(name="admin_fk", insertable = false, updatable = false)
	public Administrateur getAdmin() {
		return admin;
	}
	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	@ManyToOne
	@JoinColumn(name="param_fk", insertable = false, updatable = false)
	public ParametreJobs getExcute() {
		return Parametrejobs;
	}
	public void setExcute(ParametreJobs Parametrejobs) {
		this.Parametrejobs = Parametrejobs;
	}
/*	@ManyToOne
	@JoinColumn(name="groupe_fk", insertable = false, updatable = false)
	public GroupeIdentity getGroupeIdentity() {
		return groupeIdentity;
	}

	public void setGroupeIdentity(GroupeIdentity groupeIdentity) {
		this.groupeIdentity = groupeIdentity;
	}*/

	public Date getDate_create() {
		return dateCreate;
	}

	public void setDate_create(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * @return the groupeIdentities
	 */


	/**
	 * @return the id_groupe
	 */
	public Integer getId_groupe() {
		return id_groupe;
	}

	/**
	 * @param id_groupe the id_groupe to set
	 */
	public void setId_groupe(Integer id_groupe) {
		this.id_groupe = id_groupe;
	}

	@Override
	public String toString() {
		return "Jobscreate [jobsPK=" + jobsPK + ", admin=" + admin
				+ ", excute=" + Parametrejobs + "]";
	}



	/**
	 * @return the planifJobs
	 */
	@ManyToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
	public List<PlanifJobs> getPlanifJobs() {
		return planifJobs;
	}



	/**
	 * @param planifJobs the planifJobs to set
	 */
	public void setPlanifJobs(List<PlanifJobs> planifJobs) {
		this.planifJobs = planifJobs;
	}







}
