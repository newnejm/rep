package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PlanifJobs
 *
 */
@Table(name="PlanifJobs")
@Entity

public class PlanifJobs implements Serializable {

	   
	
	private int planifId;
	private Date dateDebut;
	private Date dateFin;
	private String frequence;
	private int nbrJours;
	private Date heureDebut;
	private static final long serialVersionUID = 1L;
	private List<Jobscreate> jobscreates;

	public PlanifJobs() {
		super();
	}  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPlanifId() {
		return this.planifId;
	}

	public void setPlanifId(int planifId) {
		this.planifId = planifId;
	}   
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}   
	public String getFrequence() {
		return this.frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}   
	public int getNbrJours() {
		return this.nbrJours;
	}

	public void setNbrJours(int nbrJours) {
		this.nbrJours = nbrJours;
	}   
	public Date getHeureDebut() {
		return this.heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	/**
	 * @return the jobscreates
	 */	@ManyToMany(fetch = FetchType.LAZY,mappedBy="planifJobs")

	public List<Jobscreate> getJobscreates() {
		return jobscreates;
	}
	/**
	 * @param jobscreates the jobscreates to set
	 */
	public void setJobscreates(List<Jobscreate> jobscreates) {
		this.jobscreates = jobscreates;
	}
   
}
