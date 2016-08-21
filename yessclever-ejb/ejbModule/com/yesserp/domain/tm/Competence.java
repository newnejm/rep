package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Competence
 *
 */
@Entity
@Table(name="TM_Comp")

public class Competence implements Serializable {

	
	private int code;
	private String libelle;
	private List<Offre> listoffre ;
	private static final long serialVersionUID = 1L;

	public Competence() {
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
	@ManyToMany(mappedBy="listcompetence")
	public List<Offre> getListoffre() {
		return listoffre;
	}
	public void setListoffre(List<Offre> listoffre) {
		this.listoffre = listoffre;
	}
   
	
	
	
}
