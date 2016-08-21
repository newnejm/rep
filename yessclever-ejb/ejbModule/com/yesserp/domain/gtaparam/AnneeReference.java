package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gta_param_anneereference database table.
 * 
 */
@Entity
@Table(name="gta_param_anneereference")
public class AnneeReference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idan;

	@Temporal(TemporalType.DATE)
	private Date debut;

	@Temporal(TemporalType.DATE)
	private Date fin;

	private String libelle;

	public AnneeReference() {
	}

	public Integer getIdan() {
		return this.idan;
	}

	public void setIdan(Integer idan) {
		this.idan = idan;
	}

	public Date getDebut() {
		return this.debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}