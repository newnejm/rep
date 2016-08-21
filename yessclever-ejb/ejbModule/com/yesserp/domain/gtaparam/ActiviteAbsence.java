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

import com.yesserp.domain.gta.Absence;
import com.yesserp.domain.gta.ActiviteReelCalculer;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: ActiviteAbsence
 * 
 */
@Entity
@Table(name = "GTA_AAP_UH01", uniqueConstraints = @UniqueConstraint(columnNames = { "codeaabs" }))
public class ActiviteAbsence implements Serializable {

	private int idaabs;
	private String codeaabs;
	private int poids;
	private List<PlageHoraire> plageHoraires;
	private List<Libelle> libelles;
	private List<Filtre> filtres;
	private List<GroupeActivite> groupeActivites;
	private List<Imputation> imputations;
	private List<ActiviteReelCalculer> activiteReelClaculers;
	private List<GestionPeriodeConge> gestionPeriodeConges;
	private List<AbsenceTypeConge> abscenceTypeConges;
	private List<Anciennete> anciennetes;
	private List<Absence> absences;
	private CodeGTA codeGTA ;

	private static final long serialVersionUID = 1L;

	public ActiviteAbsence() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdaabs() {
		return this.idaabs;
	}

	public void setIdaabs(int idaabs) {
		this.idaabs = idaabs;
	}

	public String getCodeaabs() {
		return codeaabs;
	}

	public void setCodeaabs(String codeaabs) {
		this.codeaabs = codeaabs;
	}

	@OneToMany(mappedBy = "activiteAbsence")
	public List<PlageHoraire> getPlageHoraires() {
		return plageHoraires;
	}

	public void setPlageHoraires(List<PlageHoraire> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}

	@OneToMany(mappedBy = "activiteAbsence", cascade = CascadeType.ALL)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToMany(mappedBy = "activiteAbsences")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}

	@ManyToMany(mappedBy = "activiteAbsences")
	public List<GroupeActivite> getGroupeActivites() {
		return groupeActivites;
	}

	public void setGroupeActivites(List<GroupeActivite> groupeActivites) {
		this.groupeActivites = groupeActivites;
	}

	@ManyToMany(mappedBy = "activiteAbsences")
	public List<Imputation> getImputations() {
		return imputations;
	}

	public void setImputations(List<Imputation> imputations) {
		this.imputations = imputations;
	}

	@OneToMany(mappedBy = "activiteAbsence")
	public List<ActiviteReelCalculer> getActiviteReelClaculers() {
		return activiteReelClaculers;
	}

	public void setActiviteReelClaculers(
			List<ActiviteReelCalculer> activiteReelClaculers) {
		this.activiteReelClaculers = activiteReelClaculers;
	}

	@OneToMany(mappedBy = "activiteAbsence")
	public List<GestionPeriodeConge> getGestionPeriodeConges() {
		return gestionPeriodeConges;
	}

	public void setGestionPeriodeConges(
			List<GestionPeriodeConge> gestionPeriodeConges) {
		this.gestionPeriodeConges = gestionPeriodeConges;
	}

	@OneToMany(mappedBy = "activiteAbsence")
	public List<AbsenceTypeConge> getAbscenceTypeConges() {
		return abscenceTypeConges;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public void setAbscenceTypeConges(List<AbsenceTypeConge> abscenceTypeConges) {
		this.abscenceTypeConges = abscenceTypeConges;
	}

	@OneToMany(mappedBy = "activiteAbsence")
	public List<Anciennete> getAnciennetes() {
		return anciennetes;
	}

	public void setAnciennetes(List<Anciennete> anciennetes) {
		this.anciennetes = anciennetes;
	}

	@Override
	public String toString() {
		return "" + codeaabs + "";
	}

	@OneToMany(mappedBy = "activiteAbsence")
	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeaabs == null) ? 0 : codeaabs.hashCode());
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
		ActiviteAbsence other = (ActiviteAbsence) obj;
		if (codeaabs == null) {
			if (other.codeaabs != null)
				return false;
		} else if (!codeaabs.equals(other.codeaabs))
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
