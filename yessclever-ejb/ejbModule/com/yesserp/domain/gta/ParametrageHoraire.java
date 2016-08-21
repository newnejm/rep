package com.yesserp.domain.gta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "GTA_prmhuh01" database table.
 * 
 */
@Entity
@Table(name="\"gta_prmhuh01\"")
@NamedQuery(name="GTA_prmhuh01.findAll", query="SELECT g FROM ParametrageHoraire g")
public class ParametrageHoraire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="\"CD_clndre\"")
	private String CD_clndre;

	@Column(name="\"CD_cycle\"")
	private String CD_cycle;

	@Temporal(TemporalType.DATE)
	@Column(name="date_effet")
	private Date dateEffet;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;

	public ParametrageHoraire() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCD_clndre() {
		return this.CD_clndre;
	}

	public void setCD_clndre(String CD_clndre) {
		this.CD_clndre = CD_clndre;
	}

	public String getCD_cycle() {
		return this.CD_cycle;
	}

	public void setCD_cycle(String CD_cycle) {
		this.CD_cycle = CD_cycle;
	}

	public Date getDateEffet() {
		return this.dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}