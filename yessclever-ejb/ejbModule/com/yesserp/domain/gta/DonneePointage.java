package com.yesserp.domain.gta;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "GTA_dnpguh01" database table.
 * 
 */
@Entity
@Table(name="\"gta_dnpguh01\"")
@NamedQuery(name="GTA_dnpguh01.findAll", query="SELECT g FROM DonneePointage g")
public class DonneePointage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="heure_pointage")
	private Integer heurePointage;

	private String sense;

	public DonneePointage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHeurePointage() {
		return this.heurePointage;
	}

	public void setHeurePointage(Integer heurePointage) {
		this.heurePointage = heurePointage;
	}

	public String getSense() {
		return this.sense;
	}

	public void setSense(String sense) {
		this.sense = sense;
	}

}