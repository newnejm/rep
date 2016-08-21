package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.yesserp.domain.ga.Identite;

@Entity
public class GroupeImputationAssociateIdentite implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Identite identite;
	private GroupeImputation groupeImputation;
	private GroupeImputationAssociatePK groupeImputationAssociatePK ;
	
	public GroupeImputationAssociateIdentite() {
		super();
	}
	
	

	public GroupeImputationAssociateIdentite(Identite identite,
			GroupeImputation groupeImputation,
			GroupeImputationAssociatePK groupeImputationAssociatePK) {
		super();
		this.identite = identite;
		this.groupeImputation = groupeImputation;
		this.groupeImputationAssociatePK = groupeImputationAssociatePK;
	}



	@EmbeddedId
	public GroupeImputationAssociatePK getGroupeImputationAssociatePK() {
		return groupeImputationAssociatePK;
	}

	public void setGroupeImputationAssociatePK(
			GroupeImputationAssociatePK groupeImputationAssociatePK) {
		this.groupeImputationAssociatePK = groupeImputationAssociatePK;
	}
	

	@ManyToOne
	@JoinColumn(name = "idIdentite", referencedColumnName = "numedoss", insertable = false, updatable = false)
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	


	@ManyToOne
	@JoinColumn(name = "idGrpImputation", referencedColumnName = "idgrp", insertable = false, updatable = false)
	public GroupeImputation getGroupeImputation() {
		return groupeImputation;
	}

	public void setGroupeImputation(GroupeImputation groupeImputation) {
		this.groupeImputation = groupeImputation;
	}


	

	
	
}
