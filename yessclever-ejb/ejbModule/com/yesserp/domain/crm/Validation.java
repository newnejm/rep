package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Validation
 *
 */
@Entity
@Table(name="crm_valid01")
public class Validation implements Serializable {

	
	private int id;
	private String date;
	private String statut_interne;
	private String statut_client;
	private String note;
	private Suivi suivi;
	private static final long serialVersionUID = 1L;

	public Validation() {
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
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public String getStatut_interne() {
		return this.statut_interne;
	}

	public void setStatut_interne(String statut_interne) {
		this.statut_interne = statut_interne;
	}   
	public String getStatut_client() {
		return this.statut_client;
	}

	public void setStatut_client(String statut_client) {
		this.statut_client = statut_client;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	@OneToOne
	public Suivi getSuivi() {
		return suivi;
	}
	public void setSuivi(Suivi suivi) {
		this.suivi = suivi;
	}
   
}
