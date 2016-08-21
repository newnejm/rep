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
 * Entity implementation class for Entity: GroupeActivite
 * 
 */
@Entity
@Table(name = "GTA_GAP_UH01", uniqueConstraints = @UniqueConstraint(columnNames = { "codegrpa" }))
public class GroupeActivite implements Serializable {

	private int idgrpa;
	private String codegrpa;
	private Date dateff;
	private Date datefin;
	private List<ActiviteAbsence> activiteAbsences;
	private List<ActivitePresence> activitePresences;
	private List<Libelle> libelles;
	private List<Filtre> filtres;
	private Date dateeffe;
	private Identite identite ;
	private CodeGTA codeGTA ;


	private static final long serialVersionUID = 1L;

	public GroupeActivite() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdgrpa() {
		return this.idgrpa;
	}

	public void setIdgrpa(int idgrpa) {
		this.idgrpa = idgrpa;
	}

	public String getCodegrpa() {
		return this.codegrpa;
	}

	public void setCodegrpa(String codegrpa) {
		this.codegrpa = codegrpa;
	}

	@OneToMany(mappedBy = "groupeActivite", cascade = CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToMany
	@JoinTable(name = "GTA_GRPA_AABS_UF01")
	public List<ActiviteAbsence> getActiviteAbsences() {
		return activiteAbsences;
	}

	public void setActiviteAbsences(List<ActiviteAbsence> activiteAbsences) {
		this.activiteAbsences = activiteAbsences;
	}

	@ManyToMany
	@JoinTable(name = "GTA_GRPA_APRE_UF01")
	public List<ActivitePresence> getActivitePresences() {
		return activitePresences;
	}

	public void setActivitePresences(List<ActivitePresence> activitePresences) {
		this.activitePresences = activitePresences;
	}

	@ManyToMany(mappedBy = "groupeActivites")
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
		result = prime * result
				+ ((codegrpa == null) ? 0 : codegrpa.hashCode());
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
		GroupeActivite other = (GroupeActivite) obj;
		if (codegrpa == null) {
			if (other.codegrpa != null)
				return false;
		} else if (!codegrpa.equals(other.codegrpa))
			return false;
		return true;
	}
	


	@Temporal(TemporalType.DATE)
	public Date getDateff() {
		return dateff;
	}

	public void setDateff(Date dateff) {
		this.dateff = dateff;
	}

	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	
	@ManyToOne
	@JoinColumn(name="grpactivite")
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public Date getDateeffe() {
		return dateeffe;
	}

	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}
	
   

}
