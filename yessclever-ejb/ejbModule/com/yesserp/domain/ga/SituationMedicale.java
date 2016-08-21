package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: SituationMedicale
 *
 */
@Entity
@Table(name="ga_medirh01")

public class SituationMedicale implements Serializable {

	
	private Long id;
	private String motifInvalidite;
	private String gravite;
	private String tauxInvalidite;
	private String note;
	private Date datedeb;
	private Date datefin;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public SituationMedicale() {
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
	
	@Column(name="motifinv")
	public String getMotifInvalidite() {
		return this.motifInvalidite;
	}

	public void setMotifInvalidite(String motifInvalidite) {
		this.motifInvalidite = motifInvalidite;
	}  
	
	public String getGravite() {
		return this.gravite;
	}

	public void setGravite(String gravite) {
		this.gravite = gravite;
	}   
	
	@Column(name="tauxinva")
	public String getTauxInvalidite() {
		return this.tauxInvalidite;
	}
	
	public void setTauxInvalidite(String tauxInvalidite) {
		this.tauxInvalidite = tauxInvalidite;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeb() {
		return this.datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
   
	@ManyToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}	
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

}
