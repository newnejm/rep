package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Param_Jobs_Excute
 *
 */
@Entity
@Table(name = "parametreJobs")
public class ParametreJobs implements Serializable {

	   

	private int parametreJobsid;
	private String typeAction;
	private String mailDenvoi;
	private String staut;
	private Date dateJobs;
	private Date heureDebut;
	private List<Jobs>paramjobs;
	private List<Asso_Jobs_paramJobs> asso_Jobs_paramJobs;
	private List<Jobscreate>jobscreates;
	private static final long serialVersionUID = 1L;

	public ParametreJobs() {
		super();
	}  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_jobs_excute() {
		return this.parametreJobsid;
	}

	public void setId_jobs_excute(int parametreJobsid) {
		this.parametreJobsid = parametreJobsid;
	}

	public String getType_action() {
		return this.typeAction;
	}

	public void setType_action(String type_action) {
		this.typeAction = type_action;
	}   
	public String getMail_envoi() {
		return this.mailDenvoi;
	}

	public void setMail_envoi(String mailDenvoi) {
		this.mailDenvoi = mailDenvoi;
	}   
	public String getStaut() {
		return this.staut;
	}

	public void setStaut(String staut) {
		this.staut = staut;
	}
	/**
	 * @return the paramjobs
	 */
	@ManyToMany(mappedBy="paramexcutes")
	public List<Jobs> getParamjobs() {
		return paramjobs;
	}

	public void setParamjobs(List<Jobs> paramjobs) {
		this.paramjobs = paramjobs;
	}

	public Date getDateJobs() {
		return dateJobs;
	}
	/**
	 * @param dateJobs the dateJobs to set
	 */
	public void setDateJobs(Date dateJobs) {
		this.dateJobs = dateJobs;
	}
	@OneToMany
	public List<Asso_Jobs_paramJobs> getAsso_Jobs_paramJobs() {
		return asso_Jobs_paramJobs;
	}
	public void setAsso_Jobs_paramJobs(List<Asso_Jobs_paramJobs> asso_Jobs_paramJobs) {
		this.asso_Jobs_paramJobs = asso_Jobs_paramJobs;
	}
	/**
	 * @return the jobscreates
	 */
	@OneToMany(mappedBy="excute")
	public List<Jobscreate> getJobscreates() {
		return jobscreates;
	}
	/**
	 * @param jobscreates the jobscreates to set
	 */
	public void setJobscreates(List<Jobscreate> jobscreates) {
		this.jobscreates = jobscreates;
	}
	/**
	 * @return the heure_debut
	 */
	/**
	 * @return the heure_debut
	 */
	public Date getHeure_debut() {
		return heureDebut;
	}
	/**
	 * @param heure_debut the heure_debut to set
	 */
	public void setHeure_debut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	


	
   
}
