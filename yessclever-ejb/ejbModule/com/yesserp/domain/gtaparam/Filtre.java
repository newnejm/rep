package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: Filtre
 * 
 */
@Entity(name = "Fi")
@Table(name = "GTA_FP_UR01")
public class Filtre implements Serializable {

	private int idf;
	private String codef;
	private Date heuredeb;
	private Date heurefin;
	private List<NatureJournee> natureJournees;
	private List<GroupeActivite> groupeActivites;
	private List<ActiviteAbsence> activiteAbsences;
	private List<ActivitePresence> activitePresences;
	private List<GroupeImputation> groupeImputations;
	private List<Imputation> imputations;
	private List<JourneeType> journeeTypes;
	private List<JourneeType2> journeeType2s ;
	private List<CodeJour> codeJours;
	private List<Libelle> libelles;
	private List<FormuleCompteur>formuleCompteurs;
	private CodeGTA codeGTA ;
	private static final long serialVersionUID = 1L;

	public Filtre() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdf() {
		return this.idf;
	}

	public void setIdf(int idf) {
		this.idf = idf;
	}

	public String getCodef() {
		return this.codef;
	}

	public void setCodef(String codef) {
		this.codef = codef;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_GRPAP_RH01")
	public List<GroupeActivite> getGroupeActivites() {
		return groupeActivites;
	}

	public void setGroupeActivites(List<GroupeActivite> groupeActivites) {
		this.groupeActivites = groupeActivites;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_GRPIP_RH01")
	public List<GroupeImputation> getGroupeImputations() {
		return groupeImputations;
	}

	public void setGroupeImputations(List<GroupeImputation> groupeImputations) {
		this.groupeImputations = groupeImputations;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_IP_RH01")
	public List<Imputation> getImputations() {
		return imputations;
	}

	public void setImputations(List<Imputation> imputations) {
		this.imputations = imputations;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_JTP_RH01")
	public List<JourneeType> getJourneeTypes() {
		return journeeTypes;
	}

	public void setJourneeTypes(List<JourneeType> journeeTypes) {
		this.journeeTypes = journeeTypes;
	}
	
	@ManyToMany
	@JoinTable
	public List<JourneeType2> getJourneeType2s() {
		return journeeType2s;
	}

	public void setJourneeType2s(List<JourneeType2> journeeType2s) {
		this.journeeType2s = journeeType2s;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_CJP_RH01")
	public List<CodeJour> getCodeJours() {
		return codeJours;
	}

	public void setCodeJours(List<CodeJour> codeJours) {
		this.codeJours = codeJours;
	}

	@OneToMany(mappedBy = "filtre")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_AABS_RH01")
	public List<ActiviteAbsence> getActiviteAbsences() {
		return activiteAbsences;
	}

	public void setActiviteAbsences(List<ActiviteAbsence> activiteAbsences) {
		this.activiteAbsences = activiteAbsences;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_APRE_RH01")
	public List<ActivitePresence> getActivitePresences() {
		return activitePresences;
	}

	public void setActivitePresences(List<ActivitePresence> activitePresences) {
		this.activitePresences = activitePresences;
	}

	@ManyToMany
	@JoinTable(name = "GTA_FP_NJP_UH01")
	public List<NatureJournee> getNatureJournees() {
		return natureJournees;
	}

	public void setNatureJournees(List<NatureJournee> natureJournees) {
		this.natureJournees = natureJournees;
	}


	@Temporal(TemporalType.TIME)
	public Date getHeuredeb() {
		return heuredeb;
	}

	public void setHeuredeb(Date heuredeb) {
		this.heuredeb = heuredeb;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeurefin() {
		return heurefin;
	}

	public void setHeurefin(Date heurefin) {
		this.heurefin = heurefin;
	}

	
	@ManyToMany(mappedBy = "filters")
	public List<FormuleCompteur> getFormuleCompteurs() {
		return formuleCompteurs;
	}

	public void setFormuleCompteurs(List<FormuleCompteur> formuleCompteurs) {
		this.formuleCompteurs = formuleCompteurs;
	}
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}
}
