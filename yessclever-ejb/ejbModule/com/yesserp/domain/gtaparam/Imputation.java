package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.ActiviteAbsence;
import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.Filtre;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.ImputaCentreCout;
import com.yesserp.domain.gtaparam.ImputaCodeFact;
import com.yesserp.domain.gtaparam.ImputaCompte;
import com.yesserp.domain.gtaparam.ImputaSousCompte;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: Imputation
 * 
 */
@Entity
@Table(name = "GTA_IP_UH01")
public class Imputation implements Serializable {

	private int idi;
	private String codei;
	private ImputaCentreCout imputaCentreCout;
	private ImputaCodeFact imputaCodeFact;
	private ImputaCompte imputaCompte;
	private ImputaSousCompte imputaSousCompte;
	private List<ActiviteAbsence> activiteAbsences;
	private List<ActivitePresence> activitePresences;
	private List<Libelle> libelles;
	private List<GroupeImputation> groupeImputations;
	private List<Filtre> filtres;
	private CodeGTA codeGTA ;

	private static final long serialVersionUID = 1L;

	public Imputation() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdi() {
		return this.idi;
	}

	public void setIdi(int idi) {
		this.idi = idi;
	}

	public String getCodei() {
		return this.codei;
	}

	public void setCodei(String codei) {
		this.codei = codei;
	}

	@OneToMany(mappedBy = "imputation")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToMany
	@JoinTable(name = "GTA_IP_AABS_UF01")
	public List<ActiviteAbsence> getActiviteAbsences() {
		return activiteAbsences;
	}

	public void setActiviteAbsences(List<ActiviteAbsence> activiteAbsences) {
		this.activiteAbsences = activiteAbsences;
	}

	@ManyToMany
	@JoinTable(name = "GTA_IP_APRE_UF01")
	public List<ActivitePresence> getActivitePresences() {
		return activitePresences;
	}

	public void setActivitePresences(List<ActivitePresence> activitePresences) {
		this.activitePresences = activitePresences;
	}

	@ManyToMany(mappedBy = "imputations")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}

	@ManyToMany(mappedBy = "imputations")
	public List<GroupeImputation> getGroupeImputations() {
		return groupeImputations;
	}

	public void setGroupeImputations(List<GroupeImputation> groupeImputations) {
		this.groupeImputations = groupeImputations;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public ImputaCentreCout getImputaCentreCout() {
		return imputaCentreCout;
	}

	public void setImputaCentreCout(ImputaCentreCout imputaCentreCout) {
		this.imputaCentreCout = imputaCentreCout;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public ImputaCodeFact getImputaCodeFact() {
		return imputaCodeFact;
	}

	public void setImputaCodeFact(ImputaCodeFact imputaCodeFact) {
		this.imputaCodeFact = imputaCodeFact;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public ImputaCompte getImputaCompte() {
		return imputaCompte;
	}

	public void setImputaCompte(ImputaCompte imputaCompte) {
		this.imputaCompte = imputaCompte;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public ImputaSousCompte getImputaSousCompte() {
		return imputaSousCompte;
	}

	public void setImputaSousCompte(ImputaSousCompte imputaSousCompte) {
		this.imputaSousCompte = imputaSousCompte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codei == null) ? 0 : codei.hashCode());
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
		Imputation other = (Imputation) obj;
		if (codei == null) {
			if (other.codei != null)
				return false;
		} else if (!codei.equals(other.codei))
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
