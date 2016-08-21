package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.yesserp.domain.gta.ActiviteReelCalculer;
import com.yesserp.domain.gta.ActiviteReelSaisie;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: ActivitePresence
 * 
 */
@Entity
@Table(name = "GTA_APP_UH01", uniqueConstraints = @UniqueConstraint(columnNames = { "codeap" }))
public class ActivitePresence implements Serializable {

	private int idap;
	private String codeap;
	private int poids;
	private List<PlageHoraire> plageHoraires;
	private List<ActiviteReelCalculer> activiteReelClaculers;
	private List<Libelle> libelles;
	private List<Filtre> filtres;
	private List<GroupeActivite> groupeActivites;
	private List<Imputation> imputations;

	private List<ActiviteReelSaisie> activiteReelSaisies;
	private CodeGTA codeGTA ;
	
	
	private static final long serialVersionUID = 1L;

	public ActivitePresence() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdap() {
		return this.idap;
	}

	public void setIdap(int idap) {
		this.idap = idap;
	}

	public String getCodeap() {
		return this.codeap;
	}

	public void setCodeap(String codeap) {
		this.codeap = codeap;
	}

	@OneToMany(mappedBy = "activitePresence")
	public List<PlageHoraire> getPlageHoraires() {
		return plageHoraires;
	}

	public void setPlageHoraires(List<PlageHoraire> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}

	@OneToMany(mappedBy = "activitePresence", cascade = CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToMany(mappedBy = "activitePresences")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}

	@ManyToMany(mappedBy = "activitePresences")
	public List<GroupeActivite> getGroupeActivites() {
		return groupeActivites;
	}

	public void setGroupeActivites(List<GroupeActivite> groupeActivites) {
		this.groupeActivites = groupeActivites;
	}

	@ManyToMany(mappedBy = "activitePresences")
	public List<Imputation> getImputations() {
		return imputations;
	}

	public void setImputations(List<Imputation> imputations) {
		this.imputations = imputations;
	}

	@OneToMany(mappedBy = "activitePresence")
	public List<ActiviteReelCalculer> getActiviteReelClaculers() {
		return activiteReelClaculers;
	}

	public void setActiviteReelClaculers(
			List<ActiviteReelCalculer> activiteReelClaculers) {
		this.activiteReelClaculers = activiteReelClaculers;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	@OneToMany(mappedBy = "activitePresence")
	public List<ActiviteReelSaisie> getActiviteReelSaisies() {
		return activiteReelSaisies;
	}

	public void setActiviteReelSaisies(
			List<ActiviteReelSaisie> activiteReelSaisies) {
		this.activiteReelSaisies = activiteReelSaisies;
	}

	@Override
	public String toString() {
		return "" + codeap + "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeap == null) ? 0 : codeap.hashCode());
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
		ActivitePresence other = (ActivitePresence) obj;
		if (codeap == null) {
			if (other.codeap != null)
				return false;
		} else if (!codeap.equals(other.codeap))
			return false;
		return true;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

}
