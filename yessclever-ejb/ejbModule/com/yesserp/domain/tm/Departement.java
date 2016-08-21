package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: Departement
 *
 */
@Entity
@Table(name = "TM_DeptUH")

public class Departement implements Serializable {

	
	private int code;
	private String libelle;
	private List<Identite> employes;
	private static final long serialVersionUID = 1L;

	public Departement() {
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
	
	@OneToMany(mappedBy = "departement")
	public List<Identite> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Identite> employes) {
		this.employes = employes;
	}
	
	
	
   
}
