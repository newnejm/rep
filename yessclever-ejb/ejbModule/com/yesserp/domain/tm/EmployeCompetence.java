package com.yesserp.domain.tm;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: EmployeCompetence
 *
 */
@Entity
@Table(name="TM_EmpCom")
public class EmployeCompetence implements Serializable {
	

	private EmployeCompetenceId id;
	private String niveau;
	private String experience;
	
	private Identite identite;
	private CompetenceRh competence;
	
	private static final long serialVersionUID = 1L;
    
	
	public EmployeCompetence() {
		super();
	}

   
	
	@EmbeddedId
	public EmployeCompetenceId getId() {
		return id;
	}

	public void setId(EmployeCompetenceId id) {
		this.id = id;
	}
	

	public String getNiveau() {
		return niveau;
	}

	

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
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
	@JoinColumn(insertable=false,updatable=false,name="codecompetence")
	public CompetenceRh getCompetence() {
		return competence;
	}

	public void setCompetence(CompetenceRh competence) {
		this.competence = competence;
	}

    
	
	
	
	
	
	
	
}
