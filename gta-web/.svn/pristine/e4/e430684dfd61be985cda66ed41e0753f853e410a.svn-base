package managedBeans.gtaparam;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;













import javax.annotation.PostConstruct;
import javax.ejb.EJB;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.List_Identity;
import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.sessionbean.ga.identite.GestionIdentite;
import com.yesserp.sessionbean.paramgta.gestiongroupeselect.gestionGroupeSelect;
import com.yesserp.sessionbean.paramgta.gestiongroupeselect.gestionGroupeSelectLocal;

@ManagedBean(name="CalCulJobsBean")
@ViewScoped
public class CalCulJobsBean {
	/*
	 * @EJB GestionJobsLocal gestionJobsLocal;
	 * 
	 * @EJB GestionListGroupe gestionListGroupe;
	 * 
	 * @EJB GestionIdentiteLocal gestionIdentiteLocal;
	 * 
	 * @EJB GestionGpSalarierLocal gestionGpSalarierLocal;
	 * 	@EJB
	gestionGroupeSelect gestionGroupeSelect;
	 */
	@EJB
	gestionGroupeSelectLocal gestionGroupeSelectLocal;
	@EJB
	gestionGroupeSelect gestionGroupeSelect;
	@EJB
	GestionIdentite gestionIdentite;

	private GroupeIdentity groupeSelectSelectionne = new GroupeIdentity();
	private GroupeIdentity groupeSelectSelectionne2 = new GroupeIdentity();
	private List<Identite> selectlistidentite = new ArrayList<>();
	private GroupeIdentity groupe = new GroupeIdentity();
	 private boolean selected;
	// private ArrayList<ListGroupe> groupes = new ArrayList<ListGroupe>();*/
	private List<GroupeIdentity> groupeSelect = new ArrayList<GroupeIdentity>();
	private List<GroupeIdentity> listgroupeSelect = new ArrayList<GroupeIdentity>();
	private boolean headerButtonsDisabled = true;
	// private MyData dataItem;
	    private HtmlInputHidden dataItemId = new HtmlInputHidden();
	/*
	 * private ListGroupe listGroupe = new ListGroupe(); private ListGroupe
	 * LGroupes; private ListGroupePK groupePK; private ListGroupePK
	 * listgroupePK = new ListGroupePK(); private ArrayList<ListGroupe> groupes
	 * = new ArrayList<ListGroupe>();
	 */
	// private List<SelectOneMenu> oneMenusOfGrpSal = new
	// ArrayList<SelectOneMenu>();
	/*
	 * private Identite listeIdentite = new Identite(); private int
	 * num_listGroupe;
	 */
	private String libelle;

	/* private Identite identite; */

	/*
	 * private List<Identite> employesCherches = new ArrayList<Identite>();
	 * private DualListModel<Identite> identitePickList; private List<Identite>
	 * idenditeTarget = new ArrayList<Identite>(); private List<Identite>
	 * idenditeSource = new ArrayList<Identite>();
	 */
	public CalCulJobsBean() {

		// oneMenusOfGrpSal.add(new SelectOneMenu());

	}

	@PostConstruct
	public void init() {
		groupeSelect=gestionGroupeSelect.listeGroupeSelect();
		//this.setGroupeSelectSelectionne2(groupeSelectSelectionne2);
		//this.setListgroupeSelect(gestionGroupeSelect.listeGroupeSelect());
		selectlistidentite=gestionIdentite.findAll();
		//this.setactivitePresences(gestionActivitePresence.findAll());
	/*	for (GroupeIdentity ap : listgroupeSelect) {
			try {
				ap.setGroupelistIdentity(gestionGroupeSelectLocal.listeGroupeSelect());
				ap.setGroupelistIdentity(gestionGroupeSelectLocal.findListGroupeSelecteById(1));
			//ap.set
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		// idenditeSource = gestionGpSalarierLocal.listeSalarier();
		// System.out.println("salarier est "+idenditeSource);
		// identitePickList = new
		// DualListModel<Salarier>(idenditeSource,idenditeTarget);
		// setGroupeSelect(gestionGroupeSelect.listeGroupeSelect());
	}
	  public String editDataItem() {

	        // The dataItem is already set by f:setPropertyActionListener.
	        // Store the ID of the data item in hidden input element.
	        dataItemId.setValue(groupeSelectSelectionne2.getId());

	        return "edit"; // Navigation case.
	    }
	public void selectlistGroupe() {
		// num_listGroupe = groupeSelectSelectionne.getId_groupe();

	}
	

	public void ajoutergroupe() {
		// groupeIdentites.add(groupeIdentite);

		groupeSelectSelectionne.setLibelle(libelle);
	}

	/*
	 * public void selectIdentite() {
	 * 
	 * idenditeTarget = new ArrayList<Identite>(); idenditeSource = new
	 * ArrayList<Identite>(); //idenditeSource =
	 * gestionGpSalarierLocal.listeSalarier();
	 * 
	 * idenditeSource = gestionGpSalarierLocal
	 * .getidentiteInGroupe(groupeIdentite); idenditeTarget =
	 * gestionGpSalarierLocal .getidentiteNotInGroupe(groupeIdentite);
	 * 
	 * 
	 * identitePickList = new DualListModel<Salarier>(idenditeSource,
	 * idenditeTarget); System.out.println("idenditeTarget est" + idenditeTarget
	 * + "idenditeSource est " + idenditeSource); } public void
	 * listeridentitesource(){
	 * 
	 * idenditeSource = gestionGpSalarierLocal.listeSalarier(); identitePickList
	 * = new DualListModel<Salarier>(idenditeSource, idenditeTarget); }
	 */

	/*
	 * @SuppressWarnings("deprecation") public void ajouter() {
	 * 
	 * // groupeIdentites.add(groupeIdentite);
	 * groupeIdentites.add(groupeIdentite);
	 * 
	 * groupeSelectSelectionne.setLibelle(Libelle_groupe); //
	 * groupeSelectSelectionne.setSalariers(identitePickList.getTarget());
	 * groupeSelectSelectionne.setSalariers(groupeIdentite.getSalariers());
	 * gestionGroupeSelect.ajouterGroupeSelect(groupeSelectSelectionne);
	 * 
	 * System.out.println("le groupe identite :" + groupeIdentite.getSalariers()
	 * + "est ajouter a la groupe " + groupeSelectSelectionne.getLibelle()); //
	 * System
	 * .out.println("libelle groupe ajouter est "+groupeSelectSelectionne.getLibelle
	 * ()); // Délibération des variable de la mémoire locale groupeIdentite =
	 * new GroupeIdentite(); groupeIdentites = new ArrayList<>(); }
	 * 
	 * public ArrayList<ListGroupe> getGroupes() { return groupes; }
	 * 
	 * public void setGroupes(ArrayList<ListGroupe> groupes) { this.groupes =
	 * groupes; }
	 * 
	 * public GroupeSelect getGroupeSelectSelectionne() { return
	 * groupeSelectSelectionne; }
	 * 
	 * public void setGroupeSelectSelectionne(GroupeSelect
	 * groupeSelectSelectionne) { this.groupeSelectSelectionne =
	 * groupeSelectSelectionne; }
	 * 
	 * public int getNum_listGroupe() { return num_listGroupe; }
	 * 
	 * public void setNum_listGroupe(int num_listGroupe) { this.num_listGroupe =
	 * num_listGroupe; }
	 * 
	 * public String getLibelle_groupe() { return Libelle_groupe; }
	 * 
	 * public void setLibelle_groupe(String libelle_groupe) { Libelle_groupe =
	 * libelle_groupe; }
	 * 
	 * public Identite getIdentite() { return identite; }
	 * 
	 * public void setIdentite(Identite identite) { this.identite = identite; }
	 * 
	 * public ListGroupe getListGroupe() { return listGroupe; }
	 * 
	 * public void setListGroupe(ListGroupe listGroupe) { this.listGroupe =
	 * listGroupe; }
	 * 
	 * public ListGroupe getLGroupes() { return LGroupes; }
	 * 
	 * public void setLGroupes(ListGroupe lGroupes) { LGroupes = lGroupes; }
	 * 
	 * public ListGroupePK getGroupePK() { return groupePK; }
	 * 
	 * public void setGroupePK(ListGroupePK groupePK) { this.groupePK =
	 * groupePK; }
	 * 
	 * public ListGroupePK getListgroupePK() { return listgroupePK; }
	 * 
	 * public void setListgroupePK(ListGroupePK listgroupePK) {
	 * this.listgroupePK = listgroupePK; }
	 * 
	 * public void setEmployesCherches(ArrayList<Identite> employesCherches) {
	 * this.employesCherches = employesCherches; }
	 * 
	 * public Identite getListeIdentite() { return listeIdentite; }
	 * 
	 * public void setListeIdentite(Identite listeIdentite) { this.listeIdentite
	 * = listeIdentite; }
	 * 
	 * public DualListModel<Salarier> getIdentitePickList() { return
	 * identitePickList; }
	 * 
	 * public void setIdentitePickList(DualListModel<Salarier> identitePickList)
	 * { this.identitePickList = identitePickList; }
	 * 
	 * public List<Identite> getEmployesCherches() { return employesCherches; }
	 *//**
	 * @param employesCherches
	 *            the employesCherches to set
	 */
	/*
	 * public void setEmployesCherches(List<Identite> employesCherches) {
	 * this.employesCherches = employesCherches; }
	 *//**
	 * @return the groupeSelect
	 */
	/*
	 * public List<GroupeSelect> getGroupeSelect() { return groupeSelect; }
	 *//**
	 * @param groupeSelect
	 *            the groupeSelect to set
	 */
	/*
	 * public void setGroupeSelect(List<GroupeSelect> groupeSelect) {
	 * this.groupeSelect = groupeSelect; }
	 *//**
	 * @return the groupe
	 */
	/*
	 * public GroupeSelect getGroupe() { return groupe; }
	 *//**
	 * @param groupe
	 *            the groupe to set
	 */
	/*
	 * public void setGroupe(GroupeSelect groupe) { this.groupe = groupe; }
	 *//**
	 * @return the groupeSelects
	 */
	/*
	 * public List<Salarier> getGroupeSelects() { return groupeSelects; }
	 *//**
	 * @param groupeSelects
	 *            the groupeSelects to set
	 */
	/*
	 * public void setGroupeSelects(List<Salarier> groupeSelects) {
	 * this.groupeSelects = groupeSelects; }
	 * 
	 * public void onButtonAddFieldClick(AjaxBehaviorEvent p_oEvent) {
	 * groupeIdentites.add(groupeIdentite); oneMenusOfGrpSal.add(new
	 * SelectOneMenu());
	 * 
	 * }
	 *//**
	 * @return the oneMenusOfGrpSal
	 */
	/*
	 * public List<SelectOneMenu> getOneMenusOfGrpSal() { return
	 * oneMenusOfGrpSal; }
	 *//**
	 * @param oneMenusOfGrpSal
	 *            the oneMenusOfGrpSal to set
	 */
	/*
	 * public void setOneMenusOfGrpSal(List<SelectOneMenu> oneMenusOfGrpSal) {
	 * this.oneMenusOfGrpSal = oneMenusOfGrpSal; }
	 *//**
	 * @return the idenditeTarget
	 */
	/*
	 * public List<Salarier> getIdenditeTarget() { return idenditeTarget; }
	 *//**
	 * @param idenditeTarget
	 *            the idenditeTarget to set
	 */
	/*
	 * public void setIdenditeTarget(List<Salarier> idenditeTarget) {
	 * this.idenditeTarget = idenditeTarget; }
	 *//**
	 * @return the idenditeSource
	 */
	/*
	 * public List<Salarier> getIdenditeSource() { return idenditeSource; }
	 * 
	 * public GroupeIdentite getGroupeIdentite() { return groupeIdentite; }
	 * 
	 * public void setGroupeIdentite(GroupeIdentite groupeIdentite) {
	 * this.groupeIdentite = groupeIdentite; }
	 * 
	 * public List<GroupeIdentite> getGroupeIdentites() { return
	 * groupeIdentites; }
	 * 
	 * public void setGroupeIdentites(List<GroupeIdentite> groupeIdentites) {
	 * this.groupeIdentites = groupeIdentites; }
	 * 
	 * public void setIdenditeSource(List<Salarier> idenditeSource) {
	 * this.idenditeSource = idenditeSource; }
	 *//**
	 * @param idenditeSource
	 *            the idenditeSource to set
	 */

	public void ajouter() {

		// groupeIdentites.add(groupeIdentite);
		// groupeIdentites.add(groupeIdentite);

		groupeSelectSelectionne.setLibelle(libelle);
		gestionGroupeSelect.ajouterGroupeSelect(groupeSelectSelectionne);
		/*
		 * //
		 * groupeSelectSelectionne.setSalariers(identitePickList.getTarget());
		 * groupeSelectSelectionne.setSalariers(groupeIdentite.getSalariers());
		 * gestionGroupeSelect.ajouterGroupeSelect(groupeSelectSelectionne);
		 * 
		 * System.out.println("le groupe identite :" +
		 * groupeIdentite.getSalariers() + "est ajouter a la groupe " +
		 * groupeSelectSelectionne.getLibelle()); //
		 * System.out.println("libelle groupe ajouter est "
		 * +groupeSelectSelectionne.getLibelle()); // Délibération des variable
		 * de la mémoire locale groupeIdentite = new GroupeIdentite();
		 * groupeIdentites = new ArrayList<>();
		 */
	}
	public void onRowSelectDataTable() {
		this.setHeaderButtonsDisabled(false);
	}
/*	public void modifierGroupeSelect() {
		try {
			List<List_Identity> list_Identity=new ArrayList<List_Identity>();
gestionGroupeSelect.ajouterListeidentity(list_Identity, selectlistidentite);
			gestionGroupeSelect.modifierGroupeSelect(groupeSelectSelectionne);
					.modifierActivitePresence(selectedActivitePresence);
			gestionLibelleLocal.modifierLibelle(selectedActivitePresence
					.getLibelles().get(0));

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							selectedActivitePresence.getCodeap(), "<"
									+ selectedActivitePresence.getLibelles()
											.get(0).getLib()
									+ "> a été modifié avec succès."));

		} catch (Exception exception) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur de modification! "
									+ selectedActivitePresence.getCodeap(),
							"n'a pas pu être modifié."));
		}
	}*/

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
	 * @param selectlistidentite the selectlistidentite to set
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

	public void setGroupeSelectSelectionne2(GroupeIdentity groupeSelectSelectionne2) {
		this.groupeSelectSelectionne2 = groupeSelectSelectionne2;
	}

	/**
	 * @return the headerButtonsDisabled
	 */
	public boolean isHeaderButtonsDisabled() {
		return headerButtonsDisabled;
	}

	/**
	 * @param headerButtonsDisabled the headerButtonsDisabled to set
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
	 * @param dataItemId the dataItemId to set
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
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @param groupeSelect
	 *            the groupeSelect to set
	 */

}
