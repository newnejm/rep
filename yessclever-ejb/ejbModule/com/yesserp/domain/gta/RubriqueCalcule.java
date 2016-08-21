package com.yesserp.domain.gta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "GTA_rbcluh01" database table.
 * 
 */
@Entity
@Table(name="\"gta_rbcluh01\"")
@NamedQuery(name="GTA_rbcluh01.findAll", query="SELECT g FROM RubriqueCalcule g")
public class RubriqueCalcule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String code;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Long valeur;

	public RubriqueCalcule() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getValeur() {
		return this.valeur;
	}

	public void setValeur(Long valeur) {
		this.valeur = valeur;
	}

}