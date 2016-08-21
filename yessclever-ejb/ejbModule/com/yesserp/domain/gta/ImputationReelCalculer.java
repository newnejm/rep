package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.Imputation;

@Entity
public class ImputationReelCalculer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Date date;
	private Date heuredeb;
	private Date heurefin;
	private Identite identite;
	private Imputation imputation;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Temporal(TemporalType.TIME)
	public Date getHeuredeb() {
		return heuredeb;
	}
	public void setHeuredeb(Date heuredeb) {
		this.heuredeb = heuredeb;
	}
	@Temporal(TemporalType.TIME)
	public Date getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(Date heurefin) {
		this.heurefin = heurefin;
	}
	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	@ManyToOne
	public Imputation getImputation() {
		return imputation;
	}
	public void setImputation(Imputation imputation) {
		this.imputation = imputation;
	}

	
	
}
