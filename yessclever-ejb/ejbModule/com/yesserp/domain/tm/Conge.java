package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: Conge
 *
 */
@Entity
@Table(name="TM_congRH")
public class Conge implements Serializable {

	
	private int code;
	private String libelle;
	private String datedebut;
	private String datefin;
	private String raison;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public Conge() {
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
	public String getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}   
	public String getDatefin() {
		return this.datefin;
	}

	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}   
	public String getRaison() {
		return this.raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}
	@ManyToOne
	@JoinColumn(name="Employe")
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	
	
	
   
}
