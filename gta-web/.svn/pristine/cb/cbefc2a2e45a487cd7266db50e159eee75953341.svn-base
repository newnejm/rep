package managedBeans.gta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ActiviteReelCalculer;
import com.yesserp.domain.gta.ActiviteReelSaisie;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.gta.Pointage;
import com.yesserp.domain.gta.Terminal;
import com.yesserp.domain.gta.TypePointage;
import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.SemaineType;
import com.yesserp.sessionbean.ga.identite.GestionIdentiteLocal;
import com.yesserp.sessionbean.gta.gestionAbsence.GestionAbsenceLocal;
import com.yesserp.sessionbean.gta.gestionactivitereelcalculer.GestionActiviteReelCalculerLocal;
import com.yesserp.sessionbean.gta.gestionactivitereelsaisie.GestionActiviteReelSaisieLocal;
import com.yesserp.sessionbean.gta.gestiondatejournees.GestionDateJourneesLocal;
import com.yesserp.sessionbean.gta.gestionplanningreel.GestionPlanningReelLocal;
import com.yesserp.sessionbean.gta.gestionpointage.GestionPointageLocal;
import com.yesserp.sessionbean.paramgta.gestionactivitepresence.GestionActivitePresenceLocal;
import com.yesserp.sessionbean.paramgta.gestioncodejour.GestionCodeJourLocal;
import com.yesserp.sessionbean.paramgta.gestionhorairedereferenceabsence.GestionHoraireDeReferenceAbsenceLocal;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeType;
import com.yesserp.sessionbean.paramgta.gestionplagehoraire.GestionPlageHoraireLocal;
import com.yesserp.sessionbean.paramgta.gestionsemainetype.GestionSemaineTypeLocal;
import com.yesserp.sessionbean.paramgta.tranche.GestionTrancheLocal;

@ManagedBean(name="planingCalculerBean")
@ViewScoped	
public class PlaningCalculerBean {
	private List<PlageHoraire> plageHorairess = new ArrayList<PlageHoraire>();
	private PlageHoraire plageHoraire = new PlageHoraire();
	private PlageHoraire plageHoraireAjout = new PlageHoraire();
	private TimelineModel model;
	private String locale; // current locale as String, java.util.Locale is
							// possible too.
	private Date heurep;
		private Date dateEffet = new Date();
	private Date heurfin;
	private Date start;
	private Date end;
	private TimelineEvent event;
	private boolean timeChangeable = true;
	//private Tache selected;
	private String idemp;
	private String idemp3;
	private String idp;
	private String idsp;
	private List<PlanningReel>planningReels;
	private List<PlageHoraire>plageHoraires;
	private Identite selectedIdentite;
	private List<Identite>identites;
	@EJB
	GestionIdentiteLocal gestionIdentiteLocal;
	@EJB
	GestionPlanningReelLocal gestionPlanningReelLocal;
	@EJB
	GestionAbsenceLocal gestionAbsenceLocal;
	@EJB
	GestionActiviteReelSaisieLocal gestionActiviteReelSaisieLocal;
	@EJB
	GestionActiviteReelCalculerLocal gestionActiviteReelCalculerLocal;
	@EJB
	GestionActivitePresenceLocal gestionActivitePresenceLocal;
	@EJB
	GestionTrancheLocal gestionTrancheLocal;
	@EJB
	GestionHoraireDeReferenceAbsenceLocal gestionHoraireDeReferenceAbsenceLocal;
	@EJB
	GestionPointageLocal gestionPointageLocal;
	@EJB
	GestionSemaineTypeLocal gestionSemaineTypeLocal;
	@EJB
	GestionDateJourneesLocal gestionDateJourneesLocal;
	@EJB
	GestionCodeJourLocal gestionCodeJourLocal;
	@EJB
	GestionPlageHoraireLocal gestionPlageHoraireLocal;
	@EJB
	GestionJourneeType gestionJourneeTypeLocal;
	@EJB
	private GestionIdentiteLocal gestionIdentite;
	@PostConstruct
	public void init() {
		selectedIdentite = new Identite();
			// pointages = gestionPointageLocal.listPointage();
	identites=gestionIdentite.findAll();
	plageHorairess=gestionPlageHoraireLocal.findAllPlagesHoraire();
	}
	public void AjouterPlanigthorique(){
		Date date=new Date();
		PlageHoraire plageHoraire=new PlageHoraire();
		JourneeType journeeType=new JourneeType();
		SemaineType semaineType=new SemaineType();
		plageHoraire=gestionPlageHoraireLocal.findPlageHoraireById(1);
		journeeType=gestionJourneeTypeLocal.findJourneeTypeById(1);
		semaineType=gestionSemaineTypeLocal.findSemaineByID(1);
		PlanningReel planningReel=new PlanningReel();
		planningReel.setIdentite(selectedIdentite);
		planningReel.setJourneeType(journeeType);
		planningReel.setSemaineType(semaineType);
		planningReel.setDate(dateEffet);
		planningReel.setHeuredeb(heurep);
		planningReel.setHeurefin(heurfin);
		planningReel.setPlageHoraire(plageHoraireAjout);
		System.out.println("plageHoraire ajouter est "+plageHoraireAjout.getCodeph());
	gestionPlanningReelLocal.AjouterPlaningReel(planningReel);
/*		PlanningTheorique planningTheorique=new PlanningTheorique();
		planningTheorique.setDatePlanning(date);
		planningTheorique.setIdentite(selectedIdentite);
		gestionPlanningTheoriqueLocal.ajouterPlanningTh(planningTheorique);
		*/
	}
	// Selection d'un identite
	public void chargerPointages() {

		
		planningReels = new ArrayList<PlanningReel>();
		planningReels=gestionPlanningReelLocal.findAll(selectedIdentite);
	}

	public void onRowSelect(SelectEvent event2) {
	
		planningReels=gestionPlanningReelLocal.findAll(selectedIdentite);
		System.out.println("selctes identite est "+selectedIdentite.getNom()+selectedIdentite.getPrenom());
		plageHoraires = gestionPlageHoraireLocal.findAllPlagesHoraire();
		// groups
		List<String> NAMES = new ArrayList<String>();
		for (int i = 0; i < plageHoraires.size(); i++) {
			NAMES.add(plageHoraires.get(i).getTypePlage());

		}

		// create timeline model
		model = new TimelineModel();
		String name;

		int deb;
		int fin;
		int year;
		int month;
		int day;
		int h;
		int hf;
		int m;
		int mf;
		int se;

		

				// Tache tyuo = taches.get(0);
				for (int j = 0; j < planningReels.size(); j++) {
					name = planningReels.get(j).getPlageHoraire().getTypePlage();

					Date start = new Date();
					end = new Date();
					year = planningReels.get(j).getDate().getYear();

					month = planningReels.get(j).getDate().getMonth();
					day = planningReels.get(j).getDate().getDate();

					h = planningReels.get(j).getHeuredeb().getHours();
					m = planningReels.get(j).getHeuredeb().getMinutes();
					se = planningReels.get(j).getHeuredeb().getSeconds();

					month = planningReels.get(j).getDate().getMonth();
					day = planningReels.get(j).getDate().getDate();
					hf = planningReels.get(j).getHeurefin().getHours();
					mf = planningReels.get(j).getHeurefin().getMinutes();
					se = planningReels.get(j).getHeurefin().getSeconds();

					start = new Date(year, month, day, h, m);
					end = new Date(year, month, day, hf, mf);

					long r = Math.round(Math.random() * 2);
					String availability = (r == 0 ? "Unavailable"
							: (r == 1 ? "Available" : "Maybe"));

			
				

					event = new TimelineEvent(planningReels.get(j).getPlageHoraire().getTypePlage(), start, end, true, selectedIdentite.getNumedoss()+ ":" + selectedIdentite.getNom(),
							availability.toLowerCase());
					model.add(event);

				}


				for (int j = 0; j < planningReels.size(); j++) {
					System.out.println("plage horaire est "+planningReels.get(j).getPlageHoraire().getTypePlage());}
	}
	public TimelineModel getModel() throws ParseException{
			
		return model;
	}
		public void setModel(TimelineModel model) {
		this.model = model;
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
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public TimelineEvent getEvent() {
		return event;
	}
	public void setEvent(TimelineEvent event) {
		this.event = event;
	}
	public boolean isTimeChangeable() {
		return timeChangeable;
	}
	public void setTimeChangeable(boolean timeChangeable) {
		this.timeChangeable = timeChangeable;
	}
	public String getIdemp() {
		return idemp;
	}
	public void setIdemp(String idemp) {
		this.idemp = idemp;
	}
	public String getIdemp3() {
		return idemp3;
	}
	public void setIdemp3(String idemp3) {
		this.idemp3 = idemp3;
	}
	public String getIdp() {
		return idp;
	}
	public void setIdp(String idp) {
		this.idp = idp;
	}
	public String getIdsp() {
		return idsp;
	}
	public void setIdsp(String idsp) {
		this.idsp = idsp;
	}
	/**
	 * @return the planningReels
	 */
	public List<PlanningReel> getPlanningReels() {
		return planningReels;
	}
	/**
	 * @param planningReels the planningReels to set
	 */
	public void setPlanningReels(List<PlanningReel> planningReels) {
		this.planningReels = planningReels;
	}
	/**
	 * @return the plageHoraires
	 */
	public List<PlageHoraire> getPlageHoraires() {
		return plageHoraires;
	}
	/**
	 * @param plageHoraires the plageHoraires to set
	 */
	public void setPlageHoraires(List<PlageHoraire> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}
	/**
	 * @return the identites
	 */
	public List<Identite> getIdentites() {
		return identites;
	}
	/**
	 * @param identites the identites to set
	 */
	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}
	public Identite getSelectedIdentite() {
		return selectedIdentite;
	}
	public void setSelectedIdentite(Identite selectedIdentite) {
		this.selectedIdentite = selectedIdentite;
	}
	/**
	 * @return the plageHorairess
	 */
	public List<PlageHoraire> getPlageHorairess() {
		return plageHorairess;
	}
	/**
	 * @param plageHorairess the plageHorairess to set
	 */
	public void setPlageHorairess(List<PlageHoraire> plageHorairess) {
		this.plageHorairess = plageHorairess;
	}
	/**
	 * @return the plageHoraire
	 */
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}
	/**
	 * @param plageHoraire the plageHoraire to set
	 */
	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}
	/**
	 * @return the plageHoraireAjout
	 */
	public PlageHoraire getPlageHoraireAjout() {
		return plageHoraireAjout;
	}
	/**
	 * @param plageHoraireAjout the plageHoraireAjout to set
	 */
	public void setPlageHoraireAjout(PlageHoraire plageHoraireAjout) {
		this.plageHoraireAjout = plageHoraireAjout;
	}
	public Date getHeurep() {
		return heurep;
	}
	public void setHeurep(Date heurep) {
		this.heurep = heurep;
	}
	public Date getDateEffet() {
		return dateEffet;
	}
	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}
	public Date getHeurfin() {
		return heurfin;
	}
	public void setHeurfin(Date heurfin) {
		this.heurfin = heurfin;
	}
	
	
	
	
	
	
}

