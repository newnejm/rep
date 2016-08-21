package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



/**
 * Entity implementation class for Entity: Parametres_Generaux
 *
 */
@Entity
@Table(name="pg_Parametres_Generaux")
public class Parametres_Generaux implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Parametres_Generaux() {
		super();
	}
	
	private	int code;
	private	String note_legal;
	private	String depense_des_exercices ;
	
	private Boolean staut ;

	
	//@OneToMany(mappedBy="parametres_generaux")
	private	List<Person> person ;
	private List<Libelle> libelles;
	
	private	List<Societe> societe ;
	
	
	
	
	
	@Id   
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	/*public List<Person> getPerson() {
		return person;
	}/*
	
	public void setPerson(List<Person> person) {
		this.person = person;
	}*/
	
	@OneToMany( targetEntity=Societe.class ,mappedBy="pg",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Societe> getSociete() {
		return societe;
	}
	public void setSociete(List<Societe> societe) {
		this.societe = societe;
	}

	
	@OneToMany(mappedBy = "parametres_Generaux")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	public String getNote_legal() {
		return note_legal;
	}
	public void setNote_legal(String note_legal) {
		this.note_legal = note_legal;
	}
	public String getDepense_des_exercices() {
		return depense_des_exercices;
	}
	public void setDepense_des_exercices(String depense_des_exercices) {
		this.depense_des_exercices = depense_des_exercices;
	}
	
	public Boolean getStaut() {
		return staut;
	}
	public void setStaut(Boolean staut) {
		this.staut = staut;
	}
	
   //
}