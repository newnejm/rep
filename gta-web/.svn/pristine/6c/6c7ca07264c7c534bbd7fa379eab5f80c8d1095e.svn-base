package managedBeans.gta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.CodeCalendrier;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gta.DateCalculGta;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.gta.PlanningTheorique;
import com.yesserp.domain.gta.Pointage;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.SemaineType;
import com.yesserp.sessionbean.ga.identite.GestionIdentiteLocal;
import com.yesserp.sessionbean.gta.gestionOccurence.GestionOccurenceLocal;
import com.yesserp.sessionbean.gta.gestioncodecalendrier.GestionCodeCalendrierLocal;
import com.yesserp.sessionbean.gta.gestiondatejournees.GestionDateJourneesLocal;
import com.yesserp.sessionbean.gta.gestionplanningreel.GestionPlanningReelLocal;
import com.yesserp.sessionbean.gta.gestionplanningtheorique.GestionPlanningTheoriqueLocal;
import com.yesserp.sessionbean.paramgta.gestioncodejour.GestionCodeJourLocal;
import com.yesserp.sessionbean.paramgta.gestioncycledetravail.GestionCycleTravailLocal;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeType;
import com.yesserp.sessionbean.paramgta.gestionplagehoraire.GestionPlageHoraireLocal;
import com.yesserp.sessionbean.paramgta.gestionsemainetype.GestionSemaineType;
import com.yesserp.sessionbean.paramgta.gestionsemainetype.GestionSemaineTypeLocal;

@ManagedBean(name="occurenceBean")
@ViewScoped
public class OccurenceBean {
	private Date heurep;
	private Date heurfin;
	private Boolean boolGta;
	private List<ContratGta> listcontratGTA = new ArrayList<>();
	private ContratGta contratGta = new ContratGta();
	private ContratGta contratGtaSelected = new ContratGta();
	private ContratGta contratGtaEdit = new ContratGta();
	private String pointage;
	private String gta;
	private Identite identite = new Identite();
	private List<CycleTravail> cycleTravails = new ArrayList<>();
	private ClasseEmp classeEmp =new ClasseEmp();
	private CycleTravail cycleTravail = new CycleTravail();
	private CodeCalendrier codeCalendrier = new CodeCalendrier();
	private List<Identite> identites = new ArrayList<>();
	private List<CodeCalendrier> codeCalendriers = new ArrayList<>();
	private PlanningTheorique planningTheorique = new PlanningTheorique();
	private List<SemaineType> semaineTypes = new ArrayList<>();
	private DateCalculGta dateJournees = new DateCalculGta();
	private JourneeType journeeType = new JourneeType();
	private Date dateplanning = new Date();
	private CodeJour codeJour = new CodeJour();
	private int nbjours = 7;
	private int nbParcours;
	private int codejournee;
	private String matricul = "";
	private String isGTA = "";
	private String ispointage = "";
	private Identite selectedIdentite;
	private Date dateEffet = new Date();
	private Date dateFin = new Date();
	private boolean soumisGta;
	private boolean saisirPointage;
	 private boolean checked=false;
	    private boolean disabled=false;
	    private String natureHeure;
	
	@EJB
	GestionOccurenceLocal gestionOccurenceLocal;
	@EJB
	GestionCycleTravailLocal gestionCycleTravailLocal;
	@EJB
	GestionIdentiteLocal gestionIdentiteLocal;
	@EJB
	GestionCodeCalendrierLocal gestionCodeCalendrierLocal;
	@EJB
	GestionPlanningTheoriqueLocal gestionPlanningTheoriqueLocal;
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
	GestionPlanningReelLocal gestionPlanningReelLocal;


	public void rowselect() {
		contratGtaEdit=gestionOccurenceLocal.findOccurenceById(selectedIdentite.getContratGta().getId());
		System.out.println("id contrat GET est "+contratGtaEdit.getId());
		dateEffet=contratGtaEdit.getDateeffe();
		dateFin=contratGtaEdit.getDatefin();
		soumisGta=contratGtaEdit.isGta();
		saisirPointage=contratGtaEdit.isPointage();
		natureHeure=contratGtaEdit.getNatureHeure();
		if(soumisGta){
			isGTA="true";
			checked=true;
		}else{
			
			isGTA="false";
			checked=false;
		}
		if(saisirPointage){
			ispointage="true";
			disabled=true;
		}else{
			
			ispointage="false";
			disabled=false;
		}
		 boolGta= Boolean.parseBoolean(isGTA);
		System.out.println("isGTA"+isGTA);
			
	}
	public void ajoutcontratGTA(){
		
		if (saisirPointage) {
			contratGta.setPointage(true);
		} else {
			contratGta.setPointage(false);
		}
		
		if (soumisGta) {
			contratGta.setGta(true);
		} else {
			contratGta.setGta(false);
		}
		contratGta.setDateeffe(dateEffet);
		contratGta.setDatefin(dateFin);
		contratGta.setNatureHeure(natureHeure);
		contratGta.setIdentite(selectedIdentite);
		gestionOccurenceLocal.ajouterOccurence(contratGta);
		selectedIdentite.setContratGta(contratGta);
		gestionIdentiteLocal.modifierIdentite(selectedIdentite);
		System.out.println("nature Heure est "+natureHeure);
	}
	
	public void ModifiercontratGTA(){
		
	/*	if (contratGtaSelected.isPointage()){
			
			contratGta.setPointage(true);
		}else{
			contratGta.setPointage(false);
		}
		if (contratGtaSelected.isPointage()){
			contratGta.setGta(true);
		}else{
			contratGta.setGta(false);
		}
		contratGta.setDateeffe(contratGtaSelected.getDateeffe());
		contratGta.setDatefin(contratGtaSelected.getDatefin());
		contratGta.setNatureHeure(contratGtaSelected.getNatureHeure());*/
		gestionOccurenceLocal.modifierOccurence(contratGtaSelected);
		//selectedIdentite.setContratGta(contratGta);
		//gestionIdentiteLocal.modifierIdentite(selectedIdentite);
	}
	public void chargerGTAByIdentity(){
		contratGtaEdit=gestionOccurenceLocal.findOccurenceById(contratGtaSelected.getId());
		/*System.out.println("id contrat GET est "+contratGtaEdit.getId());
		dateEffet=contratGtaEdit.getDateeffe();
		dateFin=contratGtaEdit.getDatefin();
		soumisGta=contratGtaEdit.isGta();
		saisirPointage=contratGtaEdit.isPointage();
		natureHeure=contratGtaEdit.getNatureHeure();
		if(soumisGta){
			isGTA="true";
			checked=true;
		}else{
			
			isGTA="false";
			checked=false;
		}
		if(saisirPointage){
			ispointage="true";
			disabled=true;
		}else{
			
			ispointage="false";
			disabled=false;
		}
		 boolGta= Boolean.parseBoolean(isGTA);
		System.out.println("isGTA"+isGTA);*/
			
	
		
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
	gestionPlanningReelLocal.AjouterPlaningReel(planningReel);
/*		PlanningTheorique planningTheorique=new PlanningTheorique();
		planningTheorique.setDatePlanning(date);
		planningTheorique.setIdentite(selectedIdentite);
		gestionPlanningTheoriqueLocal.ajouterPlanningTh(planningTheorique);
		*/
	}
	public void ajoutOccurence() {
		if (gta.equals("oui")) {
			contratGta.setPointage(true);
		} else {
			contratGta.setPointage(false);
		}
		if (pointage.equals("oui")) {
			contratGta.setGta(true);
		} else {
			contratGta.setGta(false);
		}
		
		
		
		gestionOccurenceLocal.ajouterOccurence(contratGta);
		cycleTravail = gestionCycleTravailLocal
				.findCycleTravailById(cycleTravail.getIdct());
		gestionCycleTravailLocal.affectCycleToEmployee(identite, cycleTravail,
				contratGta.getDateeffe());
		identite.setCodeCalendrier(codeCalendrier);
		identite.setContratGta(contratGta);
		gestionIdentiteLocal.modifierIdentite(identite);

		if (contratGta.isGta()) {
			planningTheorique.setIdentite(identite);
			planningTheorique.setDatePlanning(contratGta.getDateeffe());
			gestionPlanningTheoriqueLocal.ajouterPlanningTh(planningTheorique);
			semaineTypes = gestionSemaineTypeLocal
					.findSemaineTypeForCycle(cycleTravail);
			dateplanning = planningTheorique.getDatePlanning();

		}

		contratGta = new ContratGta();
		planningTheorique = new PlanningTheorique();
		System.out.println("Ajout effectué");
	}

	@PostConstruct
	public void init() {
		cycleTravails = gestionCycleTravailLocal.listerCycleTravail();
		identites = gestionIdentiteLocal.findAll();
		codeCalendriers = gestionCodeCalendrierLocal.findAllCodeCalendriers();

	}
	public void onRowSelect(SelectEvent event) {
		listcontratGTA=gestionOccurenceLocal.findAllContratByIdentite(selectedIdentite);
		//contratGtaEdit=gestionOccurenceLocal.findContratByIdentite(selectedIdentite);
		//listcontratGTA=gestionOccurenceLocal.findAllContratById(selectedIdentite.getContratGta().getId());
		/*disabledBtnPlus = "false";
		pointages=gestionPointageLocal.findPointageByIdentite(selectedIdentite);
		pointages=new ArrayList<Pointage>();
		pointages=gestionPointageLocal.findPointageByIdentite(selectedIdentite);*/
	}
	public void chargercontrat() {
		listcontratGTA=gestionOccurenceLocal.findAllContratByIdentite(selectedIdentite);
		//contratGtaEdit=gestionOccurenceLocal.findContratByIdentite(selectedIdentite);
		//listcontratGTA=gestionOccurenceLocal.findAllContratById(selectedIdentite.getContratGta().getId());
		/*disabledBtnPlus = "false";
		pointages=gestionPointageLocal.findPointageByIdentite(selectedIdentite);
		pointages=new ArrayList<Pointage>();
		pointages=gestionPointageLocal.findPointageByIdentite(selectedIdentite);*/
	}
	public ContratGta getOccurence() {
		return contratGta;
	}

	public void setOccurence(ContratGta contratGta) {
		this.contratGta = contratGta;
	}

	


	public String getPointage() {
		return pointage;
	}

	public void setPointage(String pointage) {
		this.pointage = pointage;
	}

	public String getGta() {
		return gta;
	}

	public void setGta(String gta) {
		this.gta = gta;
	}

	public List<CycleTravail> getCycleTravails() {
		return cycleTravails;
	}

	public void setCycleTravails(List<CycleTravail> cycleTravails) {
		this.cycleTravails = cycleTravails;
	}

	public CycleTravail getCycleTravail() {
		return cycleTravail;
	}

	public void setCycleTravail(CycleTravail cycleTravail) {
		this.cycleTravail = cycleTravail;
	}

	public List<Identite> getIdentites() {
		return identites;
	}

	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}

	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}


	public CodeCalendrier getCodeCalendrier() {
		return codeCalendrier;
	}

	public void setCodeCalendrier(CodeCalendrier codeCalendrier) {
		this.codeCalendrier = codeCalendrier;
	}

	public List<CodeCalendrier> getCodeCalendriers() {
		return codeCalendriers;
	}

	public void setCodeCalendriers(List<CodeCalendrier> codeCalendriers) {
		this.codeCalendriers = codeCalendriers;
	}

	public List<SemaineType> getSemaineTypes() {
		return semaineTypes;
	}

	public void setSemaineTypes(List<SemaineType> semaineTypes) {
		this.semaineTypes = semaineTypes;
	}

	public DateCalculGta getDateJournees() {
		return dateJournees;
	}

	public void setDateJournees(DateCalculGta dateJournees) {
		this.dateJournees = dateJournees;
	}

	public Date getDateplanning() {
		return dateplanning;
	}

	public void setDateplanning(Date dateplanning) {
		this.dateplanning = dateplanning;
	}

	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public int getNbjours() {
		return nbjours;
	}

	public void setNbjours(int nbjours) {
		this.nbjours = nbjours;
	}

	public int getNbParcours() {
		return nbParcours;
	}

	public void setNbParcours(int nbParcours) {
		this.nbParcours = nbParcours;
	}

	
	


	public int getCodejournee() {
		return codejournee;
	}

	public void setCodejournee(int codejournee) {
		this.codejournee = codejournee;
	}

	public CodeJour getCodeJour() {
		return codeJour;
	}

	public void setCodeJour(CodeJour codeJour) {
		this.codeJour = codeJour;
	}

	public String annuler(){
		return null ;
	}

	public ClasseEmp getClasseEmp() {
		return classeEmp;
	}

	public void setClasseEmp(ClasseEmp classeEmp) {
		this.classeEmp = classeEmp;
	}

	/**
	 * @return the selectedIdentite
	 */
	public Identite getSelectedIdentite() {
		return selectedIdentite;
	}

	/**
	 * @param selectedIdentite the selectedIdentite to set
	 */
	public void setSelectedIdentite(Identite selectedIdentite) {
		this.selectedIdentite = selectedIdentite;
	}

	/**
	 * @return the matricul
	 */
	public String getMatricul() {
		return matricul;
	}

	/**
	 * @param matricul the matricul to set
	 */
	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}
	/**
	 * @return the dateEffet
	 */
	public Date getDateEffet() {
		return dateEffet;
	}
	/**
	 * @param dateEffet the dateEffet to set
	 */
	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}
	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * @return the soumisGta
	 */
	public boolean isSoumisGta() {
		return soumisGta;
	}
	/**
	 * @param soumisGta the soumisGta to set
	 */
	public void setSoumisGta(boolean soumisGta) {
		this.soumisGta = soumisGta;
	}
	/**
	 * @return the saisirPointage
	 */
	public boolean isSaisirPointage() {
		return saisirPointage;
	}
	/**
	 * @param saisirPointage the saisirPointage to set
	 */
	public void setSaisirPointage(boolean saisirPointage) {
		this.saisirPointage = saisirPointage;
	}
	/**
	 * @return the contratGtaEdit
	 */
	public ContratGta getContratGtaEdit() {
		return contratGtaEdit;
	}
	/**
	 * @param contratGtaEdit the contratGtaEdit to set
	 */
	public void setContratGtaEdit(ContratGta contratGtaEdit) {
		this.contratGtaEdit = contratGtaEdit;
	}
	/**
	 * @return the isGTA
	 */
	public String getIsGTA() {
		return isGTA;
	}
	/**
	 * @param isGTA the isGTA to set
	 */
	public void setIsGTA(String isGTA) {
		this.isGTA = isGTA;
	}
	/**
	 * @return the ispointage
	 */
	public String getIspointage() {
		return ispointage;
	}
	/**
	 * @param ispointage the ispointage to set
	 */
	public void setIspointage(String ispointage) {
		this.ispointage = ispointage;
	}
	/**
	 * @return the boolGta
	 */
	public Boolean getBoolGta() {
		return boolGta;
	}
	/**
	 * @param boolGta the boolGta to set
	 */
	public void setBoolGta(Boolean boolGta) {
		this.boolGta = boolGta;
	}
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}
	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * @return the natureHeure
	 */
	public String getNatureHeure() {
		return natureHeure;
	}
	/**
	 * @param natureHeure the natureHeure to set
	 */
	public void setNatureHeure(String natureHeure) {
		this.natureHeure = natureHeure;
	}
	/**
	 * @return the heurep
	 */
	public Date getHeurep() {
		return heurep;
	}
	/**
	 * @param heurep the heurep to set
	 */
	public void setHeurep(Date heurep) {
		this.heurep = heurep;
	}
	/**
	 * @return the heurfin
	 */
	public Date getHeurfin() {
		return heurfin;
	}
	/**
	 * @param heurfin the heurfin to set
	 */
	public void setHeurfin(Date heurfin) {
		this.heurfin = heurfin;
	}
	/**
	 * @return the contratGtaSelected
	 */
	public ContratGta getContratGtaSelected() {
		return contratGtaSelected;
	}
	/**
	 * @param contratGtaSelected the contratGtaSelected to set
	 */
	public void setContratGtaSelected(ContratGta contratGtaSelected) {
		this.contratGtaSelected = contratGtaSelected;
	}
	/**
	 * @return the listcontratGTA
	 */
	public List<ContratGta> getListcontratGTA() {
		return listcontratGTA;
	}
	/**
	 * @param listcontratGTA the listcontratGTA to set
	 */
	public void setListcontratGTA(List<ContratGta> listcontratGTA) {
		this.listcontratGTA = listcontratGTA;
	}
	
}
