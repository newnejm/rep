package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: FormationPl
 *
 */
@Entity
@Table(name="TM_FplRH")
public class FormationPl implements Serializable {

	
	private int code;
	private String libelle;
	private Date debut;
	private Date fin;
	private String heuredebut;
	private String heurefin;
	
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public FormationPl() {
		super();
	}   
	@Id
	@GeneratedValue
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}   
	
	@Temporal(TemporalType.DATE)
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	@Temporal(TemporalType.DATE)
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	@ManyToOne
	@JoinColumn(name="formateur")
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	public String getHeuredebut() {
		return heuredebut;
	}
	public void setHeuredebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}
	public String getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}
	
	
	
   
	
	
	
}
