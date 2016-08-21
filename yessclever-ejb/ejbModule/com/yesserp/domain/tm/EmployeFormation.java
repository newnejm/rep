package com.yesserp.domain.tm;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: EmployeFormation
 *
 */
@Entity
@Table(name="TM_EmpForm")
public class EmployeFormation implements Serializable {

	private EmployeFormationId id;
	private String datedebut;
	private String datefin;
	private Identite identite;
	private Formation formation;
	private static final long serialVersionUID = 1L;

	public EmployeFormation() {
		super();
	}

	
	
	@EmbeddedId
	public EmployeFormationId getId() {
		return id;
	}




	public void setId(EmployeFormationId id) {
		this.id = id;
	}




	public String getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}

	public String getDatefin() {
		return datefin;
	}

	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}


	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="codeidentite")
	public Identite getIdentite() {
		return identite;
	}



	public void setIdentite(Identite identite) {
		this.identite = identite;
	}


	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="codeformation")
	public Formation getFormation() {
		return formation;
	}



	public void setFormation(Formation formation) {
		this.formation = formation;
	}
   
	
	
	
	
	
}
