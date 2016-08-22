package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;





import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;






import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
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
import com.yesserp.domain.ga.PersonneACharge;
import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.ga.Profil;
import com.yesserp.domain.ga.Salaire;
import com.yesserp.domain.ga.SituationCivile;
import com.yesserp.domain.ga.SituationMedicale;
import com.yesserp.domain.ga.Statut;
import com.yesserp.domain.ga.Telephone;
import com.yesserp.domain.ga.Vehicule;
import com.yesserp.domain.pg.Age;
import com.yesserp.domain.pg.CategorieAffectationIdentite;
import com.yesserp.domain.pg.DateEmbauche;
import com.yesserp.domain.pg.EmploiAffectationIdentite;
import com.yesserp.domain.pg.NatureContratIdentite;
import com.yesserp.domain.pg.PosteAffectationIdentite;
import com.yesserp.domain.pg.QualiteIdentite;
import com.yesserp.domain.pg.RechercheAvancee;
import com.yesserp.domain.pg.SexeIdentite;
import com.yesserp.domain.pg.SituationCivileIdentite;
import com.yesserp.domain.pg.SituationContratIdentite;
import com.yesserp.domain.pg.TypeContratIdentite;
import com.yesserp.domain.pg.TypePieceIdentite;
import com.yesserp.domain.pg.TypeStatutIdentite;
import com.yesserp.domain.pg.UOAffectationIdentite;
import com.yesserp.sessionbean.ga.affectation.GestionAffectationLocal;
import com.yesserp.sessionbean.ga.cetification.GestionCertificationLocal;
import com.yesserp.sessionbean.ga.contrat.GestionContratLocal;
import com.yesserp.sessionbean.ga.diplome.GestionDiplomeGaLocal;
import com.yesserp.sessionbean.ga.embauche.GestionEmbaucheLocal;
import com.yesserp.sessionbean.ga.experience.GestionExperienceLocal;
import com.yesserp.sessionbean.ga.identite.GestionIdentiteLocal;
import com.yesserp.sessionbean.ga.nationalite.GestionNationaliteLocal;
import com.yesserp.sessionbean.ga.pieceidentite.GestionPieceIdentiteLocal;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;
import com.yesserp.sessionbean.pg.gestionCategorieAffectationIdentite.GestionCategorieAffectationIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionEmploiAffectationIdentite.GestionEmploiAffectationIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionNatureContratIdentite.GestionNatureContratIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionPosteAffectationIdentite.GestionPosteAffectationIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionQualiteIdentite.GestionQualiteIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionRechercheAvancee.GestionRechercheAvanceeLocal;
import com.yesserp.sessionbean.pg.gestionSexeIdentite.GestionSexeIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionSituationCivileIdentite.GestionSituationCivileIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionSituationContratIdentite.GestionSituationContratIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionTypeContratIdentite.GestionTypeContratIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionTypePieceIdentite.GestionTypePieceIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionTypeStatutIdentite.GestionTypeStatutIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionUOAffectationIdentite.GestionUOAffectationIdentiteLocal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
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
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.faces.validator.ValidatorException;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
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
import com.yesserp.domain.ga.PersonneACharge;
import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.ga.Profil;
import com.yesserp.domain.ga.Salaire;
import com.yesserp.domain.ga.SituationCivile;
import com.yesserp.domain.ga.SituationMedicale;
import com.yesserp.domain.ga.Statut;
import com.yesserp.domain.ga.Telephone;
import com.yesserp.domain.ga.Vehicule;
import com.yesserp.domain.pg.Age;
import com.yesserp.domain.pg.CategorieAffectationIdentite;
import com.yesserp.domain.pg.DateEmbauche;
import com.yesserp.domain.pg.EmploiAffectationIdentite;
import com.yesserp.domain.pg.NatureContratIdentite;
import com.yesserp.domain.pg.PosteAffectationIdentite;
import com.yesserp.domain.pg.QualiteIdentite;
import com.yesserp.domain.pg.RechercheAvancee;
import com.yesserp.domain.pg.SexeIdentite;
import com.yesserp.domain.pg.SituationCivileIdentite;
import com.yesserp.domain.pg.SituationContratIdentite;
import com.yesserp.domain.pg.TypeContratIdentite;
import com.yesserp.domain.pg.TypePieceIdentite;
import com.yesserp.domain.pg.TypeStatutIdentite;
import com.yesserp.domain.pg.UOAffectationIdentite;
import com.yesserp.sessionbean.ga.affectation.GestionAffectationLocal;
import com.yesserp.sessionbean.ga.cetification.GestionCertificationLocal;
import com.yesserp.sessionbean.ga.contrat.GestionContratLocal;
import com.yesserp.sessionbean.ga.diplome.GestionDiplomeGaLocal;
import com.yesserp.sessionbean.ga.embauche.GestionEmbaucheLocal;
import com.yesserp.sessionbean.ga.experience.GestionExperienceLocal;
import com.yesserp.sessionbean.ga.identite.GestionIdentiteLocal;
import com.yesserp.sessionbean.ga.nationalite.GestionNationaliteLocal;
import com.yesserp.sessionbean.ga.pieceidentite.GestionPieceIdentiteLocal;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;
import com.yesserp.sessionbean.pg.gestionCategorieAffectationIdentite.GestionCategorieAffectationIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionEmploiAffectationIdentite.GestionEmploiAffectationIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionNatureContratIdentite.GestionNatureContratIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionPosteAffectationIdentite.GestionPosteAffectationIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionQualiteIdentite.GestionQualiteIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionRechercheAvancee.GestionRechercheAvanceeLocal;
import com.yesserp.sessionbean.pg.gestionSexeIdentite.GestionSexeIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionSituationCivileIdentite.GestionSituationCivileIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionSituationContratIdentite.GestionSituationContratIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionTypeContratIdentite.GestionTypeContratIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionTypePieceIdentite.GestionTypePieceIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionTypeStatutIdentite.GestionTypeStatutIdentiteLocal;
import com.yesserp.sessionbean.pg.gestionUOAffectationIdentite.GestionUOAffectationIdentiteLocal;

@ManagedBean  
@ViewScoped  
public class CustomTimelineController implements Serializable {  
  
    private TimelineModel model;  
    private String locale; // current locale as String, java.util.Locale is possible too.  
    private Date start;  
    private Date end;  
    
    
    
    
    
/*******************************************************************************/
    
    
    
    
    
    @EJB
	GestionLibelleLocal gestionLibelle;
	@EJB
	GestionSexeIdentiteLocal gestionSexeIdentite;
	
	@EJB
	GestionQualiteIdentiteLocal gestionQualiteIdentite;
	
	@EJB
	GestionSituationCivileIdentiteLocal gestionSituationCivileIdentite;
	
	@EJB
	GestionTypeStatutIdentiteLocal gestionTypeStatutIdentite;
	
	@EJB
	GestionTypeContratIdentiteLocal gestionTypeContratIdentite;
	
	@EJB
	GestionNatureContratIdentiteLocal gestionNatureContratIdentite;
	
	@EJB
	GestionSituationContratIdentiteLocal gestionSituationContratIdentite;
	
	@EJB
	GestionPosteAffectationIdentiteLocal gestionPosteAffectationIdentite;
	
	@EJB
	GestionUOAffectationIdentiteLocal gestionUOAffectationIdentite;
	@EJB
	GestionEmploiAffectationIdentiteLocal gestionEmploiAffectationIdentite;
	@EJB
	GestionCategorieAffectationIdentiteLocal gestionCategorieAffectationIdentite;	
	@EJB
	GestionRechercheAvanceeLocal gestionRechercheAvanceeLocal;
	
	@EJB
	GestionIdentiteLocal gestionIdentiteLocal;
	@EJB
	GestionEmbaucheLocal gestionEmbaucheLocal;
	@EJB
	GestionAffectationLocal gestionAffectationLocal;
	@EJB
	GestionNationaliteLocal gestionNationaliteLocal;

	@EJB
	GestionCertificationLocal gestionCertificatLocal;

	@EJB
	GestionDiplomeGaLocal gestionDiplomeLocal;

	@EJB
	GestionExperienceLocal gestionExperienceLocal;

	@EJB
	GestionContratLocal gestionContratLocal;

	@EJB
	GestionPieceIdentiteLocal gestionPieceIdentiteLocal;
	
	@EJB
	GestionTypePieceIdentiteLocal gestionTypePieceIdentiteLocal;
	
	private Age intervalleAge=new Age();
	private RechercheAvancee ra=new RechercheAvancee();
	private DateEmbauche intervalleDateEmbauche=new DateEmbauche();
	private List<Age> listIntervallesAge;
	private List<DateEmbauche> listIntervallesDateEmbauche;
	private Identite identiteSelectionne = new Identite();
	private AttachementManager attachementManagerSelectionne = new AttachementManager();
	private AttachementEmploye attachementEmployeSelectionne = new AttachementEmploye();
	private Nationalite nationaliteSelectionne=new Nationalite();
	private SituationMedicale situationMedicaleSelectionne=new SituationMedicale();
	private Vehicule vehiculeSelectionne=new Vehicule();
	private Telephone telephoneSelectionne=new Telephone();
	private Mail mailSelectionne=new Mail();
	private Adresse adresseSelectionne =new Adresse();
	private DiplomeGa diplomeSelectionne=new DiplomeGa();
	private Experience experienceSelectionne=new Experience();
	private Certification certificatSelectionne=new Certification();
	private String numMatriculeManager;
	private String numMatriculeEmploye;
	private String matricule;
	private String numMatricule;
	private String valeurPieceIdentite;
	private String typPieceIdentite;
	private Long id;
	private String numeroCompte;
	private String codePays;
	private String codeAgence;
	private String codeBanque;
	private String cle;

	private Map<String, String> items_sexe = new LinkedHashMap<String, String>();
	private Map<String, String> items_qualite = new LinkedHashMap<String, String>();
	private Map<String, String> items_typeStatut = new LinkedHashMap<String, String>();
	private Map<String, String> items_situationCivile= new LinkedHashMap<String, String>();
	private Map<String, String> items_natureContrat = new LinkedHashMap<String, String>();
	private Map<String, String> items_situationContrat = new LinkedHashMap<String, String>();
	private Map<String, String> items_affectationCategorie= new LinkedHashMap<String, String>();
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
	
	private ArrayList<PieceIdentite> piecesidentite=new ArrayList<PieceIdentite>();
	private Identite identite = new Identite();
	private InfosIndividuelles individuelles = new InfosIndividuelles();
	private PieceIdentite pieceIdentite=new PieceIdentite();
	private TypePieceIdentite typePieceIdentite=new TypePieceIdentite();
	private InfosPhysiques physiques = new InfosPhysiques();
	private Adresse adresse = new Adresse();
	private ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	private Nationalite nationalite = new Nationalite();
	private ArrayList<Nationalite> nationalites = new ArrayList<>();
	private SituationCivile situationCivile = new SituationCivile();
	private Statut statut = new Statut();
	private ArrayList<Mail> mails = new ArrayList<Mail>();
	private ArrayList<Telephone> telephones = new ArrayList<Telephone>();
	private ArrayList<PersonneACharge> aCharges = new ArrayList<PersonneACharge>();
	private ArrayList<DiplomeGa> diplomes = new ArrayList<>();
	private DiplomeGa diplome = new DiplomeGa();
	private ArrayList<Certification> certifications = new ArrayList<>();
	private Certification certification = new Certification();
	private ArrayList<Experience> experiences = new ArrayList<>();
	private Experience experience = new Experience();
	private Cycle cycle = new Cycle();
	private Profil profil = new Profil();
	private Embauche embauche = new Embauche();
	private Salaire salaire = new Salaire();
	private Affectation affectation = new Affectation();
	private ImputationGa imputationGa = new ImputationGa();
	private ArrayList<AttachementManager> managers = new ArrayList<AttachementManager>();
	private ArrayList<AttachementManager> managersSelectionnes = new ArrayList<AttachementManager>();
	private ArrayList<AttachementEmploye> employes = new ArrayList<AttachementEmploye>();
	private AttachementEmploye employe = new AttachementEmploye();
	private AttachementManager manager = new AttachementManager();
	private Long numdossier;
	private Long mgdossier;
	private Identite idEmp = new Identite();
	private Identite idMgr = new Identite();
	private Telephone tel = new Telephone();
	private Mail mail = new Mail();
	private Naissance naissance = new Naissance();
	private Contrat contrat = new Contrat();
	private SituationMedicale medicale = new SituationMedicale();
	private ArrayList<SituationMedicale> medicales = new ArrayList<>();
	private ArrayList<Vehicule> vehicules = new ArrayList<>();
	private Vehicule vehicule = new Vehicule();
	private CoordonneeBancaire bancaire = new CoordonneeBancaire();
	private byte[] contratsigne = null;
	private byte[] photo = null;
	private StreamedContent photoView;

	private ArrayList<String> prefixesMatricule = new ArrayList<>();
	private String prefixeMat;
	int suffixe = 0;
	private int taillePrefixe = 0;
	private int tailleSuffixe = 0;
	private ArrayList<String> listePeriodes = new ArrayList<>();
	private String periodeEssai;
	private String valPeriode;
	private StreamedContent photoE;
	private String disabledNjf = "false";
	private ArrayList<Identite> employesCherches = new ArrayList<Identite>();
	 private BarChartModel barModel;
	    private HorizontalBarChartModel horizontalBarModel;
	
  
    @PostConstruct  
    protected void initialize() {  
        // set initial start / end dates for the axis of the timeline  
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));  
        Date now = new Date();  
  
        cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);  
        start = cal.getTime();  
  
        cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 1000);  
        end = cal.getTime();  
  
        // groups  
        String[] NAMES = new String[] {"Mohamed", "Hamida", "Ridha", "Ramzi", "Nour", "Safa"};  
  
        // create timeline model  
        model = new TimelineModel();  
  
        for (String name : NAMES) {  
            now = new Date();  
            Date end = new Date(now.getTime() - 12 * 60 * 60 * 1000);  
  
            for (int i = 0; i < 5; i++) {  
                Date start = new Date(end.getTime() + Math.round(Math.random() * 5) * 60 * 60 * 1000);  
                end = new Date(start.getTime() + Math.round(4 + Math.random() * 5) * 60 * 60 * 1000);  
  
                long r = Math.round(Math.random() * 2);  
                String availability = (r == 0 ? "Absence" : (r == 1 ? "Travail normal" : "Dejeuner"));  
  
                // create an event with content, start / end dates, editable flag, group name and custom style class  
                TimelineEvent event = new TimelineEvent(availability, start, end, true, name, availability.toLowerCase());  
                model.add(event);  
            }  
        }  
        piecesidentite = new ArrayList<>();
		piecesidentite.add(new PieceIdentite());
		listIntervallesAge = new ArrayList<>();
		listIntervallesDateEmbauche = new ArrayList<>();
        
    	diplome=new DiplomeGa();
		certification=new Certification();
		experience=new Experience();
		 ChargerRechercheAvancee();
		afficherListeTypePiecesIdentite();		
		afficherListeNationalitePays();
		afficherListeTypeContrat();
		afficherListeNiveauDiplome();
		afficherListeTypeCertificat();
		afficherListeExperiencePoste();
		afficherListeExperienceSociete();
		afficherListeAffectationPoste();
		afficherListeAffectationUniteOrg();
		afficherListeAffectationEmploi();
		prefixesMatricule = new ArrayList<>();
		prefixesMatricule.add("Selectionnez");
		prefixesMatricule.add("cadre");
		prefixesMatricule.add("ouvri");
		prefixesMatricule.add("ingen");
		taillePrefixe = 5;
		tailleSuffixe = 5;
		listePeriodes.add("Selectionnez");
		listePeriodes.add("jour");
		listePeriodes.add("mois");
		affectation.setPctaffec((double) 100);
		
		
		
		
		 
	      
		 createBarModels();
		
    }  
    
   /***********************CHARTS************************************/
    
    
    
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Travail normal");
        boys.set("Mohamed", 120);
        boys.set("Ali", 100);
        boys.set("Ridha", 44);
        boys.set("Ramzi", 150);
        boys.set("Nour", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Absence");
        girls.set("Hamida", 52);
        girls.set("Nour", 60);
        girls.set("Fatma", 110);
        girls.set("Souhir", 135);
        girls.set("Bella", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Diagramme de performance");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Personnelle");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Performance");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 82);
        girls.set("2007", 35);
        girls.set("2008", 120);
 
        horizontalBarModel.addSeries(boys);
        horizontalBarModel.addSeries(girls);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
    
    /*********************** FIN CHARTS************************************/
    
    
    public void ChargerRechercheAvancee()
	{
		
		try {
		if(gestionRechercheAvanceeLocal.AfficherRechercheAvancee().get(0)!= null)
		{
		
		ra=gestionRechercheAvanceeLocal.AfficherRechercheAvancee().get(0);
		listIntervallesAge= gestionRechercheAvanceeLocal.AfficherAgesParRechercheAvancee(ra);
		listIntervallesDateEmbauche=gestionRechercheAvanceeLocal.AfficherDatesEmbaucheParRechercheAvancee(ra);
		
		}}
		catch (Exception e)
		{
		System.out.println(e.getMessage());
		}
	}
	
	

	
	public void chargerNumeroCompte()
	{
		numeroCompte=bancaire.getNumcompt();
		if(numeroCompte!="" && codeBanque!="" & codePays!="" && codeAgence!="" && cle!="")
		{
			bancaire.setIban(getIBAN(codePays,codeBanque,codeAgence,numeroCompte,cle));
		}
	}
	
	public void chargerCodeBanque()
	{
		codeBanque=bancaire.getCodeBanque();
		if(numeroCompte!="" && codeBanque!="" & codePays!="" && codeAgence!="" && cle!="")
		{
			bancaire.setIban(getIBAN(codePays,codeBanque,codeAgence,numeroCompte,cle));
		}
	}
	
	public void chargerCodeAgence()
	{
		codeAgence=bancaire.getCodeAgence();
		if(numeroCompte!="" && codeBanque!="" & codePays!="" && codeAgence!="" && cle!="")
		{
			bancaire.setIban(getIBAN(codePays,codeBanque,codeAgence,numeroCompte,cle));
		}
	}
	
	public void chargerCodePays()
	{
		codePays=bancaire.getCodepays();
		if(numeroCompte!="" && codeBanque!="" & codePays!="" && codeAgence!="" && cle!="")
		{
			bancaire.setIban(getIBAN(codePays,codeBanque,codeAgence,numeroCompte,cle));
		}
	}
	public void chargerCle()
	{
		FacesMessage message=new FacesMessage();
			
		if(numeroCompte!="" && codeBanque!="" & codePays!="" && codeAgence!="" && cle!="")
		{
			System.out.println("Le RIB = "+verifierRIB(codeBanque,codeAgence,numeroCompte));
			if(new BigDecimal(bancaire.getCle()).equals(verifierRIB(codeBanque,codeAgence,numeroCompte)))
			{
			cle=bancaire.getCle();	
			bancaire.setIban(getIBAN(codePays,codeBanque,codeAgence,numeroCompte,cle));
		}
			else 
				  message = new FacesMessage("Le cl� RIB est Incorrect. Mettre RIB = "+verifierRIB(codeBanque,codeAgence,numeroCompte));
		        message.setSeverity(FacesMessage.SEVERITY_ERROR);
		     			
	      
				
		}
		
	}
	
	public BigDecimal  verifierRIB(String codebanque, String codeGuichet, String numerocompte)
	{
		numerocompte=numerocompte.toUpperCase();
		System.out.println("Numero de compte avnt = "+numerocompte);
		numerocompte=numerocompte.replace('A', '1');
		numerocompte=numerocompte.replace('J', '1');
		numerocompte=numerocompte.replace('B', '2');
		numerocompte=numerocompte.replace('K', '2');
		numerocompte=numerocompte.replace('S', '2');
		numerocompte=numerocompte.replace('C', '3');
		numerocompte=numerocompte.replace('L', '3');
		numerocompte=numerocompte.replace('T', '3');
		numerocompte=numerocompte.replace('D', '4');
		numerocompte=numerocompte.replace('M', '4');
		numerocompte=numerocompte.replace('U', '4');
		numerocompte=numerocompte.replace('E', '5');
		numerocompte=numerocompte.replace('N', '5');
		numerocompte=numerocompte.replace('V', '5');
		numerocompte=numerocompte.replace('F', '6');
		numerocompte=numerocompte.replace('O', '6');
		numerocompte=numerocompte.replace('W', '6');
		numerocompte=numerocompte.replace('G', '7');
		numerocompte=numerocompte.replace('P', '7');
		numerocompte=numerocompte.replace('X', '7');
		numerocompte=numerocompte.replace('H', '8');
		numerocompte=numerocompte.replace('Q', '8');
		numerocompte=numerocompte.replace('Y', '8');
		numerocompte=numerocompte.replace('I', '9');
		numerocompte=numerocompte.replace('R', '9');
		numerocompte=numerocompte.replace('Z', '9');	
		System.out.println("Numero de compte apres = "+numerocompte);
		BigDecimal x=new BigDecimal(codebanque).multiply(new BigDecimal(89));
		BigDecimal y=new BigDecimal(codeGuichet).multiply(new BigDecimal(15));
		BigDecimal z=new BigDecimal(numerocompte).multiply(new BigDecimal(3));
		BigDecimal xy=x.add(y);
		BigDecimal xyz=xy.add(z);
		BigDecimal t=xyz.remainder(new BigDecimal(97));
		BigDecimal val= new BigDecimal(97).subtract(t);
		System.out.println("Val "+ val);
		return val;
        
	}
	
	public static String getIBAN(String codepays,String codebanque, String codeGuichet, String numerocompte, String cle) {
		 
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String tmp = codebanque + codeGuichet + numerocompte + cle + codepays+ "00";
	    tmp = tmp.toUpperCase();
	 
	    for (char c : tmp.toCharArray()) {
	        if (Character.isLetter(c)) {
	            tmp  = tmp .replaceAll(String.valueOf(c), String.valueOf(alphabet.indexOf(c) + 10));
	        }
	    }
	    String ibanKey =
	            String.valueOf(new BigDecimal(98).subtract(new BigDecimal(tmp).remainder((new BigDecimal(97)))));
	    if (ibanKey.length() == 1) {
	        ibanKey = "0" + ibanKey;
	    }
	    return codepays + ibanKey + codebanque + codeGuichet + numerocompte + cle;
	}
	    public boolean checkRib(String rib) {
	        StringBuilder extendedRib = new StringBuilder(rib.length());
	        for (char currentChar : rib.toCharArray()) {
	            //Works on base 36
	            int currentCharValue = Character.digit(currentChar, Character.MAX_RADIX);
	            //Convert character to simple digit
	            extendedRib.append(currentCharValue<10?currentCharValue:(currentCharValue + (int) StrictMath.pow(2,(currentCharValue-10)/9))%10);
	        }
	 
	        return new BigDecimal(extendedRib.toString()).remainder(new BigDecimal(97)).intValue() == 0;
	   
	}
	
	public void onButtonRemoveFieldClick(final PieceIdentite pieceIdentite) {
		piecesidentite.remove(piecesidentite.indexOf(pieceIdentite));
		
	}

	public void onButtonAddFieldClick(AjaxBehaviorEvent p_oEvent) {

		piecesidentite.add(new PieceIdentite());
        
		
	}
	
	public void onButtonRemoveIntervalleAgeClick(final Age intervalleAge) {
		listIntervallesAge.remove(listIntervallesAge.indexOf(intervalleAge));
		
	}

	public void onButtonAddIntervalleAgeClick(AjaxBehaviorEvent p_oEvent) {
		listIntervallesAge.add(new Age());
        
		
	}
	public void onButtonRemoveIntervalleDateEmbaucheClick(final  DateEmbauche intervalleDateEmbauche) {
		listIntervallesDateEmbauche.remove(listIntervallesDateEmbauche.indexOf(intervalleDateEmbauche));
		
	}

	public void onButtonAddIntervalleDateEmbaucheClick(AjaxBehaviorEvent p_oEvent) {
		listIntervallesDateEmbauche.add(new DateEmbauche());
        
		
	}

	public void onCallDropEmp(DragDropEvent ddEvent) {
		numMatriculeEmploye = ((Identite) ddEvent.getData()).getMatricul();

	}

	public void onCallDropMan(DragDropEvent ddEvent) {
		numMatriculeManager = ((Identite) ddEvent.getData()).getMatricul();

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

				items_TypePieceIdentite.put(c.getNom(),c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void afficherListeSituationCivile() {
		items_situationCivile.clear();
		try {
			List list = gestionSituationCivileIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				SituationCivileIdentite c = (SituationCivileIdentite) iter.next();

				items_situationCivile.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void afficherListeQualite() {
		items_qualite.clear();
		try {
			List list = gestionQualiteIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				QualiteIdentite c = (QualiteIdentite) iter.next();

				items_qualite.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void afficherListeSexe() {
		items_sexe.clear();
		try {
			List list = gestionSexeIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				SexeIdentite c = (SexeIdentite) iter.next();

				items_sexe.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void afficherListeTypeStatut() {
		items_typeStatut.clear();
		try {
			List list = gestionTypeStatutIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				TypeStatutIdentite c = (TypeStatutIdentite) iter.next();

				items_typeStatut.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void afficherListeTypeContrat() {
		items_typeContrat.clear();
		try {
			List list = gestionTypeContratIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				TypeContratIdentite c = (TypeContratIdentite) iter.next();

				items_typeContrat.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void afficherListeSituationContrat() {
		items_situationContrat.clear();
		try {
			List list = gestionSituationContratIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				SituationContratIdentite c = (SituationContratIdentite) iter.next();

				items_situationContrat.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void afficherListeNatureContrat() {
		items_natureContrat.clear();
		try {
			List list = gestionNatureContratIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				NatureContratIdentite c = (NatureContratIdentite) iter.next();

				items_natureContrat.put(c.getNom(), c.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	public void afficherListeAffectationPoste() {
		items_affectationPoste.clear();
		try {
			List list = gestionPosteAffectationIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				PosteAffectationIdentite a = (PosteAffectationIdentite) iter.next();

				items_affectationPoste.put(a.getNom(), a.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeAffectationUniteOrg() {
		items_affectationUniteOrg.clear();
		try {
			List list = gestionUOAffectationIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				UOAffectationIdentite a = (UOAffectationIdentite) iter.next();

				items_affectationUniteOrg.put(a.getNom(),
						a.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeAffectationCategorie() {
		items_affectationCategorie.clear();
		try {
			List list = gestionCategorieAffectationIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				CategorieAffectationIdentite a = (CategorieAffectationIdentite) iter.next();

				items_affectationCategorie.put(a.getNom(),
						a.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeAffectationEmploi() {
		items_affectationEmploi.clear();
		try {
			List list = gestionEmploiAffectationIdentite.findall();
			Iterator iter = list.iterator();
			if (!iter.hasNext()) {
				System.out.println("La liste est vide");
			} else
				System.out.println("not empty");

			while (iter.hasNext()) {
				EmploiAffectationIdentite a = (EmploiAffectationIdentite) iter.next();

				items_affectationEmploi.put(a.getNom(), a.getNom());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void afficherListeNiveauDiplome() {
		items_niveauDiplome.clear();
		try {
			List list = gestionDiplomeLocal.findAll();
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
			List list = gestionCertificatLocal.findAll();
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
	
		gestionRechercheAvanceeLocal.supprimerRechercheAvancee(ra,listIntervallesAge,listIntervallesDateEmbauche);
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

	public void chercherEmployesByMatricule() {
		getEmployesCherches().clear();
		if (getMatricule().equals("%")) {

			setEmployesCherches((ArrayList<Identite>) gestionIdentiteLocal
					.findAll());
		} else
			setEmployesCherches((ArrayList<Identite>) gestionIdentiteLocal
					.trouverParLikeMatricule(getMatricule(), 1));
	}


	public Date getDateNaissanceByAge(int age)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -age);
		System.out.println(cal.getTime());
		return cal.getTime();
	}
	public void memoriser() {
		if(gestionRechercheAvanceeLocal.AfficherRechercheAvancee().size()==(-1))
		{
		RechercheAvancee r=new RechercheAvancee();
		r=gestionRechercheAvanceeLocal.AfficherRechercheAvancee().get(0);
		gestionRechercheAvanceeLocal.supprimerRechercheAvancee(r,listIntervallesAge,listIntervallesDateEmbauche);
		}
		gestionRechercheAvanceeLocal.enregistrerRechercheAvancee(ra);
		for(Age a:getListIntervallesAge())
		{
		a.setMinDateNaissance(getDateNaissanceByAge(a.getMinAge()));
		a.setMaxDateNaissance(getDateNaissanceByAge(a.getMaxAge()));	
		}
		gestionRechercheAvanceeLocal.enregistrerAge(ra, listIntervallesAge);
		gestionRechercheAvanceeLocal.enregistrerDateEmbauche(ra, listIntervallesDateEmbauche);
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
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La valeur de Minimum age doit etre inferieur � la valeur de maximum age"));

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
						"Error!", "La valeur de Minimum date d'embauche doit etre inferieur � la valeur de maximum date d'embauche"));
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

	public void disableNJF() {
		if (identite.getQualite().equals("Mr")) {
			disabledNjf = "true";
			identite.setNomjfill(null);
		} else
			disabledNjf = "false";

	}

	public void trouverSuffixe() {
		if (prefixeMat != null && !prefixeMat.equals("Selectionnez")) {
			suffixe = gestionIdentiteLocal.trouverNextMatriculeParPrefixe(
					prefixeMat, taillePrefixe);
			String suf = String.valueOf(suffixe);

			suf = StringUtils.leftPad(suf, tailleSuffixe, "0");

			identite.setMatricul(prefixeMat + suf);
			prefixeMat = "Selectionnez";
		} else {
			identite.setMatricul(null);
		}
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

		photo = img;
		getPhotoView();

	}

	public void handleFileUpload(FileUploadEvent event) {

		FacesMessage message = new FacesMessage("success", event.getFile()
				.getFileName() + " file pdf uploaded");
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

		contratsigne = cont;

	}

	public String annuler() {

		identite = new Identite();
		individuelles = new InfosIndividuelles();
		physiques = new InfosPhysiques();
		adresse = new Adresse();
		adresses = new ArrayList<Adresse>();
		situationCivile = new SituationCivile();
		statut = new Statut();
		mails = new ArrayList<Mail>();
		telephones = new ArrayList<Telephone>();
		aCharges = new ArrayList<PersonneACharge>();
		cycle = new Cycle();
		profil = new Profil();
		embauche = new Embauche();
		salaire = new Salaire();
		affectation = new Affectation();
		imputationGa = new ImputationGa();
		managers = new ArrayList<AttachementManager>();
		employes = new ArrayList<AttachementEmploye>();
		employe = new AttachementEmploye();
		manager = new AttachementManager();

		mail = new Mail();
		tel = new Telephone();
		naissance = new Naissance();
		nationalite = new Nationalite();
		nationalites = new ArrayList<>();
		contrat = new Contrat();
		medicale = new SituationMedicale();
		medicales = new ArrayList<>();
		vehicules = new ArrayList<>();
		vehicule = new Vehicule();
		bancaire = new CoordonneeBancaire();
		certifications = new ArrayList<>();
		certification = new Certification();
		diplomes = new ArrayList<>();
		diplome = new DiplomeGa();
		experiences = new ArrayList<>();
		experience = new Experience();
		piecesidentite=new ArrayList<>();
		photo = null;

		// return "accueil?faces-redirect=true";
		return null;
	}

	public void definirFinEssai() {
		valPeriode = periodeEssai;
		if (embauche.getDatedeb() != null && embauche.getPeriodeEssai() != null
				&& !periodeEssai.equals("Selectionnez")) {
			try {
				int i = Integer.parseInt(embauche.getPeriodeEssai());
				if (periodeEssai.startsWith("m"))
					embauche.setFinessai(MyCalendar.addMonths(
							embauche.getDatedeb(), i));
				else if (periodeEssai.startsWith("j")
						|| periodeEssai.startsWith("d"))
					embauche.setFinessai(MyCalendar.addDays(
							embauche.getDatedeb(), i));
				periodeEssai = "Selectionnez";

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			embauche.setFinessai(null);
			periodeEssai = "Selectionnez";
		}
	}

	public String sauvegarder() {

		boolean test = true;
		FacesContext context = FacesContext.getCurrentInstance();
		if (piecesidentite.size() == 0) {
		
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Au moins une piece d'identite demandee", ""));
			test = false;
		} 
			
		if (nationalites.size() == 0) {

			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Au moins une nationalite demandee", ""));
			test = false;
		} else {
			for (int i = 0; i < nationalites.size(); i++)
				if (nationalites.get(i).getPays().equals("")) {
					context.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Champs Pays du Nationalite " + (i + 1)
									+ " obligatoire", ""));
					test = false;
				}
		}

		if (adresses.size() == 0) {
	
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Au moins une adresse demandee", ""));

			test = false;
		} else {
			for (int i = 0; i < adresses.size(); i++)
				if ((adresses.get(i).getRue().equals(""))
						|| (adresses.get(i).getVille().equals(""))
						|| (adresses.get(i).getNumaison() == null)
						|| (adresses.get(i).getCodepost() == null)) {
				
					context.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Donnees de l'adresse " + (i + 1) + " incompletes",
							""));

					test = false;
				}
		}

		if (affectation.getPoste().equals("")
				&& ((affectation.getEmploi().equals("")) || (affectation
						.getUniteorga().equals("")))) {
		
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Poste ou (Emploi et Unit� organisationnelle) obligatoire",
					""));

			test = false;
		}

		if (test == true) {
			identite.setPhoto(photo);
			if (!gestionIdentiteLocal.ajouterIdentite(identite)) {
	
				context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "erreur: le matricule existe, veuiller recharger le matricule",
								"exist"));
				gestionIdentiteLocal.ajouterIdentite(identite);
				return null;
			} 
			else {
				gestionIdentiteLocal.ajouterNaissance(identite, naissance);
				gestionIdentiteLocal.ajouterFichePhysique(identite, physiques);
				gestionIdentiteLocal.ajouterListeAdresses(identite, adresses);
				gestionIdentiteLocal.ajouterListNationalites(identite,nationalites);
				gestionIdentiteLocal.ajouterSituationCivile(identite,situationCivile);
				gestionIdentiteLocal.ajouterListeMails(identite, mails);
				gestionIdentiteLocal.ajouterListeTelephones(identite,telephones);
				gestionIdentiteLocal.ajouterListePersonneACharge(identite,aCharges);
				
				statut.setSituation("actif");
				gestionIdentiteLocal.ajouterStatut(identite, statut);
				gestionIdentiteLocal.ajouterCycle(identite, cycle);
				gestionIdentiteLocal.ajouterProfil(identite, profil);
				gestionIdentiteLocal.ajouterListPiecesIdentite(identite, piecesidentite);
			
				if (embauche.getPeriodeEssai() != null && valPeriode != null
						&& !valPeriode.equals("")) {
					if (!valPeriode.equals("mois")) {
						try {
							int periode = Integer.parseInt(embauche
									.getPeriodeEssai());
							if (periode == 1)
								embauche.setPeriodeEssai(periode + " "
										+ valPeriode);
							else if (periode > 1)
								embauche.setPeriodeEssai(periode + " "
										+ valPeriode + "s");
						} catch (Exception e) {
							// TODO: handle exception
						}
					} else {
						try {
							int periode = Integer.parseInt(embauche
									.getPeriodeEssai());
							embauche.setPeriodeEssai(periode + " " + valPeriode);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}

				}
				
					embauche.setValide("valide");
					gestionIdentiteLocal.ajouterEmbauche(identite, embauche);
					gestionEmbaucheLocal.ajouterSalaire(embauche, salaire);
					gestionEmbaucheLocal.ajouterAffectation(embauche,affectation);
					gestionAffectationLocal.attacherListManagers(affectation, managers);
					gestionAffectationLocal.attacherListEmployes(affectation, employes);
					gestionAffectationLocal.ajouterImputationGa(affectation, imputationGa);
					
					contrat.setActif(true);
					contrat.setContratSigne(contratsigne);
					gestionEmbaucheLocal.ajouterContrat(embauche, contrat);
				
					gestionIdentiteLocal.ajouterListDiplomes(identite, diplomes);
				
					gestionIdentiteLocal.ajouterListCertifications(identite,certifications);
			
					gestionIdentiteLocal.ajouterListExperiences(identite,experiences);
				gestionIdentiteLocal.ajouterListSituationMedicales(identite,medicales);
				gestionIdentiteLocal.ajouterListVehicules(identite, vehicules);
				gestionIdentiteLocal.ajouterCoordonneeBancaire(identite,bancaire);

				identite = new Identite();
				individuelles = new InfosIndividuelles();
				physiques = new InfosPhysiques();
				adresse = new Adresse();
				situationCivile = new SituationCivile();
				statut = new Statut();
				mails = new ArrayList<Mail>();
				telephones = new ArrayList<Telephone>();
				aCharges = new ArrayList<PersonneACharge>();
				cycle = new Cycle();
				profil = new Profil();
				embauche = new Embauche();
				salaire = new Salaire();
				affectation = new Affectation();
				imputationGa = new ImputationGa();
				managers = new ArrayList<AttachementManager>();
				employes = new ArrayList<AttachementEmploye>();
				employe = new AttachementEmploye();
				manager = new AttachementManager();
				mail = new Mail();
				tel = new Telephone();
				adresses = new ArrayList<Adresse>();
				naissance = new Naissance();
				nationalite = new Nationalite();
				nationalites = new ArrayList<>();
				contrat = new Contrat();
				medicale = new SituationMedicale();
				vehicule = new Vehicule();
				bancaire = new CoordonneeBancaire();
				certifications = new ArrayList<>();
				certification = new Certification();
				diplomes = new ArrayList<>();
				diplome = new DiplomeGa();
				experiences = new ArrayList<>();
				experience = new Experience();
				piecesidentite=new ArrayList<>();
				piecesidentite.add(new PieceIdentite());
				photo = null;
				contratsigne = null;
				return null;
			}
		}
		
		
		
	        return null;
	}
	
	public void showMessage() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "L'embauche est enregistr� .");
         
	  //      RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	

	public void ajouterEmployeAListe() {
		Identite i = new Identite();
		i = gestionIdentiteLocal.trouverParMatricule(numMatriculeEmploye);
		employe = new AttachementEmploye();
		employe.setNumMat(i.getMatricul());
		employe.setEmpnom(i.getNom());
		employe.setEmppreno(i.getPrenom());
		employe.setDatedeb(new Date());
		employes.add(employe);
		employe = new AttachementEmploye();
		idEmp = new Identite();

	}

	public void ajouterManagerAListe() {
		Identite i = new Identite();
		i = gestionIdentiteLocal.trouverParMatricule(numMatriculeManager);
		AttachementManager amanager = new AttachementManager();
		amanager.setNumMat(i.getMatricul());
		amanager.setManagnom(i.getNom());
		amanager.setManagpre(i.getPrenom());
		amanager.setDatedeb(new Date());
		managers.add(amanager);
		amanager = new AttachementManager();

	}

	public void ajouterAdresseAListe() {

		if (adresse.isPrincipa()) {
			int i = 0;
			boolean existP = false;
			while (i < adresses.size() && !existP) {
				if (adresses.get(i).isPrincipa()) {
					existP = true;

				} else
					i++;
			}
			if (!existP) {
				adresses.add(adresse);
				adresse = new Adresse();
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"Attention: plus qu'une adresse principale ", "exist "));
			}
		} else {
			adresses.add(adresse);
			System.out.println(adresses.get(adresses.size() - 1).getType());
			adresse = new Adresse();
		}

	}


	public void supprimerDernierAttachManagers() {
		System.out.println("Num Matricul"+attachementManagerSelectionne.getNumMat());
		System.out.println("Size de Managers "+managers.size());
		AttachementManager attM=new AttachementManager();
		attM=attachementManagerSelectionne;
		managers.remove(attM);		
		attachementManagerSelectionne=new AttachementManager();

	}
	
	public void supprimerDernierAttachEmployes() {
		if (employes.size() > 0)
			employes.remove(employes.size() - 1);
	}
	public void supprimerDerniereAdresse() {
		if (adresses.size() > 0)
			adresses.remove(adresses.size() - 1);
	}

	public void supprimerDernierMail() {
		if (mails.size() > 0)
			mails.remove(mails.size() - 1);
	}

	public void supprimerDernierTel() {
		if (telephones.size() > 0)
			telephones.remove(telephones.size() - 1);
	}

	public void ajouterNationaliteAListe() {
		if (nationalite.isPrincipa()) {
			int i = 0;
			boolean existP = false;
			while (i < nationalites.size() && !existP) {
				if (nationalites.get(i).isPrincipa()) {
					existP = true;

				} else
					i++;
			}
			if (!existP) {
				nationalites.add(nationalite);
				nationalite = new Nationalite();
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(
						"erreur: nationalite principale existe", "exist "));
			}
		} else {
			nationalites.add(nationalite);
			nationalite = new Nationalite();
		}
	}

	
	
	
	public void supprimerDerniereNatio() {
		if (nationalites.size() > 0)
			nationalites.remove(nationalites.size() - 1);
	}

	public void ajouterTelephoneAListe() {
		telephones.add(tel);
		tel = new Telephone();
	}

	public void ajouterMailAListe() {
		mails.add(mail);
		mail = new Mail();
	}

	public void ajouterVehiculeAListe() {
		vehicules.add(vehicule);
		vehicule = new Vehicule();
	}

	public void ajouterMedicaleAListe() {
		medicales.add(medicale);
		medicale = new SituationMedicale();
	}

	public void ajouterDiplome() {
		diplomes.add(diplome);
		diplome = new DiplomeGa();

	}

	public void ajouterExperience() {
		experiences.add(experience);
		experience = new Experience();

	}

	public void ajouterCertification() {
		certifications.add(certification);
		certification = new Certification();

	}

	public void supprimerDernierDiplome() {
		if (diplomes.size() > 0)
			diplomes.remove(diplomes.size() - 1);

	}

	public void supprimerDerniereExperience() {
		if (experiences.size() > 0)
			experiences.remove(experiences.size() - 1);

	}

	public void supprimerDerniereCertification() {
		if (certifications.size() > 0)
			certifications.remove(certifications.size() - 1);
	}

	public void supprimerDernierVehicule() {
		if (vehicules.size() > 0)
			vehicules.remove(vehicules.size() - 1);

	}

	public void supprimerDerniereMedicale() {
		if (medicales.size() > 0)
			medicales.remove(medicales.size() - 1);
	}

	public void selectEmploye() {
		numMatriculeEmploye = identiteSelectionne.getMatricul();

	}

	public void rechercher(Long num) {
		idEmp = gestionIdentiteLocal.trouverParNumeroDossier(num);

		if (idEmp == null)
			idEmp = new Identite();
	}

	public int nombreAdressePrincipale(ArrayList<Adresse> adr) {
		int i = 0;
		int n = 0;
		while (i < adr.size()) {
			if (adr.get(i).isPrincipa()) {
				n++;

			}
			i++;
		}
		return n;
	}

	public int nombreNationalitePrincipale(ArrayList<Nationalite> nat) {
		int i = 0;
		int n = 0;
		while (i < nat.size()) {
			if (nat.get(i).isPrincipa()) {
				n++;

			}
			i++;
		}
		return n;
	}
  
    public TimelineModel getModel() {  
        return model;  
    }  
  
    public String getLocale() {  
        return locale;  
    }  
  
    public void setLocale(String locale) {  
        this.locale = locale;  
    }  
  
    public Date getStart() {  
        return start;  
    }  
  
    public Date getEnd() {  
        return end;  
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

	public InfosPhysiques getPhysiques() {
		return physiques;
	}

	public void setPhysiques(InfosPhysiques physiques) {
		this.physiques = physiques;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public ArrayList<PersonneACharge> getaCharges() {
		return aCharges;
	}

	public void setaCharges(ArrayList<PersonneACharge> aCharges) {
		this.aCharges = aCharges;
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

	public Affectation getAffectation() {
		return affectation;
	}

	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}

	public ArrayList<AttachementEmploye> getEmployes() {
		return employes;
	}

	public void setEmployes(ArrayList<AttachementEmploye> employes) {
		this.employes = employes;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public ArrayList<Mail> getMails() {
		return mails;
	}

	public void setMails(ArrayList<Mail> mails) {
		this.mails = mails;
	}

	public ArrayList<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(ArrayList<Telephone> telephones) {
		this.telephones = telephones;
	}

	public ArrayList<AttachementManager> getManagers() {
		return managers;
	}

	public void setManagers(ArrayList<AttachementManager> managers) {
		this.managers = managers;
	}

	public SituationCivile getSituationCivile() {
		return situationCivile;
	}

	public void setSituationCivile(SituationCivile situationCivile) {
		this.situationCivile = situationCivile;
	}

	public AttachementEmploye getEmploye() {
		return employe;
	}

	public void setEmploye(AttachementEmploye employe) {
		this.employe = employe;
	}

	public Long getNumdossier() {
		return numdossier;
	}

	public void setNumdossier(Long numdossier) {
		this.numdossier = numdossier;
	}

	public Identite getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(Identite idEmp) {
		this.idEmp = idEmp;
	}

	public Identite getIdMgr() {
		return idMgr;
	}

	public void setIdMgr(Identite idMgr) {
		this.idMgr = idMgr;
	}

	public Long getMgdossier() {
		return mgdossier;
	}

	public void setMgdossier(Long mgdossier) {
		this.mgdossier = mgdossier;
	}

	public Telephone getTel() {
		return tel;
	}

	public void setTel(Telephone tel) {
		this.tel = tel;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public ArrayList<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(ArrayList<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Naissance getNaissance() {
		return naissance;
	}

	public void setNaissance(Naissance naissance) {
		this.naissance = naissance;
	}

	public Nationalite getNationalite() {
		return nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}

	public ArrayList<Nationalite> getNationalites() {
		return nationalites;
	}

	public void setNationalites(ArrayList<Nationalite> nationalites) {
		this.nationalites = nationalites;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public SituationMedicale getMedicale() {
		return medicale;
	}

	public void setMedicale(SituationMedicale medicale) {
		this.medicale = medicale;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public CoordonneeBancaire getBancaire() {
		return bancaire;
	}

	public void setBancaire(CoordonneeBancaire bancaire) {
		this.bancaire = bancaire;
	}

	public byte[] getContratsigne() {
		return contratsigne;
	}

	public void setContratsigne(byte[] contratsigne) {
		this.contratsigne = contratsigne;
	}

	public ArrayList<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(ArrayList<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public ArrayList<SituationMedicale> getMedicales() {
		return medicales;
	}

	public void setMedicales(ArrayList<SituationMedicale> medicales) {
		this.medicales = medicales;
	}

	public AttachementManager getManager() {
		return manager;
	}

	public void setManager(AttachementManager manager) {
		this.manager = manager;
	}

	public ArrayList<String> getPrefixesMatricule() {
		return prefixesMatricule;
	}

	public void setPrefixesMatricule(ArrayList<String> prefixesMatricule) {
		this.prefixesMatricule = prefixesMatricule;
	}

	public String getPrefixeMat() {
		return prefixeMat;
	}

	public void setPrefixeMat(String prefixeMat) {
		this.prefixeMat = prefixeMat;
	}

	public int getTaillePrefixe() {
		return taillePrefixe;
	}

	public void setTaillePrefixe(int taillePrefixe) {
		this.taillePrefixe = taillePrefixe;
	}

	public int getTailleSuffixe() {
		return tailleSuffixe;
	}

	public void setTailleSuffixe(int tailleSuffixe) {
		this.tailleSuffixe = tailleSuffixe;
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

	public String getDisabledNjf() {
		return disabledNjf;
	}

	public void setDisabledNjf(String disabledNjf) {
		this.disabledNjf = disabledNjf;
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

	public ImputationGa getImputationGa() {
		return imputationGa;
	}

	public void setImputationGa(ImputationGa imputationGa) {
		this.imputationGa = imputationGa;
	}

	public String getValPeriode() {
		return valPeriode;
	}

	public void setValPeriode(String valPeriode) {
		this.valPeriode = valPeriode;
	}

	public StreamedContent getPhotoView() {

		byte[] imageInByte2 = null;
		photoView = null;
		if (photo != null) {

			imageInByte2 = photo;
			InputStream is = new ByteArrayInputStream(imageInByte2);

			photoView = new DefaultStreamedContent(is, "image/png");

		}

		return photoView;
	}

	public void setPhotoView(StreamedContent photoView) {
		this.photoView = photoView;
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

	public ArrayList<Identite> getEmployesCherches() {
		return employesCherches;
	}

	public void setEmployesCherches(ArrayList<Identite> employesCherches) {
		this.employesCherches = employesCherches;
	}

	public String getNumMatricule() {
		return numMatricule;
	}

	public void setNumMatricule(String numMatricule) {
		this.numMatricule = numMatricule;
	}

	

	public String getNumMatriculeManager() {
		return numMatriculeManager;
	}

	public void setNumMatriculeManager(String numMatriculeManager) {
		this.numMatriculeManager = numMatriculeManager;
	}

	public String getNumMatriculeEmploye() {
		return numMatriculeEmploye;
	}

	public void setNumMatriculeEmploye(String numMatriculeEmploye) {
		this.numMatriculeEmploye = numMatriculeEmploye;
	}

	public Identite getIdentiteSelectionne() {
		return identiteSelectionne;
	}

	public void setIdentiteSelectionne(Identite identiteSelectionne) {
		this.identiteSelectionne = identiteSelectionne;
	}


	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Map<String, String> getItems_nationalitePays() {
		afficherListeNationalitePays();
		return items_nationalitePays;
	}

	public void setItems_nationalitePays(
			Map<String, String> items_nationalitePays) {
		this.items_nationalitePays = items_nationalitePays;
	}

	public Map<String, String> getItems_niveauDiplome() {
		
		afficherListeNiveauDiplome();
		return items_niveauDiplome;
	}

	public void setItems_niveauDiplome(Map<String, String> items_niveauDiplome) {
		this.items_niveauDiplome = items_niveauDiplome;
	}

	public Map<String, String> getItems_typeCertificat() {
	
		afficherListeTypeCertificat();
		return items_typeCertificat;
	}

	public void setItems_typeCertificat(Map<String, String> items_typeCertificat) {
		this.items_typeCertificat = items_typeCertificat;
	}

	public Map<String, String> getItems_typeContrat() {
		
		afficherListeTypeContrat();
		return items_typeContrat;
	}

	public void setItems_typeContrat(Map<String, String> items_typeContrat) {
		this.items_typeContrat = items_typeContrat;
	}

	public Map<String, String> getItems_experiencePoste() {
	
		afficherListeExperiencePoste();
		return items_experiencePoste;
	}

	public void setItems_experiencePoste(
			Map<String, String> items_experiencePoste) {
		this.items_experiencePoste = items_experiencePoste;
	}

	public Map<String, String> getItems_experienceSociete() {
	
		afficherListeExperienceSociete();
		return items_experienceSociete;
	}

	public void setItems_experienceSociete(
			Map<String, String> items_experienceSociete) {
		this.items_experienceSociete = items_experienceSociete;
	}

	public Map<String, String> getItems_affectationPoste() {

		afficherListeAffectationPoste();
		return items_affectationPoste;
	}

	public void setItems_affectationPoste(
			Map<String, String> items_affectationPoste) {
		this.items_affectationPoste = items_affectationPoste;
	}

	public Map<String, String> getItems_affectationUniteOrg() {
		
		afficherListeAffectationUniteOrg();
		return items_affectationUniteOrg;
	}

	public void setItems_affectationUniteOrg(
			Map<String, String> items_affectationUniteOrg) {
		this.items_affectationUniteOrg = items_affectationUniteOrg;
	}

	public Map<String, String> getItems_affectationEmploi() {
		
		afficherListeAffectationEmploi();
		return items_affectationEmploi;
	}

	public void setItems_affectationEmploi(
			Map<String, String> items_affectationEmploi) {
		this.items_affectationEmploi = items_affectationEmploi;
	}

	public GestionIdentiteLocal getGestionIdentiteLocal() {
		return gestionIdentiteLocal;
	}

	public void setGestionIdentiteLocal(
			GestionIdentiteLocal gestionIdentiteLocal) {
		this.gestionIdentiteLocal = gestionIdentiteLocal;
	}

	public AttachementManager getAttachementManagerSelectionne() {
		return attachementManagerSelectionne;
	}

	public void setAttachementManagerSelectionne(
			AttachementManager attachementManagerSelectionne) {
		this.attachementManagerSelectionne = attachementManagerSelectionne;
	}

	public AttachementEmploye getAttachementEmployeSelectionne() {
		return attachementEmployeSelectionne;
	}

	public void setAttachementEmployeSelectionne(
			AttachementEmploye attachementEmployeSelectionne) {
		this.attachementEmployeSelectionne = attachementEmployeSelectionne;
	}

	public Nationalite getNationaliteSelectionne() {
		return nationaliteSelectionne;
	}

	public void setNationaliteSelectionne(Nationalite nationaliteSelectionne) {
		this.nationaliteSelectionne = nationaliteSelectionne;
	}

	public SituationMedicale getSituationMedicaleSelectionne() {
		return situationMedicaleSelectionne;
	}

	public void setSituationMedicaleSelectionne(
			SituationMedicale situationMedicaleSelectionne) {
		this.situationMedicaleSelectionne = situationMedicaleSelectionne;
	}

	public Vehicule getVehiculeSelectionne() {
		return vehiculeSelectionne;
	}

	public void setVehiculeSelectionne(Vehicule vehiculeSelectionne) {
		this.vehiculeSelectionne = vehiculeSelectionne;
	}

	public Telephone getTelephoneSelectionne() {
		return telephoneSelectionne;
	}

	public void setTelephoneSelectionne(Telephone telephoneSelectionne) {
		this.telephoneSelectionne = telephoneSelectionne;
	}

	public Mail getMailSelectionne() {
		return mailSelectionne;
	}

	public void setMailSelectionne(Mail mailSelectionne) {
		this.mailSelectionne = mailSelectionne;
	}

	public Adresse getAdresseSelectionne() {
		return adresseSelectionne;
	}

	public void setAdresseSelectionne(Adresse adresseSelectionne) {
		this.adresseSelectionne = adresseSelectionne;
	}

	public DiplomeGa getDiplomeSelectionne() {
		return diplomeSelectionne;
	}

	public void setDiplomeSelectionne(DiplomeGa diplomeSelectionne) {
		this.diplomeSelectionne = diplomeSelectionne;
	}

	public Experience getExperienceSelectionne() {
		return experienceSelectionne;
	}

	public void setExperienceSelectionne(Experience experienceSelectionne) {
		this.experienceSelectionne = experienceSelectionne;
	}

	public Certification getCertificatSelectionne() {
		return certificatSelectionne;
	}

	public void setCertificatSelectionne(Certification certificatSelectionne) {
		this.certificatSelectionne = certificatSelectionne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TypePieceIdentite getTypePieceIdentite() {
		return typePieceIdentite;
	}

	public void setTypePieceIdentite(TypePieceIdentite typePieceIdentite) {
		this.typePieceIdentite = typePieceIdentite;
	}

	public Map<String, String> getItems_TypePieceIdentite() {
		afficherListeTypePiecesIdentite();
		return items_TypePieceIdentite;
	}

	public void setItems_TypePieceIdentite(
			Map<String, String> items_TypePieceIdentite) {
		this.items_TypePieceIdentite = items_TypePieceIdentite;
	}

	public PieceIdentite getPieceIdentite() {
		return pieceIdentite;
	}

	public void setPieceIdentite(PieceIdentite pieceIdentite) {
		this.pieceIdentite = pieceIdentite;
	}

	public ArrayList<PieceIdentite> getPiecesidentite() {
		return piecesidentite;
	}

	public void setPiecesidentite(ArrayList<PieceIdentite> piecesidentite) {
		this.piecesidentite = piecesidentite;
	}

	public ArrayList<AttachementManager> getManagersSelectionnes() {
		return managersSelectionnes;
	}

	public void setManagersSelectionnes(
			ArrayList<AttachementManager> managersSelectionnes) {
		this.managersSelectionnes = managersSelectionnes;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getCodePays() {
		return codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public String getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(String codeBanque) {
		this.codeBanque = codeBanque;
	}

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	public Age getIntervalleAge() {
		return intervalleAge;
	}

	public void setIntervalleAge(Age intervalleAge) {
		this.intervalleAge = intervalleAge;
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

	public RechercheAvancee getRa() {
		return ra;
	}

	public void setRa(RechercheAvancee ra) {
		this.ra = ra;
	}

	public Map<String, String> getItems_sexe() {
		afficherListeSexe();
		return items_sexe;
	}

	public void setItems_sexe(Map<String, String> items_sexe) {
		this.items_sexe = items_sexe;
	}

	public Map<String, String> getItems_qualite() {
		afficherListeQualite();
		return items_qualite;
	}

	public void setItems_qualite(Map<String, String> items_qualite) {
		this.items_qualite = items_qualite;
	}

	public Map<String, String> getItems_typeStatut() {
		afficherListeTypeStatut();
		return items_typeStatut;
	}

	public void setItems_typeStatut(Map<String, String> items_typeStatut) {
		this.items_typeStatut = items_typeStatut;
	}

	public Map<String, String> getItems_situationCivile() {
		afficherListeSituationCivile();
		return items_situationCivile;
	}

	public void setItems_situationCivile(Map<String, String> items_situationCivile) {
		this.items_situationCivile = items_situationCivile;
	}

	public Map<String, String> getItems_natureContrat() {
		afficherListeNatureContrat();
		return items_natureContrat;
	}

	public void setItems_natureContrat(Map<String, String> items_natureContrat) {
		this.items_natureContrat = items_natureContrat;
	}

	public Map<String, String> getItems_situationContrat() {
		afficherListeSituationContrat();
		return items_situationContrat;
	}

	public void setItems_situationContrat(Map<String, String> items_situationContrat) {
		this.items_situationContrat = items_situationContrat;
	}

	public Map<String, String> getItems_affectationCategorie() {
		afficherListeAffectationCategorie();
		return items_affectationCategorie;
	}

	public void setItems_affectationCategorie(
			Map<String, String> items_affectationCategorie) {
		this.items_affectationCategorie = items_affectationCategorie;
	}

	
	
	

	


    
}  