package com.yesserp.domain.wkf;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mapping
 *
 */
@Entity
@Table(name = "pgw_mapping")
@NamedQuery(name = "Mapping.findAll", query = "SELECT a FROM Mapping a")
public class Mapping implements Serializable {


	private Long id;
	private String attributentite;
	private String attributdemande;
	private String entitedemande;
	private String entite;
	private String packageentite;
	private String typeattribut;
	private String textaffichage;
	private Boolean etataffichage;
	private static final long serialVersionUID = 1L;

	public Mapping() {
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

	public String getAttributentite() {
		return attributentite;
	}

	public void setAttributentite(String attributentite) {
		this.attributentite = attributentite;
	}

	public String getAttributdemande() {
		return attributdemande;
	}

	public void setAttributdemande(String attributdemande) {
		this.attributdemande = attributdemande;
	}

	public String getEntitedemande() {
		return entitedemande;
	}

	public void setEntitedemande(String entitedemande) {
		this.entitedemande = entitedemande;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public String getPackageentite() {
		return packageentite;
	}

	public void setPackageentite(String packageentite) {
		this.packageentite = packageentite;
	}

	public String getTypeattribut() {
		return typeattribut;
	}

	public void setTypeattribut(String typeattribut) {
		this.typeattribut = typeattribut;
	}

	public String getTextaffichage() {
		return textaffichage;
	}

	public void setTextaffichage(String textaffichage) {
		this.textaffichage = textaffichage;
	}

	public Boolean getEtataffichage() {
		return etataffichage;
	}

	public void setEtataffichage(Boolean etataffichage) {
		this.etataffichage = etataffichage;
	}  
	
}
