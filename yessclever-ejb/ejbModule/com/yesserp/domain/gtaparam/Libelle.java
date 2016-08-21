package com.yesserp.domain.gtaparam;

import java.io.Serializable;













import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.yesserp.domain.gta.Absence;
import com.yesserp.domain.pg.Categorie;
import com.yesserp.domain.pg.CodeGTA;
import com.yesserp.domain.pg.CategorieAffectationIdentite;
import com.yesserp.domain.pg.DebutSemaine;
import com.yesserp.domain.pg.Description_UO;
import com.yesserp.domain.pg.Description_poste;
import com.yesserp.domain.pg.EmploiAffectationIdentite;
import com.yesserp.domain.pg.Emploie;
import com.yesserp.domain.pg.Employeur;
import com.yesserp.domain.pg.Filiale;
import com.yesserp.domain.pg.Module;
import com.yesserp.domain.pg.MotifDentree;
import com.yesserp.domain.pg.MotifDinvalidite;
import com.yesserp.domain.pg.NatureContratIdentite;
import com.yesserp.domain.pg.ParametrageAbsence;
import com.yesserp.domain.pg.ParametrageAlerte;
import com.yesserp.domain.pg.ParametrageComptabilite;
import com.yesserp.domain.pg.ParametrageFrais;
import com.yesserp.domain.pg.ParametrageGTA;
import com.yesserp.domain.pg.ParametrageMail;
import com.yesserp.domain.pg.ParametrageModuleGlobale;
import com.yesserp.domain.pg.ParametrageStock;
import com.yesserp.domain.pg.ParametrageTM;
import com.yesserp.domain.pg.ParametrageWorkFlow;
import com.yesserp.domain.pg.Parametres_Generaux;
import com.yesserp.domain.pg.Parametres_fiscal;
import com.yesserp.domain.pg.Parametres_system;
import com.yesserp.domain.pg.Pays;
import com.yesserp.domain.pg.Person;
import com.yesserp.domain.pg.Poste;
import com.yesserp.domain.pg.PosteAffectationIdentite;
import com.yesserp.domain.pg.Qualite;
import com.yesserp.domain.pg.QualiteIdentite;
import com.yesserp.domain.pg.Sexe;
import com.yesserp.domain.pg.SexeIdentite;
import com.yesserp.domain.pg.SituationCivile;
import com.yesserp.domain.pg.SituationCivileIdentite;
import com.yesserp.domain.pg.SituationContratIdentite;
import com.yesserp.domain.pg.Societe;
import com.yesserp.domain.pg.StatutCollaborateur;
import com.yesserp.domain.pg.TempsDeService;
import com.yesserp.domain.pg.TypeAddress;
import com.yesserp.domain.pg.TypeContrat;
import com.yesserp.domain.pg.TypeContratIdentite;
import com.yesserp.domain.pg.TypeStatutIdentite;
import com.yesserp.domain.pg.TypeTel;
import com.yesserp.domain.pg.TypePieceIdentite;
import com.yesserp.domain.pg.UOAffectationIdentite;
import com.yesserp.domain.pg.Unite_organisationnelle;

/**
 * Entity implementation class for Entity: Libelle
 * 
 */
@Entity
public class Libelle implements Serializable {

	private int idlib;
	private String lib;
	private Langue langue;
	private SemaineType semaineType;
	private Filtre filtre;
	private ActiviteAbsence activiteAbsence;
	private ActivitePresence activitePresence;
	private CodeJour codeJour;
	private CycleTravail cycleTravail;
	private GroupeActivite groupeActivite;
	private GroupeImputation groupeImputation;
	private Imputation imputation;
	private JourneeType journeeType;
	private JourneeType2 journeeType2;
	private PlageHoraire plageHoraire;
	private PlageHoraire2 plageHoraire2;
	private NatureJournee natureJournee;
	private Compteur compteur;
	private CategorieDroit categoriedroit;
	private Droit droit;
	private GroupeCompteur groupeCompteur;
	private RubriquePaie rubPaie;
	private ImputaCompte imputaCompte;
	private ImputaSousCompte imputaSousCompte;
	private ImputaCentreCout imputaCentreCout;
	private ImputaCodeFact imputaCodeFact;
	private Absence absence;

	private Description_poste description_poste;
	private Description_UO description_UO;
	private Emploie emploie;
	private Employeur employeur;
	private Parametres_fiscal parametres_fiscal;
	private Parametres_Generaux parametres_Generaux;
	private Parametres_system parametres_system;
	private Person person;
	private Poste poste;
	private Societe societe;
	private Unite_organisationnelle unite_organisationnelle;
	private TypeContrat typeContrat;
	private TypeTel typeTel;

	private Filiale filiale;
	private Module module;
	private MotifDentree motifDentree;
	private MotifDinvalidite motifDinvalidite;
	private ParametrageModuleGlobale parametrageModuleGlobale;
	private Pays pays;
	private Qualite qualite;
	private SituationCivile situationCivile;
	private StatutCollaborateur statutCollaborateur;
	private TempsDeService tempsDeService;
	private TypeAddress typeAddress;
	private Sexe sexe;
	private TypeDePointage typeDePointage;
	private TypePieceIdentite typePieceIdentite;
	private ParametrageMail parametrageMail;
	private ParametrageAbsence parametrageAbsence;
	private ParametrageFrais parametrageFrais;
	private ParametrageGTA parametrageGTA;
	private ParametrageTM parametrageTM;
	private ParametrageStock parametrageStock;
	private ParametrageComptabilite parametrageComptabilite;
	private ParametrageWorkFlow parametrageWorkFlow;
	private ParametrageAlerte parametrageAlerte;
	private Categorie categoriee;
	private DebutSemaine pg_DebutSemaine;

	private CodeGTA codeGTA ;


	
	// PG Ga
	private SexeIdentite sexeIdentite;
	private QualiteIdentite qualiteIdentite;
	private SituationCivileIdentite situationCivileIdentite;
	private TypeStatutIdentite typeStatutIdentite;
	private TypeContratIdentite typeContratIdentite;
	private NatureContratIdentite natureContratIdentite;
	private SituationContratIdentite situationContratIdentite;
	private CategorieAffectationIdentite categorieAffectationIdentite;
	private PosteAffectationIdentite posteAffectationIdentite;
	private EmploiAffectationIdentite emploiAffectationIdentite;
	private UOAffectationIdentite uOAffectationIdentite;

	private static final long serialVersionUID = 1L;

	public Libelle() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdlib() {
		return this.idlib;
	}

	public void setIdlib(int idlib) {
		this.idlib = idlib;
	}

	public String getLib() {
		return this.lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	@ManyToOne
	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	@ManyToOne
	public SemaineType getSemaineType() {
		return semaineType;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

	@ManyToOne
	public Filtre getFiltre() {
		return filtre;
	}

	public void setFiltre(Filtre filtre) {
		this.filtre = filtre;
	}

	@ManyToOne
	public CodeJour getCodeJour() {
		return codeJour;
	}

	public void setCodeJour(CodeJour codeJour) {
		this.codeJour = codeJour;
	}

	@ManyToOne
	public CycleTravail getCycleTravail() {
		return cycleTravail;
	}

	public void setCycleTravail(CycleTravail cycleTravail) {
		this.cycleTravail = cycleTravail;
	}

	@ManyToOne
	public GroupeActivite getGroupeActivite() {
		return groupeActivite;
	}

	public void setGroupeActivite(GroupeActivite groupeActivite) {
		this.groupeActivite = groupeActivite;
	}

	@ManyToOne
	public GroupeImputation getGroupeImputation() {
		return groupeImputation;
	}

	public void setGroupeImputation(GroupeImputation groupeImputation) {
		this.groupeImputation = groupeImputation;
	}

	@ManyToOne
	public Imputation getImputation() {
		return imputation;
	}

	public void setImputation(Imputation imputation) {
		this.imputation = imputation;
	}

	@ManyToOne
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	@ManyToOne
	public JourneeType2 getJourneeType2() {
		return journeeType2;
	}

	public void setJourneeType2(JourneeType2 journeeType2) {
		this.journeeType2 = journeeType2;
	}

	@ManyToOne
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	
	
	
	@ManyToOne
	public PlageHoraire2 getPlageHoraire2() {
		return plageHoraire2;
	}

	public void setPlageHoraire2(PlageHoraire2 plageHoraire2) {
		this.plageHoraire2 = plageHoraire2;
	}

	@ManyToOne
	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}

	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;
	}

	@ManyToOne
	public ActivitePresence getActivitePresence() {
		return activitePresence;
	}

	public void setActivitePresence(ActivitePresence activitePresence) {
		this.activitePresence = activitePresence;
	}

	@ManyToOne
	public NatureJournee getNatureJournee() {
		return natureJournee;
	}

	public void setNatureJournee(NatureJournee natureJournee) {
		this.natureJournee = natureJournee;
	}

	@ManyToOne
	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	@ManyToOne
	public GroupeCompteur getGroupeCompteur() {
		return groupeCompteur;
	}

	public void setGroupeCompteur(GroupeCompteur groupeCompteur) {
		this.groupeCompteur = groupeCompteur;
	}

	@ManyToOne
	public CategorieDroit getCategorie() {
		return categoriedroit;
	}

	public void setCategorie(CategorieDroit categorie) {
		this.categoriedroit = categorie;
	}

	@ManyToOne
	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	@ManyToOne
	public RubriquePaie getRubPaie() {
		return rubPaie;
	}

	public void setRubPaie(RubriquePaie rubPaie) {
		this.rubPaie = rubPaie;
	}

	@ManyToOne
	public ImputaCompte getImputaCompte() {
		return imputaCompte;
	}

	public void setImputaCompte(ImputaCompte imputaCompte) {
		this.imputaCompte = imputaCompte;
	}

	@ManyToOne
	public ImputaSousCompte getImputaSousCompte() {
		return imputaSousCompte;
	}

	public void setImputaSousCompte(ImputaSousCompte imputaSousCompte) {
		this.imputaSousCompte = imputaSousCompte;
	}

	@ManyToOne
	public ImputaCentreCout getImputaCentreCout() {
		return imputaCentreCout;
	}

	public void setImputaCentreCout(ImputaCentreCout imputaCentreCout) {
		this.imputaCentreCout = imputaCentreCout;
	}

	@ManyToOne
	public ImputaCodeFact getImputaCodeFact() {
		return imputaCodeFact;
	}

	public void setImputaCodeFact(ImputaCodeFact imputaCodeFact) {
		this.imputaCodeFact = imputaCodeFact;
	}

	@ManyToOne
	@JoinColumn(name = "absence_fk")
	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	@ManyToOne
	public Description_poste getDescription_poste() {
		return description_poste;
	}

	public void setDescription_poste(Description_poste description_poste) {
		this.description_poste = description_poste;
	}

	@ManyToOne
	public Description_UO getDescription_UO() {
		return description_UO;
	}

	public void setDescription_UO(Description_UO description_UO) {
		this.description_UO = description_UO;
	}

	@ManyToOne
	public Emploie getEmploie() {
		return emploie;
	}

	public void setEmploie(Emploie emploie) {
		this.emploie = emploie;
	}

	@ManyToOne
	public Employeur getEmployeur() {
		return employeur;
	}

	public void setEmployeur(Employeur employeur) {
		this.employeur = employeur;
	}

	@ManyToOne
	public Parametres_fiscal getParametres_fiscal() {
		return parametres_fiscal;
	}

	public void setParametres_fiscal(Parametres_fiscal parametres_fiscal) {
		this.parametres_fiscal = parametres_fiscal;
	}

	@ManyToOne
	public Parametres_Generaux getParametres_Generaux() {
		return parametres_Generaux;
	}

	public void setParametres_Generaux(Parametres_Generaux parametres_Generaux) {
		this.parametres_Generaux = parametres_Generaux;
	}

	@ManyToOne
	public Parametres_system getParametres_system() {
		return parametres_system;
	}

	public void setParametres_system(Parametres_system parametres_system) {
		this.parametres_system = parametres_system;
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	@ManyToOne
	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	@ManyToOne
	public Unite_organisationnelle getUnite_organisationnelle() {
		return unite_organisationnelle;
	}

	public void setUnite_organisationnelle(
			Unite_organisationnelle unite_organisationnelle) {
		this.unite_organisationnelle = unite_organisationnelle;
	}

	@ManyToOne
	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	@ManyToOne
	public TypeTel getTypeTel() {
		return typeTel;
	}

	public void setTypeTel(TypeTel typeTel) {
		this.typeTel = typeTel;
	}

	@ManyToOne
	public CategorieDroit getCategoriedroit() {
		return categoriedroit;
	}

	public void setCategoriedroit(CategorieDroit categoriedroit) {
		this.categoriedroit = categoriedroit;
	}

	@ManyToOne
	public Filiale getFiliale() {
		return filiale;
	}

	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}

	@ManyToOne
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@ManyToOne
	public MotifDentree getMotifDentree() {
		return motifDentree;
	}

	public void setMotifDentree(MotifDentree motifDentree) {
		this.motifDentree = motifDentree;
	}

	@ManyToOne
	public MotifDinvalidite getMotifDinvalidite() {
		return motifDinvalidite;
	}

	public void setMotifDinvalidite(MotifDinvalidite motifDinvalidite) {
		this.motifDinvalidite = motifDinvalidite;
	}

	@ManyToOne
	public ParametrageModuleGlobale getParametrageModuleGlobale() {
		return parametrageModuleGlobale;
	}

	public void setParametrageModuleGlobale(
			ParametrageModuleGlobale parametrageModuleGlobale) {
		this.parametrageModuleGlobale = parametrageModuleGlobale;
	}

	@ManyToOne
	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@ManyToOne
	public Qualite getQualite() {
		return qualite;
	}

	public void setQualite(Qualite qualite) {
		this.qualite = qualite;
	}

	@ManyToOne
	public SituationCivile getSituationCivile() {
		return situationCivile;
	}

	public void setSituationCivile(SituationCivile situationCivile) {
		this.situationCivile = situationCivile;
	}

	@ManyToOne
	public StatutCollaborateur getStatutCollaborateur() {
		return statutCollaborateur;
	}

	public void setStatutCollaborateur(StatutCollaborateur statutCollaborateur) {
		this.statutCollaborateur = statutCollaborateur;
	}

	@ManyToOne
	public TempsDeService getTempsDeService() {
		return tempsDeService;
	}

	public void setTempsDeService(TempsDeService tempsDeService) {
		this.tempsDeService = tempsDeService;
	}

	@ManyToOne
	public TypeAddress getTypeAddress() {
		return typeAddress;
	}

	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress;
	}

	@ManyToOne
	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	@ManyToOne
	public TypeDePointage getTypeDePointage() {
		return typeDePointage;
	}

	public void setTypeDePointage(TypeDePointage typeDePointage) {
		this.typeDePointage = typeDePointage;
	}

	@ManyToOne
	public ParametrageMail getParametrageMail() {
		return parametrageMail;
	}

	public void setParametrageMail(ParametrageMail parametrageMail) {
		this.parametrageMail = parametrageMail;
	}

	@ManyToOne
	public ParametrageAbsence getParametrageAbsence() {
		return parametrageAbsence;
	}

	public void setParametrageAbsence(ParametrageAbsence parametrageAbsence) {
		this.parametrageAbsence = parametrageAbsence;
	}

	@ManyToOne
	public ParametrageFrais getParametrageFrais() {
		return parametrageFrais;
	}

	public void setParametrageFrais(ParametrageFrais parametrageFrais) {
		this.parametrageFrais = parametrageFrais;
	}

	@ManyToOne
	public ParametrageGTA getParametrageGTA() {
		return parametrageGTA;
	}

	public void setParametrageGTA(ParametrageGTA parametrageGTA) {
		this.parametrageGTA = parametrageGTA;
	}

	@ManyToOne
	public ParametrageTM getParametrageTM() {
		return parametrageTM;
	}

	public void setParametrageTM(ParametrageTM parametrageTM) {
		this.parametrageTM = parametrageTM;
	}

	@ManyToOne
	public ParametrageStock getParametrageStock() {
		return parametrageStock;
	}

	public void setParametrageStock(ParametrageStock parametrageStock) {
		this.parametrageStock = parametrageStock;
	}

	@ManyToOne
	public ParametrageWorkFlow getParametrageWorkFlow() {
		return parametrageWorkFlow;
	}

	public void setParametrageWorkFlow(ParametrageWorkFlow parametrageWorkFlow) {
		this.parametrageWorkFlow = parametrageWorkFlow;
	}

	@ManyToOne
	public ParametrageAlerte getParametrageAlerte() {
		return parametrageAlerte;
	}

	public void setParametrageAlerte(ParametrageAlerte parametrageAlerte) {
		this.parametrageAlerte = parametrageAlerte;
	}

	@ManyToOne
	public Categorie getCategoriee() {
		return categoriee;
	}

	public void setCategoriee(Categorie categoriee) {
		this.categoriee = categoriee;
	}

	@ManyToOne
	public ParametrageComptabilite getParametrageComptabilite() {
		return parametrageComptabilite;
	}

	public void setParametrageComptabilite(
			ParametrageComptabilite parametrageComptabilite) {
		this.parametrageComptabilite = parametrageComptabilite;
	}

	@ManyToOne
	public DebutSemaine getPg_DebutSemaine() {
		return pg_DebutSemaine;
	}

	public void setPg_DebutSemaine(DebutSemaine pg_DebutSemaine) {
		this.pg_DebutSemaine = pg_DebutSemaine;
	}

	@ManyToOne
	public TypePieceIdentite getTypePieceIdentite() {
		return typePieceIdentite;
	}

	public void setTypePieceIdentite(TypePieceIdentite typePieceIdentite) {
		this.typePieceIdentite = typePieceIdentite;
	}


	
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}


	@ManyToOne
	public SexeIdentite getSexeIdentite() {
		return sexeIdentite;
	}

	public void setSexeIdentite(SexeIdentite sexeIdentite) {
		this.sexeIdentite = sexeIdentite;
	}

	@ManyToOne
	public QualiteIdentite getQualiteIdentite() {
		return qualiteIdentite;
	}

	public void setQualiteIdentite(QualiteIdentite qualiteIdentite) {
		this.qualiteIdentite = qualiteIdentite;
	}

	@ManyToOne
	public SituationCivileIdentite getSituationCivileIdentite() {
		return situationCivileIdentite;
	}

	public void setSituationCivileIdentite(
			SituationCivileIdentite situationCivileIdentite) {
		this.situationCivileIdentite = situationCivileIdentite;
	}

	@ManyToOne
	public TypeStatutIdentite getTypeStatutIdentite() {
		return typeStatutIdentite;
	}

	public void setTypeStatutIdentite(TypeStatutIdentite typeStatutIdentite) {
		this.typeStatutIdentite = typeStatutIdentite;
	}

	@ManyToOne
	public TypeContratIdentite getTypeContratIdentite() {
		return typeContratIdentite;
	}

	public void setTypeContratIdentite(TypeContratIdentite typeContratIdentite) {
		this.typeContratIdentite = typeContratIdentite;
	}

	@ManyToOne
	public NatureContratIdentite getNatureContratIdentite() {
		return natureContratIdentite;
	}

	public void setNatureContratIdentite(NatureContratIdentite natureContratIdentite) {
		this.natureContratIdentite = natureContratIdentite;
	}

	@ManyToOne
	public SituationContratIdentite getSituationContratIdentite() {
		return situationContratIdentite;
	}

	public void setSituationContratIdentite(
			SituationContratIdentite situationContratIdentite) {
		this.situationContratIdentite = situationContratIdentite;
	}

	@ManyToOne
	public CategorieAffectationIdentite getCategorieAffectationIdentite() {
		return categorieAffectationIdentite;
	}

	public void setCategorieAffectationIdentite(
			CategorieAffectationIdentite categorieAffectationIdentite) {
		this.categorieAffectationIdentite = categorieAffectationIdentite;
	}

	@ManyToOne
	public PosteAffectationIdentite getPosteAffectationIdentite() {
		return posteAffectationIdentite;
	}

	public void setPosteAffectationIdentite(
			PosteAffectationIdentite posteAffectationIdentite) {
		this.posteAffectationIdentite = posteAffectationIdentite;
	}

	@ManyToOne
	public EmploiAffectationIdentite getEmploiAffectationIdentite() {
		return emploiAffectationIdentite;
	}

	public void setEmploiAffectationIdentite(
			EmploiAffectationIdentite emploiAffectationIdentite) {
		this.emploiAffectationIdentite = emploiAffectationIdentite;
	}

	@ManyToOne
	public UOAffectationIdentite getuOAffectationIdentite() {
		return uOAffectationIdentite;
	}

	public void setuOAffectationIdentite(UOAffectationIdentite uOAffectationIdentite) {
		this.uOAffectationIdentite = uOAffectationIdentite;
	}
	


}
