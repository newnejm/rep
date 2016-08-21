 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
@Table(name="pg_Person")
public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Person() {
		super();
	}
  
	
	
	private	int code ;
	private	String nom ;
	private	String adresse ;
	
	
	private	Parametres_Generaux parametres_generaux ;
	
	private List<Emploie> emploie ;
	
	
	
/*	@ManyToOne
	public Parametres_Generaux getParametres_generux() {
		return parametres_generaux;
	}
	*/
	
	public void setParametres_generux(Parametres_Generaux parametres_generux) {
		this.parametres_generaux = parametres_generux;
	}
	
	
	
	
	@OneToMany( targetEntity=Emploie.class ,mappedBy="person",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Emploie> getEmploie() {
		return emploie;
	}
	public void setEmploie(List<Emploie> emploie) {
		this.emploie = emploie;
	}
	
	
	@Id   
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	private List<Libelle> libelles;
	
	
	@OneToMany(mappedBy = "person")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	//
	
}
