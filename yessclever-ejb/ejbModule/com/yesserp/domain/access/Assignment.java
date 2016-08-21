package com.yesserp.domain.access;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Affectation
 *
 */
@Entity
public class Assignment implements Serializable {

	
	private AssignmentPK assignmentPK;
	
	private static final long serialVersionUID = 1L;
	
	private String rol;
	private Utilisateur utilisateur;
	private Groupe groupe;
	
	public Assignment() {
	}
	
	
	public Assignment(Utilisateur utilisateur, Groupe groupe, String rol) {
		this.getAssignmentPK().setUtilisateurId(utilisateur.getId_utilisateur());
		this.getAssignmentPK().setGroupeId(groupe.getId_groupe());
		this.utilisateur = utilisateur;
		this.groupe = groupe;
		this.rol = rol;
	}




	@ManyToOne
	@JoinColumn(name="utilisateur_fk", insertable = false, updatable = false)
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@ManyToOne
	@JoinColumn(name="groupe_fk", insertable = false, updatable = false)
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@EmbeddedId
	public AssignmentPK getAssignmentPK() {
		if (assignmentPK == null) {
			assignmentPK = new AssignmentPK();
		}
		return assignmentPK;
	}

	public void setAssignmentPK(AssignmentPK assignmentPK) {
		this.assignmentPK = assignmentPK;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}



   
	
	
}
