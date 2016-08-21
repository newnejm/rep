package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Planification_Jobs
 *
 */
@Entity
@Table(name = "Planification_Jobs")
public class Planification_Jobs implements Serializable {

	   

	private int id_planification_Jobs;
	private String statut;
	private Date date_debut;
	private Date date_fin;
	
	private static final long serialVersionUID = 1L;

	public Planification_Jobs() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_planification_Jobs() {
		return this.id_planification_Jobs;
	}

	public void setId_planification_Jobs(int id_planification_Jobs) {
		this.id_planification_Jobs = id_planification_Jobs;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
   
}
