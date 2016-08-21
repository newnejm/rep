package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gta_param_tranche database table.
 * 
 */
@Entity
@Table(name="gta_param_tranche")
public class TrancheDroit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idt;

	private String code;

	@Temporal(TemporalType.DATE)
	private Date debut;

	@Temporal(TemporalType.DATE)
	private Date fin;

	private String libelle;

	//bi-directional one-to-one association to GtaParamDroit
	@OneToOne(mappedBy="gtaParamTranche")
	private Droit gtaParamDroit;

	public TrancheDroit() {
	}

	public Integer getIdt() {
		return this.idt;
	}

	public void setIdt(Integer idt) {
		this.idt = idt;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Droit getGtaParamDroit() {
		return this.gtaParamDroit;
	}

	public void setGtaParamDroit(Droit gtaParamDroit) {
		this.gtaParamDroit = gtaParamDroit;
	}

}