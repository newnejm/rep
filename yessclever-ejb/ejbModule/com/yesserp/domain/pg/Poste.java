 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



/**
 * Entity implementation class for Entity: Poste
 *
 */
@Entity
@Table(name="pg_Poste")
public class Poste implements Serializable {
	
	private int code ;
    private  String	numero_poste ;
	private   String	grade;
	private   String	salaire;
	private   Emploie emploie ;
	private   Employeur employeur ;
	private List<Libelle> libelles;
	private static final long serialVersionUID = 1L;
	public Poste() {
		
	}

	@Id
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	
	
	@OneToMany(mappedBy = "poste")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	
	
	

	public String getNumero_poste() {
		return numero_poste;
	}



	public void setNumero_poste(String numero_poste) {
		this.numero_poste = numero_poste;
	}
	
	 
     private   Description_poste description_poste ;
	 
	 
	@ManyToOne 
	public Description_poste getDescription_poste() {
		return description_poste;
	}



	public void setDescription_poste(Description_poste description_poste) {
		this.description_poste = description_poste;
	}
	

	  public String getGrade() {
			return grade;
		}


		public void setGrade(String grade) {
			this.grade = grade;
		}


		public String getSalaire() {
			return salaire;
		}


		public void setSalaire(String salaire) {
			this.salaire = salaire;
		}

		@ManyToOne
		public Emploie getEmploie() {
			return emploie;
		}


		public void setEmploie(Emploie emploie) {
			this.emploie = emploie;
		}

		@ManyToOne
		public Employeur getEmployeur() {
			return employeur;
		}


		public void setEmployeur(Employeur employeur) {
			this.employeur = employeur;
		}



	//
   
}
