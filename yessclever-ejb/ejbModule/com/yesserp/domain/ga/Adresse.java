package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ga_infouh02 database table.
 * 
 */
@Entity
@Table(name = "ga_infouh02")
@NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String type;
	private boolean principa;
	private Integer numaison;
	private String rue;
	private String residenc;
	private String bloc;
	private String ville;
	private Long codepost;
	private String gouverno;
	private String codepays;
	private String pays;
	private Date dateeffe;
	private Date datefin;
	private Identite identite;

	public Adresse() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodepost() {
		return this.codepost;
	}

	public void setCodepost(Long codepost) {
		this.codepost = codepost;
	}

	public Integer getNumaison() {
		return this.numaison;
	}

	public void setNumaison(Integer numaison) {
		this.numaison = numaison;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateeffe() {
		return this.dateeffe;
	}

	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@ManyToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public String getGouverno() {
		return gouverno;
	}

	public void setGouverno(String gouverno) {
		this.gouverno = gouverno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPrincipa() {
		return principa;
	}

	public void setPrincipa(boolean principa) {
		this.principa = principa;
	}

	public String getResidenc() {
		return residenc;
	}

	public void setResidenc(String residenc) {
		this.residenc = residenc;
	}

	public String getBloc() {
		return bloc;
	}

	public void setBloc(String bloc) {
		this.bloc = bloc;
	}

	public String getCodepays() {
		return codepays;
	}

	public void setCodepays(String codepays) {
		this.codepays = codepays;
	}

}