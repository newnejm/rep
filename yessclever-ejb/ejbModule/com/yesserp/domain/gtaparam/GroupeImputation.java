package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: GroupeImputation
 * 
 */
@Entity
@Table(name = "GTA_GIP_UH01", uniqueConstraints = @UniqueConstraint(columnNames = { "codegrp" }))
public class GroupeImputation implements Serializable {

	private int idgrp;
	private String codegrp;
	private List<Imputation> imputations;
	private List<Libelle> libelles;
	private List<Filtre> filtres;
	private Date dateeffe;
	private Date datefin;
	private Identite identite ;
	private CodeGTA codeGTA ;
	private static final long serialVersionUID = 1L;

	public GroupeImputation() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdgrp() {
		return this.idgrp;
	}

	public void setIdgrp(int idgrp) {
		this.idgrp = idgrp;
	}

	public String getCodegrp() {
		return this.codegrp;
	}

	public void setCodegrp(String codegrp) {
		this.codegrp = codegrp;
	}

	@ManyToMany
	@JoinTable(name = "GTA_GIP_IP_RH01")
	public List<Imputation> getImputations() {
		return imputations;
	}

	public void setImputations(List<Imputation> imputations) {
		this.imputations = imputations;
	}

	@OneToMany(mappedBy = "groupeImputation", cascade = CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToMany(mappedBy = "groupeImputations")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codegrp == null) ? 0 : codegrp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupeImputation other = (GroupeImputation) obj;
		if (codegrp == null) {
			if (other.codegrp != null)
				return false;
		} else if (!codegrp.equals(other.codegrp))
			return false;
		return true;
	}

	

	@Temporal(TemporalType.DATE)
	public Date getDateeffe() {
		return dateeffe;
	}

	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	

	
	}
	@ManyToOne
	@JoinColumn(name="grpimutation")
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

}
