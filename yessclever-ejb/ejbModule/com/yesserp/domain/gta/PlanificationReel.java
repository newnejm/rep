package com.yesserp.domain.gta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "GTA_plreuh01" database table.
 * 
 */
@Entity
@Table(name="\"gta_plreuh01\"")
@NamedQuery(name="GTA_plreuh01.findAll", query="SELECT g FROM PlanificationReel g")
public class PlanificationReel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="cd_journee")
	private String cdJournee;

	@Temporal(TemporalType.DATE)
	@Column(name="date_journee")
	private Date dateJournee;

	@Column(name="type_code")
	private String typeCode;

	public PlanificationReel() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCdJournee() {
		return this.cdJournee;
	}

	public void setCdJournee(String cdJournee) {
		this.cdJournee = cdJournee;
	}

	public Date getDateJournee() {
		return this.dateJournee;
	}

	public void setDateJournee(Date dateJournee) {
		this.dateJournee = dateJournee;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}