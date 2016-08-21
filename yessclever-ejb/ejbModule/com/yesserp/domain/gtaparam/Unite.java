package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gta_param_unite database table.
 * 
 */
@Entity
@Table(name="gta_param_unite")
public class Unite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idu;

	private String code;

	private String libelle;

	//bi-directional many-to-one association to GtaParamDroit
	private Integer idd;

	public Unite() {
	}

	public Integer getIdu() {
		return this.idu;
	}

	public void setIdu(Integer idu) {
		this.idu = idu;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getIdd() {
		return idd;
	}

	public void setIdd(Integer idd) {
		this.idd = idd;
	}

	

}