package managedBeans.gtaparam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.FlowEvent;

import com.yesserp.domain.ga.Administrateur;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.Jobs;
import com.yesserp.domain.gta.Jobscreate;
import com.yesserp.domain.gta.ParametreJobs;
import com.yesserp.domain.gta.Planification_Jobs;
import com.yesserp.domain.pg.QualiteIdentite;
import com.yesserp.sessionbean.gta.gestionjobs.gestionJobs;
import com.yesserp.sessionbean.paramgta.gestiongroupeselect.gestionGroupeSelect;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;

@ManagedBean(name = "JobsBean")
@ViewScoped
public class JobsBean {
	
	///parametre planification 
	
	private int planifId;
	private Date dateDebutPlanif;
	private Date dateFinPlanif;
	private String frequencePlanif;
	private int nbrJoursPlanif;
	private Date heureDebutPlanif;
	private String JoursPlanif;

	
	////
	private String statut;
	private String type_action;
	private Date date_debut;
	private Date heure_debut;
	private Date date_create;
	private int repeat;
	   private String mois;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	// private Map<String, String> items_groupe = new LinkedHashMap<String,
	// String>();
	private Administrateur admin2;
	private Jobs jobs = new Jobs();
	private ParametreJobs param_Jobs_Excute = new ParametreJobs();
	private Planification_Jobs planification_Jobs = new Planification_Jobs();
	private Administrateur admin = new Administrateur();
	private GroupeIdentity groupeIdentity = new GroupeIdentity();
	private List<GroupeIdentity> groupeIdentities = new ArrayList<GroupeIdentity>();
	private GroupeIdentity groupeIdentity2 = new GroupeIdentity();
	private List<Jobscreate> jobscreates = new ArrayList<Jobscreate>();
	private Jobscreate jobscreateselctione = new Jobscreate();
    private List<String> cities;
	private boolean skip;


	@EJB
	gestionJobs gestionJobs;
	@EJB
	gestionGroupeSelect gestionGroupeSelect;

	@PostConstruct
	public void init() {
		admin2 = gestionJobs.trouveradminbyid(1);
		date_create = date;
		groupeIdentities = gestionGroupeSelect.listeGroupeSelect();
		jobscreates = gestionJobs.listeJobs();
		// System.out.println(jobscreates.get(0));
		 cities = new ArrayList<String>();
	        cities.add("Janvier");
	        cities.add("Fevrier");
	        cities.add("Mars");
	        cities.add("Avril");
	        cities.add("Mai");
	        cities.add("juin");
	        cities.add("juillet");
	        cities.add("Aout");
	        cities.add("Septemebre");
	        cities.add("Octobre");
	        cities.add("Novembre");
	        cities.add("Decembre");
	}

	public void ajouterJobs() {
		// log_Admin admin=new log_Admin();
		ParametreJobs excute = new ParametreJobs();
		Jobscreate jobscreate = new Jobscreate();
		GroupeIdentity groupeIdentity3 = new GroupeIdentity();
		groupeIdentity3 = groupeIdentity;
		excute.setType_action(type_action);
		excute.setDateJobs(date_debut);
		excute.setHeure_debut(heure_debut);
		gestionJobs.addparam(excute);
		// gestionJobs.addAdmin(admin2);

		jobscreate.setStatut(statut);
		// jobscreate.setId_groupe(groupeIdentity.getId());
		// System.out.println("id groupe select est " + groupeIdentity.getId());
		// jobscreate.setGroupeIdentities(groupeIdentity2);
		// jobscreate.setGroupeIdentities(groupeIdentities);
		// gestionJobs.ajouterJobscreate(jobscreate);
		System.out.println("ahouter jos befor");
		gestionJobs.addnewJobs(admin2, excute, date_create, statut,
				groupeIdentity.getId());

		// gestionJobs.addnewJobscrate(admin, excute, groupeIdentity3,
		// date_create, statut);
		// jobscreate.setGroupeIdentities(groupeIdentities);
		// gestionJobs.modifierJobscreate(jobscreate);

		// jobs.setDate_effet(date_debut);
		// excute.setType_action(type_action);
		// gestionJobs.addJobs(jobs);
		// excute.setDateJobs(date_create);
		/*
		 * gestionJobs.addJobs(jobs); gestionJobs.addparam(excute);
		 */
		// planification_Jobs.setDate_debut(date_debut);
		// gestionJobs.addnewJobs(jobs,excute);
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip=false;
			return "panelactdec";
		}

		 else {
	            return event.getOldStep();
	        }

	}

	/*
	 * public void afficherListeQualite() { items_groupe.clear(); try { List
	 * list = gestionGroupeSelect.listeGroupeSelect(); Iterator iter =
	 * list.iterator(); if (!iter.hasNext()) {
	 * System.out.println("La liste est vide"); } else
	 * System.out.println("not empty");
	 * 
	 * while (iter.hasNext()) { GroupeIdentity c = (GroupeIdentity) iter.next();
	 * 
	 * items_groupe.put(c.getLibelle(), c.getLibelle().toString()); } } catch
	 * (Exception e) { System.out.println(e.getMessage()); } }
	 */
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	


	/*	public boolean isSkip2() {
		return skip2;
	}

	public void setSkip2(boolean skip2) {
		this.skip2 = skip2;
	}

	public boolean isSkip3() {
		return skip3;
	}

	public void setSkip3(boolean skip3) {
		this.skip3 = skip3;
	}
*/
	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public ParametreJobs getParam_Jobs_Excute() {
		return param_Jobs_Excute;
	}

	public void setParam_Jobs_Excute(ParametreJobs param_Jobs_Excute) {
		this.param_Jobs_Excute = param_Jobs_Excute;
	}

	public Planification_Jobs getPlanification_Jobs() {
		return planification_Jobs;
	}

	public void setPlanification_Jobs(Planification_Jobs planification_Jobs) {
		this.planification_Jobs = planification_Jobs;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType_action() {
		return type_action;
	}

	public void setType_action(String type_action) {
		this.type_action = type_action;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_create() {
		return date_create;
	}

	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the admin2
	 */
	public Administrateur getAdmin2() {
		return admin2;
	}

	/**
	 * @param admin2
	 *            the admin2 to set
	 */
	public void setAdmin2(Administrateur admin2) {
		this.admin2 = admin2;
	}

	/**
	 * @return the items_groupe
	 */
	/*
	 * public Map<String, String> getItems_groupe() { afficherListeQualite();
	 * return items_groupe; }
	 *//**
	 * @param items_groupe
	 *            the items_groupe to set
	 */
	/*
	 * public void setItems_groupe(Map<String, String> items_groupe) {
	 * this.items_groupe = items_groupe; }
	 */

	/**
	 * @return the groupeIdentity
	 */
	public GroupeIdentity getGroupeIdentity() {
		return groupeIdentity;
	}

	/**
	 * @param groupeIdentity
	 *            the groupeIdentity to set
	 */
	public void setGroupeIdentity(GroupeIdentity groupeIdentity) {
		this.groupeIdentity = groupeIdentity;
	}

	/**
	 * @return the groupeIdentity2
	 */
	public GroupeIdentity getGroupeIdentity2() {
		return groupeIdentity2;
	}

	/**
	 * @param groupeIdentity2
	 *            the groupeIdentity2 to set
	 */
	public void setGroupeIdentity2(GroupeIdentity groupeIdentity2) {
		this.groupeIdentity2 = groupeIdentity2;
	}

	/**
	 * @return the groupeIdentities
	 */
	public List<GroupeIdentity> getGroupeIdentities() {
		return groupeIdentities;
	}

	/**
	 * @param groupeIdentities
	 *            the groupeIdentities to set
	 */
	public void setGroupeIdentities(List<GroupeIdentity> groupeIdentities) {
		this.groupeIdentities = groupeIdentities;
	}

	public List<Jobscreate> getJobscreates() {
		return jobscreates;
	}

	public void setJobscreates(List<Jobscreate> jobscreates) {
		this.jobscreates = jobscreates;
	}

	public Jobscreate getJobscreateselctione() {
		return jobscreateselctione;
	}

	public void setJobscreateselctione(Jobscreate jobscreateselctione) {
		this.jobscreateselctione = jobscreateselctione;
	}

	/**
	 * @return the heure_debut
	 */
	public Date getHeure_debut() {
		return heure_debut;
	}

	/**
	 * @param heure_debut
	 *            the heure_debut to set
	 */
	public void setHeure_debut(Date heure_debut) {
		this.heure_debut = heure_debut;
	}

	/**
	 * @return the repeat
	 */
	public int getRepeat() {
		return repeat;
	}

	/**
	 * @param repeat the repeat to set
	 */
	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public int getPlanifId() {
		return planifId;
	}

	public void setPlanifId(int planifId) {
		this.planifId = planifId;
	}

	public Date getDateDebutPlanif() {
		return dateDebutPlanif;
	}

	public void setDateDebutPlanif(Date dateDebutPlanif) {
		this.dateDebutPlanif = dateDebutPlanif;
	}

	public Date getDateFinPlanif() {
		return dateFinPlanif;
	}

	public void setDateFinPlanif(Date dateFinPlanif) {
		this.dateFinPlanif = dateFinPlanif;
	}

	public String getFrequencePlanif() {
		return frequencePlanif;
	}

	public void setFrequencePlanif(String frequencePlanif) {
		this.frequencePlanif = frequencePlanif;
	}

	public int getNbrJoursPlanif() {
		return nbrJoursPlanif;
	}

	public void setNbrJoursPlanif(int nbrJoursPlanif) {
		this.nbrJoursPlanif = nbrJoursPlanif;
	}

	public Date getHeureDebutPlanif() {
		return heureDebutPlanif;
	}

	public void setHeureDebutPlanif(Date heureDebutPlanif) {
		this.heureDebutPlanif = heureDebutPlanif;
	}

	/**
	 * @return the joursPlanif
	 */
	public String getJoursPlanif() {
		return JoursPlanif;
	}

	/**
	 * @param joursPlanif the joursPlanif to set
	 */
	public void setJoursPlanif(String joursPlanif) {
		JoursPlanif = joursPlanif;
	}



	
	
}
