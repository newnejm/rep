package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: Offre
 *
 */
@Entity
@Table(name="TM_OffrRF")

public class Offre implements Serializable {

	
	private int code;
	private String libelle;
	private String dateoff;
	private String valide;
	private List<Diplome> listdiplome ;
	private List<Profile> listprofile ;
	private List<Competence> listcompetence;
	private Identite identite;
	private static final long serialVersionUID = 1L;
	

	public Offre() {
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
	public String getDateoff() {
		return this.dateoff;
	}

	public void setDateoff(String dateoff) {
		this.dateoff = dateoff;
	}
	
	
	public String getValide() {
		return valide;
	}

	public void setValide(String valide) {
		this.valide = valide;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	public List<Diplome> getListdiplome() {
		return listdiplome;
	}
	public void setListdiplome(List<Diplome> listdiplome) {
		this.listdiplome = listdiplome;
	}
	

	@ManyToMany(fetch=FetchType.EAGER)
	public List<Profile> getListprofile() {
		return listprofile;
	}
	public void setListprofile(List<Profile> listprofile) {
		this.listprofile = listprofile;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	public List<Competence> getListcompetence() {
		return listcompetence;
	}

	public void setListcompetence(List<Competence> listcompetence) {
		this.listcompetence = listcompetence;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Employe")
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	
	
   
}
