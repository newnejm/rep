package managedBeans.gtaparam;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;

import org.apache.commons.io.IOUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.yesserp.domain.ga.Adresse;
import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementEmploye;
import com.yesserp.domain.ga.AttachementManager;
import com.yesserp.domain.ga.Certification;
import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.CoordonneeBancaire;
import com.yesserp.domain.ga.Cycle;
import com.yesserp.domain.ga.DiplomeGa;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Experience;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.ImputationGa;
import com.yesserp.domain.ga.InfosIndividuelles;
import com.yesserp.domain.ga.InfosPhysiques;
import com.yesserp.domain.ga.Mail;
import com.yesserp.domain.ga.Naissance;
import com.yesserp.domain.ga.Nationalite;
import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.ga.Profil;
import com.yesserp.domain.ga.Salaire;
import com.yesserp.domain.ga.SituationCivile;
import com.yesserp.domain.ga.SituationMedicale;
import com.yesserp.domain.ga.Statut;
import com.yesserp.domain.ga.Telephone;
import com.yesserp.domain.ga.Vehicule;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.List_Identity;
import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.pg.Age;
import com.yesserp.domain.pg.DateEmbauche;
import com.yesserp.domain.pg.RechercheAvancee;
import com.yesserp.domain.pg.TypePieceIdentite;
import com.yesserp.sessionbean.ga.adresse.GestionAdresseLocal;
import com.yesserp.sessionbean.ga.affectation.GestionAffectationLocal;
import com.yesserp.sessionbean.ga.attachementemploye.GestionAttachementEmployeLocal;
import com.yesserp.sessionbean.ga.attachementmanager.GestionAttachementManagerLocal;
import com.yesserp.sessionbean.ga.cetification.GestionCertificationLocal;
import com.yesserp.sessionbean.ga.contrat.GestionContratLocal;
import com.yesserp.sessionbean.ga.coordonneebancaire.GestionCoordonneeBancaireLocal;
import com.yesserp.sessionbean.ga.cycle.GestionCycleLocal;
import com.yesserp.sessionbean.ga.diplome.GestionDiplomeGaLocal;
import com.yesserp.sessionbean.ga.embauche.GestionEmbaucheLocal;
import com.yesserp.sessionbean.ga.experience.GestionExperienceLocal;
import com.yesserp.sessionbean.ga.identite.GestionIdentite;
import com.yesserp.sessionbean.ga.identite.GestionIdentiteLocal;
import com.yesserp.sessionbean.ga.imputationga.GestionImputationGaLocal;
import com.yesserp.sessionbean.ga.infosindividuelles.GestionInfosIndividuellesLocal;
import com.yesserp.sessionbean.ga.infosphysiques.GestionInfosPhysiquesLocal;
import com.yesserp.sessionbean.ga.mail.GestionMailLocal;
import com.yesserp.sessionbean.ga.naissance.GestionNaissanceLocal;
import com.yesserp.sessionbean.ga.nationalite.GestionNationaliteLocal;
import com.yesserp.sessionbean.ga.personneacharge.GestionPersonneAChargeLocal;
import com.yesserp.sessionbean.ga.pieceidentite.GestionPieceIdentiteLocal;
import com.yesserp.sessionbean.ga.profil.GestionProfilLocal;
import com.yesserp.sessionbean.ga.salaire.GestionSalaireLocal;
import com.yesserp.sessionbean.ga.situation.GestionSituationCivileLocal;
import com.yesserp.sessionbean.ga.situationmedicale.GestionSituationMedicaleLocal;
import com.yesserp.sessionbean.ga.statut.GestionStatutLocal;
import com.yesserp.sessionbean.ga.telephone.GestionTelephoneLocal;
import com.yesserp.sessionbean.ga.vehicule.GestionVehiculeLocal;
import com.yesserp.sessionbean.paramgta.gestiongroupeselect.gestionGroupeSelect;
import com.yesserp.sessionbean.paramgta.gestiongroupeselect.gestionGroupeSelectLocal;
import com.yesserp.sessionbean.pg.gestionRechercheAvancee.GestionRechercheAvanceeLocal;
import com.yesserp.sessionbean.pg.gestionTypePieceIdentite.GestionTypePieceIdentiteLocal;

@ManagedBean(name = "DonneesIndivJobsBean")
@ViewScoped
public class DonneesIndivJobsBean {

	@EJB
	gestionGroupeSelectLocal gestionGroupeSelectLocal;
	@EJB
	gestionGroupeSelect gestionGroupeSelect;

	@EJB
	GestionRechercheAvanceeLocal gestionRechercheAvanceeLocal;

	@EJB
	GestionTypePieceIdentiteLocal gestionTypePieceIdentiteLocal;
	@EJB
	GestionIdentiteLocal gestionIdentiteLocal;
	@EJB
	GestionInfosIndividuellesLocal gestionInfosIndividuellesLocal;
	@EJB
	GestionInfosPhysiquesLocal gestionInfosPhysiquesLocal;
	@EJB
	GestionAdresseLocal gestionAdresseLocal;
	@EJB
	GestionSituationCivileLocal gestionSituationCivileLocal;
	@EJB
	GestionNationaliteLocal gestionNationaliteLocal;
	@EJB
	GestionTelephoneLocal gestionTelephoneLocal;
	@EJB
	GestionMailLocal gestionMailLocal;
	@EJB
	GestionCycleLocal gestionCycleLocal;
	@EJB
	GestionProfilLocal gestionProfilLocal;
	@EJB
	GestionPersonneAChargeLocal gestionPersonneAChargeLocal;
	@EJB
	GestionEmbaucheLocal gestionEmbaucheLocal;
	@EJB
	GestionSalaireLocal gestionSalaireLocal;
	@EJB
	GestionAffectationLocal gestionAffectationLocal;
	@EJB
	GestionAttachementEmployeLocal attachementEmployeLocal;
	@EJB
	GestionAttachementManagerLocal attachementManagerLocal;
	@EJB
	GestionStatutLocal gestionStatutLocal;
	@EJB
	GestionNaissanceLocal gestionNaissanceLocal;
	@EJB
	GestionContratLocal gestionContratLocal;
	@EJB
	GestionCoordonneeBancaireLocal gestionCoordonneeBancaireLocal;
	@EJB
	GestionCoordonneeBancaireLocal bancaireLocal;
	@EJB
	GestionVehiculeLocal gestionVehiculeLocal;
	@EJB
	GestionSituationMedicaleLocal gestionSituationMedicaleLocal;
	@EJB
	GestionImputationGaLocal gestionImputationGaLocal;
	@EJB
	GestionDiplomeGaLocal gestionDiplomeGaLocal;
	@EJB
	GestionCertificationLocal gestionCertificationLocal;
	@EJB
	GestionExperienceLocal gestionExperienceLocal;

	@EJB
	GestionPieceIdentiteLocal gestionPieceIdentiteLocal;

	private Long numdossier;
	private int maxSelectCollaborateurs = 10;

	// Recherche Avancee
	private Age intervalleAge = new Age();
	private RechercheAvancee ra = new RechercheAvancee();
	private DateEmbauche intervalleDateEmbauche = new DateEmbauche();
	private List<Age> listIntervallesAge;
	private List<DateEmbauche> listIntervallesDateEmbauche;

	// identite
	private ArrayList<Identite> collaborateurs = new ArrayList<>();

	private Identite identite = new Identite();
	private StreamedContent photo = null;
	private byte[] nouvellePhoto = null;

	private ArrayList<StreamedContent> photos = new ArrayList<>();
	private StreamedContent photoC = null;
	private String renderedimage = "false";

	private InfosIndividuelles individuelles = new InfosIndividuelles();
	private ArrayList<PieceIdentite> piecesIdentite = new ArrayList<PieceIdentite>();
	private InfosPhysiques physiques = new InfosPhysiques();

	// embauche
	private Embauche embauche = new Embauche();
	private Embauche nouvelEMB = new Embauche();
	private String precedentEMB = "false";
	private String suivantEMB = "false";

	// salaire
	private Salaire salaire = new Salaire();
	private Salaire nouveauSal = new Salaire();
	private String precedentSal = "false";
	private String suivantSal = "false";

	// contrats
	private ArrayList<Contrat> contrats = new ArrayList<>();
	private Contrat selectedContrat = new Contrat();
	private Contrat nouveauContrat = new Contrat();
	private int nombreSelectCont = 3;
	private Long nombreContrats = null;
	private String precedentCont = "true";
	private String suivantCont = "true";
	private int restePrecedCont = 0;
	private int resteSuivantCont = 0;

	private StreamedContent contratsigne = null;
	private byte[] uploadedCont = null;

	// affectations
	private ArrayList<Affectation> affectations = new ArrayList<Affectation>();
	private Affectation affectation = new Affectation();
	private Affectation nouvelleAffectation = new Affectation();
	private int nombreSelectAff = 3;
	private Long nombreAffectations = null;
	private String precedentAff = "true";
	private String suivantAff = "true";
	private int restePrecedAff = 0;
	private int resteSuivantAff = 0;
	// employes
	private ArrayList<AttachementEmploye> attachementEmployes = new ArrayList<AttachementEmploye>();
	private AttachementEmploye attachementEmploye = new AttachementEmploye();
	private AttachementEmploye nouvelAttachementEmploye = new AttachementEmploye();
	private int nombreSelectEmp = 3;
	private Long nombreAttachementsEmp = null;
	private String precedentEmp = "true";
	private String suivantEmp = "true";
	private int restePrecedEmp = 0;
	private int resteSuivantEmp = 0;
	private Long numEmp;
	private String numMatriculeEmploye;
	private Identite idEmp = new Identite();
	// managers
	private ArrayList<AttachementManager> attachementManagers = new ArrayList<AttachementManager>();
	private AttachementManager attachementManager = new AttachementManager();
	private AttachementManager nouvelAttachementManager = new AttachementManager();
	private Long numMgr;
	private int nombreSelectMgr = 3;
	private Long nombreAttachementsMgr = null;
	private String precedentMgr = "true";
	private String suivantMgr = "true";
	private int restePrecedMgr = 0;
	private int resteSuivantMgr = 0;
	private String numMatriculeManager;
	// imputation
	private ArrayList<ImputationGa> imputationGas = new ArrayList<>();
	private ImputationGa imputationGa = new ImputationGa();
	private ImputationGa nouvelleImputationGa = new ImputationGa();
	private int nombreSelectImp = 0;
	private Long nombreImputations = null;
	private String precedentImp = "true";
	private String suivantImp = "true";
	private int restePrecedImp = 0;
	private int resteSuivantImp = 0;

	private Cycle cycle = new Cycle();
	private Profil profil = new Profil();

	// Adresses
	private Adresse adresse = new Adresse();
	private Adresse nouvelleAdresse = new Adresse();
	private ArrayList<Adresse> adresseshistorique = new ArrayList<Adresse>();
	private ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	private Date datecomp = new Date();
	private Long nombreAdresses = null;
	private String precedentAdresse = "true";
	private String suivantAdresse = "true";
	private int restePrecedAdr = 0;
	private int resteSuivantAdr = 0;
	private int nombreSelectionAdr = 3;

	// Telephone
	private ArrayList<Telephone> telephones = new ArrayList<>();
	private Telephone telephone = new Telephone();
	private Telephone nouveauTel = new Telephone();

	// Mail
	private ArrayList<Mail> mails = new ArrayList<>();
	private Mail mail = new Mail();
	private Mail nouveauMail = new Mail();

	// Situation civile
	private SituationCivile situationCivile = new SituationCivile();
	private SituationCivile nouvelleSc = new SituationCivile();
	private ArrayList<SituationCivile> situationCiviles = new ArrayList<SituationCivile>();
	private String precedentSc = "true";
	private String suivantSc = "true";
	private Long nombreSc = null;
	private int restePrecedSc = 0;
	private int resteSuivantSc = 0;
	private int nombreSelectionSc = 3;

	// statut
	private ArrayList<Statut> statuts = new ArrayList<>();
	private Statut statut = new Statut();
	private Statut nouvelSt = new Statut();
	private String precedentSt = "true";
	private String suivantSt = "true";
	private Long nombreSt = null;
	private int restePrecedSt = 0;
	private int resteSuivantSt = 0;
	private int nombreSelectionSt = 3;

	// Naissance
	private Naissance naissance = new Naissance();

	// PieceIdentites

	private PieceIdentite selectedPieceIdentite = new PieceIdentite();
	private PieceIdentite nouveauPieceIdentite = new PieceIdentite();

	// Nationalites
	private ArrayList<Nationalite> nationalites = new ArrayList<>();
	private Nationalite selectedNationalite = new Nationalite();
	private Nationalite nouvelleNationalite = new Nationalite();
	private Long nombreNatios = null;
	private String precedentNatio = "true";
	private String suivantNatio = "true";
	private int restePrecedNatio = 0;
	private int resteSuivantNatio = 0;
	private int nombreSelectionNatio = 3;

	// coordonnées bancaires
	private ArrayList<CoordonneeBancaire> bancaires = new ArrayList<>();
	private CoordonneeBancaire bancaire = new CoordonneeBancaire();
	private CoordonneeBancaire nouvelleCB = new CoordonneeBancaire();
	private String precedentCB = "false";
	private String suivantCB = "false";

	// situation medicale
	private ArrayList<SituationMedicale> medicales = new ArrayList<>();
	private SituationMedicale medicale = new SituationMedicale();
	private SituationMedicale nouvelleMedicale = new SituationMedicale();
	private Long nombreMedicales = null;
	private String precedentMedicale = "true";
	private String suivantMedicale = "true";
	private int restePrecedMed = 0;
	private int resteSuivantMed = 0;
	private int nombreSelectionMed = 3;

	// vehicules
	private ArrayList<Vehicule> vehicules = new ArrayList<>();
	private Vehicule vehicule = new Vehicule();
	private Vehicule nouveauVehicule = new Vehicule();
	private Long nombreVehicule = null;
	private String precedentVehicule = "true";
	private String suivantVehicule = "true";
	private int restePrecedVeh = 0;
	private int resteSuivantVeh = 0;
	private int nombreSelectionVeh = 3;

	// Diplomes
	private ArrayList<DiplomeGa> diplomes = new ArrayList<>();
	private DiplomeGa diplome = new DiplomeGa();
	private DiplomeGa nouveauDiplome = new DiplomeGa();
	private Long nombreDiplome = null;
	private String precedentDiplome = "true";
	private String suivantDiplome = "true";
	private int restePrecedDip = 0;
	private int resteSuivantDip = 0;
	private int nombreSelectionDip = 3;

	// Experiences
	private ArrayList<Experience> experiences = new ArrayList<>();
	private Experience experience = new Experience();
	private Experience nouvelleExperience = new Experience();
	private Long nombreExperience = null;
	private String precedentExperience = "true";
	private String suivantExperience = "true";
	private int restePrecedExp = 0;
	private int resteSuivantExp = 0;
	private int nombreSelectionExp = 3;

	// Certification
	private ArrayList<Certification> certifications = new ArrayList<>();
	private Certification certification = new Certification();
	private Certification nouvelleCertification = new Certification();
	private Long nombreCertification = null;
	private String precedentCertification = "true";
	private String suivantCertification = "true";
	private int restePrecedCert = 0;
	private int resteSuivantCert = 0;
	private int nombreSelectionCert = 3;
	private ArrayList<String> listePeriodes = new ArrayList<>();
	private String periodeEssai;
	private String valPeriode;
	private String age;
	private String posteCol;
	private String telephoneCol;
	private String mailCol;
	private String departementCol;

	// Recherche Avancée
	private String matricule;
	private String numMatricule;
	private String nom;
	private String prenom;
	private String sexe;
	private String cin;
	private String numPassp;
	private String poste;
	private String emploi;
	private String uniteOrg;
	private Date dateEmbauche;
	private String typeContrat;
	private String niveauDiplome;
	private String typeCertificat;
	private String situationFamiliale;
	private String nationalitePays;
	private String experiencePoste;
	private String experienceSociete;
	private String valeurPieceIdentite;
	private String typPieceIdentite;
	private StreamedContent photoE;
	private ArrayList<Identite> employesCherches = new ArrayList<Identite>();
	private ArrayList<Identite> employesCherchesmodif = new ArrayList<Identite>();
	private Identite identiteSelectionne = new Identite();
	private List<Identite> listidentiteSelectione;
	private List<Identite> listidentiteSelectionemodif;
	private Map<String, String> items_nationalitePays = new LinkedHashMap<String, String>();
	private Map<String, String> items_niveauDiplome = new LinkedHashMap<String, String>();
	private Map<String, String> items_typeCertificat = new LinkedHashMap<String, String>();
	private Map<String, String> items_typeContrat = new LinkedHashMap<String, String>();
	private Map<String, String> items_experiencePoste = new LinkedHashMap<String, String>();
	private Map<String, String> items_experienceSociete = new LinkedHashMap<String, String>();
	private Map<String, String> items_affectationPoste = new LinkedHashMap<String, String>();
	private Map<String, String> items_affectationUniteOrg = new LinkedHashMap<String, String>();
	private Map<String, String> items_affectationEmploi = new LinkedHashMap<String, String>();
	private Map<String, String> items_TypePieceIdentite = new LinkedHashMap<String, String>();
	// private boolean headerButtonsDisabled = true;
	// CalCul Job@EJB

	@EJB
	GestionIdentite gestionIdentite;

	private GroupeIdentity groupeSelectSelectionne = new GroupeIdentity();
	private GroupeIdentity groupeSelectSelectionne2 = new GroupeIdentity();
	private List<Identite> selectlistidentite = new ArrayList<>();
	// private List_Identity list_Identity = new List_Identity();
	// List_Identity list_Identity = new List_Identity();
	private GroupeIdentity groupe = new GroupeIdentity();
	private boolean selected;
	// private ArrayList<ListGroupe> groupes = new ArrayList<ListGroupe>();*/
	private List<GroupeIdentity> groupeSelect = new ArrayList<GroupeIdentity>();
	private List<GroupeIdentity> listgroupeSelect = new ArrayList<GroupeIdentity>();
	private boolean headerButtonsDisabled = true;
	// private MyData dataItem;
	private HtmlInputHidden dataItemId = new HtmlInputHidden();
	private String libelle;
	private Bean bean;

	@PostConstruct
	public void init() {
		ChargerRechercheAvancee();
		afficherListeTypePiecesIdentite();
		groupeSelect = gestionGroupeSelect.listeGroupeSelect();
		// this.setGroupeSelectSelectionne2(groupeSelectSelectionne2);
		// this.setListgroupeSelect(gestionGroupeSelect.listeGroupeSelect());
		selectlistidentite = gestionIdentite.findAll();
		afficherListeNationalitePays();
		afficherListeTypeContrat();
		afficherListeNiveauDiplome();
		afficherListeTypeCertificat();
		afficherListeExperiencePoste();
		afficherListeExperienceSociete();
		afficherListeAffectationPoste();
		afficherListeAffectationUniteOrg();
		afficherListeAffectationEmploi();
		identite = new Identite();
		initialiser();
		listePeriodes.add("Selectionnez");
		listePeriodes.add("jour");
		listePeriodes.add("mois");
	}

	public DonneesIndivJobsBean() {
		listIntervallesAge = new ArrayList<>();
		listIntervallesAge.add(new Age());
		listIntervallesDateEmbauche = new ArrayList<>();
		listIntervallesDateEmbauche.add(new DateEmbauche());
	}

	public void ajoutergroupe() {
		// groupeIdentites.add(groupeIdentite);

		groupeSelectSelectionne.setLibelle(libelle);
	}

	public void ajouter() {

		// groupeIdentites.add(groupeIdentite);
		// groupeIdentites.add(groupeIdentite);

		groupeSelectSelectionne.setLibelle(libelle);
		gestionGroupeSelect.ajouterGroupeSelect(groupeSelectSelectionne);

	}

	public void ajouter2() {

		//groupeSelectSelectionne2.setIdentites(listidentiteSelectione);
		groupeSelectSelectionne2.setLibelle(libelle);
		gestionGroupeSelect.modifierGroupeSelect(groupeSelectSelectionne2);

	}

	public void ChargerRechercheAvancee() {
		try {
			if (gestionRechercheAvanceeLocal.AfficherRechercheAvancee().get(0) != null) {
				ra = gestionRechercheAvanceeLocal.AfficherRechercheAvancee()
						.get(0);
				listIntervallesAge = gestionRechercheAvanceeLocal
						.AfficherAgesParRechercheAvancee(ra);
				listIntervallesDateEmbauche = gestionRechercheAvanceeLocal
						.AfficherDatesEmbaucheParRechercheAvancee(ra);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void onRowSelectDataTable() {
		this.setHeaderButtonsDisabled(false);
	}

	public void afficherListeNationalitePays() {
		items_nationalitePays.clear();
		try {
			List list = gestionNationaliteLocal.findAll();
			Iterator iter = list.iterator();

			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Nationalite n = (Nationalite) iter.next();
				// if(!items_nationalitePays.containsKey(n.getPays()))
				items_nationalitePays.put(n.getPays(), n.getPays());

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeTypePiecesIdentite() {
		items_TypePieceIdentite.clear();
		try {
			List list = gestionTypePieceIdentiteLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				TypePieceIdentite c = (TypePieceIdentite) iter.next();

				items_TypePieceIdentite.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void ajouterIdentityTogroupe() {
employesCherchesmodif.clear();
		try {
			List<Identite>identites=new ArrayList<Identite>();
			// List_Identity list_Identity= new List_Identity();
			//groupeSelectSelectionne2.setIdentites(listidentiteSelectione);
			//groupeSelectSelectionne2.setLibelle(libelle);
			listidentiteSelectionemodif=gestionGroupeSelect.findidentiteByGroupeIdentity(groupeSelectSelectionne2);
			for(Identite identite:listidentiteSelectionemodif){
				employesCherchesmodif.add(identite);
				System.out.println("identite1"+identite.getNom()+identite.getPrenom());
			}
			// list_Identity.setIdentites(listidentiteSelectione);
			// list_Identity.setGroupeIdentities(groupeSelect);
			// gestionGroupeSelect.ajouterListToGroupe2(list_Identity);

		} catch (Exception exception) {

		}
	}
	public void modifierlistgroupe() {
//employesCherchesmodif.clear();
groupeSelectSelectionne2.setIdentites(listidentiteSelectionemodif);
groupeSelectSelectionne2.setLibelle(libelle);
gestionGroupeSelect.modifierGroupeSelect(groupeSelectSelectionne2);
	/*	try {
			List<Identite>identites=new ArrayList<Identite>();
			// List_Identity list_Identity= new List_Identity();
			//groupeSelectSelectionne2.setIdentites(listidentiteSelectione);
			//groupeSelectSelectionne2.setLibelle(libelle);
			listidentiteSelectionemodif=gestionGroupeSelect.findidentiteByGroupeIdentity(groupeSelectSelectionne2);
			for(Identite identite:listidentiteSelectionemodif){
				employesCherchesmodif.add(identite);
				System.out.println("identite1"+identite.getNom()+identite.getPrenom());
			}
			// list_Identity.setIdentites(listidentiteSelectione);
			// list_Identity.setGroupeIdentities(groupeSelect);
			// gestionGroupeSelect.ajouterListToGroupe2(list_Identity);

		} catch (Exception exception) {

		}*/
	}

	public void ajoutertogroupe() {

		try {
			GroupeIdentity groupeIdentities= new GroupeIdentity();
			/*groupeIdentities.add(groupeSelectSelectionne);
			GroupeIdentity groupeIdentity = new GroupeIdentity();*/

			groupeIdentities.setIdentites(listidentiteSelectione);
			groupeIdentities.setLibelle(libelle);
			gestionGroupeSelect.modifierGroupeSelect(groupeIdentities);
			//gestionGroupeSelect.ajouterGroupeSelect(groupeSelectSelectionne);

		} catch (Exception exception) {

		}
	
	}

	public void afficherListeTypeContrat() {
		items_typeContrat.clear();
		try {
			List list = gestionContratLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Contrat c = (Contrat) iter.next();

				items_typeContrat.put(c.getType(), c.getType());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeAffectationPoste() {
		items_affectationPoste.clear();
		try {
			List list = gestionAffectationLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Affectation a = (Affectation) iter.next();

				items_affectationPoste.put(a.getPoste(), a.getPoste());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeAffectationUniteOrg() {
		items_affectationUniteOrg.clear();
		try {
			List list = gestionAffectationLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Affectation a = (Affectation) iter.next();

				items_affectationUniteOrg.put(a.getUniteorga(),
						a.getUniteorga());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeAffectationEmploi() {
		items_affectationEmploi.clear();
		try {
			List list = gestionAffectationLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Affectation a = (Affectation) iter.next();

				items_affectationEmploi.put(a.getEmploi(), a.getEmploi());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeNiveauDiplome() {
		items_niveauDiplome.clear();
		try {
			List list = gestionDiplomeGaLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				DiplomeGa d = (DiplomeGa) iter.next();

				items_niveauDiplome.put(d.getNiveau(), d.getNiveau());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeTypeCertificat() {
		items_typeCertificat.clear();
		try {
			List list = gestionCertificationLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Certification c = (Certification) iter.next();
				System.out.println(c.getNom());
				items_typeCertificat.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeExperiencePoste() {
		items_experiencePoste.clear();
		try {
			List list = gestionExperienceLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Experience e = (Experience) iter.next();

				items_experiencePoste.put(e.getPoste(), e.getPoste());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeExperienceSociete() {
		items_experienceSociete.clear();
		try {
			List list = gestionExperienceLocal.findAll();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				Experience e = (Experience) iter.next();

				items_experienceSociete.put(e.getSociete(), e.getSociete());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void resetSearch() {
		gestionRechercheAvanceeLocal.supprimerRechercheAvancee(ra,
				listIntervallesAge, listIntervallesDateEmbauche);
		ra.setUniteOrg("");
		ra.setPoste("");
		ra.setEmploi("");
		ra.setNom("");
		ra.setPrenom("");
		ra.setSexe("");
		ra.setValeurPieceIdentite("");
		ra.setTypPieceIdentite("");
		ra.setTypeContrat("");
		ra.setNumMatricule("");
		setMatricule("");
		ra.setSituationFamiliale("");
		ra.setNiveauDiplome("");
		ra.setTypeCertificat("");
		ra.setExperiencePoste("");
		ra.setExperienceSociete("");
		ra.setNationalitePays("");
		listIntervallesAge.clear();
		listIntervallesDateEmbauche.clear();

	}
	public void chercherEmployesByMatriculemodif() {
	getEmployesCherchesmodif().clear();
		if (getMatricule().equals("%")) {

			setEmployesCherchesmodif((ArrayList<Identite>) gestionIdentiteLocal
					.findAll());
		} else
			setEmployesCherchesmodif((ArrayList<Identite>) gestionIdentiteLocal
					.trouverParLikeMatricule(getMatricule(), 1));
	}

	public void chercherEmployesByMatricule() {
		getEmployesCherches().clear();
		if (getMatricule().equals("%")) {

			setEmployesCherches((ArrayList<Identite>) gestionIdentiteLocal
					.findAll());
		} else
			setEmployesCherches((ArrayList<Identite>) gestionIdentiteLocal
					.trouverParLikeMatricule(getMatricule(), 1));
	}

	public Date getDateNaissanceByAge(int age) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -age);
		System.out.println(cal.getTime());
		return cal.getTime();
	}

	public void memoriser() {
		if (gestionRechercheAvanceeLocal.AfficherRechercheAvancee().size() > (-1)) {
			RechercheAvancee r = new RechercheAvancee();
			r = gestionRechercheAvanceeLocal.AfficherRechercheAvancee().get(0);
			gestionRechercheAvanceeLocal.supprimerRechercheAvancee(r,
					listIntervallesAge, listIntervallesDateEmbauche);
		}
		gestionRechercheAvanceeLocal.enregistrerRechercheAvancee(ra);
		for (Age a : getListIntervallesAge()) {
			a.setMinDateNaissance(getDateNaissanceByAge(a.getMinAge()));
			a.setMaxDateNaissance(getDateNaissanceByAge(a.getMaxAge()));

		}
		gestionRechercheAvanceeLocal.enregistrerAge(ra, listIntervallesAge);
		gestionRechercheAvanceeLocal.enregistrerDateEmbauche(ra,
				listIntervallesDateEmbauche);
	}
	
	public void chercherEmployesmodif() {
		getEmployesCherchesmodif().clear();
		//getemployesCherchesmodif().clear();
		if (ra.getUniteOrg().equals(""))
			ra.setUniteOrg("%");
		if (ra.getPoste().equals(""))
			ra.setPoste("%");
		if (ra.getEmploi().equals(""))
			ra.setEmploi("%");
		if (ra.getNom().equals(""))
			ra.setNom("%");
		if (ra.getPrenom().equals(""))
			ra.setPrenom("%");
		if (ra.getSexe().equals(""))
			ra.setSexe("%");
		if (ra.getTypeContrat().equals(""))
			ra.setTypeContrat("%");
		if (ra.getSituationFamiliale().equals(""))
			ra.setSituationFamiliale("%");
		if (ra.getNiveauDiplome().equals(""))
			ra.setNiveauDiplome("%");
		if (ra.getTypeCertificat().equals(""))
			ra.setTypeCertificat("%");
		if (ra.getExperiencePoste().equals(""))
			ra.setExperiencePoste("%");
		if (ra.getExperienceSociete().equals(""))
			ra.setExperienceSociete("%");
		if (ra.getNumMatricule().equals(""))
			ra.setNumMatricule("%");
		if (ra.getNationalitePays().equals(""))
			ra.setNationalitePays("%");
		if(ra.getValeurPieceIdentite().equals(""))
			ra.setValeurPieceIdentite("%");
		if(ra.getTypPieceIdentite().equals(""))
			ra.setTypPieceIdentite("%");
		
		for(Age a:getListIntervallesAge())
		{
			if(a.getMinAge()==0 || a.getMaxAge()==0)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Verifier les valeurs de l'age"));
			  
			else if(a.getMinAge() > a.getMaxAge())
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La valeur de Minimum age doit etre inferieur à la valeur de maximum age"));

			else
			{
		a.setMinDateNaissance(getDateNaissanceByAge(a.getMinAge()));
		a.setMaxDateNaissance(getDateNaissanceByAge(a.getMaxAge()));
			}
		for(DateEmbauche de:getListIntervallesDateEmbauche())	
		{
			if(de.getMinDateEmbauche()==null ||de.getMaxDateEmbauche()==null)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Error!", "Verifier les valeurs de la date d'embauche"));
			else if(de.getMinDateEmbauche().before(de.getMaxDateEmbauche()))
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Error!", "La valeur de Minimum date d'embauche doit etre inferieur à la valeur de maximum date d'embauche"));
		}
		
		}
		try {
			setEmployesCherches((ArrayList<Identite>) gestionIdentiteLocal
					.trouverByCriteria(ra.getNumMatricule(), ra.getNom(),
							ra.getPrenom(), ra.getSexe(), ra.getPoste(), ra.getUniteOrg(),
							ra.getEmploi(), ra.getValeurPieceIdentite(), ra.getTypPieceIdentite(),
							ra.getSituationFamiliale(), ra.getTypeContrat(),
							ra.getNationalitePays(), ra.getNiveauDiplome(),
							ra.getTypeCertificat(), ra.getExperiencePoste(),
							ra.getExperienceSociete(),listIntervallesDateEmbauche,listIntervallesAge));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void chercherEmployes() {
		getEmployesCherches().clear();
		if (ra.getUniteOrg().equals(""))
			ra.setUniteOrg("%");
		if (ra.getPoste().equals(""))
			ra.setPoste("%");
		if (ra.getEmploi().equals(""))
			ra.setEmploi("%");
		if (ra.getNom().equals(""))
			ra.setNom("%");
		if (ra.getPrenom().equals(""))
			ra.setPrenom("%");
		if (ra.getSexe().equals(""))
			ra.setSexe("%");
		if (ra.getTypeContrat().equals(""))
			ra.setTypeContrat("%");
		if (ra.getSituationFamiliale().equals(""))
			ra.setSituationFamiliale("%");
		if (ra.getNiveauDiplome().equals(""))
			ra.setNiveauDiplome("%");
		if (ra.getTypeCertificat().equals(""))
			ra.setTypeCertificat("%");
		if (ra.getExperiencePoste().equals(""))
			ra.setExperiencePoste("%");
		if (ra.getExperienceSociete().equals(""))
			ra.setExperienceSociete("%");
		if (ra.getNumMatricule().equals(""))
			ra.setNumMatricule("%");
		if (ra.getNationalitePays().equals(""))
			ra.setNationalitePays("%");
		if(ra.getValeurPieceIdentite().equals(""))
			ra.setValeurPieceIdentite("%");
		if(ra.getTypPieceIdentite().equals(""))
			ra.setTypPieceIdentite("%");
		
		for(Age a:getListIntervallesAge())
		{
			if(a.getMinAge()==0 || a.getMaxAge()==0)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Verifier les valeurs de l'age"));
			  
			else if(a.getMinAge() > a.getMaxAge())
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La valeur de Minimum age doit etre inferieur à la valeur de maximum age"));

			else
			{
		a.setMinDateNaissance(getDateNaissanceByAge(a.getMinAge()));
		a.setMaxDateNaissance(getDateNaissanceByAge(a.getMaxAge()));
			}
		for(DateEmbauche de:getListIntervallesDateEmbauche())	
		{
			if(de.getMinDateEmbauche()==null ||de.getMaxDateEmbauche()==null)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Error!", "Verifier les valeurs de la date d'embauche"));
			else if(de.getMinDateEmbauche().before(de.getMaxDateEmbauche()))
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Error!", "La valeur de Minimum date d'embauche doit etre inferieur à la valeur de maximum date d'embauche"));
		}
		
		}
		try {
			setEmployesCherches((ArrayList<Identite>) gestionIdentiteLocal
					.trouverByCriteria(ra.getNumMatricule(), ra.getNom(),
							ra.getPrenom(), ra.getSexe(), ra.getPoste(), ra.getUniteOrg(),
							ra.getEmploi(), ra.getValeurPieceIdentite(), ra.getTypPieceIdentite(),
							ra.getSituationFamiliale(), ra.getTypeContrat(),
							ra.getNationalitePays(), ra.getNiveauDiplome(),
							ra.getTypeCertificat(), ra.getExperiencePoste(),
							ra.getExperienceSociete(),listIntervallesDateEmbauche,listIntervallesAge));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void ajouterEmployeAListe() {
		Identite i = new Identite();
		i = gestionIdentiteLocal.trouverParMatricule(numMatriculeEmploye);
		nouvelAttachementEmploye = new AttachementEmploye();

		nouvelAttachementEmploye.setNumMat(i.getMatricul());
		nouvelAttachementEmploye.setEmpnom(i.getNom());
		nouvelAttachementEmploye.setEmppreno(i.getPrenom());
		nouvelAttachementEmploye.setDatedeb(new Date());

	}

	public void ajouterManagerAListe() {
		Identite i = new Identite();
		i = gestionIdentiteLocal.trouverParMatricule(numMatriculeManager);
		nouvelAttachementManager = new AttachementManager();
		nouvelAttachementManager.setNumMat(i.getMatricul());
		nouvelAttachementManager.setManagnom(i.getNom());
		nouvelAttachementManager.setManagpre(i.getPrenom());
		nouvelAttachementManager.setDatedeb(new Date());

	}

	public String calculerAge(Date date) {
		long years = new Date().getYear() - date.getYear();

		return years + " ans";

	}

	public void initialiser() {
		age = "";
		telephoneCol = "";
		mailCol = "";
		posteCol = "";
		departementCol = "";
		piecesIdentite = new ArrayList<>();
		physiques = new InfosPhysiques();
		statuts = new ArrayList<>();
		statut = new Statut();
		adresse = new Adresse();
		adresses = new ArrayList<>();
		adresseshistorique = new ArrayList<>();
		telephones = new ArrayList<>();
		mails = new ArrayList<>();
		embauche = new Embauche();
		affectations = new ArrayList<>();
		affectation = new Affectation();
		bancaire = new CoordonneeBancaire();
		bancaires = new ArrayList<>();
		salaire = new Salaire();
		attachementEmployes = new ArrayList<>();
		attachementManagers = new ArrayList<>();
		naissance = new Naissance();
		nationalites = new ArrayList<>();
		selectedNationalite = new Nationalite();
		situationCiviles = new ArrayList<>();
		situationCivile = new SituationCivile();
		vehicules = new ArrayList<>();
		nouveauVehicule = new Vehicule();
		medicales = new ArrayList<>();
		nouvelleMedicale = new SituationMedicale();
		diplomes = new ArrayList<>();
		nouveauDiplome = new DiplomeGa();
		certifications = new ArrayList<>();
		nouvelleCertification = new Certification();
		experiences = new ArrayList<>();
		nouvelleExperience = new Experience();
		nouvelAttachementManager = new AttachementManager();
		nouvelAttachementEmploye = new AttachementEmploye();
	}

	public void rechercher() {
		initialiser();
		if (identite != null) {

			piecesIdentite = (ArrayList<PieceIdentite>) gestionPieceIdentiteLocal
					.trouverPiecesIdentiteParIdentite(identite);

			naissance = gestionNaissanceLocal.trouverParIdentite(identite);

			physiques = gestionInfosPhysiquesLocal.trouverParIdentite(identite);
			nombreSt = gestionStatutLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreSt > 0)
				statuts = (ArrayList<Statut>) gestionStatutLocal
						.trouverHistoriqueStatutsParIdentite(identite,
								nombreSelectionSt);
			// Adresses
			adresses = (ArrayList<Adresse>) gestionAdresseLocal
					.trouverAdressesParIdentite(identite);
			nombreAdresses = gestionAdresseLocal
					.trouverNombreOccurrencesParIdentite(identite);
			afficherHistoriqueAdresses();
			// Nationalites
			nombreNatios = gestionNationaliteLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreNatios > 0)
				afficherHistoriqueNatios();
			nombreSc = gestionSituationCivileLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreSc > 0)
				afficherHistoriqueSc();
			telephones = (ArrayList<Telephone>) gestionTelephoneLocal
					.trouverTelephonesParIdentite(identite);
			mails = (ArrayList<Mail>) gestionMailLocal
					.trouverMailsParIdentite(identite);
			bancaire = (CoordonneeBancaire) bancaireLocal
					.trouverDerniereCoordonneeBancaireParIdentite(identite);
			nombreVehicule = gestionVehiculeLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreVehicule > 0)
				afficherHistoriqueVehicules();
			nombreMedicales = gestionSituationMedicaleLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreMedicales > 0)
				afficherHistoriqueSituationMedicales();
			nombreDiplome = gestionDiplomeGaLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreDiplome > 0)
				afficherDiplomes();
			nombreCertification = gestionCertificationLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreCertification > 0)
				afficherCertifications();
			nombreExperience = gestionExperienceLocal
					.trouverNombreOccurrencesParIdentite(identite);
			if (nombreExperience > 0)
				afficherExperiences();

			embauche = gestionEmbaucheLocal
					.trouverDernierEmbaucheParIdentite(identite);
			if (embauche != null) {
				salaire = gestionSalaireLocal
						.trouverSalaireParEmbauche(embauche);

				nombreContrats = gestionContratLocal
						.trouverNombreOccurrencesParEmbauche(embauche);
				if (nombreContrats > 0)
					afficherHistoriqueContrats();

				nombreAffectations = gestionAffectationLocal
						.trouverNombreOccurrencesParEmbauche(embauche);
				if (nombreAffectations > 0)
					afficherHistoriqueAffectations();
				setAge(calculerAge(naissance.getDatenais()));
				setTelephoneCol(getTelephones().get(0).getNumero());
				setMailCol(getMails().get(0).getEmail());
				setPosteCol(getAffectations().get(0).getPoste());
				setDepartementCol(getAffectations().get(0).getUniteorga());

			} else {
				salaire = new Salaire();
				contrats = new ArrayList<>();
				selectedContrat = new Contrat();
				affectations = new ArrayList<>();
				affectation = new Affectation();
				attachementEmployes = new ArrayList<>();
				attachementManagers = new ArrayList<>();
			}

			renderedimage = "true";
		}
		// image définie en getPhoto

	}

	public void handlePhotoUpload(FileUploadEvent event) {

		FacesMessage message = new FacesMessage("success", event.getFile()
				.getFileName() + " photo uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);

		InputStream is = null;
		try {
			is = event.getFile().getInputstream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] img = null;
		try {
			img = IOUtils.toByteArray(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		nouvellePhoto = img;

	}

	public void sortie() {

	}

	/*
	 * ********************************************************** Adresses
	 * ***********************************************************
	 */

	public void afficherHistoriqueAdresses() {

		adresseshistorique = (ArrayList<Adresse>) gestionAdresseLocal
				.trouverHistoriqueAdressesParIdentite(identite,
						nombreSelectionAdr);
		restePrecedAdr = 0;
		resteSuivantAdr = 0;
		if (nombreAdresses > nombreSelectionAdr) {
			restePrecedAdr = (int) (nombreAdresses - nombreSelectionAdr);
			precedentAdresse = "false";
		} else {
			precedentAdresse = "true";
		}
		suivantAdresse = "true";

	}

	public void premiersHistoriqueAdr() {
		adresseshistorique = (ArrayList<Adresse>) gestionAdresseLocal
				.trouverPremiersHistoriqueAdressesParIdentite(identite,
						nombreSelectionAdr);
		restePrecedAdr = 0;
		resteSuivantAdr = 0;
		if (nombreAdresses > nombreSelectionAdr) {
			resteSuivantAdr = (int) (nombreAdresses - nombreSelectionAdr);
			suivantAdresse = "false";
		} else {
			suivantAdresse = "true";
		}
		precedentAdresse = "true";
	}

	public void derniersHistoriqueAdr() {
		afficherHistoriqueAdresses();
	}

	public void precedentHistoriqueAdresse() {
		Date max = adresseshistorique.get(adresseshistorique.size() - 1)
				.getDateeffe();

		adresseshistorique = (ArrayList<Adresse>) gestionAdresseLocal
				.trouverHistoriqueAdressesParIdentiteEtDateMax(identite, max,
						nombreSelectionAdr);
		suivantAdresse = "false";
		resteSuivantAdr += nombreSelectionAdr;
		restePrecedAdr -= nombreSelectionAdr;
		if (restePrecedAdr < 1)
			precedentAdresse = "true";
		if (resteSuivantAdr < 1)
			suivantAdresse = "true";

	}

	public void suivantHistoriqueAdresse() {
		Date min = adresseshistorique.get(0).getDateeffe();
		adresseshistorique = (ArrayList<Adresse>) gestionAdresseLocal
				.trouverPremiersHistoriqueAdressesParIdentiteEtDateMin(
						identite, min, nombreSelectionAdr);
		restePrecedAdr += nombreSelectionAdr;
		precedentAdresse = "false";
		resteSuivantAdr -= nombreSelectionAdr;
		if (resteSuivantAdr < 1)
			suivantAdresse = "true";
		if (restePrecedAdr < 1)
			precedentAdresse = "true";
	}

	public void ajouterAdresse() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal.ajouterAdresse(identite, nouvelleAdresse);
			nouvelleAdresse = new Adresse();

			nombreAdresses++;
			afficherHistoriqueAdresses();
		}
	}

	public void supprimerAdresse() {
		boolean test = true;
		if (adresseshistorique.size() == 1) {
			FacesContext.getCurrentInstance().addMessage(
					"adr",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Au moins une adresse obligatoire", ""));
			test = false;
		}

		if (test == true) {
			if (adresse.getId() != null) {

				gestionAdresseLocal.supprimerAdresse(adresse);
				nombreAdresses--;
				afficherHistoriqueAdresses();
			}
		}
	}

	public void modifierAdresse() {
		if (adresse != null && adresse.getId() != null)
			gestionAdresseLocal.modifierAdresse(adresse);
		afficherHistoriqueAdresses();
	}

	/*
	 * ********************************************************** Nationalités
	 * ***********************************************************
	 */

	public void afficherHistoriqueNatios() {
		nationalites = (ArrayList<Nationalite>) gestionNationaliteLocal
				.trouverHistoriqueNationalitesParIdentite(identite,
						nombreSelectionNatio);
		restePrecedNatio = 0;
		resteSuivantNatio = 0;
		if (nombreNatios > nombreSelectionNatio) {
			restePrecedNatio = (int) (nombreNatios - nombreSelectionNatio);
			precedentNatio = "false";
		} else {
			precedentNatio = "true";
		}
		suivantNatio = "true";
	}

	public void premiersHistoriqueNatio() {
		nationalites = (ArrayList<Nationalite>) gestionNationaliteLocal
				.trouverPremiersHistoriqueNationalitesParIdentite(identite,
						nombreSelectionNatio);
		restePrecedNatio = 0;
		resteSuivantNatio = 0;
		if (nombreNatios > nombreSelectionNatio) {
			resteSuivantNatio = (int) (nombreNatios - nombreSelectionNatio);
			suivantNatio = "false";
		} else {
			suivantNatio = "true";
		}
		precedentNatio = "true";
	}

	public void derniersHistoriqueNatio() {
		afficherHistoriqueNatios();
	}

	public void precedentHistoriqueNatio() {
		Date max = nationalites.get(nationalites.size() - 1).getDatedeb();

		nationalites = (ArrayList<Nationalite>) gestionNationaliteLocal
				.trouverHistoriqueNationalitesParIdentiteEtDateMax(identite,
						max, nombreSelectionNatio);
		suivantNatio = "false";
		resteSuivantNatio += nombreSelectionNatio;
		restePrecedNatio -= nombreSelectionNatio;
		if (restePrecedNatio < 1)
			precedentNatio = "true";
		if (resteSuivantNatio < 1)
			suivantNatio = "true";

	}

	public void suivantHistoriqueNatio() {
		Date min = nationalites.get(0).getDatedeb();
		nationalites = (ArrayList<Nationalite>) gestionNationaliteLocal
				.trouverPremiersHistoriqueNationalitesParIdentiteEtDateMin(
						identite, min, nombreSelectionNatio);
		restePrecedNatio += nombreSelectionNatio;
		precedentNatio = "false";
		resteSuivantNatio -= nombreSelectionNatio;
		if (resteSuivantNatio < 1)
			suivantNatio = "true";
		if (restePrecedNatio < 1)
			precedentNatio = "true";
	}

	public void ajouterNatio() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal.ajouterNationalite(identite,
					nouvelleNationalite);
			nouvelleNationalite = new Nationalite();

			nombreNatios++;

			afficherHistoriqueNatios();
		}
	}

	public void supprimerNatio() {
		boolean test = true;
		if (nationalites.size() == 1) {
			FacesContext.getCurrentInstance().addMessage(
					"sitciv",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Au moins une nationalite obligatoire", ""));
			test = false;
		}

		if (test == true) {
			if (selectedNationalite != null
					&& selectedNationalite.getId() != null) {

				gestionNationaliteLocal
						.supprimerNationalite(selectedNationalite);
				nombreNatios--;
				afficherHistoriqueNatios();
			}
		}
	}

	public void modifierNatio() {
		if (selectedNationalite != null && selectedNationalite.getId() != null)
			gestionNationaliteLocal.modifierNationalite(selectedNationalite);
		afficherHistoriqueNatios();
	}

	/*
	 * ********************************************************** Vehicules
	 * ***********************************************************
	 */

	public void afficherHistoriqueVehicules() {

		vehicules = (ArrayList<Vehicule>) gestionVehiculeLocal
				.trouverHistoriqueVehiculesParIdentite(identite,
						nombreSelectionVeh);
		restePrecedVeh = 0;
		resteSuivantVeh = 0;
		if (nombreVehicule > nombreSelectionVeh) {
			restePrecedVeh = (int) (nombreVehicule - nombreSelectionVeh);
			precedentVehicule = "false";
		} else {
			precedentVehicule = "true";
		}
		suivantVehicule = "true";

	}

	public void premiersHistoriqueVehicule() {
		vehicules = (ArrayList<Vehicule>) gestionVehiculeLocal
				.trouverPremiersHistoriqueVehiculesParIdentite(identite,
						nombreSelectionVeh);
		restePrecedVeh = 0;
		resteSuivantVeh = 0;
		if (nombreVehicule > nombreSelectionVeh) {
			resteSuivantVeh = (int) (nombreVehicule - nombreSelectionVeh);
			suivantVehicule = "false";
		} else {
			suivantVehicule = "true";
		}
		precedentVehicule = "true";
	}

	public void derniersHistoriqueVehicule() {
		afficherHistoriqueVehicules();
	}

	public void precedentHistoriqueVehicule() {
		Date max = vehicules.get(vehicules.size() - 1).getDatedeb();

		vehicules = (ArrayList<Vehicule>) gestionVehiculeLocal
				.trouverHistoriqueVehiculesParIdentiteEtDateMax(identite, max,
						nombreSelectionVeh);
		suivantVehicule = "false";
		resteSuivantVeh += nombreSelectionVeh;
		restePrecedVeh -= nombreSelectionVeh;
		if (restePrecedVeh < 1)
			precedentVehicule = "true";
		if (resteSuivantVeh < 1)
			suivantVehicule = "true";

	}

	public void suivantHistoriqueVehicule() {
		Date min = vehicules.get(0).getDatedeb();
		vehicules = (ArrayList<Vehicule>) gestionVehiculeLocal
				.trouverPremiersHistoriqueVehiculesParIdentiteEtDateMin(
						identite, min, nombreSelectionVeh);
		restePrecedVeh += nombreSelectionVeh;
		precedentVehicule = "false";
		resteSuivantVeh -= nombreSelectionVeh;
		if (resteSuivantVeh < 1)
			suivantVehicule = "true";
		if (restePrecedVeh < 1)
			precedentVehicule = "true";
	}

	public void ajouterVehicule() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal.ajouterVehicule(identite, nouveauVehicule);
			nouveauVehicule = new Vehicule();

			nombreVehicule++;
			afficherHistoriqueVehicules();
		}
	}

	public void supprimerVehicule() {
		if (vehicule.getId() != null) {
			gestionVehiculeLocal.supprimerVehicule(vehicule);
			nombreVehicule--;
			afficherHistoriqueVehicules();
		}
	}

	public void modifierVehicule() {
		if (vehicule != null && vehicule.getId() != null)
			gestionVehiculeLocal.modifierVehicule(vehicule);
		afficherHistoriqueVehicules();
	}

	/*
	 * ********************************************************** Medicales
	 * ***********************************************************
	 */
	public void afficherHistoriqueSituationMedicales() {

		medicales = (ArrayList<SituationMedicale>) gestionSituationMedicaleLocal
				.trouverHistoriqueSituationsMedicalesParIdentite(identite,
						nombreSelectionMed);
		restePrecedMed = 0;
		resteSuivantMed = 0;
		if (nombreMedicales > nombreSelectionMed) {
			restePrecedMed = (int) (nombreMedicales - nombreSelectionMed);
			precedentMedicale = "false";
		} else {
			precedentMedicale = "true";
		}
		suivantMedicale = "true";

	}

	public void premiersHistoriqueMed() {
		medicales = (ArrayList<SituationMedicale>) gestionSituationMedicaleLocal
				.trouverPremiersHistoriqueSituationsMedicalesParIdentite(
						identite, nombreSelectionMed);
		restePrecedMed = 0;
		resteSuivantMed = 0;
		if (nombreMedicales > nombreSelectionMed) {
			resteSuivantMed = (int) (nombreMedicales - nombreSelectionMed);
			suivantMedicale = "false";
		} else {
			suivantMedicale = "true";
		}
		precedentMedicale = "true";
	}

	public void derniersHistoriqueMed() {
		afficherHistoriqueSituationMedicales();
	}

	public void precedentHistoriqueMed() {
		Date max = medicales.get(medicales.size() - 1).getDatedeb();

		medicales = (ArrayList<SituationMedicale>) gestionSituationMedicaleLocal
				.trouverHistoriqueSituationMedicalesParIdentiteEtDateMax(
						identite, max, nombreSelectionMed);
		suivantMedicale = "false";
		resteSuivantMed += nombreSelectionMed;
		restePrecedMed -= nombreSelectionMed;
		if (restePrecedMed < 1)
			precedentMedicale = "true";
		if (resteSuivantMed < 1)
			suivantMedicale = "true";

	}

	public void suivantHistoriqueSituationMedicale() {
		Date min = medicales.get(0).getDatedeb();
		System.out.println(min);
		medicales = (ArrayList<SituationMedicale>) gestionSituationMedicaleLocal
				.trouverPremiersHistoriqueSituationMedicalesParIdentiteEtDateMin(
						identite, min, nombreSelectionMed);
		restePrecedMed += nombreSelectionMed;
		precedentMedicale = "false";
		resteSuivantMed -= nombreSelectionMed;
		if (resteSuivantMed < 1)
			suivantMedicale = "true";
		if (restePrecedMed < 1)
			precedentMedicale = "true";
	}

	public void ajouterSituationMedicale() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal.ajouterSituationMedicale(identite,
					nouvelleMedicale);
			nouvelleMedicale = new SituationMedicale();

			nombreMedicales++;
			afficherHistoriqueSituationMedicales();
		}
	}

	public void supprimerSituationMedicale() {
		if (medicale.getId() != null) {
			gestionSituationMedicaleLocal.supprimerSituationMedicale(medicale);
			nombreMedicales--;
			afficherHistoriqueSituationMedicales();
		}
	}

	public void modifierSituationMedicale() {
		if (medicale != null && medicale.getId() != null)
			gestionSituationMedicaleLocal.modifierSituationMedicale(medicale);
		afficherHistoriqueSituationMedicales();
	}

	/*
	 * ********************************************************** Diplomes
	 * ***********************************************************
	 */

	public void afficherDiplomes() {

		diplomes = (ArrayList<DiplomeGa>) gestionDiplomeGaLocal
				.trouverDiplomesParIdentite(identite, nombreSelectionDip);
		restePrecedDip = 0;
		resteSuivantDip = 0;
		if (nombreDiplome > nombreSelectionDip) {
			restePrecedDip = (int) (nombreDiplome - nombreSelectionDip);
			precedentDiplome = "false";
		} else {
			precedentDiplome = "true";
		}
		suivantDiplome = "true";

	}

	public void premiersHDiplome() {
		diplomes = (ArrayList<DiplomeGa>) gestionDiplomeGaLocal
				.trouverPremiersDiplomesParIdentite(identite,
						nombreSelectionDip);
		restePrecedDip = 0;
		resteSuivantDip = 0;
		if (nombreDiplome > nombreSelectionDip) {
			resteSuivantDip = (int) (nombreDiplome - nombreSelectionDip);
			suivantDiplome = "false";
		} else {
			suivantDiplome = "true";
		}
		precedentDiplome = "true";
	}

	public void derniersHDiplome() {
		afficherDiplomes();
	}

	public void precedentHDiplome() {
		Date max = diplomes.get(diplomes.size() - 1).getDateffet();

		diplomes = (ArrayList<DiplomeGa>) gestionDiplomeGaLocal
				.trouverDiplomesParIdentiteEtDateMax(identite, max,
						nombreSelectionDip);
		suivantDiplome = "false";
		resteSuivantDip += nombreSelectionDip;
		restePrecedDip -= nombreSelectionDip;
		if (restePrecedDip < 1)
			precedentDiplome = "true";
		if (resteSuivantDip < 1)
			suivantDiplome = "true";

	}

	public void suivantHDiplome() {
		Date min = diplomes.get(0).getDateffet();
		diplomes = (ArrayList<DiplomeGa>) gestionDiplomeGaLocal
				.trouverPremiersDiplomesParIdentiteEtDateMin(identite, min,
						nombreSelectionDip);
		restePrecedDip += nombreSelectionDip;
		precedentDiplome = "false";
		resteSuivantDip -= nombreSelectionDip;
		if (resteSuivantDip < 1)
			suivantDiplome = "true";
		if (restePrecedDip < 1)
			precedentDiplome = "true";
	}

	public void ajouterDiplome() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal.ajouterDiplome(identite, nouveauDiplome);
			nouveauDiplome = new DiplomeGa();

			nombreDiplome++;
			afficherDiplomes();
		}
	}

	public void supprimerDiplome() {
		if (diplome.getId() != null) {
			gestionDiplomeGaLocal.supprimerDiplome(diplome);
			nombreDiplome--;
			afficherDiplomes();
		}
	}

	public void modifierDiplome() {
		if (diplome != null && diplome.getId() != null)
			gestionDiplomeGaLocal.modifierDiplome(diplome);
		afficherDiplomes();
	}

	/*
	 * ********************************************************** Certifications
	 * ***********************************************************
	 */

	public void afficherCertifications() {

		certifications = (ArrayList<Certification>) gestionCertificationLocal
				.trouverCertificationsParIdentite(identite, nombreSelectionCert);
		restePrecedCert = 0;
		resteSuivantCert = 0;
		if (nombreCertification > nombreSelectionCert) {
			restePrecedCert = (int) (nombreCertification - nombreSelectionCert);
			precedentCertification = "false";
		} else {
			precedentCertification = "true";
		}
		suivantCertification = "true";

	}

	public void premieresHCertification() {
		certifications = (ArrayList<Certification>) gestionCertificationLocal
				.trouverPremiersCertificationsParIdentite(identite,
						nombreSelectionCert);
		restePrecedCert = 0;
		resteSuivantCert = 0;
		if (nombreCertification > nombreSelectionCert) {
			resteSuivantCert = (int) (nombreCertification - nombreSelectionCert);
			suivantCertification = "false";
		} else {
			suivantCertification = "true";
		}
		precedentCertification = "true";
	}

	public void dernieresHCertification() {
		afficherCertifications();
	}

	public void precedentHCertification() {
		Date max = certifications.get(certifications.size() - 1).getDateffet();

		certifications = (ArrayList<Certification>) gestionCertificationLocal
				.trouverCertificationsParIdentiteEtDateMax(identite, max,
						nombreSelectionCert);
		suivantCertification = "false";
		resteSuivantCert += nombreSelectionCert;
		restePrecedCert -= nombreSelectionCert;
		if (restePrecedCert < 1)
			precedentCertification = "true";
		if (resteSuivantCert < 1)
			suivantCertification = "true";

	}

	public void suivantHCertification() {
		Date min = certifications.get(0).getDateffet();
		certifications = (ArrayList<Certification>) gestionCertificationLocal
				.trouverPremiersCertificationsParIdentiteEtDateMin(identite,
						min, nombreSelectionCert);
		restePrecedCert += nombreSelectionCert;
		precedentCertification = "false";
		resteSuivantCert -= nombreSelectionCert;
		if (resteSuivantCert < 1)
			suivantCertification = "true";
		if (restePrecedCert < 1)
			precedentCertification = "true";
	}

	public void ajouterCertification() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal.ajouterCertification(identite,
					nouvelleCertification);
			nouvelleCertification = new Certification();

			nombreCertification++;
			afficherCertifications();
		}
	}

	public void supprimerCertification() {
		if (certification.getId() != null) {
			gestionCertificationLocal.supprimerCertification(certification);
			nombreCertification--;
			afficherCertifications();
		}
	}

	public void modifierCertification() {
		if (certification != null && certification.getId() != null)
			gestionCertificationLocal.modifierCertification(certification);
		afficherCertifications();
	}

	/*
	 * ********************************************************** Experiences
	 * ***********************************************************
	 */

	public void afficherExperiences() {

		experiences = (ArrayList<Experience>) gestionExperienceLocal
				.trouverExperiencesParIdentite(identite, nombreSelectionExp);
		restePrecedExp = 0;
		resteSuivantExp = 0;
		if (nombreExperience > nombreSelectionExp) {
			restePrecedExp = (int) (nombreExperience - nombreSelectionExp);
			precedentExperience = "false";
		} else {
			precedentExperience = "true";
		}
		suivantExperience = "true";

	}

	public void premieresHExperience() {
		experiences = (ArrayList<Experience>) gestionExperienceLocal
				.trouverPremiersExperiencesParIdentite(identite,
						nombreSelectionExp);
		restePrecedExp = 0;
		resteSuivantExp = 0;
		if (nombreExperience > nombreSelectionExp) {
			resteSuivantExp = (int) (nombreExperience - nombreSelectionExp);
			suivantExperience = "false";
		} else {
			suivantExperience = "true";
		}
		precedentExperience = "true";
	}

	public void dernieresHExperience() {
		afficherExperiences();

	}

	public void precedentHExperience() {
		Date max = experiences.get(experiences.size() - 1).getDatedebu();

		experiences = (ArrayList<Experience>) gestionExperienceLocal
				.trouverExperiencesParIdentiteEtDateMax(identite, max,
						nombreSelectionExp);
		suivantExperience = "false";
		resteSuivantExp += nombreSelectionExp;
		restePrecedExp -= nombreSelectionExp;
		if (restePrecedExp < 1)
			precedentExperience = "true";
		if (resteSuivantExp < 1)
			suivantExperience = "true";

	}

	public void suivantHExperience() {
		Date min = experiences.get(0).getDatedebu();
		experiences = (ArrayList<Experience>) gestionExperienceLocal
				.trouverPremiersExperiencesParIdentiteEtDateMin(identite, min,
						nombreSelectionExp);
		restePrecedExp += nombreSelectionExp;
		precedentExperience = "false";
		resteSuivantExp -= nombreSelectionExp;
		if (resteSuivantExp < 1)
			suivantExperience = "true";
		if (restePrecedExp < 1)
			precedentExperience = "true";
	}

	public void ajouterExperience() {
		if (identite != null && identite.getNumedoss() != null) {
			gestionIdentiteLocal
					.ajouterExperience(identite, nouvelleExperience);
			nouvelleExperience = new Experience();

			nombreExperience++;
			afficherExperiences();
		}
	}

	public void supprimerExperience() {
		if (experience.getId() != null) {
			gestionExperienceLocal.supprimerExperience(experience);
			nombreExperience--;
			afficherExperiences();
		}
	}

	public void modifierExperience() {
		if (experience != null && experience.getId() != null)
			gestionExperienceLocal.modifierExperience(experience);
		afficherExperiences();
	}

	/*
	 * ********************************************************** Identité
	 * ***********************************************************
	 */
	public void supprimerIdentite() {
		if (identite != null && identite.getNumedoss() != null)
			gestionIdentiteLocal.supprimerIdentite(identite);

		identite = new Identite();
		piecesIdentite = new ArrayList<>();
		individuelles = new InfosIndividuelles();
		physiques = new InfosPhysiques();
		statuts = new ArrayList<>();
		statut = new Statut();
		nouvelSt = new Statut();
		adresse = new Adresse();
		adresses = new ArrayList<>();
		adresseshistorique = new ArrayList<>();
		telephones = new ArrayList<>();
		mails = new ArrayList<>();
		embauche = new Embauche();
		affectations = new ArrayList<>();
		affectation = new Affectation();
		bancaire = new CoordonneeBancaire();
		bancaires = new ArrayList<>();
		salaire = new Salaire();
		attachementEmployes = new ArrayList<>();
		attachementManagers = new ArrayList<>();
		naissance = new Naissance();
		nationalites = new ArrayList<>();
		selectedNationalite = new Nationalite();
		vehicules = new ArrayList<>();
		medicales = new ArrayList<>();
	}

	public void modifierIdentite() {
		if (identite != null && identite.getNumedoss() != null) {
			if (nouvellePhoto != null)
				identite.setPhoto(nouvellePhoto);
			gestionIdentiteLocal.modifierIdentite(identite);
			gestionInfosIndividuellesLocal
					.modifierInfosIndividuelles(individuelles);

		}
	}

	public void modifierNaissance() {
		if (identite != null && identite.getNumedoss() != null) {
			if (naissance != null && naissance.getId() != null)
				gestionNaissanceLocal.modifierNaissance(naissance);
			else
				gestionIdentiteLocal.ajouterNaissance(identite, naissance);
		}
	}

	public void modifierPhysiques() {
		if (identite != null && identite.getNumedoss() != null) {
			if (physiques != null && physiques.getId() != null)
				gestionInfosPhysiquesLocal.modifierInfosPhysiques(physiques);
			else
				gestionIdentiteLocal.ajouterFichePhysique(identite, physiques);
		}
	}

	public String embaucher() {
		return "embauche?faces-redirect=true";
	}

	/*
	 * **********************************************************
	 * Affectations***********************************************************
	 */

	public void afficherHistoriqueAffectations() {
		affectations = (ArrayList<Affectation>) gestionAffectationLocal
				.trouverHistoriqueAffectationsParEmbauche(embauche,
						nombreSelectAff);
		restePrecedAff = 0;
		resteSuivantAff = 0;
		if (nombreAffectations > nombreSelectAff) {
			restePrecedAff = (int) (nombreAffectations - nombreSelectAff);
			precedentAff = "false";
		} else {
			precedentAff = "true";
		}
		suivantAff = "true";
	}

	public void premiersHistoriqueAff() {
		affectations = (ArrayList<Affectation>) gestionAffectationLocal
				.trouverPremiersHistoriqueAffectationsParEmbauche(embauche,
						nombreSelectAff);
		restePrecedAff = 0;
		resteSuivantAff = 0;
		if (nombreAffectations > nombreSelectAff) {
			resteSuivantAff = (int) (nombreAffectations - nombreSelectAff);
			suivantAff = "false";
		} else {
			suivantAff = "true";
		}
		precedentAff = "true";
	}

	public void derniersHistoriqueAff() {
		afficherHistoriqueAffectations();
	}

	public void precedentHistoriqueAff() {
		Date max = affectations.get(affectations.size() - 1).getDatedeb();

		affectations = (ArrayList<Affectation>) gestionAffectationLocal
				.trouverHistoriqueAffectationsParEmbaucheEtDateMax(embauche,
						max, nombreSelectAff);
		suivantAff = "false";
		resteSuivantAff += nombreSelectAff;
		restePrecedAff -= nombreSelectAff;
		if (restePrecedAff < 1)
			precedentAff = "true";
		if (resteSuivantAff < 1)
			suivantAff = "true";

	}

	public void suivantHistoriqueAff() {
		Date min = affectations.get(0).getDatedeb();
		affectations = (ArrayList<Affectation>) gestionAffectationLocal
				.trouverPremiersHistoriqueAffectationsParEmbaucheEtDateMin(
						embauche, min, nombreSelectAff);
		restePrecedAff += nombreSelectAff;
		precedentAff = "false";
		resteSuivantAff -= nombreSelectAff;
		if (resteSuivantAff < 1)
			suivantAff = "true";
		if (restePrecedAff < 1)
			precedentAff = "true";
	}

	public void modifierAffectation() {
		boolean test = true;

		if (affectation.getPoste().equals("")
				&& ((affectation.getEmploi().equals("")) || (affectation
						.getUniteorga().equals("")))) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"affe",
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Poste ou (Emploi et Unité organisationnelle) obligatoire",
									""));
			test = false;
		}
		if (test == true) {
			if (affectation != null && affectation.getId() != null) {
				if (affectation.getDatedeb().after(
						affectations.get(affectations.indexOf(affectation) + 1)
								.getDatedeb())) {
					if (affectations.indexOf(affectation) == 0) {
						affectations.get(affectations.indexOf(affectation) + 1)
								.setDatefin(
										MyCalendar.subDays(
												affectation.getDatedeb(), 1));
						gestionAffectationLocal
								.modifierAffectation(affectations
										.get(affectations.indexOf(affectation) + 1));
					} else {
						affectations.get(affectations.indexOf(affectation) + 1)
								.setDatefin(
										MyCalendar.subDays(
												affectation.getDatedeb(), 1));
						affectations.get(affectations.indexOf(affectation) - 1)
								.setDatedeb(
										MyCalendar.addDays(
												affectation.getDatefin(), 1));
						gestionAffectationLocal
								.modifierAffectation(affectations
										.get(affectations.indexOf(affectation) - 1));
						gestionAffectationLocal
								.modifierAffectation(affectations
										.get(affectations.indexOf(affectation) + 1));
					}
				}
				gestionAffectationLocal.modifierAffectation(affectation);

				afficherHistoriqueAffectations();

			}
		}
	}

	public void ajouterAffectation() {
		boolean test = true;

		if (nouvelleAffectation.getPoste().equals("")
				&& ((nouvelleAffectation.getEmploi().equals("")) || (nouvelleAffectation
						.getUniteorga().equals("")))) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"affe",
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Poste ou (Emploi et Unité organisationnelle) obligatoire",
									""));
			test = false;
		}
		if (test == true) {
			if (embauche != null && embauche.getId() != null
					&& nouvelleAffectation.getDatedeb() != null) {
				gestionEmbaucheLocal.ajouterAffectation(embauche,
						nouvelleAffectation);
				nouvelleAffectation = new Affectation();
				nombreAffectations++;
				afficherHistoriqueAffectations();

			}
		}
	}

	public void supprimerAffectation() {
		boolean test = true;
		if (affectations.size() == 1) {
			FacesContext.getCurrentInstance().addMessage(
					"affe",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Au moins une affectation obligatoire", ""));
			test = false;
		}

		if (test == true) {
			if (affectation != null && affectation.getId() != null) {
				if (affectation.getDatedeb().after(
						affectations.get(affectations.indexOf(affectation) + 1)
								.getDatedeb())) {
					if (affectations.indexOf(affectation) == 0)
						affectations.get(affectations.indexOf(affectation) + 1)
								.setDatefin(null);
					else
						affectations.get(affectations.indexOf(affectation) + 1)
								.setDatefin(affectation.getDatefin());
					gestionAffectationLocal.modifierAffectation(affectations
							.get(affectations.indexOf(affectation) + 1));
				}
				gestionAffectationLocal.supprimerAffectation(affectation);
				nombreAffectations--;
				afficherHistoriqueAffectations();

			}
		}
	}

	public void afficherManagersEtEmployes() {
		nombreAttachementsEmp = attachementEmployeLocal
				.trouverNombreOccurrencesParAffectation(affectation);
		if (nombreAttachementsEmp > 0)
			afficherHistoriqueEmployes();
		else {
			attachementEmployes = new ArrayList<>();
			nouvelAttachementEmploye = new AttachementEmploye();

		}
		nombreAttachementsMgr = attachementManagerLocal
				.trouverNombreOccurrencesParAffectation(affectation);
		if (nombreAttachementsMgr > 0)
			afficherHistoriqueManagers();
		else {
			attachementManagers = new ArrayList<>();
			nouvelAttachementManager = new AttachementManager();
		}
		nombreImputations = gestionImputationGaLocal
				.trouverNombreOccurrencesParAffectation(affectation);
		if (nombreImputations > 0)
			afficherHistoriqueImputations();
		else {
			imputationGas = new ArrayList<>();
			nouvelleImputationGa = new ImputationGa();
		}
	}

	// employers

	public void afficherHistoriqueEmployes() {
		if (affectation != null && affectation.getId() != null) {
			attachementEmployes = (ArrayList<AttachementEmploye>) attachementEmployeLocal
					.trouverHistoriqueAttachementsEmployesParAffectation(
							affectation, nombreSelectEmp);
			restePrecedEmp = 0;
			resteSuivantEmp = 0;
			if (nombreAttachementsEmp > nombreSelectEmp) {
				restePrecedEmp = (int) (nombreAttachementsEmp - nombreSelectEmp);
				precedentEmp = "false";
			} else {
				precedentEmp = "true";
			}
			suivantEmp = "true";
		}
	}

	public void premiersHistoriqueEmp() {
		attachementEmployes = (ArrayList<AttachementEmploye>) attachementEmployeLocal
				.trouverPremiersHistoriqueAttachementsEmployesParAffectation(
						affectation, nombreSelectEmp);
		restePrecedEmp = 0;
		resteSuivantEmp = 0;
		if (nombreAttachementsEmp > nombreSelectEmp) {
			resteSuivantEmp = (int) (nombreAttachementsEmp - nombreSelectEmp);
			suivantEmp = "false";
		} else {
			suivantEmp = "true";
		}
		precedentEmp = "true";
	}

	public void derniersHistoriqueEmp() {
		afficherHistoriqueEmployes();
	}

	public void precedentHistoriqueEmp() {
		Date max = attachementEmployes.get(attachementEmployes.size() - 1)
				.getDatedeb();

		attachementEmployes = (ArrayList<AttachementEmploye>) attachementEmployeLocal
				.trouverHistoriqueAttachementsEmployesParAffectationEtDateMax(
						affectation, max, nombreSelectEmp);
		suivantEmp = "false";
		resteSuivantEmp += nombreSelectEmp;
		restePrecedEmp -= nombreSelectEmp;
		if (restePrecedEmp < 1)
			precedentEmp = "true";
		if (resteSuivantEmp < 1)
			suivantEmp = "true";

	}

	public void suivantHistoriqueEmp() {
		Date min = attachementEmployes.get(0).getDatedeb();
		attachementEmployes = (ArrayList<AttachementEmploye>) attachementEmployeLocal
				.trouverPremiersHistoriqueAttachementsEmployesParAffectationEtDateMin(
						affectation, min, nombreSelectEmp);
		restePrecedEmp += nombreSelectEmp;
		precedentEmp = "false";
		resteSuivantEmp -= nombreSelectEmp;
		if (resteSuivantEmp < 1)
			suivantEmp = "true";
		if (restePrecedEmp < 1)
			precedentEmp = "true";
	}

	public void modifierAttachementEmploye() {
		if (attachementEmploye != null && attachementEmploye.getId() != null) {
			if (attachementEmploye.getDatedeb().after(
					attachementEmployes
							.get(attachementEmployes
									.indexOf(attachementEmploye) + 1)
							.getDatedeb())) {
				if (attachementEmployes.indexOf(attachementEmploye) == 0) {
					attachementEmployes
							.get(attachementEmployes
									.indexOf(attachementEmploye) + 1)
							.setDatefin(
									MyCalendar.subDays(
											attachementEmploye.getDatedeb(), 1));
					attachementEmployeLocal
							.modifierAttachementEmploye(attachementEmployes
									.get(attachementEmployes
											.indexOf(attachementEmploye) + 1));
				} else {
					situationCiviles
							.get(attachementEmployes
									.indexOf(attachementEmploye) + 1)
							.setDatefin(
									MyCalendar.subDays(
											attachementEmploye.getDatedeb(), 1));
					situationCiviles
							.get(attachementEmployes
									.indexOf(attachementEmploye) - 1)
							.setDateffet(
									MyCalendar.addDays(
											attachementEmploye.getDatefin(), 1));
					attachementEmployeLocal
							.modifierAttachementEmploye(attachementEmployes
									.get(attachementEmployes
											.indexOf(attachementEmploye) - 1));
					attachementEmployeLocal
							.modifierAttachementEmploye(attachementEmployes
									.get(attachementEmployes
											.indexOf(attachementEmploye) + 1));
				}
			}
			attachementEmployeLocal
					.modifierAttachementEmploye(attachementEmploye);
			afficherHistoriqueEmployes();
		}
	}

	public void ajouterAttachementEmploye() {
		if (affectation != null && affectation.getId() != null
				&& nouvelAttachementEmploye.getEmpdossi() != null) {
			gestionAffectationLocal.attacherEmploye(affectation,
					nouvelAttachementEmploye);
			nouvelAttachementEmploye = new AttachementEmploye();
			nombreAttachementsEmp++;
			afficherHistoriqueEmployes();
		}
	}

	public void supprimerAttachementEmploye() {
		if (attachementEmploye != null && attachementEmploye.getId() != null) {
			if (attachementEmploye.getDatedeb().after(
					attachementEmployes
							.get(attachementEmployes
									.indexOf(attachementEmploye) + 1)
							.getDatedeb())) {
				if (attachementEmployes.indexOf(attachementEmploye) == 0)
					attachementEmployes
							.get(attachementEmployes
									.indexOf(attachementEmploye) + 1)
							.setDatefin(null);
				else
					attachementEmployes
							.get(attachementEmployes
									.indexOf(attachementEmploye) + 1)
							.setDatefin(attachementEmploye.getDatefin());
				attachementEmployeLocal
						.modifierAttachementEmploye(attachementEmployes
								.get(attachementEmployes
										.indexOf(attachementEmploye) + 1));
			}
			attachementEmployeLocal
					.supprimerAttachementEmploye(attachementEmploye);
			nombreAttachementsEmp--;
			afficherHistoriqueEmployes();
		}
	}

	public void ajouterIdentiteEmploye() {
		if (numEmp != null) {
			rechercher(numEmp);
			if (idEmp.getNumedoss() != null && idEmp.getMatricul() != null) {
				nouvelAttachementEmploye = new AttachementEmploye();
				nouvelAttachementEmploye.setEmpdossi(idEmp.getNumedoss());
				nouvelAttachementEmploye.setEmpnom(idEmp.getNom());
				nouvelAttachementEmploye.setEmppreno(idEmp.getPrenom());
				nouvelAttachementEmploye.setDatedeb(new Date());
				idEmp = new Identite();
				numEmp = null;
			}
		}
	}

	public void rechercher(Long num) {
		idEmp = gestionIdentiteLocal.trouverParNumeroDossier(num);
		if (idEmp == null)
			idEmp = new Identite();
	}

	// managers

	public void afficherHistoriqueManagers() {
		if (affectation != null && affectation.getId() != null) {
			attachementManagers = (ArrayList<AttachementManager>) attachementManagerLocal
					.trouverHistoriqueAttachementsManagersParAffectation(
							affectation, nombreSelectMgr);
			restePrecedMgr = 0;
			resteSuivantMgr = 0;
			if (nombreAttachementsMgr > nombreSelectMgr) {
				restePrecedMgr = (int) (nombreAttachementsMgr - nombreSelectMgr);
				precedentMgr = "false";
			} else {
				precedentMgr = "true";
			}
			suivantMgr = "true";

		}
	}

	public void premiersHistoriqueMgr() {
		attachementManagers = (ArrayList<AttachementManager>) attachementManagerLocal
				.trouverPremiersHistoriqueAttachementsManagersParAffectation(
						affectation, nombreSelectMgr);
		restePrecedMgr = 0;
		resteSuivantMgr = 0;
		if (nombreAttachementsMgr > nombreSelectMgr) {
			resteSuivantMgr = (int) (nombreAttachementsMgr - nombreSelectMgr);
			suivantMgr = "false";
		} else {
			suivantMgr = "true";
		}
		precedentMgr = "true";
	}

	public void derniersHistoriqueMgr() {
		afficherHistoriqueManagers();
	}

	public void precedentHistoriqueMgr() {
		Date max = attachementManagers.get(attachementManagers.size() - 1)
				.getDatedeb();

		attachementManagers = (ArrayList<AttachementManager>) attachementManagerLocal
				.trouverHistoriqueAttachementsManagersParAffectationEtDateMax(
						affectation, max, nombreSelectMgr);
		suivantMgr = "false";
		resteSuivantMgr += nombreSelectMgr;
		restePrecedMgr -= nombreSelectMgr;
		if (restePrecedMgr < 1)
			precedentMgr = "true";
		if (resteSuivantMgr < 1)
			suivantMgr = "true";

	}

	public void suivantHistoriqueMgr() {
		Date min = attachementManagers.get(0).getDatedeb();
		attachementManagers = (ArrayList<AttachementManager>) attachementManagerLocal
				.trouverPremiersHistoriqueAttachementsManagersParAffectationEtDateMin(
						affectation, min, nombreSelectMgr);
		restePrecedMgr += nombreSelectMgr;
		precedentMgr = "false";
		resteSuivantMgr -= nombreSelectMgr;
		if (resteSuivantMgr < 1)
			suivantMgr = "true";
		if (restePrecedMgr < 1)
			precedentMgr = "true";
	}

	public void modifierAttachementManager() {
		if (attachementManager != null && attachementManager.getId() != null) {
			if (attachementManager.getDatedeb().after(
					attachementManagers
							.get(attachementManagers
									.indexOf(attachementManager) + 1)
							.getDatedeb())) {
				if (attachementManagers.indexOf(attachementManager) == 0) {
					attachementManagers
							.get(attachementManagers
									.indexOf(attachementManager) + 1)
							.setDatefin(
									MyCalendar.subDays(
											attachementManager.getDatedeb(), 1));
					attachementManagerLocal
							.modifierAttachementManager(attachementManagers
									.get(attachementManagers
											.indexOf(attachementManager) + 1));
				} else {
					situationCiviles
							.get(attachementManagers
									.indexOf(attachementManager) + 1)
							.setDatefin(
									MyCalendar.subDays(
											attachementManager.getDatedeb(), 1));
					situationCiviles
							.get(attachementManagers
									.indexOf(attachementManager) - 1)
							.setDateffet(
									MyCalendar.addDays(
											attachementManager.getDatefin(), 1));
					attachementManagerLocal
							.modifierAttachementManager(attachementManagers
									.get(attachementManagers
											.indexOf(attachementManager) - 1));
					attachementManagerLocal
							.modifierAttachementManager(attachementManagers
									.get(attachementManagers
											.indexOf(attachementManager) + 1));
				}
			}
			attachementManagerLocal
					.modifierAttachementManager(attachementManager);
			afficherHistoriqueManagers();
		}
	}

	public void ajouterAttachementManager() {
		if (affectation != null && affectation.getId() != null
				&& nouvelAttachementManager.getManagdos() != null) {
			gestionAffectationLocal.attacherManager(affectation,
					nouvelAttachementManager);
			nouvelAttachementManager = new AttachementManager();
			nombreAttachementsMgr++;
			afficherHistoriqueManagers();
		}
	}

	public void supprimerAttachementManager() {
		if (attachementManager != null && attachementManager.getId() != null) {
			if (attachementManager.getDatedeb().after(
					attachementManagers
							.get(attachementManagers
									.indexOf(attachementManager) + 1)
							.getDatedeb())) {
				if (attachementManagers.indexOf(attachementManager) == 0)
					attachementManagers
							.get(attachementManagers
									.indexOf(attachementManager) + 1)
							.setDatefin(null);
				else
					attachementManagers
							.get(attachementManagers
									.indexOf(attachementManager) + 1)
							.setDatefin(attachementManager.getDatefin());
				attachementManagerLocal
						.modifierAttachementManager(attachementManagers
								.get(attachementManagers
										.indexOf(attachementManager) + 1));
			}
			attachementManagerLocal
					.supprimerAttachementManager(attachementManager);
			nombreAttachementsMgr--;
			afficherHistoriqueManagers();
		}
	}

	public void ajouterIdentiteManager() {
		if (numMgr != null) {
			rechercher(numMgr);
			if (idEmp.getNumedoss() != null && idEmp.getMatricul() != null) {
				nouvelAttachementManager = new AttachementManager();
				nouvelAttachementManager.setManagdos(idEmp.getNumedoss());
				nouvelAttachementManager.setManagnom(idEmp.getNom());
				nouvelAttachementManager.setManagpre(idEmp.getPrenom());
				nouvelAttachementManager.setDatedeb(new Date());
				idEmp = new Identite();
				numMgr = null;
			}
		}
	}

	// Imputaion

	public void afficherHistoriqueImputations() {
		if (affectation != null && affectation.getId() != null) {
			imputationGas = (ArrayList<ImputationGa>) gestionImputationGaLocal
					.trouverHistoriqueImputationGasParAffectation(affectation,
							nombreSelectImp);
			restePrecedImp = 0;
			resteSuivantImp = 0;
			if (nombreImputations > nombreSelectImp) {
				restePrecedImp = (int) (nombreImputations - nombreSelectImp);
				precedentImp = "false";
			} else {
				precedentImp = "true";
			}
			suivantImp = "true";
		}
	}

	public void premiersHistoriqueImp() {
		imputationGas = (ArrayList<ImputationGa>) gestionImputationGaLocal
				.trouverPremiersHistoriqueImputationGasParAffectation(
						affectation, nombreSelectImp);
		restePrecedImp = 0;
		resteSuivantImp = 0;
		if (nombreImputations > nombreSelectImp) {
			resteSuivantImp = (int) (nombreImputations - nombreSelectImp);
			suivantImp = "false";
		} else {
			suivantImp = "true";
		}
		precedentImp = "true";
	}

	public void derniersHistoriqueImp() {
		afficherHistoriqueImputations();
	}

	public void precedentHistoriqueImp() {
		Date max = imputationGas.get(imputationGas.size() - 1).getDateffet();

		imputationGas = (ArrayList<ImputationGa>) gestionImputationGaLocal
				.trouverHistoriqueImputationGasParAffectationEtDateMax(
						affectation, max, nombreSelectImp);
		suivantImp = "false";
		resteSuivantImp += nombreSelectImp;
		restePrecedImp -= nombreSelectImp;
		if (restePrecedImp < 1)
			precedentImp = "true";
		if (resteSuivantImp < 1)
			suivantImp = "true";

	}

	public void suivantHistoriqueImp() {
		Date min = imputationGas.get(0).getDateffet();
		imputationGas = (ArrayList<ImputationGa>) gestionImputationGaLocal
				.trouverPremiersHistoriqueImputationGasParAffectationEtDateMin(
						affectation, min, nombreSelectImp);
		restePrecedImp += nombreSelectImp;
		precedentImp = "false";
		resteSuivantImp -= nombreSelectImp;
		if (resteSuivantImp < 1)
			suivantImp = "true";
		if (restePrecedImp < 1)
			precedentImp = "true";
	}

	public void modifierImputation() {
		if (imputationGa != null && imputationGa.getId() != null
				&& (imputationGas != null)) {

			if (imputationGa.getDateffet().after(
					imputationGas.get(imputationGas.indexOf(imputationGa) + 1)
							.getDateffet())) {
				if (imputationGas.indexOf(imputationGa) == 0) {
					imputationGas.get(imputationGas.indexOf(imputationGa) + 1)
							.setDatefin(
									MyCalendar.subDays(
											imputationGa.getDateffet(), 1));
					gestionImputationGaLocal.modifierImputationGa(imputationGas
							.get(imputationGas.indexOf(imputationGa) + 1));
				} else {
					imputationGas.get(imputationGas.indexOf(imputationGa) + 1)
							.setDatefin(
									MyCalendar.subDays(
											imputationGa.getDateffet(), 1));
					imputationGas.get(imputationGas.indexOf(imputationGa) - 1)
							.setDateffet(
									MyCalendar.addDays(
											imputationGa.getDatefin(), 1));
					gestionImputationGaLocal.modifierImputationGa(imputationGas
							.get(imputationGas.indexOf(imputationGa) - 1));
					gestionImputationGaLocal.modifierImputationGa(imputationGas
							.get(imputationGas.indexOf(imputationGa) + 1));
				}
			}
			gestionImputationGaLocal.modifierImputationGa(imputationGa);
			afficherHistoriqueImputations();
		}
	}

	public void ajouterImputation() {
		if (nouvelleImputationGa != null
				&& nouvelleImputationGa.getId() != null
				&& nouvelleImputationGa.getDateffet() != null) {
			gestionAffectationLocal.ajouterImputationGa(affectation,
					nouvelleImputationGa);
			nouvelleImputationGa = new ImputationGa();
			nombreImputations++;
			afficherHistoriqueImputations();
		}
	}

	public void supprimerImputation() {
		if (imputationGa != null && imputationGa.getId() != null) {
			if (imputationGa.getDateffet().after(
					imputationGas.get(imputationGas.indexOf(imputationGa) + 1)
							.getDateffet())) {
				if (imputationGas.indexOf(imputationGa) == 0)
					imputationGas.get(imputationGas.indexOf(imputationGa) + 1)
							.setDatefin(null);
				else
					imputationGas.get(imputationGas.indexOf(imputationGa) + 1)
							.setDatefin(imputationGa.getDatefin());
				gestionImputationGaLocal.modifierImputationGa(imputationGas
						.get(imputationGas.indexOf(imputationGa) + 1));
			}
			gestionImputationGaLocal.supprimerImputationGa(imputationGa);
			nombreImputations--;
			afficherHistoriqueImputations();
		}
	}

	/*
	 * ****************************************************** contrats
	 * *********************************************
	 */

	public void handleFileUpload(FileUploadEvent event) {

		FacesMessage message = new FacesMessage("success", event.getFile()
				.getFileName() + "file pdf uploaded");
		FacesContext.getCurrentInstance().addMessage(null, message);

		InputStream is = null;
		try {
			is = event.getFile().getInputstream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] cont = null;
		try {
			cont = IOUtils.toByteArray(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		uploadedCont = cont;

	}

	public void afficherHistoriqueContrats() {
		contrats = (ArrayList<Contrat>) gestionContratLocal
				.trouverHistoriqueContratsParEmbauche(embauche,
						nombreSelectCont);
		restePrecedCont = 0;
		resteSuivantCont = 0;
		if (nombreContrats > nombreSelectCont) {
			restePrecedCont = (int) (nombreContrats - nombreSelectCont);
			precedentCont = "false";
		} else {
			precedentCont = "true";
		}
		suivantCont = "true";
	}

	public void premiersHistoriqueCont() {
		contrats = (ArrayList<Contrat>) gestionContratLocal
				.trouverPremiersHistoriqueContratsParEmbauche(embauche,
						nombreSelectCont);
		restePrecedCont = 0;
		resteSuivantCont = 0;
		if (nombreContrats > nombreSelectCont) {
			resteSuivantCont = (int) (nombreContrats - nombreSelectCont);
			suivantCont = "false";
		} else {
			suivantCont = "true";
		}
		precedentCont = "true";
	}

	public void derniersHistoriqueCont() {
		afficherHistoriqueContrats();
	}

	public void precedentHistoriqueCont() {
		Date max = contrats.get(contrats.size() - 1).getDatedebu();

		contrats = (ArrayList<Contrat>) gestionContratLocal
				.trouverHistoriqueContratsParEmbaucheEtDateMax(embauche, max,
						nombreSelectCont);
		suivantCont = "false";
		resteSuivantCont += nombreSelectCont;
		restePrecedCont -= nombreSelectCont;
		if (restePrecedCont < 1)
			precedentCont = "true";
		if (resteSuivantCont < 1)
			suivantCont = "true";

	}

	public void suivantHistoriqueCont() {
		Date min = contrats.get(0).getDatedebu();
		contrats = (ArrayList<Contrat>) gestionContratLocal
				.trouverPremiersHistoriqueContratsParEmbaucheEtDateMin(
						embauche, min, nombreSelectCont);
		restePrecedCont += nombreSelectCont;
		precedentCont = "false";
		resteSuivantCont -= nombreSelectCont;
		if (resteSuivantCont < 1)
			suivantCont = "true";
		if (restePrecedCont < 1)
			precedentCont = "true";
	}

	public void ajouterContrat() {
		if (embauche != null && embauche.getId() != null
				&& nouveauContrat.getDatedebu() != null) {
			nouveauContrat.setContratSigne(uploadedCont);

			gestionEmbaucheLocal.ajouterContrat(embauche, nouveauContrat);
			nombreContrats++;
			nouveauContrat = new Contrat();
			uploadedCont = null;
			afficherHistoriqueContrats();
		}
	}

	public void modifierContrat() {
		if (selectedContrat != null && contrats.get(0) != null
				&& (contrats != null)) {

			if (selectedContrat.getDatedebu().after(
					contrats.get(contrats.indexOf(selectedContrat) + 1)
							.getDatedebu())) {
				if (contrats.indexOf(selectedContrat) == 0) {
					contrats.get(contrats.indexOf(selectedContrat) + 1)
							.setDatefin(
									MyCalendar.subDays(
											selectedContrat.getDatedebu(), 1));
					gestionContratLocal.modifierContrat(contrats.get(contrats
							.indexOf(selectedContrat) + 1));
				} else {
					contrats.get(contrats.indexOf(selectedContrat) + 1)
							.setDatefin(
									MyCalendar.subDays(
											selectedContrat.getDatedebu(), 1));
					contrats.get(contrats.indexOf(selectedContrat) - 1)
							.setDatedebu(
									MyCalendar.addDays(
											selectedContrat.getDatefin(), 1));
					gestionContratLocal.modifierContrat(contrats.get(contrats
							.indexOf(selectedContrat) - 1));
					gestionContratLocal.modifierContrat(contrats.get(contrats
							.indexOf(selectedContrat) + 1));
				}
			}
			if (uploadedCont != null) {
				selectedContrat.setContratSigne(uploadedCont);
			}
			gestionContratLocal.modifierContrat(selectedContrat);
			uploadedCont = null;

			afficherHistoriqueContrats();

		}
	}

	public void supprimerContrat() {
		if (selectedContrat != null && selectedContrat.getId() != null
				&& (contrats != null)) {

			if (selectedContrat.getDatedebu().after(
					contrats.get(contrats.indexOf(selectedContrat) + 1)
							.getDatedebu())) {
				if (contrats.indexOf(selectedContrat) == 0)
					contrats.get(contrats.indexOf(selectedContrat) + 1)
							.setDatefin(null);
				else
					contrats.get(contrats.indexOf(selectedContrat) + 1)
							.setDatefin(selectedContrat.getDatefin());
				gestionContratLocal.modifierContrat(contrats.get(contrats
						.indexOf(selectedContrat) + 1));
			}
			gestionContratLocal.supprimerContrat(selectedContrat);
			nombreContrats--;
			afficherHistoriqueContrats();

		}
	}

	/*
	 * ****************************************************** situation civile
	 * *********************************************
	 */

	public void afficherHistoriqueSc() {

		situationCiviles = (ArrayList<SituationCivile>) gestionSituationCivileLocal
				.trouverHistoriqueSituationsCivilesParIdentite(identite,
						nombreSelectionSc);

		restePrecedSc = 0;
		resteSuivantSc = 0;
		if (nombreSc > nombreSelectionSc) {
			restePrecedSc = (int) (nombreSc - nombreSelectionSc);
			precedentSc = "false";
		} else {
			precedentSc = "true";
		}
		suivantSc = "true";
	}

	public void precedentHistoriqueSC() {

		Date max = situationCiviles.get(situationCiviles.size() - 1)
				.getDateffet();

		situationCiviles = (ArrayList<SituationCivile>) gestionSituationCivileLocal
				.trouverPrecedentsHSituationCivileParIdentiteEtDateMax(
						identite, max, nombreSelectionSc);

		suivantSc = "false";
		resteSuivantSc += nombreSelectionSc;
		restePrecedSc -= nombreSelectionSc;
		if (restePrecedSc < 1)
			precedentSc = "true";
		if (resteSuivantSc < 1)
			suivantSc = "true";

	}

	public void suivantHistoriqueSC() {

		Date min = situationCiviles.get(0).getDateffet();

		situationCiviles = (ArrayList<SituationCivile>) gestionSituationCivileLocal
				.trouverSuivantsHSituationCivileParIdentiteEtDateMin(identite,
						min, nombreSelectionSc);

		restePrecedSc += nombreSelectionSc;
		precedentSc = "false";
		resteSuivantSc -= nombreSelectionSc;
		if (resteSuivantSc < 1)
			suivantSc = "true";
		if (restePrecedSc < 1)
			precedentSc = "true";
	}

	public void premierHistoriqueSC() {
		situationCiviles = (ArrayList<SituationCivile>) gestionSituationCivileLocal
				.trouverPremieresHSituationCivileParIdentite(identite,
						nombreSelectionSc);
		restePrecedSc = 0;
		resteSuivantSc = 0;
		if (nombreSc > nombreSelectionSc) {
			resteSuivantSc = (int) (nombreSc - nombreSelectionSc);
			suivantSc = "false";
		} else {
			suivantSc = "true";
		}
		precedentSc = "true";

	}

	public void dernierHistoriqueSC() {
		afficherHistoriqueSc();
	}

	public void ajouterSc() {

		if (identite != null && identite.getMatricul() != null
				&& nouvelleSc != null && nouvelleSc.getDateffet() != null
				&& nouvelleSc.getEtat() != null) {
			if (situationCiviles.get(0) == null
					|| situationCiviles.get(0).getId() == null) {
				gestionIdentiteLocal.ajouterSituationCivile(identite,
						nouvelleSc);
				nouvelleSc = new SituationCivile();
				nombreSc++;
				afficherHistoriqueSc();
			} else {
				if (nouvelleSc.getDateffet().after(
						situationCiviles.get(0).getDateffet())) {
					situationCiviles.get(0).setDatefin(
							MyCalendar.subDays(nouvelleSc.getDateffet(), 1));
					gestionSituationCivileLocal
							.modifierSituationCivile(situationCiviles.get(0));
					gestionIdentiteLocal.ajouterSituationCivile(identite,
							nouvelleSc);
					nouvelleSc = new SituationCivile();
					nombreSc++;
					afficherHistoriqueSc();
				}

			}
		}

	}

	public void modifierSc() {
		if (situationCivile != null && situationCivile.getId() != null
				&& (situationCiviles != null)) {

			if (situationCivile.getDateffet().after(
					situationCiviles.get(
							situationCiviles.indexOf(situationCivile) + 1)
							.getDateffet())) {
				if (situationCiviles.indexOf(situationCivile) == 0) {
					situationCiviles.get(
							situationCiviles.indexOf(situationCivile) + 1)
							.setDatefin(
									MyCalendar.subDays(
											situationCivile.getDateffet(), 1));
					gestionSituationCivileLocal
							.modifierSituationCivile(situationCiviles
									.get(situationCiviles
											.indexOf(situationCivile) + 1));
				} else {
					situationCiviles.get(
							situationCiviles.indexOf(situationCivile) + 1)
							.setDatefin(
									MyCalendar.subDays(
											situationCivile.getDateffet(), 1));
					situationCiviles.get(
							situationCiviles.indexOf(situationCivile) - 1)
							.setDateffet(
									MyCalendar.addDays(
											situationCivile.getDatefin(), 1));
					gestionSituationCivileLocal
							.modifierSituationCivile(situationCiviles
									.get(situationCiviles
											.indexOf(situationCivile) - 1));
					gestionSituationCivileLocal
							.modifierSituationCivile(situationCiviles
									.get(situationCiviles
											.indexOf(situationCivile) + 1));
				}
			}
			gestionSituationCivileLocal
					.modifierSituationCivile(situationCivile);

			afficherHistoriqueSc();
		}
	}

	public void supprimerSc() {
		boolean test = true;
		if (situationCiviles.size() == 1) {
			FacesContext.getCurrentInstance().addMessage(
					"sitciv",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Au moins une situation civile obligatoire", ""));
			test = false;
		}

		if (test == true) {
			if (situationCivile != null && situationCivile.getId() != null
					&& (situationCiviles != null)) {

				if (situationCivile.getDateffet().after(
						situationCiviles.get(
								situationCiviles.indexOf(situationCivile) + 1)
								.getDateffet())) {
					if (situationCiviles.indexOf(situationCivile) == 0)
						situationCiviles.get(
								situationCiviles.indexOf(situationCivile) + 1)
								.setDatefin(null);
					else
						situationCiviles.get(
								situationCiviles.indexOf(situationCivile) + 1)
								.setDatefin(situationCivile.getDatefin());
					gestionSituationCivileLocal
							.modifierSituationCivile(situationCiviles
									.get(situationCiviles
											.indexOf(situationCivile) + 1));
				}
				gestionSituationCivileLocal
						.supprimerSituationCivile(situationCivile);

				nombreSc--;
				afficherHistoriqueSc();
			}
		}
	}

	/*
	 * ****************************************************** statut
	 * *********************************************
	 */

	public void afficherHistoriqueSt() {

		statuts = (ArrayList<Statut>) gestionStatutLocal
				.trouverHistoriqueStatutsParIdentite(identite,
						nombreSelectionSt);

		restePrecedSt = 0;
		resteSuivantSt = 0;
		if (nombreSt > nombreSelectionSt) {
			restePrecedSt = (int) (nombreSt - nombreSelectionSt);
			precedentSt = "false";
		} else {
			precedentSt = "true";
		}
		suivantSt = "true";
	}

	public void precedentHistoriqueSt() {
		Date max = statuts.get(statuts.size() - 1).getDateffet();

		statuts = (ArrayList<Statut>) gestionStatutLocal
				.trouverPrecedentsHStatutParIdentiteEtDateMax(identite, max,
						nombreSelectionSt);

		suivantSt = "false";
		resteSuivantSt += nombreSelectionSt;
		restePrecedSt -= nombreSelectionSt;
		if (restePrecedSt < 1)
			precedentSt = "true";
		if (resteSuivantSt < 1)
			suivantSt = "true";

	}

	public void suivantHistoriqueSt() {
		Date min = statuts.get(0).getDateffet();

		statuts = (ArrayList<Statut>) gestionStatutLocal
				.trouverSuivantsHStatutParIdentiteEtDateMin(identite, min,
						nombreSelectionSt);

		restePrecedSt += nombreSelectionSt;
		precedentSt = "false";
		resteSuivantSt -= nombreSelectionSt;
		if (resteSuivantSt < 1)
			suivantSt = "true";
		if (restePrecedSt < 1)
			precedentSt = "true";
	}

	public void ajouterSt() {

		if (identite != null && identite.getMatricul() != null
				&& nouvelSt != null && nouvelSt.getDateffet() != null
				&& nouvelSt.getType() != null) {
			if (statuts.get(0) == null || statuts.get(0).getId() == null) {
				nouvelSt.setSituation("actif");
				gestionIdentiteLocal.ajouterStatut(identite, nouvelSt);
				nouvelSt = new Statut();
				nombreSt++;
				afficherHistoriqueSt();
			} else {
				if (nouvelSt.getDateffet().after(statuts.get(0).getDateffet())
						&& statuts.get(0).getDatefin() == null) {
					statuts.get(0).setDatefin(
							MyCalendar.subDays(nouvelSt.getDateffet(), 1));
					gestionStatutLocal.modifierStatut(statuts.get(0));
					nouvelSt.setSituation("actif");
					gestionIdentiteLocal.ajouterStatut(identite, nouvelSt);
					nouvelSt = new Statut();
					nombreSt++;
					afficherHistoriqueSt();
				} else if (statuts.get(0).getDatefin() != null
						&& statuts.get(0).getDatefin()
								.before(nouvelSt.getDateffet())) {
					nouvelSt.setSituation("actif");
					gestionIdentiteLocal.ajouterStatut(identite, nouvelSt);
					nouvelSt = new Statut();
					nombreSt++;
					afficherHistoriqueSt();
				}
			}
		}
	}

	public void modifierSt() {
		if (statut != null && statuts.get(0) != null && (statuts != null)) {

			if (statut.getDateffet().after(
					statuts.get(statuts.indexOf(statut) + 1).getDateffet())) {
				if (statuts.indexOf(statut) == 0) {
					statuts.get(statuts.indexOf(statut) + 1).setDatefin(
							MyCalendar.subDays(statut.getDateffet(), 1));
					gestionStatutLocal.modifierStatut(statuts.get(statuts
							.indexOf(statut) + 1));
				} else {
					statuts.get(statuts.indexOf(statut) + 1).setDatefin(
							MyCalendar.subDays(statut.getDateffet(), 1));
					statuts.get(statuts.indexOf(statut) - 1).setDateffet(
							MyCalendar.addDays(statut.getDatefin(), 1));
					gestionStatutLocal.modifierStatut(statuts.get(statuts
							.indexOf(statut) - 1));
					gestionStatutLocal.modifierStatut(statuts.get(statuts
							.indexOf(statut) + 1));
				}
			}
			gestionStatutLocal.modifierStatut(statut);

			statut = gestionStatutLocal.trouverStatutParIdentite(identite);
		}
	}

	public void premierHistoriqueSt() {

		statuts = (ArrayList<Statut>) gestionStatutLocal
				.trouverPremiersHStatutParIdentite(identite, nombreSelectionSt);
		restePrecedSt = 0;
		resteSuivantSt = 0;
		if (nombreSt > nombreSelectionSt) {
			resteSuivantSt = (int) (nombreSt - nombreSelectionSt);
			suivantSt = "false";
		} else {
			suivantSt = "true";
		}
		precedentSt = "true";
	}

	public void dernierHistoriqueSt() {
		afficherHistoriqueSt();
	}

	public void supprimerSt() {
		if (statut != null && statuts.get(0) != null && (statuts != null)) {

			if (statut.getDateffet().after(
					statuts.get(statuts.indexOf(statut) + 1).getDateffet())) {
				if (statuts.indexOf(statut) == 0)
					statuts.get(statuts.indexOf(statut) + 1).setDatefin(null);
				else
					statuts.get(statuts.indexOf(statut) + 1).setDatefin(
							statut.getDatefin());
				gestionStatutLocal.modifierStatut(statuts.get(statuts
						.indexOf(statut) + 1));
			}
			gestionStatutLocal.supprimerStatut(statut);
			nombreSt--;
			afficherHistoriqueSt();
		}
	}

	/*
	 * ****************************************************** coordonnées
	 * bancaires *********************************************
	 */
	public void precedentHistoriqueCB() {
		CoordonneeBancaire cb = gestionCoordonneeBancaireLocal
				.trouverPrecedentCoordonneeBancaireParIdentite(identite,
						bancaire.getDateffet());
		if (cb != null && cb.getId() != null) {
			bancaire = cb;
		}

	}

	public void suivantHistoriqueCB() {
		CoordonneeBancaire cb = gestionCoordonneeBancaireLocal
				.trouverSuivantCoordonneeBancaireParIdentite(identite,
						bancaire.getDateffet());
		if (cb != null && cb.getId() != null) {
			bancaire = cb;
		}
	}

	public void ajouterCB() {
		if (nouvelleCB != null && nouvelleCB.getNumcompt() != null) {
			gestionIdentiteLocal
					.ajouterCoordonneeBancaire(identite, nouvelleCB);
			nouvelleCB = new CoordonneeBancaire();

			bancaire = gestionCoordonneeBancaireLocal
					.trouverDerniereCoordonneeBancaireParIdentite(identite);
		}
	}

	public void modifierCB() {
		if (bancaire != null && bancaire.getId() != null) {
			gestionCoordonneeBancaireLocal.modifierCoordonneeBancaire(bancaire);

			bancaire = gestionCoordonneeBancaireLocal
					.trouverDerniereCoordonneeBancaireParIdentite(identite);
		}
	}

	public void premierHistoriqueCB() {
		bancaire = gestionCoordonneeBancaireLocal
				.trouverPremiereCoordonneeBancaireParIdentite(identite);
	}

	public void dernierHistoriqueCB() {
		bancaire = gestionCoordonneeBancaireLocal
				.trouverDerniereCoordonneeBancaireParIdentite(identite);
	}

	public void supprimerCB() {
		if (bancaire != null && bancaire.getId() != null) {
			gestionCoordonneeBancaireLocal
					.supprimerCoordonneeBancaire(bancaire);

			bancaire = gestionCoordonneeBancaireLocal
					.trouverDerniereCoordonneeBancaireParIdentite(identite);
		}
	}

	/*
	 * ****************************************************** données d'embauche
	 * *********************************************
	 */
	public void precedentHistoriqueEMB() {
		Embauche eb = gestionEmbaucheLocal.trouverPrecedentEmbaucheParIdentite(
				identite, embauche.getDatedeb());
		if (eb != null && eb.getId() != null) {
			embauche = eb;
			afficherConsequenceEmbauche();
		}

	}

	public void suivantHistoriqueEMB() {
		Embauche eb = gestionEmbaucheLocal.trouverSuivantEmbaucheParIdentite(
				identite, embauche.getDatedeb());
		if (eb != null && eb.getId() != null) {
			embauche = eb;
			afficherConsequenceEmbauche();
		}
	}

	public void premierHistoriqueEMB() {

		embauche = gestionEmbaucheLocal
				.trouverPremierEmbaucheParIdentite(identite);
		afficherConsequenceEmbauche();
	}

	public void dernierHistoriqueEMB() {
		embauche = gestionEmbaucheLocal
				.trouverDernierEmbaucheParIdentite(identite);
		afficherConsequenceEmbauche();
	}

	public void definirFinEssai() {
		valPeriode = periodeEssai;
		if (nouvelEMB.getDatedeb() != null
				&& nouvelEMB.getPeriodeEssai() != null
				&& !periodeEssai.equals("Selectionnez")) {
			try {
				int i = Integer.parseInt(nouvelEMB.getPeriodeEssai());
				if (periodeEssai.startsWith("m"))
					nouvelEMB.setFinessai(MyCalendar.addMonths(
							nouvelEMB.getDatedeb(), i));
				else if (periodeEssai.startsWith("j")
						|| periodeEssai.startsWith("d"))
					nouvelEMB.setFinessai(MyCalendar.addDays(
							nouvelEMB.getDatedeb(), i));
				periodeEssai = "Selectionnez";

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			nouvelEMB.setFinessai(null);
			periodeEssai = "Selectionnez";
		}
	}
	

	public void ajouterEMB() {
		if (embauche != null && embauche.getId() != null) {
			if (nouvelEMB != null && nouvelEMB.getDatedeb() != null
					&& nouvelEMB.getDatedeb().after(embauche.getDatedeb())) {
				if (embauche.getDatefin() == null) {
					embauche.setDatefin(MyCalendar.subDays(
							nouvelEMB.getDatedeb(), 1));
					gestionEmbaucheLocal.modifierEmbauche(embauche);

					if (nouvelEMB.getPeriodeEssai() != null
							&& valPeriode != null && !valPeriode.equals("")) {
						if (!valPeriode.equals("mois")) {
							try {
								int periode = Integer.parseInt(nouvelEMB
										.getPeriodeEssai());
								if (periode == 1)
									nouvelEMB.setPeriodeEssai(periode + " "
											+ valPeriode);
								else if (periode > 1)
									nouvelEMB.setPeriodeEssai(periode + " "
											+ valPeriode + "s");
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else {
							try {
								int periode = Integer.parseInt(nouvelEMB
										.getPeriodeEssai());
								nouvelEMB.setPeriodeEssai(periode + " "
										+ valPeriode);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}

					}
					nouvelEMB.setValide("valide");
					gestionIdentiteLocal.ajouterEmbauche(identite, nouvelEMB);
					nouvelEMB = new Embauche();

					embauche = gestionEmbaucheLocal
							.trouverDernierEmbaucheParIdentite(identite);
					afficherConsequenceEmbauche();
				} else if (embauche.getDatefin() != null) {
					if (nouvelEMB.getDatedeb().after(embauche.getDatefin())) {
						if (nouvelEMB.getPeriodeEssai() != null
								&& valPeriode != null && !valPeriode.equals("")) {
							if (!valPeriode.equals("mois")) {
								try {
									int periode = Integer.parseInt(nouvelEMB
											.getPeriodeEssai());
									if (periode == 1)
										nouvelEMB.setPeriodeEssai(periode + " "
												+ valPeriode);
									else if (periode > 1)
										nouvelEMB.setPeriodeEssai(periode + " "
												+ valPeriode + "s");
								} catch (Exception e) {
									// TODO: handle exception
								}
							} else {
								try {
									int periode = Integer.parseInt(nouvelEMB
											.getPeriodeEssai());
									nouvelEMB.setPeriodeEssai(periode + " "
											+ valPeriode);
								} catch (Exception e) {
									// TODO: handle exception
								}
							}

						}
						nouvelEMB.setValide("valide");
						gestionIdentiteLocal.ajouterEmbauche(identite,
								nouvelEMB);
						nouvelEMB = new Embauche();

						embauche = gestionEmbaucheLocal
								.trouverDernierEmbaucheParIdentite(identite);
						afficherConsequenceEmbauche();
					}
				}
			}
		} else if ((embauche == null || embauche.getId() == null)
				&& identite.getNumedoss() != null) {
			if (nouvelEMB != null && nouvelEMB.getDatedeb() != null) {
				if (nouvelEMB.getPeriodeEssai() != null && valPeriode != null
						&& !valPeriode.equals("")) {
					if (!valPeriode.equals("mois")) {
						try {
							int periode = Integer.parseInt(nouvelEMB
									.getPeriodeEssai());
							if (periode == 1)
								nouvelEMB.setPeriodeEssai(periode + " "
										+ valPeriode);
							else if (periode > 1)
								nouvelEMB.setPeriodeEssai(periode + " "
										+ valPeriode + "s");
						} catch (Exception e) {
							// TODO: handle exception
						}
					} else {
						try {
							int periode = Integer.parseInt(nouvelEMB
									.getPeriodeEssai());
							nouvelEMB.setPeriodeEssai(periode + " "
									+ valPeriode);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

				}
				nouvelEMB.setValide("valide");
				gestionIdentiteLocal.ajouterEmbauche(identite, nouvelEMB);
				nouvelEMB = new Embauche();

				embauche = gestionEmbaucheLocal
						.trouverDernierEmbaucheParIdentite(identite);
				afficherConsequenceEmbauche();
			}
		}

	}

	public void modifierEMB() {
		if (embauche != null && embauche.getId() != null) {
			gestionEmbaucheLocal.modifierEmbauche(embauche);

			embauche = gestionEmbaucheLocal
					.trouverDernierEmbaucheParIdentite(identite);
			afficherConsequenceEmbauche();
		}
	}
	

	public void supprimerEMB() {
		if (embauche != null && embauche.getId() != null) {
			gestionEmbaucheLocal.supprimerEmbauche(embauche);

			embauche = gestionEmbaucheLocal
					.trouverDernierEmbaucheParIdentite(identite);
			afficherConsequenceEmbauche();
		}
	}

	public void afficherConsequenceEmbauche() {
		if (embauche != null) {
			try {
				afficherHistoriqueContrats();

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				affectations = (ArrayList<Affectation>) gestionAffectationLocal
						.trouverHistoriqueAffectationsParEmbauche(embauche,
								nombreSelectAff);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				salaire = gestionSalaireLocal
						.trouverDernierSalaireParEmbauche(embauche);

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			salaire = new Salaire();
			// salaire.setMontant(0.0);
			contrats = new ArrayList<>();
			affectations = new ArrayList<>();
		}
	}

	/*
	 * ****************************************************** salaire
	 * *********************************************
	 */

	public void precedentHistoriqueSal() {
		Salaire sl = gestionSalaireLocal.trouverPrecedentSalaireParEmbauche(
				embauche, salaire.getDateeffe());
		if (sl != null && sl.getId() != null) {
			salaire = sl;
		}

	}

	public void suivantHistoriqueSal() {
		Salaire sl = gestionSalaireLocal.trouverSuivantSalaireParEmbauche(
				embauche, salaire.getDateeffe());
		if (sl != null && sl.getId() != null) {
			salaire = sl;
		}
	}

	public void premierHistoriqueSal() {

		salaire = gestionSalaireLocal
				.trouverPremierSalaireParEmbauche(embauche);
	}

	public void dernierHistoriqueSal() {
		salaire = gestionSalaireLocal
				.trouverDernierSalaireParEmbauche(embauche);
	}

	public void ajouterSal() {
		if (embauche != null && embauche.getId() != null && nouveauSal != null
				&& nouveauSal.getDateeffe() != null) {
			if (salaire == null || salaire.getId() == null) {
				gestionEmbaucheLocal.ajouterSalaire(embauche, nouveauSal);
				nouveauSal = new Salaire();
				salaire = gestionSalaireLocal
						.trouverSalaireParEmbauche(embauche);
			} else {
				if (nouveauSal.getDateeffe().after(salaire.getDateeffe())
						&& salaire.getDatefin() == null) {
					salaire.setDatefin(MyCalendar.subDays(
							nouveauSal.getDateeffe(), 1));
					gestionSalaireLocal.modifierSalaire(salaire);
					gestionEmbaucheLocal.ajouterSalaire(embauche, nouveauSal);
					nouveauSal = new Salaire();
					salaire = gestionSalaireLocal
							.trouverSalaireParEmbauche(embauche);
				} else if (salaire.getDatefin() != null
						&& salaire.getDatefin()
								.before(nouveauSal.getDateeffe())) {
					gestionEmbaucheLocal.ajouterSalaire(embauche, nouveauSal);
					nouveauSal = new Salaire();
					salaire = gestionSalaireLocal
							.trouverSalaireParEmbauche(embauche);
				}
			}
		}
	}

	public void modifierSal() {
		if (salaire != null && salaire.getDateeffe() != null) {
			gestionSalaireLocal.modifierSalaire(salaire);

			salaire = gestionSalaireLocal.trouverSalaireParEmbauche(embauche);
		}
	}

	public void supprimerSal() {
		if (salaire != null && salaire.getId() != null) {
			gestionSalaireLocal.supprimerSalaire(salaire);

			salaire = gestionSalaireLocal.trouverSalaireParEmbauche(embauche);

		}
	}

	/*
	 * ****************************************************** Téléphones
	 * *********************************************
	 */
	public void ajouterTel() {
		if (identite != null && nouveauTel != null
				&& nouveauTel.getNumero() != null) {
			gestionIdentiteLocal.ajouterTelephone(identite, nouveauTel);
			nouveauTel = new Telephone();

			telephones = (ArrayList<Telephone>) gestionTelephoneLocal
					.trouverTelephonesParIdentite(identite);
		}
	}

	public void modifierTel() {
		if (telephone != null && telephone.getNumero() != null) {
			gestionTelephoneLocal.modifierTelephone(telephone);

			telephones = (ArrayList<Telephone>) gestionTelephoneLocal
					.trouverTelephonesParIdentite(identite);
		}
	}

	public void supprimerTel() {
		if (telephone != null && telephone.getId() != null) {
			gestionTelephoneLocal.supprimerTelephone(telephone);

			telephones = (ArrayList<Telephone>) gestionTelephoneLocal
					.trouverTelephonesParIdentite(identite);

		}
	}

	/*
	 * ****************************************************** Pieces d'identité
	 * *********************************************
	 */
	public void ajouterPieceIdentite() {
		if (identite != null && nouveauPieceIdentite != null
				&& nouveauPieceIdentite.getValeur() != null) {
			gestionIdentiteLocal.ajouterPieceIdentite(identite,
					nouveauPieceIdentite);
			nouveauPieceIdentite = new PieceIdentite();

			piecesIdentite = (ArrayList<PieceIdentite>) gestionPieceIdentiteLocal
					.trouverPiecesIdentiteParIdentite(identite);
		}
	}

	public void modifierPieceIdentite() {
		if (selectedPieceIdentite != null
				&& selectedPieceIdentite.getValeur() != null) {
			gestionPieceIdentiteLocal
					.modifierPieceIdentite(selectedPieceIdentite);

			piecesIdentite = (ArrayList<PieceIdentite>) gestionPieceIdentiteLocal
					.trouverPiecesIdentiteParIdentite(identite);
		}
	}

	public void supprimerPieceIdentite() {
		if (selectedPieceIdentite != null
				&& selectedPieceIdentite.getId() != null) {
			gestionPieceIdentiteLocal
					.supprimerPieceIdentite(selectedPieceIdentite);

			piecesIdentite = (ArrayList<PieceIdentite>) gestionPieceIdentiteLocal
					.trouverPiecesIdentiteParIdentite(identite);

		}
	}

	/*
	 * ****************************************************** Mails
	 * *********************************************
	 */

	public void ajouterMail() {
		if (identite != null && nouveauMail != null
				&& nouveauMail.getEmail() != null) {
			gestionIdentiteLocal.ajouterMail(identite, nouveauMail);
			nouveauMail = new Mail();

			mails = (ArrayList<Mail>) gestionMailLocal
					.trouverMailsParIdentite(identite);
		}
	}

	public void modifierMail() {
		if (telephone != null && telephone.getNumero() != null) {
			gestionMailLocal.modifierMail(mail);

			mails = (ArrayList<Mail>) gestionMailLocal
					.trouverMailsParIdentite(identite);
		}
	}

	public void supprimerMail() {
		if (telephone != null && telephone.getId() != null) {
			gestionMailLocal.supprimerMail(mail);

			mails = (ArrayList<Mail>) gestionMailLocal
					.trouverMailsParIdentite(identite);

		}
	}

	/*
	 * ********************************************************** Getters
	 * Setters******************************
	 */

	public Long getNumdossier() {
		return numdossier;
	}

	public void setNumdossier(Long numdossier) {
		this.numdossier = numdossier;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public InfosIndividuelles getIndividuelles() {
		return individuelles;
	}

	public void setIndividuelles(InfosIndividuelles individuelles) {
		this.individuelles = individuelles;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(ArrayList<Adresse> adresses) {
		this.adresses = adresses;
	}

	public SituationCivile getSituationCivile() {
		return situationCivile;
	}

	public void setSituationCivile(SituationCivile situationCivile) {
		this.situationCivile = situationCivile;
	}

	public ArrayList<SituationCivile> getSituationCiviles() {
		return situationCiviles;
	}

	public void setSituationCiviles(ArrayList<SituationCivile> situationCiviles) {
		this.situationCiviles = situationCiviles;
	}

	public Long getNombreSc() {
		return nombreSc;
	}

	public void setNombreSc(Long nombreSc) {
		this.nombreSc = nombreSc;
	}

	public int getRestePrecedSc() {
		return restePrecedSc;
	}

	public void setRestePrecedSc(int restePrecedSc) {
		this.restePrecedSc = restePrecedSc;
	}

	public int getResteSuivantSc() {
		return resteSuivantSc;
	}

	public void setResteSuivantSc(int resteSuivantSc) {
		this.resteSuivantSc = resteSuivantSc;
	}

	public int getNombreSelectionSc() {
		return nombreSelectionSc;
	}

	public void setNombreSelectionSc(int nombreSelectionSc) {
		this.nombreSelectionSc = nombreSelectionSc;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public ArrayList<Statut> getStatuts() {
		return statuts;
	}

	public void setStatuts(ArrayList<Statut> statuts) {
		this.statuts = statuts;
	}

	public Long getNombreSt() {
		return nombreSt;
	}

	public void setNombreSt(Long nombreSt) {
		this.nombreSt = nombreSt;
	}

	public int getRestePrecedSt() {
		return restePrecedSt;
	}

	public void setRestePrecedSt(int restePrecedSt) {
		this.restePrecedSt = restePrecedSt;
	}

	public int getResteSuivantSt() {
		return resteSuivantSt;
	}

	public void setResteSuivantSt(int resteSuivantSt) {
		this.resteSuivantSt = resteSuivantSt;
	}

	public int getNombreSelectionSt() {
		return nombreSelectionSt;
	}

	public void setNombreSelectionSt(int nombreSelectionSt) {
		this.nombreSelectionSt = nombreSelectionSt;
	}

	public Embauche getEmbauche() {
		return embauche;
	}

	public void setEmbauche(Embauche embauche) {
		this.embauche = embauche;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public ArrayList<AttachementEmploye> getAttachementEmployes() {
		return attachementEmployes;
	}

	public void setAttachementEmployes(
			ArrayList<AttachementEmploye> attachementEmployes) {
		this.attachementEmployes = attachementEmployes;
	}

	public ArrayList<AttachementManager> getAttachementManagers() {
		return attachementManagers;
	}

	public void setAttachementManagers(
			ArrayList<AttachementManager> attachementManagers) {
		this.attachementManagers = attachementManagers;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public ArrayList<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(ArrayList<Affectation> affectations) {
		this.affectations = affectations;
	}

	public ArrayList<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(ArrayList<Telephone> telephones) {
		this.telephones = telephones;
	}

	public ArrayList<Mail> getMails() {
		return mails;
	}

	public void setMails(ArrayList<Mail> mails) {
		this.mails = mails;
	}

	public StreamedContent getPhoto() {

		byte[] imageInByte2 = null;
		photo = null;
		if (identite != null && identite.getPhoto() != null) {

			imageInByte2 = identite.getPhoto();
			InputStream is = new ByteArrayInputStream(imageInByte2);

			photo = new DefaultStreamedContent(is, "image/png");
		}
		return photo;

	}

	public void setPhoto(StreamedContent photo) {
		this.photo = photo;
	}

	public String getRenderedimage() {
		return renderedimage;
	}

	public void setRenderedimage(String renderedimage) {
		this.renderedimage = renderedimage;
	}

	public InfosPhysiques getPhysiques() {
		return physiques;
	}

	public void setPhysiques(InfosPhysiques physiques) {
		this.physiques = physiques;
	}

	public ArrayList<Adresse> getAdresseshistorique() {
		return adresseshistorique;
	}

	public void setAdresseshistorique(ArrayList<Adresse> adresseshistorique) {
		this.adresseshistorique = adresseshistorique;
	}

	public Naissance getNaissance() {
		return naissance;
	}

	public void setNaissance(Naissance naissance) {
		this.naissance = naissance;
	}

	public ArrayList<Nationalite> getNationalites() {
		return nationalites;
	}

	public void setNationalites(ArrayList<Nationalite> nationalites) {
		this.nationalites = nationalites;
	}

	public StreamedContent getContratsigne() {
		contratsigne = null;
		if (selectedContrat != null
				&& selectedContrat.getContratSigne() != null) {
			byte[] fileInByte = selectedContrat.getContratSigne();
			InputStream is = new ByteArrayInputStream(fileInByte);
			System.out.println("1er bit " + fileInByte[0]);
			contratsigne = new DefaultStreamedContent(is, "application/pdf",
					"downloaded_contrat.pdf");
		}
		return contratsigne;
	}
	public void onButtonRemoveIntervalleAgeClick(final Age intervalleAge) {
		listIntervallesAge.remove(listIntervallesAge.indexOf(intervalleAge));
		
	}
	public void onButtonRemoveIntervalleDateEmbaucheClick(final  DateEmbauche intervalleDateEmbauche) {
		listIntervallesDateEmbauche.remove(listIntervallesDateEmbauche.indexOf(intervalleDateEmbauche));
		
	}

	public void onButtonAddIntervalleDateEmbaucheClick(AjaxBehaviorEvent p_oEvent) {
		listIntervallesDateEmbauche.add(new DateEmbauche());
        
		
	}

	public void setContratsigne(StreamedContent contratsigne) {
		this.contratsigne = contratsigne;
	}

	public ArrayList<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(ArrayList<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat getSelectedContrat() {
		return selectedContrat;
	}

	public void setSelectedContrat(Contrat selectedContrat) {
		this.selectedContrat = selectedContrat;
	}

	public Date getDatecomp() {
		return datecomp;
	}

	public void setDatecomp(Date datecomp) {
		this.datecomp = datecomp;
	}

	public void view() {
		System.out.println("view: " + adresse.getType());
	}

	public Long getNombreAdresses() {
		return nombreAdresses;
	}

	public void setNombreAdresses(Long nombreAdresses) {
		this.nombreAdresses = nombreAdresses;
	}

	public String getPrecedentAdresse() {
		return precedentAdresse;
	}

	public void setPrecedentAdresse(String precedentAdresse) {
		this.precedentAdresse = precedentAdresse;
	}

	public String getSuivantAdresse() {
		return suivantAdresse;
	}

	public void setSuivantAdresse(String suivantAdresse) {
		this.suivantAdresse = suivantAdresse;
	}

	public int getRestePrecedAdr() {
		return restePrecedAdr;
	}

	public void setRestePrecedAdr(int restePrecedAdr) {
		this.restePrecedAdr = restePrecedAdr;
	}

	public int getResteSuivantAdr() {
		return resteSuivantAdr;
	}

	public void setResteSuivantAdr(int resteSuivantAdr) {
		this.resteSuivantAdr = resteSuivantAdr;
	}

	public int getNombreSelectionAdr() {
		return nombreSelectionAdr;
	}

	public void setNombreSelectionAdr(int nombreSelectionAdr) {
		this.nombreSelectionAdr = nombreSelectionAdr;
	}

	public Adresse getNouvelleAdresse() {
		return nouvelleAdresse;
	}

	public void setNouvelleAdresse(Adresse nouvelleAdresse) {
		this.nouvelleAdresse = nouvelleAdresse;
	}

	public CoordonneeBancaire getBancaire() {
		return bancaire;
	}

	public void setBancaire(CoordonneeBancaire bancaire) {
		this.bancaire = bancaire;
	}

	public Affectation getAffectation() {
		return affectation;
	}

	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}

	public ArrayList<CoordonneeBancaire> getBancaires() {
		return bancaires;
	}

	public void setBancaires(ArrayList<CoordonneeBancaire> bancaires) {
		this.bancaires = bancaires;
	}

	public Nationalite getSelectedNationalite() {
		return selectedNationalite;
	}

	public void setSelectedNationalite(Nationalite selectedNationalite) {
		this.selectedNationalite = selectedNationalite;
	}

	public Nationalite getNouvelleNationalite() {
		return nouvelleNationalite;
	}

	public void setNouvelleNationalite(Nationalite nouvelleNationalite) {
		this.nouvelleNationalite = nouvelleNationalite;
	}

	public Long getNombreNatios() {
		return nombreNatios;
	}

	public void setNombreNatios(Long nombreNatios) {
		this.nombreNatios = nombreNatios;
	}

	public String getPrecedentNatio() {
		return precedentNatio;
	}

	public void setPrecedentNatio(String precedentNatio) {
		this.precedentNatio = precedentNatio;
	}

	public String getSuivantNatio() {
		return suivantNatio;
	}

	public void setSuivantNatio(String suivantNatio) {
		this.suivantNatio = suivantNatio;
	}

	public int getRestePrecedNatio() {
		return restePrecedNatio;
	}

	public void setRestePrecedNatio(int restePrecedNatio) {
		this.restePrecedNatio = restePrecedNatio;
	}

	public int getResteSuivantNatio() {
		return resteSuivantNatio;
	}

	public void setResteSuivantNatio(int resteSuivantNatio) {
		this.resteSuivantNatio = resteSuivantNatio;
	}

	public int getNombreSelectionNatio() {
		return nombreSelectionNatio;
	}

	public void setNombreSelectionNatio(int nombreSelectionNatio) {
		this.nombreSelectionNatio = nombreSelectionNatio;
	}

	public ArrayList<SituationMedicale> getMedicales() {
		return medicales;
	}

	public void setMedicales(ArrayList<SituationMedicale> medicales) {
		this.medicales = medicales;
	}

	public ArrayList<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(ArrayList<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Affectation getNouvelleAffectation() {
		return nouvelleAffectation;
	}

	public void setNouvelleAffectation(Affectation nouvelleAffectation) {
		this.nouvelleAffectation = nouvelleAffectation;
	}

	public AttachementEmploye getAttachementEmploye() {
		return attachementEmploye;
	}

	public void setAttachementEmploye(AttachementEmploye attachementEmploye) {
		this.attachementEmploye = attachementEmploye;
	}

	public AttachementEmploye getNouvelAttachementEmploye() {
		return nouvelAttachementEmploye;
	}

	public void setNouvelAttachementEmploye(
			AttachementEmploye nouvelAttachementEmploye) {
		this.nouvelAttachementEmploye = nouvelAttachementEmploye;
	}

	public AttachementManager getAttachementManager() {
		return attachementManager;
	}

	public void setAttachementManager(AttachementManager attachementManager) {
		this.attachementManager = attachementManager;
	}

	public AttachementManager getNouvelAttachementManager() {
		return nouvelAttachementManager;
	}

	public void setNouvelAttachementManager(
			AttachementManager nouvelAttachementManager) {
		this.nouvelAttachementManager = nouvelAttachementManager;
	}

	public Long getNumMgr() {
		return numMgr;
	}

	public void setNumMgr(Long numMgr) {
		this.numMgr = numMgr;
	}

	public Long getNumEmp() {
		return numEmp;
	}

	public void setNumEmp(Long numEmp) {
		this.numEmp = numEmp;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	public Telephone getNouveauTel() {
		return nouveauTel;
	}

	public void setNouveauTel(Telephone nouveauTel) {
		this.nouveauTel = nouveauTel;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public Mail getNouveauMail() {
		return nouveauMail;
	}

	public void setNouveauMail(Mail nouveauMail) {
		this.nouveauMail = nouveauMail;
	}

	public SituationMedicale getMedicale() {
		return medicale;
	}

	public void setMedicale(SituationMedicale medicale) {
		this.medicale = medicale;
	}

	public SituationMedicale getNouvelleMedicale() {
		return nouvelleMedicale;
	}

	public void setNouvelleMedicale(SituationMedicale nouvelleMedicale) {
		this.nouvelleMedicale = nouvelleMedicale;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Vehicule getNouveauVehicule() {
		return nouveauVehicule;
	}

	public void setNouveauVehicule(Vehicule nouveauVehicule) {
		this.nouveauVehicule = nouveauVehicule;
	}

	public Contrat getNouveauContrat() {
		return nouveauContrat;
	}

	public void setNouveauContrat(Contrat nouveauContrat) {
		this.nouveauContrat = nouveauContrat;
	}

	public byte[] getUploadedCont() {
		return uploadedCont;
	}

	public void setUploadedCont(byte[] uploadedCont) {
		this.uploadedCont = uploadedCont;
	}

	public String getSuivantSc() {
		return suivantSc;
	}

	public void setSuivantSc(String suivantSc) {
		this.suivantSc = suivantSc;
	}

	public String getPrecedentSc() {
		return precedentSc;
	}

	public void setPrecedentSc(String precedentSc) {
		this.precedentSc = precedentSc;
	}

	public Identite getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(Identite idEmp) {
		this.idEmp = idEmp;
	}

	public SituationCivile getNouvelleSc() {
		return nouvelleSc;
	}

	public void setNouvelleSc(SituationCivile nouvelleSc) {
		this.nouvelleSc = nouvelleSc;
	}

	public CoordonneeBancaire getNouvelleCB() {
		return nouvelleCB;
	}

	public void setNouvelleCB(CoordonneeBancaire nouvelleCB) {
		this.nouvelleCB = nouvelleCB;
	}

	public String getPrecedentCB() {
		return precedentCB;
	}

	public void setPrecedentCB(String precedentCB) {
		this.precedentCB = precedentCB;
	}

	public String getSuivantCB() {
		return suivantCB;
	}

	public void setSuivantCB(String suivantCB) {
		this.suivantCB = suivantCB;
	}

	public Embauche getNouvelEMB() {
		return nouvelEMB;
	}

	public void setNouvelEMB(Embauche nouvelEMB) {
		this.nouvelEMB = nouvelEMB;
	}

	public String getSuivantEMB() {
		return suivantEMB;
	}

	public void setSuivantEMB(String suivantEMB) {
		this.suivantEMB = suivantEMB;
	}

	public String getPrecedentEMB() {
		return precedentEMB;
	}

	public void setPrecedentEMB(String precedentEMB) {
		this.precedentEMB = precedentEMB;
	}

	public Salaire getNouveauSal() {
		return nouveauSal;
	}

	public void setNouveauSal(Salaire nouveauSal) {
		this.nouveauSal = nouveauSal;
	}

	public String getPrecedentSal() {
		return precedentSal;
	}

	public void setPrecedentSal(String precedentSal) {
		this.precedentSal = precedentSal;
	}

	public String getSuivantSal() {
		return suivantSal;
	}

	public void setSuivantSal(String suivantSal) {
		this.suivantSal = suivantSal;
	}

	public Long getNombreVehicule() {
		return nombreVehicule;
	}

	public void setNombreVehicule(Long nombreVehicule) {
		this.nombreVehicule = nombreVehicule;
	}

	public String getPrecedentVehicule() {
		return precedentVehicule;
	}

	public void setPrecedentVehicule(String precedentVehicule) {
		this.precedentVehicule = precedentVehicule;
	}

	public String getSuivantVehicule() {
		return suivantVehicule;
	}

	public void setSuivantVehicule(String suivantVehicule) {
		this.suivantVehicule = suivantVehicule;
	}

	public int getRestePrecedVeh() {
		return restePrecedVeh;
	}

	public void setRestePrecedVeh(int restePrecedVeh) {
		this.restePrecedVeh = restePrecedVeh;
	}

	public int getResteSuivantVeh() {
		return resteSuivantVeh;
	}

	public void setResteSuivantVeh(int resteSuivantVeh) {
		this.resteSuivantVeh = resteSuivantVeh;
	}

	public int getNombreSelectionVeh() {
		return nombreSelectionVeh;
	}

	public void setNombreSelectionVeh(int nombreSelectionVeh) {
		this.nombreSelectionVeh = nombreSelectionVeh;
	}

	public Long getNombreMedicales() {
		return nombreMedicales;
	}

	public void setNombreMedicales(Long nombreMedicales) {
		this.nombreMedicales = nombreMedicales;
	}

	public int getRestePrecedMed() {
		return restePrecedMed;
	}

	public void setRestePrecedMed(int restePrecedMed) {
		this.restePrecedMed = restePrecedMed;
	}

	public int getResteSuivantMed() {
		return resteSuivantMed;
	}

	public void setResteSuivantMed(int resteSuivantMed) {
		this.resteSuivantMed = resteSuivantMed;
	}

	public int getNombreSelectionMed() {
		return nombreSelectionMed;
	}

	public void setNombreSelectionMed(int nombreSelectionMed) {
		this.nombreSelectionMed = nombreSelectionMed;
	}

	public String getPrecedentMedicale() {
		return precedentMedicale;
	}

	public void setPrecedentMedicale(String precedentMedicale) {
		this.precedentMedicale = precedentMedicale;
	}

	public String getSuivantMedicale() {
		return suivantMedicale;
	}

	public void setSuivantMedicale(String suivantMedicale) {
		this.suivantMedicale = suivantMedicale;
	}

	public Statut getNouvelSt() {
		return nouvelSt;
	}

	public void setNouvelSt(Statut nouvelSt) {
		this.nouvelSt = nouvelSt;
	}

	public String getPrecedentSt() {
		return precedentSt;
	}

	public void setPrecedentSt(String precedentSt) {
		this.precedentSt = precedentSt;
	}

	public String getSuivantSt() {
		return suivantSt;
	}

	public void setSuivantSt(String suivantSt) {
		this.suivantSt = suivantSt;
	}

	public int getNombreSelectCont() {
		return nombreSelectCont;
	}

	public void setNombreSelectCont(int nombreSelectCont) {
		this.nombreSelectCont = nombreSelectCont;
	}

	public int getNombreSelectAff() {
		return nombreSelectAff;
	}

	public void setNombreSelectAff(int nombreSelectAff) {
		this.nombreSelectAff = nombreSelectAff;
	}

	public int getNombreSelectEmp() {
		return nombreSelectEmp;
	}

	public void setNombreSelectEmp(int nombreSelectEmp) {
		this.nombreSelectEmp = nombreSelectEmp;
	}

	public int getNombreSelectMgr() {
		return nombreSelectMgr;
	}

	public void setNombreSelectMgr(int nombreSelectMgr) {
		this.nombreSelectMgr = nombreSelectMgr;
	}

	public Long getNombreAttachementsMgr() {
		return nombreAttachementsMgr;
	}

	public void setNombreAttachementsMgr(Long nombreAttachementsMgr) {
		this.nombreAttachementsMgr = nombreAttachementsMgr;
	}

	public Long getNombreAffectations() {
		return nombreAffectations;
	}

	public String getPrecedentAff() {
		return precedentAff;
	}

	public void setPrecedentAff(String precedentAff) {
		this.precedentAff = precedentAff;
	}

	public String getSuivantAff() {
		return suivantAff;
	}

	public void setSuivantAff(String suivantAff) {
		this.suivantAff = suivantAff;
	}

	public int getRestePrecedAff() {
		return restePrecedAff;
	}

	public void setRestePrecedAff(int restePrecedAff) {
		this.restePrecedAff = restePrecedAff;
	}

	public int getResteSuivantAff() {
		return resteSuivantAff;
	}

	public void setResteSuivantAff(int resteSuivantAff) {
		this.resteSuivantAff = resteSuivantAff;
	}

	public String getPrecedentEmp() {
		return precedentEmp;
	}

	public void setPrecedentEmp(String precedentEmp) {
		this.precedentEmp = precedentEmp;
	}

	public String getSuivantEmp() {
		return suivantEmp;
	}

	public void setSuivantEmp(String suivantEmp) {
		this.suivantEmp = suivantEmp;
	}

	public int getRestePrecedEmp() {
		return restePrecedEmp;
	}

	public void setRestePrecedEmp(int restePrecedEmp) {
		this.restePrecedEmp = restePrecedEmp;
	}

	public int getResteSuivantEmp() {
		return resteSuivantEmp;
	}

	public void setResteSuivantEmp(int resteSuivantEmp) {
		this.resteSuivantEmp = resteSuivantEmp;
	}

	public String getPrecedentMgr() {
		return precedentMgr;
	}

	public void setPrecedentMgr(String precedentMgr) {
		this.precedentMgr = precedentMgr;
	}

	public String getSuivantMgr() {
		return suivantMgr;
	}

	public void setSuivantMgr(String suivantMgr) {
		this.suivantMgr = suivantMgr;
	}

	public int getRestePrecedMgr() {
		return restePrecedMgr;
	}

	public void setRestePrecedMgr(int restePrecedMgr) {
		this.restePrecedMgr = restePrecedMgr;
	}

	public int getResteSuivantMgr() {
		return resteSuivantMgr;
	}

	public void setResteSuivantMgr(int resteSuivantMgr) {
		this.resteSuivantMgr = resteSuivantMgr;
	}

	public Long getNombreAttachementsEmp() {
		return nombreAttachementsEmp;
	}

	public void setNombreAttachementsEmp(Long nombreAttachementsEmp) {
		this.nombreAttachementsEmp = nombreAttachementsEmp;
	}

	public void setNombreAffectations(Long nombreAffectations) {
		this.nombreAffectations = nombreAffectations;
	}

	public ArrayList<ImputationGa> getImputationGas() {
		return imputationGas;
	}

	public void setImputationGas(ArrayList<ImputationGa> imputationGas) {
		this.imputationGas = imputationGas;
	}

	public ImputationGa getImputationGa() {
		return imputationGa;
	}

	public void setImputationGa(ImputationGa imputationGa) {
		this.imputationGa = imputationGa;
	}

	public ImputationGa getNouvelleImputationGa() {
		return nouvelleImputationGa;
	}

	public void setNouvelleImputationGa(ImputationGa nouvelleImputationGa) {
		this.nouvelleImputationGa = nouvelleImputationGa;
	}

	public int getNombreSelectImp() {
		return nombreSelectImp;
	}

	public void setNombreSelectImp(int nombreSelectImp) {
		this.nombreSelectImp = nombreSelectImp;
	}

	public Long getNombreImputations() {
		return nombreImputations;
	}

	public void setNombreImputations(Long nombreImputations) {
		this.nombreImputations = nombreImputations;
	}

	public String getPrecedentImp() {
		return precedentImp;
	}

	public void setPrecedentImp(String precedentImp) {
		this.precedentImp = precedentImp;
	}

	public String getSuivantImp() {
		return suivantImp;
	}

	public void setSuivantImp(String suivantImp) {
		this.suivantImp = suivantImp;
	}

	public int getRestePrecedImp() {
		return restePrecedImp;
	}

	public void setRestePrecedImp(int restePrecedImp) {
		this.restePrecedImp = restePrecedImp;
	}

	public int getResteSuivantImp() {
		return resteSuivantImp;
	}

	public void setResteSuivantImp(int resteSuivantImp) {
		this.resteSuivantImp = resteSuivantImp;
	}

	public String getPrecedentCont() {
		return precedentCont;
	}

	public void setPrecedentCont(String precedentCont) {
		this.precedentCont = precedentCont;
	}

	public String getSuivantCont() {
		return suivantCont;
	}

	public void setSuivantCont(String suivantCont) {
		this.suivantCont = suivantCont;
	}

	public int getRestePrecedCont() {
		return restePrecedCont;
	}

	public void setRestePrecedCont(int restePrecedCont) {
		this.restePrecedCont = restePrecedCont;
	}

	public int getResteSuivantCont() {
		return resteSuivantCont;
	}

	public void setResteSuivantCont(int resteSuivantCont) {
		this.resteSuivantCont = resteSuivantCont;
	}

	public Long getNombreContrats() {
		return nombreContrats;
	}

	public void setNombreContrats(Long nombreContrats) {
		this.nombreContrats = nombreContrats;
	}

	public ArrayList<Identite> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(ArrayList<Identite> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNumMatricule() {
		return numMatricule;
	}

	public void setNumMatricule(String numMatricule) {
		this.numMatricule = numMatricule;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNumPassp() {
		return numPassp;
	}

	public void setNumPassp(String numPassp) {
		this.numPassp = numPassp;
	}

	public String getEmploi() {
		return emploi;
	}

	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}

	public String getUniteOrg() {
		return uniteOrg;
	}

	public void setUniteOrg(String uniteOrg) {
		this.uniteOrg = uniteOrg;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getNiveauDiplome() {
		return niveauDiplome;
	}

	public void setNiveauDiplome(String niveauDiplome) {
		this.niveauDiplome = niveauDiplome;
	}

	public String getTypeCertificat() {
		return typeCertificat;
	}

	public void setTypeCertificat(String typeCertificat) {
		this.typeCertificat = typeCertificat;
	}

	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public String getNationalitePays() {
		return nationalitePays;
	}

	public void setNationalitePays(String nationalitePays) {
		this.nationalitePays = nationalitePays;
	}

	public String getExperiencePoste() {
		return experiencePoste;
	}

	public void setExperiencePoste(String experiencePoste) {
		this.experiencePoste = experiencePoste;
	}

	public String getExperienceSociete() {
		return experienceSociete;
	}

	public void setExperienceSociete(String experienceSociete) {
		this.experienceSociete = experienceSociete;
	}

	public String getValeurPieceIdentite() {
		return valeurPieceIdentite;
	}

	public void setValeurPieceIdentite(String valeurPieceIdentite) {
		this.valeurPieceIdentite = valeurPieceIdentite;
	}

	public String getTypPieceIdentite() {
		return typPieceIdentite;
	}

	public void setTypPieceIdentite(String typPieceIdentite) {
		this.typPieceIdentite = typPieceIdentite;
	}

	public Map<String, String> getItems_nationalitePays() {
		return items_nationalitePays;
	}

	public void setItems_nationalitePays(
			Map<String, String> items_nationalitePays) {
		this.items_nationalitePays = items_nationalitePays;
	}

	public Map<String, String> getItems_niveauDiplome() {
		return items_niveauDiplome;
	}

	public void setItems_niveauDiplome(Map<String, String> items_niveauDiplome) {
		this.items_niveauDiplome = items_niveauDiplome;
	}

	public Map<String, String> getItems_typeCertificat() {
		return items_typeCertificat;
	}

	public void setItems_typeCertificat(Map<String, String> items_typeCertificat) {
		this.items_typeCertificat = items_typeCertificat;
	}

	public Map<String, String> getItems_typeContrat() {
		return items_typeContrat;
	}

	public void setItems_typeContrat(Map<String, String> items_typeContrat) {
		this.items_typeContrat = items_typeContrat;
	}

	public Map<String, String> getItems_experiencePoste() {
		return items_experiencePoste;
	}

	public void setItems_experiencePoste(
			Map<String, String> items_experiencePoste) {
		this.items_experiencePoste = items_experiencePoste;
	}

	public Map<String, String> getItems_experienceSociete() {
		return items_experienceSociete;
	}

	public void setItems_experienceSociete(
			Map<String, String> items_experienceSociete) {
		this.items_experienceSociete = items_experienceSociete;
	}

	public Map<String, String> getItems_affectationPoste() {
		return items_affectationPoste;
	}

	public void setItems_affectationPoste(
			Map<String, String> items_affectationPoste) {
		this.items_affectationPoste = items_affectationPoste;
	}

	public Map<String, String> getItems_affectationUniteOrg() {
		return items_affectationUniteOrg;
	}

	public void setItems_affectationUniteOrg(
			Map<String, String> items_affectationUniteOrg) {
		this.items_affectationUniteOrg = items_affectationUniteOrg;
	}

	public Map<String, String> getItems_affectationEmploi() {
		return items_affectationEmploi;
	}

	public void setItems_affectationEmploi(
			Map<String, String> items_affectationEmploi) {
		this.items_affectationEmploi = items_affectationEmploi;
	}

	public Map<String, String> getItems_TypePieceIdentite() {
		return items_TypePieceIdentite;
	}

	public void setItems_TypePieceIdentite(
			Map<String, String> items_TypePieceIdentite) {
		this.items_TypePieceIdentite = items_TypePieceIdentite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public ArrayList<StreamedContent> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<StreamedContent> photos) {
		this.photos = photos;
	}

	public ArrayList<DiplomeGa> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(ArrayList<DiplomeGa> diplomes) {
		this.diplomes = diplomes;
	}

	public DiplomeGa getDiplome() {
		return diplome;
	}

	public void setDiplome(DiplomeGa diplome) {
		this.diplome = diplome;
	}

	public DiplomeGa getNouveauDiplome() {
		return nouveauDiplome;
	}

	public void setNouveauDiplome(DiplomeGa nouveauDiplome) {
		this.nouveauDiplome = nouveauDiplome;
	}

	public Long getNombreDiplome() {
		return nombreDiplome;
	}

	public void setNombreDiplome(Long nombreDiplome) {
		this.nombreDiplome = nombreDiplome;
	}

	public String getPrecedentDiplome() {
		return precedentDiplome;
	}

	public void setPrecedentDiplome(String precedentDiplome) {
		this.precedentDiplome = precedentDiplome;
	}

	public String getSuivantDiplome() {
		return suivantDiplome;
	}

	public void setSuivantDiplome(String suivantDiplome) {
		this.suivantDiplome = suivantDiplome;
	}

	public int getRestePrecedDip() {
		return restePrecedDip;
	}

	public void setRestePrecedDip(int restePrecedDip) {
		this.restePrecedDip = restePrecedDip;
	}

	public int getResteSuivantDip() {
		return resteSuivantDip;
	}

	public void setResteSuivantDip(int resteSuivantDip) {
		this.resteSuivantDip = resteSuivantDip;
	}

	public int getNombreSelectionDip() {
		return nombreSelectionDip;
	}

	public void setNombreSelectionDip(int nombreSelectionDip) {
		this.nombreSelectionDip = nombreSelectionDip;
	}

	public ArrayList<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(ArrayList<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public Experience getNouvelleExperience() {
		return nouvelleExperience;
	}

	public void setNouvelleExperience(Experience nouvelleExperience) {
		this.nouvelleExperience = nouvelleExperience;
	}

	public Certification getNouvelleCertification() {
		return nouvelleCertification;
	}

	public void setNouvelleCertification(Certification nouvelleCertification) {
		this.nouvelleCertification = nouvelleCertification;
	}

	public Long getNombreExperience() {
		return nombreExperience;
	}

	public void setNombreExperience(Long nombreExperience) {
		this.nombreExperience = nombreExperience;
	}

	public String getPrecedentExperience() {
		return precedentExperience;
	}

	public void setPrecedentExperience(String precedentExperience) {
		this.precedentExperience = precedentExperience;
	}

	public String getSuivantExperience() {
		return suivantExperience;
	}

	public void setSuivantExperience(String suivantExperience) {
		this.suivantExperience = suivantExperience;
	}

	public int getRestePrecedExp() {
		return restePrecedExp;
	}

	public void setRestePrecedExp(int restePrecedExp) {
		this.restePrecedExp = restePrecedExp;
	}

	public int getResteSuivantExp() {
		return resteSuivantExp;
	}

	public void setResteSuivantExp(int resteSuivantExp) {
		this.resteSuivantExp = resteSuivantExp;
	}

	public int getNombreSelectionExp() {
		return nombreSelectionExp;
	}

	public void setNombreSelectionExp(int nombreSelectionExp) {
		this.nombreSelectionExp = nombreSelectionExp;
	}

	public ArrayList<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(ArrayList<Certification> certifications) {
		this.certifications = certifications;
	}

	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}

	public Long getNombreCertification() {
		return nombreCertification;
	}

	public void setNombreCertification(Long nombreCertification) {
		this.nombreCertification = nombreCertification;
	}

	public String getPrecedentCertification() {
		return precedentCertification;
	}

	public void setPrecedentCertification(String precedentCertification) {
		this.precedentCertification = precedentCertification;
	}

	public String getSuivantCertification() {
		return suivantCertification;
	}

	public void setSuivantCertification(String suivantCertification) {
		this.suivantCertification = suivantCertification;
	}

	public int getRestePrecedCert() {
		return restePrecedCert;
	}

	public void setRestePrecedCert(int restePrecedCert) {
		this.restePrecedCert = restePrecedCert;
	}

	public int getResteSuivantCert() {
		return resteSuivantCert;
	}

	public void setResteSuivantCert(int resteSuivantCert) {
		this.resteSuivantCert = resteSuivantCert;
	}

	public int getNombreSelectionCert() {
		return nombreSelectionCert;
	}

	public void setNombreSelectionCert(int nombreSelectionCert) {
		this.nombreSelectionCert = nombreSelectionCert;
	}

	public int getMaxSelectCollaborateurs() {
		return maxSelectCollaborateurs;
	}

	public void setMaxSelectCollaborateurs(int maxSelectCollaborateurs) {
		this.maxSelectCollaborateurs = maxSelectCollaborateurs;
	}

	public byte[] getNouvellePhoto() {
		return nouvellePhoto;
	}

	public void setNouvellePhoto(byte[] nouvellePhoto) {
		this.nouvellePhoto = nouvellePhoto;
	}

	public StreamedContent getPhotoC() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			String idColl = context.getExternalContext()
					.getRequestParameterMap().get("collid");
			byte[] img = gestionIdentiteLocal.trouverParNumeroDossier(
					Long.valueOf(idColl)).getPhoto();
			if (img != null)
				return new DefaultStreamedContent(
						new ByteArrayInputStream(img), "image/png");
			else {
				return null;
			}
		}
	}

	public void setPhotoC(StreamedContent photoC) {
		this.photoC = photoC;
	}

	public void onCollDrop(DragDropEvent ddEvent) {
		identite = new Identite();
		identite = ((Identite) ddEvent.getData());
		rechercher();

	}

	public ArrayList<String> getListePeriodes() {
		return listePeriodes;
	}

	public void setListePeriodes(ArrayList<String> listePeriodes) {
		this.listePeriodes = listePeriodes;
	}

	public String getPeriodeEssai() {
		return periodeEssai;
	}

	public void setPeriodeEssai(String periodeEssai) {
		this.periodeEssai = periodeEssai;
	}

	public String getValPeriode() {
		return valPeriode;
	}

	public void setValPeriode(String valPeriode) {
		this.valPeriode = valPeriode;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPosteCol() {
		return posteCol;
	}

	public void setPosteCol(String posteCol) {
		this.posteCol = posteCol;
	}

	public String getTelephoneCol() {
		return telephoneCol;
	}

	public void setTelephoneCol(String telephoneCol) {
		this.telephoneCol = telephoneCol;
	}

	public String getMailCol() {
		return mailCol;
	}

	public void setMailCol(String mailCol) {
		this.mailCol = mailCol;
	}

	public String getDepartementCol() {
		return departementCol;
	}

	public void setDepartementCol(String departementCol) {
		this.departementCol = departementCol;
	}

	public ArrayList<PieceIdentite> getPiecesIdentite() {
		return piecesIdentite;
	}

	public void setPiecesIdentite(ArrayList<PieceIdentite> piecesIdentite) {
		this.piecesIdentite = piecesIdentite;
	}

	public PieceIdentite getSelectedPieceIdentite() {
		return selectedPieceIdentite;
	}

	public void setSelectedPieceIdentite(PieceIdentite selectedPieceIdentite) {
		this.selectedPieceIdentite = selectedPieceIdentite;
	}

	public PieceIdentite getNouveauPieceIdentite() {
		return nouveauPieceIdentite;
	}

	public void setNouveauPieceIdentite(PieceIdentite nouveauPieceIdentite) {
		this.nouveauPieceIdentite = nouveauPieceIdentite;
	}

	public String getNumMatriculeEmploye() {
		return numMatriculeEmploye;
	}

	public void setNumMatriculeEmploye(String numMatriculeEmploye) {
		this.numMatriculeEmploye = numMatriculeEmploye;
	}

	public String getNumMatriculeManager() {
		return numMatriculeManager;
	}

	public void setNumMatriculeManager(String numMatriculeManager) {
		this.numMatriculeManager = numMatriculeManager;
	}

	public ArrayList<Identite> getEmployesCherches() {
		return employesCherches;
	}

	public void setEmployesCherches(ArrayList<Identite> employesCherches) {
		this.employesCherches = employesCherches;
	}

	public Identite getIdentiteSelectionne() {
		return identiteSelectionne;
	}

	public void setIdentiteSelectionne(Identite identiteSelectionne) {
		this.identiteSelectionne = identiteSelectionne;
	}

	public StreamedContent getPhotoE() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			String idColl = context.getExternalContext()
					.getRequestParameterMap().get("empid");
			byte[] img = gestionIdentiteLocal.trouverParNumeroDossier(
					Long.valueOf(idColl)).getPhoto();
			if (img != null)
				return new DefaultStreamedContent(
						new ByteArrayInputStream(img), "image/png");
			else {
				return null;
			}
		}
	}

	public void setPhotoE(StreamedContent photoE) {
		this.photoE = photoE;
	}

	public Age getIntervalleAge() {
		return intervalleAge;
	}

	public void setIntervalleAge(Age intervalleAge) {
		this.intervalleAge = intervalleAge;
	}

	public RechercheAvancee getRa() {
		return ra;
	}

	public void setRa(RechercheAvancee ra) {
		this.ra = ra;
	}

	public DateEmbauche getIntervalleDateEmbauche() {
		return intervalleDateEmbauche;
	}

	public void setIntervalleDateEmbauche(DateEmbauche intervalleDateEmbauche) {
		this.intervalleDateEmbauche = intervalleDateEmbauche;
	}

	public List<Age> getListIntervallesAge() {
		return listIntervallesAge;
	}

	public void setListIntervallesAge(List<Age> listIntervallesAge) {
		this.listIntervallesAge = listIntervallesAge;
	}

	public List<DateEmbauche> getListIntervallesDateEmbauche() {
		return listIntervallesDateEmbauche;
	}

	public void setListIntervallesDateEmbauche(
			List<DateEmbauche> listIntervallesDateEmbauche) {
		this.listIntervallesDateEmbauche = listIntervallesDateEmbauche;
	}

	/**
	 * @return the headerButtonsDisabled
	 */

	/**
	 * @return the listidentiteSelectione
	 */
	public List<Identite> getListidentiteSelectione() {
		return listidentiteSelectione;
	}

	/**
	 * @param listidentiteSelectione
	 *            the listidentiteSelectione to set
	 */
	public void setListidentiteSelectione(List<Identite> listidentiteSelectione) {
		this.listidentiteSelectione = listidentiteSelectione;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the groupe
	 */
	public GroupeIdentity getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe
	 *            the groupe to set
	 */
	public void setGroupe(GroupeIdentity groupe) {
		this.groupe = groupe;
	}

	/**
	 * @return the groupeSelect
	 */
	public List<GroupeIdentity> getGroupeSelect() {
		return groupeSelect;
	}

	/**
	 * @return the selectlistidentite
	 */
	public List<Identite> getSelectlistidentite() {
		return selectlistidentite;
	}

	/**
	 * @param selectlistidentite
	 *            the selectlistidentite to set
	 */
	public void setSelectlistidentite(List<Identite> selectlistidentite) {
		this.selectlistidentite = selectlistidentite;
	}

	public List<GroupeIdentity> getListgroupeSelect() {
		return listgroupeSelect;
	}

	public void setListgroupeSelect(List<GroupeIdentity> listgroupeSelect) {
		this.listgroupeSelect = listgroupeSelect;
	}

	public GroupeIdentity getGroupeSelectSelectionne2() {
		return groupeSelectSelectionne2;
	}

	public void setGroupeSelectSelectionne2(
			GroupeIdentity groupeSelectSelectionne2) {
		this.groupeSelectSelectionne2 = groupeSelectSelectionne2;
	}

	/**
	 * @return the headerButtonsDisabled
	 */
	public boolean isHeaderButtonsDisabled() {
		return headerButtonsDisabled;
	}

	/**
	 * @param headerButtonsDisabled
	 *            the headerButtonsDisabled to set
	 */
	public void setHeaderButtonsDisabled(boolean headerButtonsDisabled) {
		this.headerButtonsDisabled = headerButtonsDisabled;
	}

	/**
	 * @return the dataItemId
	 */
	public HtmlInputHidden getDataItemId() {
		return dataItemId;
	}

	/**
	 * @param dataItemId
	 *            the dataItemId to set
	 */
	public void setDataItemId(HtmlInputHidden dataItemId) {
		this.dataItemId = dataItemId;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the bean
	 */
	public Bean getBean() {
		return bean;
	}

	/**
	 * @param bean
	 *            the bean to set
	 */
	public void setBean(Bean bean) {
		this.bean = bean;
	}

	/**
	 * @return the listidentiteSelectionemodif
	 */
	public List<Identite> getListidentiteSelectionemodif() {
		return listidentiteSelectionemodif;
	}

	/**
	 * @param listidentiteSelectionemodif the listidentiteSelectionemodif to set
	 */
	public void setListidentiteSelectionemodif(
			List<Identite> listidentiteSelectionemodif) {
		this.listidentiteSelectionemodif = listidentiteSelectionemodif;
	}

	/**
	 * @return the employesCherchesmodif
	 */
	public ArrayList<Identite> getEmployesCherchesmodif() {
		return employesCherchesmodif;
	}

	/**
	 * @param employesCherchesmodif the employesCherchesmodif to set
	 */
	public void setEmployesCherchesmodif(ArrayList<Identite> employesCherchesmodif) {
		this.employesCherchesmodif = employesCherchesmodif;
	}

	/**
	 * @return the list_Identity
	 */
	/*
	 * public List_Identity getList_Identity() { return list_Identity; }
	 *//**
	 * @param list_Identity
	 *            the list_Identity to set
	 */
	/*
	 * public void setList_Identity(List_Identity list_Identity) {
	 * this.list_Identity = list_Identity; }
	 */

}
