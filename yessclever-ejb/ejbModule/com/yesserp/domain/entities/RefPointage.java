package com.yesserp.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.gtaparam.DescJourneeType;

@Entity
@Table(name = "ref_pointage")
public class RefPointage extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532982263231161448L;

	private Integer idRefPoint;
	private Date heurePointage;
	private Date heureInf;
	private Date heureSup;
	
	
	private DescJourneeType descJourneeType ;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdRefPoint() {
		return idRefPoint;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeurePointage() {
		return heurePointage;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeureInf() {
		return heureInf;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeureSup() {
		return heureSup;
	}

	public void setIdRefPoint(Integer idRefPoint) {
		this.idRefPoint = idRefPoint;
	}

	public void setHeurePointage(Date heurePointage) {
		this.heurePointage = heurePointage;
	}

	public void setHeureInf(Date heureInf) {
		this.heureInf = heureInf;
	}

	public void setHeureSup(Date heureSup) {
		this.heureSup = heureSup;
	}
	
	@ManyToOne
	public DescJourneeType getDescJourneeType() {
		return descJourneeType;
	}

	public void setDescJourneeType(DescJourneeType descJourneeType) {
		this.descJourneeType = descJourneeType;
	}
	

}
