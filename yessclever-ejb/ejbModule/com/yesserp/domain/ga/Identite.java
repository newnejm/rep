package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yesserp.domain.crm.Action;
import com.yesserp.domain.gf.DemandeFrais;
import com.yesserp.domain.gta.Absence;
import com.yesserp.domain.gta.ActiviteReelCalculer;
import com.yesserp.domain.gta.ActiviteReelSaisie;
import com.yesserp.domain.gta.AffectationCycle;
import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.CodeCalendrier;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gta.ExceptionPlageHoraire;
import com.yesserp.domain.gta.ExceptionSemaineType;
import com.yesserp.domain.gta.Exceptionjournee;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.List_Identity;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.gtaparam.GroupeActivite;
import com.yesserp.domain.gtaparam.GroupeCompteur;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.tm.Conge;
import com.yesserp.domain.tm.DemandeFormation;
import com.yesserp.domain.tm.Departement;
import com.yesserp.domain.tm.Diplome;
import com.yesserp.domain.tm.EmployeCompetence;
import com.yesserp.domain.tm.EmployeFormation;
import com.yesserp.domain.tm.FormationPl;
import com.yesserp.domain.tm.LangageMaternelle;
import com.yesserp.domain.tm.Offre;


/**
 * The persistent class for the ga_identite database table.
 * 
 */

@Entity
@Table(name = "ga_identite")
@NamedQuery(name = "Identite.findAll", query = "SELECT g FROM Identite g")
public class Identite implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long numedoss;
	private String matricul;
	private String nom;
	private String prenom;
	private String qualite;
	private String nomjfill;
	private String sexe;
	private byte[] photo;
	private InfosIndividuelles infosIndividuelles;
	private InfosPhysiques infosPhysiques;
	private List<PersonneACharge> personnesACharge;
	
	private List<PieceIdentite> piecesIdentite;
	private List<Profil> profils;
	private List<Cycle> cycles;
	private List<Adresse> adresses;
	private List<Telephone> telephones;
	private List<Mail> mails;
	private List<SituationCivile> situationCiviles;
	private List<Embauche> embauches;
	private List<Statut> statuts;
	private List<Nationalite> nationalites;
	private Naissance naissance;
	private List<CoordonneeBancaire> coordonneeBancaires;
	private List<SituationMedicale> situationMedicales;
	private List<Vehicule> vehicules;
	private ContratGta contratGta;
	private CodeCalendrier codeCalendrier;
	private List<Absence> absences;
	private SocieteGa societe;
	private List<DemandeFrais> demandesFrais;
	private List<ActiviteReelCalculer> activiteReelClaculers;
	private List<ActiviteReelSaisie> activiteReelSaisies;
	private List<PlanningReel> planningReels;
	private List<Action> actions;
	private List<GroupeImputation> groupeImputations ;
	private List<GroupeActivite> groupeActivites ;
	private List<GroupeCompteur> groupeCompteurs ;
	private List<ClasseEmp> classEmps ;
	private List<ContratGta> contratGtas ; 
	private List<GroupeIdentity> groupeIdentity;
	private List_Identity listIdentity;
	
	

	@ManyToMany
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	private List<Exceptionjournee> exceptionjournees;
	private List<ExceptionSemaineType> exceptionSemaineTypes;
	private List<ExceptionPlageHoraire> exceptionPlageHoraires;
	private List<AffectationCycle> affectationCycles;

	private List<CalculGta> calculGtas;
	

	
	private List<DiplomeGa> diplomes;
	private List<Certification> certifications;
	private List<Experience> experiences;
	
	// ajouté par sofien relation one to many (afectations code calendriers)
	


	// //attributs ajoutés par TM
	private List<Conge> conges;
	private List<FormationPl> formationpl;
	private Departement departement;
	 private List<LangageMaternelle> langages;
	
    private List<DemandeFormation> demandes;
	private Long manager;
	 private List<Offre> offres;
	 private List<DemandeFormation> demandesmanager;
	
	
	 private List<EmployeCompetence> empcomp;
	 private List<EmployeFormation> empform;
 private List<Diplome> empdip;
	// //*************************
	//

	public Identite() {
	}

	/**
	 * @return numï¿½ro dossier du collaborateur -- id gï¿½nï¿½rï¿½ automatiquement
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getNumedoss() {
		return this.numedoss;
	}

	public void setNumedoss(Long numedoss) {
		this.numedoss = numedoss;
	}

	/**
	 * @return matricule qu'on gï¿½nï¿½re depuis une fonction ou qu'on peut saisir ï¿½
	 *         l'entrï¿½e du nouveau collaborateur
	 */
	@Column(unique = true, nullable = false)
	public String getMatricul() {
		return this.matricul;
	}

	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}

	/**
	 * @return nom du collaborateur
	 */
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prï¿½nom du collaborateur
	 */
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return informations individuelles -- un seul objet doit ï¿½tre stoquï¿½
	 */
	@OneToOne(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public InfosIndividuelles getInfosIndividuelles() {
		return infosIndividuelles;
	}

	public void setInfosIndividuelles(InfosIndividuelles infosIndividuelles) {
		this.infosIndividuelles = infosIndividuelles;
	}

	/**
	 * @return informations physiques -- un seul objet doit ï¿½tre stoquï¿½
	 */
	@OneToOne(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public InfosPhysiques getInfosPhysiques() {
		return infosPhysiques;
	}

	public void setInfosPhysiques(InfosPhysiques infosPhysiques) {
		this.infosPhysiques = infosPhysiques;
	}

	/**
	 * @return liste des personnes ï¿½ charge du collaborateur
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<PersonneACharge> getPersonnesACharge() {
		return personnesACharge;
	}

	public void setPersonnesACharge(List<PersonneACharge> personnesACharge) {
		this.personnesACharge = personnesACharge;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

	/**
	 * @return cycle appliquï¿½ au collaborateur avec liste des cycles historisï¿½s
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Cycle> getCycles() {
		return cycles;
	}

	public void setCycles(List<Cycle> cycles) {
		this.cycles = cycles;
	}

	/**
	 * @return liste des adresses du collaborateur
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	/**
	 * @return situation familiale du collaborateur avec les situations
	 *         historisï¿½es
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<SituationCivile> getSituationCiviles() {
		return situationCiviles;
	}

	public void setSituationCiviles(List<SituationCivile> situationCiviles) {
		this.situationCiviles = situationCiviles;
	}

	/**
	 * @return embauche du collaborateur avec liste des embauches historisï¿½s
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Embauche> getEmbauches() {
		return embauches;
	}

	public void setEmbauches(List<Embauche> embauches) {
		this.embauches = embauches;
	}

	/**
	 * @return liste des tï¿½lï¿½phones du collaborateur
	 */

	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	/**
	 * @return liste des adresses mail du collaborateur
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Mail> getMails() {
		return mails;
	}

	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}

	/**
	 * @return statut du collaborateur aves liste des statuts historisï¿½s
	 */
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Statut> getStatuts() {
		return statuts;
	}

	public void setStatuts(List<Statut> statuts) {
		this.statuts = statuts;
	}

	/**
	 * @return cycle de travail liï¿½ ï¿½ la GTA
	 */

	/**
	 * @return photo -- stoquï¿½e en type bytea en base de donnï¿½es
	 */
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return qualitï¿½ du collaborateur: Mr/Mme/Mlle
	 */
	public String getQualite() {
		return qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}

	/**
	 * @return nom de jeune fille
	 */
	public String getNomjfill() {
		return nomjfill;
	}

	public void setNomjfill(String nomjfill) {
		this.nomjfill = nomjfill;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Nationalite> getNationalites() {
		return nationalites;
	}

	public void setNationalites(List<Nationalite> nationalites) {
		this.nationalites = nationalites;
	}

	@OneToOne(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public Naissance getNaissance() {
		return naissance;
	}

	public void setNaissance(Naissance naissance) {
		this.naissance = naissance;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<CoordonneeBancaire> getCoordonneeBancaires() {
		return coordonneeBancaires;
	}

	public void setCoordonneeBancaires(
			List<CoordonneeBancaire> coordonneeBancaires) {
		this.coordonneeBancaires = coordonneeBancaires;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<SituationMedicale> getSituationMedicales() {
		return situationMedicales;
	}

	public void setSituationMedicales(List<SituationMedicale> situationMedicales) {
		this.situationMedicales = situationMedicales;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@ManyToOne
	public ContratGta getContratGta() {
		return contratGta;
	}

	public void setContratGta(ContratGta contratGta) {
		this.contratGta = contratGta;
	}

	@ManyToOne
	public CodeCalendrier getCodeCalendrier() {
		return codeCalendrier;
	}

	public void setCodeCalendrier(CodeCalendrier codeCalendrier) {
		this.codeCalendrier = codeCalendrier;
	}

	@ManyToOne
	@JoinColumn(name = "societe")
	public SocieteGa getSociete() {
		return societe;
	}

	public void setSociete(SocieteGa societe) {
		this.societe = societe;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.ALL)
	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.ALL)
	public List<DemandeFrais> getDemandesFrais() {
		return demandesFrais;
	}

	public void setDemandesFrais(List<DemandeFrais> demandesFrais) {
		this.demandesFrais = demandesFrais;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.ALL)
	public List<ActiviteReelCalculer> getActiviteReelClaculers() {
		return activiteReelClaculers;
	}

	public void setActiviteReelClaculers(
			List<ActiviteReelCalculer> activiteReelClaculers) {
		this.activiteReelClaculers = activiteReelClaculers;
	}

	@OneToMany(mappedBy = "identite", cascade = CascadeType.ALL)
	public List<ActiviteReelSaisie> getActiviteReelSaisies() {
		return activiteReelSaisies;
	}

	public void setActiviteReelSaisies(
			List<ActiviteReelSaisie> activiteReelSaisies) {
		this.activiteReelSaisies = activiteReelSaisies;
	}

	@OneToMany(mappedBy = "identite")
	public List<PlanningReel> getPlanningReels() {
		return planningReels;
	}

	public void setPlanningReels(List<PlanningReel> planningReels) {
		this.planningReels = planningReels;
	}

	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@OneToMany(mappedBy = "identite")
	public List<Exceptionjournee> getExceptionjournees() {
		return exceptionjournees;
	}

	public void setExceptionjournees(List<Exceptionjournee> exceptionjournees) {
		this.exceptionjournees = exceptionjournees;
	}

	@OneToMany(mappedBy = "identite")
	public List<ExceptionSemaineType> getExceptionSemaineTypes() {
		return exceptionSemaineTypes;
	}

	public void setExceptionSemaineTypes(
			List<ExceptionSemaineType> exceptionSemaineTypes) {
		this.exceptionSemaineTypes = exceptionSemaineTypes;
	}

	@OneToMany(mappedBy = "identite")
	public List<ExceptionPlageHoraire> getExceptionPlageHoraires() {
		return exceptionPlageHoraires;
	}

	public void setExceptionPlageHoraires(
			List<ExceptionPlageHoraire> exceptionPlageHoraires) {
		this.exceptionPlageHoraires = exceptionPlageHoraires;
	}

	@OneToMany(mappedBy = "identite")
	public List<AffectationCycle> getAffectationCycles() {
		return affectationCycles;
	}

	public void setAffectationCycles(List<AffectationCycle> affectationCycles) {
		this.affectationCycles = affectationCycles;
	}
	
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
	
	@OneToMany(mappedBy = "identite", cascade = CascadeType.REMOVE)
	public List<DiplomeGa> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<DiplomeGa> diplomes) {
		this.diplomes = diplomes;
	}

	@OneToMany(mappedBy="identite")
	public List<CalculGta> getCalculGtas() {
		return calculGtas;
	}

	public void setCalculGtas(List<CalculGta> calculGtas) {
		this.calculGtas = calculGtas;
	}

	//*********************************
	@OneToMany(mappedBy = "identite")
	public List<Conge> getConges() {
		return conges;
	}

	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}
	

	@OneToMany(mappedBy = "identite")
	public List<FormationPl> getFormationpl() {
		return formationpl;
	}

	public void setFormationpl(List<FormationPl> formationpl) {
		this.formationpl = formationpl;
	}

	@ManyToOne
	@JoinColumn(name="departement")
    public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
    
	@ManyToMany
	public List<LangageMaternelle> getLangages() {
		return langages;
	}

	public void setLangages(List<LangageMaternelle> langages) {
		this.langages = langages;
	}
	
	@OneToMany(mappedBy="identite"/*,fetch=FetchType.EAGER*/)
	public List<EmployeCompetence> getEmpcomp() {
		return empcomp;
	}

	public void setEmpcomp(List<EmployeCompetence> empcomp) {
		this.empcomp = empcomp;
	}

	@ManyToMany//(fetch=FetchType.EAGER)
	public List<Diplome> getEmpdip() {
		return empdip;
	}

	public void setEmpdip(List<Diplome> empdip) {
		this.empdip = empdip;
	}
	
	
	
	
	

	public void assignEmployeCompetenceToThisIdentite(List<EmployeCompetence> employes){
		this.setEmpcomp(employes);
		for(EmployeCompetence ec : employes)
		ec.setIdentite(this);	
         			
		
	}
	
	@OneToMany(mappedBy="identite"/*,fetch=FetchType.EAGER*/)
	public List<EmployeFormation> getEmpform() {
		return empform;
	}

	public void setEmpform(List<EmployeFormation> empform) {
		this.empform = empform;
	}
	
	public void assignEmployeFormationToThisIdentite(List<EmployeFormation> employes){
		this.setEmpform(employes);
		for(EmployeFormation ef : employes)
		ef.setIdentite(this);	
         			
		
	}
	@ManyToMany//(fetch=FetchType.EAGER)
	public List<DemandeFormation> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeFormation> demandes) {
		this.demandes = demandes;
	}

	public Long getManager() {
		return manager;
	}

	public void setManager(Long manager) {
		this.manager = manager;
	}
	@OneToMany(mappedBy = "identite")
	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	
	@OneToMany(mappedBy = "manager"/*,fetch=FetchType.EAGER*/)
	public List<DemandeFormation> getDemandesmanager() {
		return demandesmanager;
	}

	public void setDemandesmanager(List<DemandeFormation> demandesmanager) {
		this.demandesmanager = demandesmanager;
	}
   //**********************************

	
	
	
	@OneToMany(mappedBy = "identite")
	public List<GroupeImputation> getGroupeImputations() {
		return groupeImputations;
	}

	public void setGroupeImputations(List<GroupeImputation> groupeImputations) {
		this.groupeImputations = groupeImputations;
	}

	
	@OneToMany(mappedBy = "identite")
	public List<GroupeActivite> getGroupeActivites() {
		return groupeActivites;
	}

	public void setGroupeActivites(List<GroupeActivite> groupeActivites) {
		this.groupeActivites = groupeActivites;
	}
	@OneToMany(mappedBy = "identite")
	public List<GroupeCompteur> getGroupeCompteurs() {
		return groupeCompteurs;
	}

	public void setGroupeCompteurs(List<GroupeCompteur> groupeCompteurs) {
		this.groupeCompteurs = groupeCompteurs;
	}
	
	
	@OneToMany(mappedBy = "identite")
	public List<ClasseEmp> getClassEmps() {
		return classEmps;
	}

	public void setClassEmps(List<ClasseEmp> classEmps) {
		this.classEmps = classEmps;
	}
	@OneToMany(mappedBy = "identite")
	public List<ContratGta> getContratGtas() {
		return contratGtas;
	}

	public void setContratGtas(List<ContratGta> contratGtas) {
		this.contratGtas = contratGtas;
	}

	@OneToMany(mappedBy = "identite")
	public List<PieceIdentite> getPiecesIdentite() {
		return piecesIdentite;
	}

	public void setPiecesIdentite(List<PieceIdentite> piecesIdentite) {
		this.piecesIdentite = piecesIdentite;
	}

	/**
	 * @return the groupeIdentity
	 */

	
	@ManyToOne

	public List_Identity getListIdentity() {
		return listIdentity;
	}

	public void setListIdentity(List_Identity listIdentity) {
		this.listIdentity = listIdentity;
	}

	/**
	 * @return the groupeIdentity
	 */
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="identites")
	public List<GroupeIdentity> getGroupeIdentity() {
		return groupeIdentity;
	}

	/**
	 * @param groupeIdentity the groupeIdentity to set
	 */
	public void setGroupeIdentity(List<GroupeIdentity> groupeIdentity) {
		this.groupeIdentity = groupeIdentity;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}