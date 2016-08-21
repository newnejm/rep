package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.CodeCalendrier;
import com.yesserp.domain.gta.Terminal;
import com.yesserp.domain.gta.TypePointage;
import com.yesserp.domain.gtaparam.ActiviteAbsence;
import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.Anomalie;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.CycleTravailAssociateJourneeType;
import com.yesserp.domain.gtaparam.Filtre;
import com.yesserp.domain.gtaparam.GroupeActivite;
import com.yesserp.domain.gtaparam.GroupeCompteur;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.ImputaCentreCout;
import com.yesserp.domain.gtaparam.ImputaCodeFact;
import com.yesserp.domain.gtaparam.ImputaCompte;
import com.yesserp.domain.gtaparam.ImputaSousCompte;
import com.yesserp.domain.gtaparam.Imputation;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.SemaineType;



@Entity
@Table(name="pg_CodeGTA")
public class CodeGTA implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    public CodeGTA() {	
	}
	
	
	private	int code;
	
	private String codePlageHoraire ;
	
	private String codeActiviteAbsence;
	
	private List<Libelle> libelles;
	
	
	private String codeactivitePresences;
	
	private String codeGroupeActivite;
	private String codeGroupeImputation;

	private String codeImputation;

	private String codeImputaCompte;

	private String codeImputaSousCompte;

	private String codeImputaCodeFact;

	private String codeImputaCentreCout;

	private String codeSemaineType;

	private String codeTypePointage;

	private String codeTerminal;

	private String codeCodeCalendrier;

	private String codeCodeJour;

	private String codeJourneeType;

	private String codeCycleTravail;

	private String codeFiltre;

	private String codeCompteur;

	private String codeAnomalie;

	private String codeClasseEmp;

	private String codeGroupeCompteur;
	
	
	
	private List<PlageHoraire> plageHoraires ;
    private List<ActivitePresence> activitePresences ;
	private List<ActiviteAbsence> activiteAbsences ;
	
	private List<GroupeActivite> groupeActivites ;	
	private List<GroupeImputation> groupeImputations ;
	private List<Imputation> imputations ;	
	private List<ImputaCompte> imputaComptes ;
	private List<ImputaSousCompte> imputaSousComptes ;
	private List<ImputaCodeFact> imputaCodeFacts ;
	private List<ImputaCentreCout> imputaCentreCouts ;
	private List<SemaineType> semaineTypes ;
	private List<TypePointage> typePointages ;
	private List<Terminal> terminals ;
	private List<CodeCalendrier> codeCalendriers ;
	private List<CodeJour> codeJour1s ;
	private List<JourneeType> journeeTypes ;
	private List<CycleTravail> cycleTravails ;
	private List<CycleTravailAssociateJourneeType> ctajts ;
	private List<Filtre> filtres ;
	private List<Compteur> compteurs ;
	private List<Anomalie> anomalies ;
	private List<ClasseEmp> classeEmps ;
	

	private List<GroupeCompteur> groupeCompteurs ;
	
	
	
	
	@Id
	public int getCode() {
		 
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	@OneToMany(mappedBy = "codeGTA")
	public List<Libelle> getLibelles() {
		return libelles;
	}


	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	@OneToMany(mappedBy = "codeGTA")
	public List<ActivitePresence> getActivitePresences() {
		return activitePresences;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<ActiviteAbsence> getActiviteAbsences() {
		
		
		
		return activiteAbsences;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<GroupeActivite> getGroupeActivites() {
		return groupeActivites;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<GroupeImputation> getGroupeImputations() {
		return groupeImputations;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<Imputation> getImputations() {
		return imputations;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<ImputaCompte> getImputaComptes() {
		return imputaComptes;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<ImputaSousCompte> getImputaSousComptes() {
		return imputaSousComptes;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<ImputaCodeFact> getImputaCodeFacts() {
		return imputaCodeFacts;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<ImputaCentreCout> getImputaCentreCouts() {
		return imputaCentreCouts;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<SemaineType> getSemaineTypes() {
		return semaineTypes;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<TypePointage> getTypePointages() {
		return typePointages;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<Terminal> getTerminals() {
		return terminals;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<CodeCalendrier> getCodeCalendriers() {
		return codeCalendriers;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<CodeJour> getCodeJour1s() {
		return codeJour1s;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<JourneeType> getJourneeTypes() {
		return journeeTypes;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<CycleTravail> getCycleTravails() {
		return cycleTravails;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<CycleTravailAssociateJourneeType> getCtajts() {
		return ctajts;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<Compteur> getCompteurs() {
		return compteurs;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<Anomalie> getAnomalies() {
		return anomalies;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<ClasseEmp> getClasseEmps() {
		return classeEmps;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<GroupeCompteur> getGroupeCompteurs() {
		return groupeCompteurs;
	}

	@OneToMany(mappedBy = "codeGTA")
	public List<PlageHoraire> getPlageHoraires() {
		
		return plageHoraires;
	}

	public void setActivitePresences(List<ActivitePresence> activitePresences) {
		this.activitePresences = activitePresences;
	}


	public void setActiviteAbsences(List<ActiviteAbsence> activiteAbsences) {
		this.activiteAbsences = activiteAbsences;
	}


	public void setGroupeActivites(List<GroupeActivite> groupeActivites) {
		this.groupeActivites = groupeActivites;
	}


	public void setGroupeImputations(List<GroupeImputation> groupeImputations) {
		this.groupeImputations = groupeImputations;
	}


	public void setImputations(List<Imputation> imputations) {
		
		
		
		this.imputations = imputations;
	}


	public void setImputaComptes(List<ImputaCompte> imputaComptes) {
		this.imputaComptes = imputaComptes;
	}


	public void setImputaSousComptes(List<ImputaSousCompte> imputaSousComptes) {
		this.imputaSousComptes = imputaSousComptes;
	}


	public void setImputaCodeFacts(List<ImputaCodeFact> imputaCodeFacts) {
		this.imputaCodeFacts = imputaCodeFacts;
	}


	public void setImputaCentreCouts(List<ImputaCentreCout> imputaCentreCouts) {
		this.imputaCentreCouts = imputaCentreCouts;
	}


	public void setSemaineTypes(List<SemaineType> semaineTypes) {
		this.semaineTypes = semaineTypes;
	}


	public void setTypePointages(List<TypePointage> typePointages) {
		this.typePointages = typePointages;
	}


	public void setTerminals(List<Terminal> terminals) {
		this.terminals = terminals;
	}


	public void setCodeCalendriers(List<CodeCalendrier> codeCalendriers) {
		this.codeCalendriers = codeCalendriers;
	}


	public void setCodeJour1s(List<CodeJour> codeJour1s) {
		this.codeJour1s = codeJour1s;
	}


	public void setJourneeTypes(List<JourneeType> journeeTypes) {
		this.journeeTypes = journeeTypes;
	}


	public void setCycleTravails(List<CycleTravail> cycleTravails) {
		this.cycleTravails = cycleTravails;
	}


	public void setCtajts(List<CycleTravailAssociateJourneeType> ctajts) {
		this.ctajts = ctajts;
	}


	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}


	public void setCompteurs(List<Compteur> compteurs) {
		this.compteurs = compteurs;
	}


	public void setAnomalies(List<Anomalie> anomalies) {
		this.anomalies = anomalies;
	}


	public void setClasseEmps(List<ClasseEmp> classeEmps) {
		this.classeEmps = classeEmps;
	}


	public void setGroupeCompteurs(List<GroupeCompteur> groupeCompteurs) {
		this.groupeCompteurs = groupeCompteurs;
	}


	public String getCodePlageHoraire() {
		return codePlageHoraire;
	}


	public String getCodeActiviteAbsence() {
		return codeActiviteAbsence;
	}


	public String getCodeactivitePresences() {
		return codeactivitePresences;
	}


	public String getCodeGroupeActivite() {
		return codeGroupeActivite;
	}


	public String getCodeGroupeImputation() {
		return codeGroupeImputation;
	}


	public String getCodeImputation() {
		return codeImputation;
	}


	public String getCodeImputaCompte() {
		return codeImputaCompte;
	}


	public String getCodeImputaSousCompte() {
		return codeImputaSousCompte;
	}


	public String getCodeImputaCodeFact() {
		return codeImputaCodeFact;
	}


	public String getCodeImputaCentreCout() {
		return codeImputaCentreCout;
	}


	public String getCodeSemaineType() {
		return codeSemaineType;
	}


	public String getCodeTypePointage() {
		return codeTypePointage;
	}


	public String getCodeTerminal() {
		return codeTerminal;
	}


	public String getCodeCodeCalendrier() {
		return codeCodeCalendrier;
	}


	public String getCodeCodeJour() {
		return codeCodeJour;
	}


	public String getCodeJourneeType() {
		return codeJourneeType;
	}


	public String getCodeCycleTravail() {
		return codeCycleTravail;
	}


	public String getCodeFiltre() {
		return codeFiltre;
	}


	public String getCodeCompteur() {
		return codeCompteur;
	}


	public String getCodeAnomalie() {
		return codeAnomalie;
	}


	public String getCodeClasseEmp() {
		return codeClasseEmp;
	}


	public String getCodeGroupeCompteur() {
		return codeGroupeCompteur;
	}


	public void setCodePlageHoraire(String codePlageHoraire) {
		this.codePlageHoraire = codePlageHoraire;
	}


	public void setCodeActiviteAbsence(String codeActiviteAbsence) {
		this.codeActiviteAbsence = codeActiviteAbsence;
	}


	public void setCodeactivitePresences(String codeactivitePresences) {
		this.codeactivitePresences = codeactivitePresences;
	}


	public void setCodeGroupeActivite(String codeGroupeActivite) {
		this.codeGroupeActivite = codeGroupeActivite;
	}


	public void setCodeGroupeImputation(String codeGroupeImputation) {
		this.codeGroupeImputation = codeGroupeImputation;
	}


	public void setCodeImputation(String codeImputation) {
		this.codeImputation = codeImputation;
	}


	public void setCodeImputaCompte(String codeImputaCompte) {
		this.codeImputaCompte = codeImputaCompte;
	}


	public void setCodeImputaSousCompte(String codeImputaSousCompte) {
		this.codeImputaSousCompte = codeImputaSousCompte;
	}


	public void setCodeImputaCodeFact(String codeImputaCodeFact) {
		this.codeImputaCodeFact = codeImputaCodeFact;
	}


	public void setCodeImputaCentreCout(String codeImputaCentreCout) {
		this.codeImputaCentreCout = codeImputaCentreCout;
	}


	public void setCodeSemaineType(String codeSemaineType) {
		this.codeSemaineType = codeSemaineType;
	}


	public void setCodeTypePointage(String codeTypePointage) {
		this.codeTypePointage = codeTypePointage;
	}


	public void setCodeTerminal(String codeTerminal) {
		this.codeTerminal = codeTerminal;
	}


	public void setCodeCodeCalendrier(String codeCodeCalendrier) {
		this.codeCodeCalendrier = codeCodeCalendrier;
	}


	public void setCodeCodeJour(String codeCodeJour) {
		this.codeCodeJour = codeCodeJour;
	}


	public void setCodeJourneeType(String codeJourneeType) {
		this.codeJourneeType = codeJourneeType;
	}


	public void setCodeCycleTravail(String codeCycleTravail) {
		this.codeCycleTravail = codeCycleTravail;
	}


	public void setCodeFiltre(String codeFiltre) {
		this.codeFiltre = codeFiltre;
	}


	public void setCodeCompteur(String codeCompteur) {
		this.codeCompteur = codeCompteur;
	}


	public void setCodeAnomalie(String codeAnomalie) {
		this.codeAnomalie = codeAnomalie;
	}


	public void setCodeClasseEmp(String codeClasseEmp) {
		this.codeClasseEmp = codeClasseEmp;
	}


	public void setCodeGroupeCompteur(String codeGroupeCompteur) {
		this.codeGroupeCompteur = codeGroupeCompteur;
	}


	public void setPlageHoraires(List<PlageHoraire> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}




	

}
