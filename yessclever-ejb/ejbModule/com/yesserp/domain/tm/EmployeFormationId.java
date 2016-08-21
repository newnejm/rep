package com.yesserp.domain.tm;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmployeFormationId
 *
 */
@Embeddable

public class EmployeFormationId implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int codeidentite;
	private int codeformation; 
	public EmployeFormationId() {
		super();
	}
	public int getCodeidentite() {
		return codeidentite;
	}
	public void setCodeidentite(int codeidentite) {
		this.codeidentite = codeidentite;
	}
	public int getCodeformation() {
		return codeformation;
	}
	public void setCodeformation(int codeformation) {
		this.codeformation = codeformation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeformation;
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
		EmployeFormationId other = (EmployeFormationId) obj;
		if (codeformation != other.codeformation)
			return false;
		if (codeidentite != other.codeidentite)
			return false;
		return true;
	}
   
	
	
	
	
}
