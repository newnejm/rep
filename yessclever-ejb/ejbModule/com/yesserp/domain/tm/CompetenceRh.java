package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompetenceRh
 *
 */
@Entity
@Table(name="TM_CompRH")
public class CompetenceRh implements Serializable {

	
	
	private int code;
	private String libelle;
	private String type;
	private List<EmployeCompetence> empcomp; 
	private static final long serialVersionUID = 1L;

	public CompetenceRh() {
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
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
	@OneToMany(mappedBy="competence")
	public List<EmployeCompetence> getEmpcomp() {
		return empcomp;
	}

	public void setEmpcomp(List<EmployeCompetence> empcomp) {
		this.empcomp = empcomp;
	}
	
	public void assignEmployeCompetenceToThisCompetence(List<EmployeCompetence> employes){
		this.setEmpcomp(employes);
		for(EmployeCompetence ec : employes)
		ec.setCompetence(this);	
         			
		
	}
	
   
}
