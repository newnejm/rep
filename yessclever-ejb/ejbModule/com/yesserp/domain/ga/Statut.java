package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Statut
 *
 */
@Entity
@Table(name="ga_statuh01")

public class Statut implements Serializable {

	
	private Long id;
	private String type;
	private String situation;
	private Identite identite;
	private Date dateffet;
	private Date datefin;
	private static final long serialVersionUID = 1L;

	public Statut() {
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
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateffet() {
		return this.dateffet;
	}

	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
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
