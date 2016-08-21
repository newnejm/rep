package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Administrateur;

/**
 * Entity implementation class for Entity: Jobs
 *
 */
@Entity
@Table(name = "Jobs")
public class Jobs implements Serializable {

	   
	
	private int id_jobs;
	private String statut;
	private Date date_effet ;
	private Date date_fin;
	private static final long serialVersionUID = 1L;
	private List<Administrateur>log_Admins;
	private List<ParametreJobs>paramexcutes;
	private List<Asso_Jobs_paramJobs> asso_Jobs_paramJobs;

	public Jobs() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_jobs() {
		return this.id_jobs;
	}

	public void setId_jobs(int id_jobs) {
		this.id_jobs = id_jobs;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	@ManyToMany(mappedBy="listjobs")
	public List<Administrateur> getLog_Admins() {
		return log_Admins;
	}
	public void setLog_Admins(List<Administrateur> log_Admins) {
		this.log_Admins = log_Admins;
	}
	/**
	 * @return the paramexcutes
	 */
	@ManyToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
	public List<ParametreJobs> getParamexcutes() {
		return paramexcutes;
	}
	
	public void setParamexcutes(List<ParametreJobs> paramexcutes) {
		this.paramexcutes = paramexcutes;
	}
	public Date getDate_effet() {
		return date_effet;
	}
	public void setDate_effet(Date date_effet) {
		this.date_effet = date_effet;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	@OneToMany
	public List<Asso_Jobs_paramJobs> getAsso_Jobs_paramJobs() {
		return asso_Jobs_paramJobs;
	}
	public void setAsso_Jobs_paramJobs(List<Asso_Jobs_paramJobs> asso_Jobs_paramJobs) {
		this.asso_Jobs_paramJobs = asso_Jobs_paramJobs;
	}


	
   
}
