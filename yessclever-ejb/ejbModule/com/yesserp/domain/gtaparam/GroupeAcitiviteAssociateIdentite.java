package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.yesserp.domain.ga.Identite;

@Entity
public class GroupeAcitiviteAssociateIdentite implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private Identite identite;
	private GroupeActivite groupeActivite;
	private GroupeAcitiviteAssociateIdentitePK acitiviteAssociateIdentitePK;
	
	


		public GroupeAcitiviteAssociateIdentite() {
			super();
		}


		public GroupeAcitiviteAssociateIdentite(Identite identite,
			GroupeActivite groupeActivite,
			GroupeAcitiviteAssociateIdentitePK acitiviteAssociateIdentitePK) {
		super();
		this.identite = identite;
		this.groupeActivite = groupeActivite;
		this.acitiviteAssociateIdentitePK = acitiviteAssociateIdentitePK;
	}
		

		@EmbeddedId
		public GroupeAcitiviteAssociateIdentitePK getAcitiviteAssociateIdentitePK() {
			return acitiviteAssociateIdentitePK;
		}


		public void setAcitiviteAssociateIdentitePK(GroupeAcitiviteAssociateIdentitePK acitiviteAssociateIdentitePK) {
			this.acitiviteAssociateIdentitePK = acitiviteAssociateIdentitePK;
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
	@JoinColumn(name = "idGrpActivite", referencedColumnName = "idgrpa", insertable = false, updatable = false)
	public GroupeActivite getGroupeActivite() {
		return groupeActivite;
	}

	public void setGroupeActivite(GroupeActivite groupeActivite) {
		this.groupeActivite = groupeActivite;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((acitiviteAssociateIdentitePK == null) ? 0
						: acitiviteAssociateIdentitePK.hashCode());
		result = prime * result
				+ ((groupeActivite == null) ? 0 : groupeActivite.hashCode());
		result = prime * result
				+ ((identite == null) ? 0 : identite.hashCode());
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
		GroupeAcitiviteAssociateIdentite other = (GroupeAcitiviteAssociateIdentite) obj;
		if (acitiviteAssociateIdentitePK == null) {
			if (other.acitiviteAssociateIdentitePK != null)
				return false;
		} else if (!acitiviteAssociateIdentitePK
				.equals(other.acitiviteAssociateIdentitePK))
			return false;
		if (groupeActivite == null) {
			if (other.groupeActivite != null)
				return false;
		} else if (!groupeActivite.equals(other.groupeActivite))
			return false;
		if (identite == null) {
			if (other.identite != null)
				return false;
		} else if (!identite.equals(other.identite))
			return false;
		return true;
	}
		
	
	

}
