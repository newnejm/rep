package com.yesserp.domain.access;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AssignmentPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int utilisateurId;
	private int groupeId;
	
	public AssignmentPK()
	{
		
	}
	@Column(name="utilisateur_fk")
	public int getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	
	@Column(name="groupe_fk")
	public int getGroupeId() {
		return groupeId;
	}
	public void setGroupeId(int groupeId) {
		this.groupeId = groupeId;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + groupeId;
		result = prime * result + utilisateurId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentPK other = (AssignmentPK) obj;
		if (groupeId != other.groupeId)
			return false;
		if (utilisateurId != other.utilisateurId)
			return false;
		return true;
	}
	
	
	
}
