package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Certification
 *
 */
@Entity
@Table(name="ga_certirh01")

public class Certification implements Serializable {

	
	private Long id;
	private Date dateffet;
	private Date datefin;
	private String nom;
	private String centreObtention;
	private String description;
	private Identite identite;
	
	private static final long serialVersionUID = 1L;

	public Certification() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	@Temporal(TemporalType.DATE)
	public Date getDateffet() {
		return this.dateffet;
	}

	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
	}
  
	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}  
	@Column(name="centrobt")
	public String getCentreObtention() {
		return this.centreObtention;
	}

	public void setCentreObtention(String centreObtention) {
		this.centreObtention = centreObtention;
	}   
	@Column(name="descript")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch = FetchType.EAGER, optional = true )
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

   
}
