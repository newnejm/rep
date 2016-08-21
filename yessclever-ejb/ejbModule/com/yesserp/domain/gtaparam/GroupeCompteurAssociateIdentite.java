package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.yesserp.domain.ga.Identite;

@Entity
public class GroupeCompteurAssociateIdentite implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Identite identite;
	private GroupeCompteur groupeCompteur;

	private GroupeCompteurAssociateIdentitePK associateIdentitePK;

	@ManyToOne
	@JoinColumn(name = "idIdentite", referencedColumnName = "numedoss", insertable = false, updatable = false)
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@ManyToOne
	@JoinColumn(name = "idGrpCompteur", referencedColumnName = "idgrpc", insertable = false, updatable = false)
	public GroupeCompteur getGroupeCompteur() {
		return groupeCompteur;
	}

	public void setGroupeCompteur(GroupeCompteur groupeCompteur) {
		this.groupeCompteur = groupeCompteur;
	}



	@EmbeddedId
	public GroupeCompteurAssociateIdentitePK getAssociateIdentitePK() {
		return associateIdentitePK;
	}

	public void setAssociateIdentitePK(
			GroupeCompteurAssociateIdentitePK associateIdentitePK) {
		this.associateIdentitePK = associateIdentitePK;
	}

	public GroupeCompteurAssociateIdentite(Identite identite,
			GroupeCompteur groupeCompteur, Date dateEffet, Date dateFin) {
		super();
		this.identite = identite;
		this.groupeCompteur = groupeCompteur;
		this.associateIdentitePK = new GroupeCompteurAssociateIdentitePK(
				identite.getNumedoss(), groupeCompteur.getIdgrpc(), dateEffet,
				dateFin);
	}

	public GroupeCompteurAssociateIdentite() {
		super();
	}

}
