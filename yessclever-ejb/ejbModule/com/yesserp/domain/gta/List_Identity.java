package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: List_Identity
 *
 */
@Entity
@Table(name = "list_identity")
public class List_Identity implements Serializable {

	   

	private int id;
	private String libelle;
	private List<Identite>identites;
	private List<GroupeIdentity> groupeIdentities;
	private String statut;
	private static final long serialVersionUID = 1L;

	public List_Identity() {
		super();
	}   
	   
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@OneToMany(mappedBy="listIdentity",cascade={CascadeType.ALL})
	public List<Identite> getIdentites() {
		return identites;
	}

	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}

	/**
	 * @return the groupeIdentities
	 */
	@OneToMany(mappedBy="groupelistIdentity",cascade={CascadeType.ALL})
	public List<GroupeIdentity> getGroupeIdentities() {
		return groupeIdentities;
	}

	/**
	 * @param groupeIdentities the groupeIdentities to set
	 */
	public void setGroupeIdentities(List<GroupeIdentity> groupeIdentities) {
		this.groupeIdentities = groupeIdentities;
	}
	
   
}
