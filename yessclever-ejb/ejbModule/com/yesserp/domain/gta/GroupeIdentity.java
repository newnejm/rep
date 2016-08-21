package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: GroupeIdentity
 *
 */
@Entity
@Table(name = "groupe_identity")
//@NamedQuery(name = "Gro.findAll", query = "SELECT g FROM Identite g")
public class GroupeIdentity implements Serializable {

	
	private int id;
	private String libelle;
	private static final long serialVersionUID = 1L;
	
	private List<Identite>identites;
	private List_Identity groupelistIdentity;
	private List<Jobscreate>jobscreates;
	

	public GroupeIdentity() {
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
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the identites
	 */
	@ManyToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
	public List<Identite> getIdentites() {
		return identites;
	}
	/**
	 * @param identites the identites to set
	 */
	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}
	@ManyToOne


	public List_Identity getGroupelistIdentity() {
		return groupelistIdentity;
	}

	public void setGroupelistIdentity(List_Identity groupelistIdentity) {
		this.groupelistIdentity = groupelistIdentity;
	}

	/**
	 * @return the jobscreates
	 */
/*	@OneToMany(mappedBy="groupeIdentity")
	public List<Jobscreate> getJobscreates() {
		return jobscreates;
	}

	*//**
	 * @param jobscreates the jobscreates to set
	 *//*
	public void setJobscreates(List<Jobscreate> jobscreates) {
		this.jobscreates = jobscreates;
	}*/



	/**
	 * @return the jobscreate
	 */


	/**
	 * @return the list_Identity
	 */
	
   
}
