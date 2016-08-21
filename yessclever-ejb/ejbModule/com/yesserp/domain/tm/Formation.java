package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Formation
 *
 */
@Entity
@Table(name="TM_FormRF")
public class Formation implements Serializable {

	
	private int code;
	private String libelle;
	private List<EmployeFormation> empform;
	private static final long serialVersionUID = 1L;

	public Formation() {
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
	
	@OneToMany(mappedBy="formation")
	public List<EmployeFormation> getEmpform() {
		return empform;
	}
	public void setEmpform(List<EmployeFormation> empform) {
		this.empform = empform;
	}
   
	public void assignEmployeCompetenceToThisFormation(List<EmployeFormation> employes){
		this.setEmpform(employes);
		for(EmployeFormation ef : employes)
		ef.setFormation(this);	
         			
		
	}
	
	
	
	
}
