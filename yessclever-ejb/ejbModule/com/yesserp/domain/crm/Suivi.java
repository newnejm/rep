package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Suivi
 *
 */
@Entity
@Table(name="crm_suiv01")
public class Suivi implements Serializable {

	
	private int id;
	private String avancement;
	private String qualite;
	private String statut;
	private String date;
	private String note;
	private Service services;
	private Validation validation;
	private static final long serialVersionUID = 1L;

	public Suivi() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getAvancement() {
		return this.avancement;
	}

	public void setAvancement(String avancement) {
		this.avancement = avancement;
	}   
	public String getQualite() {
		return this.qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	@ManyToOne
	public Service getServices() {
		return services;
	}
	public void setServices(Service services) {
		this.services = services;
	}
	@OneToOne
	public Validation getValidation() {
		return validation;
	}
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
   
}
