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
@Table(name="ga_experh01")

public class Experience implements Serializable {

	
	private Long id;
	private Date datedebu;
	private Date datefin;
	private String poste;
	private String description;
	private String societe;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public Experience() {
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
	public Date getDatedebu() {
		return datedebu;
	}
	public void setDatedebu(Date datedebu) {
		this.datedebu = datedebu;
	}
	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}   
	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
	@Column(name="descript")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getSociete() {
		return this.societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
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
