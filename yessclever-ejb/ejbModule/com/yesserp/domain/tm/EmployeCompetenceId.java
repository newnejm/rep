package com.yesserp.domain.tm;

import java.io.Serializable;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: EmployeCompetenceId
 *
 */
@Embeddable
public class EmployeCompetenceId implements Serializable {


	private static final long serialVersionUID = 1L;
	private int codeidentite;
	private int codecompetence;
	
	
	public EmployeCompetenceId() {
		super();
	}


	public int getCodeidentite() {
		return codeidentite;
	}


	public void setCodeidentite(int codeidentite) {
		this.codeidentite = codeidentite;
	}


	public int getCodecompetence() {
		return codecompetence;
	}


	public void setCodecompetence(int codecompetence) {
		this.codecompetence = codecompetence;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codecompetence;
		result = prime * result + codeidentite;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeCompetenceId other = (EmployeCompetenceId) obj;
		if (codecompetence != other.codecompetence)
			return false;
		if (codeidentite != other.codeidentite)
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
   
}
