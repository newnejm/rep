package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.DescSemaineTypeModel;

import com.yesserp.domain.gtaparam.CycleAssociateJourneeTypeEmbeddebale;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.CycleTravailAssociateJourneeType;
import com.yesserp.domain.gtaparam.DescCycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeTypeDescCycleTravail;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.SemaineType;
import com.yesserp.domain.gtaparam.SemaineTypeDescCycleTravail;
import com.yesserp.sessionbean.paramgta.gestionDescCycleTravail.GestionDescCycleTravailLocal;
import com.yesserp.sessionbean.paramgta.gestionDescSemaineType.GestionDescSemaineTypeLocal;
import com.yesserp.sessionbean.paramgta.gestioncycledetravail.GestionCycleTravailLocal;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;
import com.yesserp.sessionbean.paramgta.gestionsemainetype.GestionSemaineTypeLocal;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean
@ViewScoped
public class CycleBean {

	private CycleTravail cycleTravail = new CycleTravail();

	private List<SemaineType> semaineTypes;
	private List<JourneeType> listajout = new ArrayList<>();
	private JourneeType journeeType = new JourneeType();
	private Libelle libelle = new Libelle();

	private List<CycleTravailAssociateJourneeType> ctajtList = new ArrayList<>();
	private CycleTravailAssociateJourneeType ctajt = new CycleTravailAssociateJourneeType();
	private List<JourneeType> journeesAjout = new ArrayList<>();
	private List<Integer> ordreJours = new ArrayList<>();
	private List<CycleTravail> cycleTravails = new ArrayList<>();
	private CycleTravail selectedCT = new CycleTravail();

	private List<DescCycleTravail> descCycleTravails = new ArrayList<DescCycleTravail>();
	private Integer descCycleTravailMode = 0;
	private List<SemaineTypeDescCycleTravail> semaineTypeDesCtList;
	private SemaineType semaineType;
	private DescCycleTravail descCycleTravail;
	private List<JourneeType> journeeTypes;
	private List<JourneeTypeDescCycleTravail> journeeTypeDesCtList;
	private Boolean rendredSelectMode = true;

	private List<CycleTravail> cycleTravailList;

	private List<Libelle> libelleList;
	private List<Libelle> libelleList2;

	private JourneeType selectedJourneeType;
	private Libelle selectedLibelle;
	private CycleTravail selectedCycleTravail;
	
	private DescCycleTravail currentDescCycleTravail;
	private Date dateEffet;

	private DescCycleTravail selectedDescCycleTravail;
	@EJB
	GestionCycleTravailLocal gestionCycleTravailLocal;
	@EJB
	GestionDescCycleTravailLocal gestionDescCycleTravail;
	@EJB
	GestionLibelleLocal gestionLibelleLocal;
	@EJB
	GestionJourneeTypeLocal gestionJourneeTypeLocal;
	@EJB
	GestionSemaineTypeLocal gestionSemaineType;

	public void ajouter() {
		// cycleTravail.setJourneeTypes(listajout);
		// cycleTravail.setJourneeTypes(listajout);
		
		cycleTravail.setTypeCycle("j");
		
		libelleList2 = gestionLibelleLocal.findLibelleByCycleTravail(cycleTravail.getIdct()) ;
		libelleList2.add(libelle);
		cycleTravail.setLibelles(libelleList2);
		libelle.setCycleTravail(cycleTravail);
		gestionCycleTravailLocal.ajoutCycleTravail(cycleTravail);
	//	gestionLibelleLocal.ajoutLibelle(libelle);
		
	//	gestionLibelleLocal.modifierLibelle(libelle);

		gestionCycleTravailLocal.findCycleDeTravailParCode(cycleTravail
				.getCodect());

		definirCycleTravail();
		cycleTravails.add(cycleTravail);
		init();
		cycleTravail = new CycleTravail();
		libelle = new Libelle();

	}

	@PostConstruct
	public void init() {

		journeeTypes = gestionJourneeTypeLocal.listerJourneeType();
		cycleTravails = gestionCycleTravailLocal.findCycleTravailByType("j");

		initDescCycleTravail();
		initCycleTravail();
		for (int i = 0; i < cycleTravails.size(); i++) {
			try {
				cycleTravails.get(i).setLibelles(
						gestionLibelleLocal
								.findLibelleByCycleTravail(cycleTravails.get(i)
										.getIdct()));

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void definirCycleTravail() {

		for (int i = 0; i < ctajtList.size(); i++) {
			journeesAjout.add(ctajtList.get(i).getJourneeType());
			ordreJours.add(ctajtList.get(i)
					.getAssociateJourneeTypeEmbeddebale().getOrdreJournee());
		}
		try {
			gestionCycleTravailLocal.associateCycleTravailToJourneeType(
					cycleTravail.getIdct(), journeesAjout, ordreJours);
		} catch (Exception e) {
			e.printStackTrace();
		}
		journeesAjout = new ArrayList<>();
		ctajt = new CycleTravailAssociateJourneeType();
		ctajtList = new ArrayList<>();
		ordreJours = new ArrayList<>();

	}

	public void addDefJtp() {
		ctajt.setAssociateJourneeTypeEmbeddebale(new CycleAssociateJourneeTypeEmbeddebale());
		ctajtList.add(ctajt);
		ctajt = new CycleTravailAssociateJourneeType();
	}

	public void removeDefCtp() {
		ctajtList.remove(ctajtList.size() - 1);
		ctajt = new CycleTravailAssociateJourneeType();
	}
	
	
	public void removeCycleTravail()
	
	{
		
		gestionCycleTravailLocal.supprimerCycleTravail(selectedCT);
		
		cycleTravails.remove(selectedCT);
		
	}
	
	
	
	public void modiferCycleTravailType() {
		gestionCycleTravailLocal.modifierCycleTravail(selectedCT);
	}
	

	/**************************** DescCycleTravail *********************************/

	public void initDescCycleTravail() {
		if (descCycleTravails == null) {
			descCycleTravails = new ArrayList<DescCycleTravail>();
		}
	}

	public void selectDescCycleTravailMode() {
		if (descCycleTravailMode == 1) {
			initSemaineTypeDescCt();
		} else if (descCycleTravailMode == 2) {
			initJourneeTypeDescCt();
		}
		setRendredSelectMode(false);
	}

	public void addDescCycleTravail() {
		rendredSelectMode = true;
		initJourneeTypeDescCt();
		initSemaineTypeDescCt();
		if (descCycleTravails != null) {
			descCycleTravails.add(new DescCycleTravail());
		}
	}

	public void saveDesCycleTravail2() {

		// List<DescCycleTravail> descCycleTravails2 = new
		// ArrayList<DescCycleTravail>();

		// descCycleTravails2.set(0,
		// descCycleTravailModel.getDescCycleTravail());

		

	//	gestionDescCycleTravail.ajouterDescCycleTravail(descCycleTravail);

		// Sauvegarder JourneeType
		/*
		 * if (journeeTypeDesCtList != null && !journeeTypeDesCtList.isEmpty())
		 * {
		 * 
		 * for (JourneeTypeDescCycleTravail phDjt : journeeTypeDesCtList) {
		 * 
		 * phDjt.getDescCycleTravail().setId(descCycleTravailModel.
		 * getDescCycleTravail().getId());
		 * 
		 * gestionDescCycleTravail.associateJourneeTypeToDescCycleTravail(phDjt.
		 * getDescCycleTravail().getId(),phDjt.getJourneeType(),
		 * phDjt.getHeure());
		 * 
		 * }
		 * 
		 * }
		 */

	}
	
	public void saveDescCycleTravail() {
		
		
		
		if (descCycleTravails != null && !descCycleTravails.isEmpty()) {
			 currentDescCycleTravail = descCycleTravails.get(descCycleTravails.size() - 1);
			 
			 
			// descCycleTravails.add(currentDescCycleTravail);

				gestionCycleTravailLocal.modifierCycleTravail(selectedCT);

				selectedCT.setDescCycleTravails(descCycleTravails);

				currentDescCycleTravail.setCycleTravail(selectedCT);
				currentDescCycleTravail.setDateEffet(dateEffet);
				
			currentDescCycleTravail = gestionDescCycleTravail.ajouterDescCycleTravail(currentDescCycleTravail);
			if (descCycleTravailMode == 1) {
				if (semaineTypeDesCtList != null	&& !semaineTypeDesCtList.isEmpty()) {
					currentDescCycleTravail.setSemaineTypeDescCycleTravails(semaineTypeDesCtList);
					int indexSemaineType = 1;
					for (SemaineTypeDescCycleTravail semaineTypeDescCycleTravail : currentDescCycleTravail.getSemaineTypeDescCycleTravails()) {
						gestionDescCycleTravail.associateSemaineTypeToDescCycleTravail(currentDescCycleTravail.getIdDescCT(),semaineTypeDescCycleTravail.getSemaineType().getIdst(),indexSemaineType);
						indexSemaineType++;
					}
				}
			} else if (descCycleTravailMode == 2) {
				if (journeeTypeDesCtList != null
						&& !journeeTypeDesCtList.isEmpty()) {
					currentDescCycleTravail.setJourneeTypeDescCycleTravails(journeeTypeDesCtList);
					int indexJourneeType = 1;
					for (JourneeTypeDescCycleTravail journeeTypeDescCycleTravail : currentDescCycleTravail.getJourneeTypeDescCycleTravails()) {
						gestionDescCycleTravail.associateJourneeTypeToDescCycleTravail(currentDescCycleTravail.getIdDescCT(),journeeTypeDescCycleTravail.getJourneeType().getIdjt(),indexJourneeType);
						indexJourneeType++;
					}
				}
			}
		}
		// Réinitialiser les listes pour le prochain ajout de descCycleTravail
		semaineTypeDesCtList = null;
		journeeTypeDesCtList = null;
		setDateEffet(null);
	}

	
	
public void removeDescCycleTravail()
	
	{
		
		gestionDescCycleTravail.supprimerDescCycleTravail(selectedDescCycleTravail);
		
		descCycleTravails.remove(selectedCT);
		
		init();
		
	}
	
	
	
	
	
	
	
	
	/*
	 * public void removeDescCycleTravail() { if (selectedDescCycleTravail !=
	 * null) { CycleTravail CycleTravail =
	 * selectedDescCycleTravail.getCycleTravail();
	 * gestionDescCycleTravail.supprimerDescCycleTravail
	 * (selectedDescCycleTravail); for (DescCycleTravailModel descJT :
	 * descCycleTravailList) { if
	 * (selectedDescCycleTravail.getDescCycleTravail().getId() == descJT
	 * .getDescCycleTravail().getId()) { descCycleTravailList.remove(descJT);
	 * break; } } if (CycleTravail != null) {
	 * gestionCycleTravailLocal.modifierCycleTravail(CycleTravail); } } }
	 */

	public void initJourneeTypeDescCt() {
		journeeTypeDesCtList = new ArrayList<JourneeTypeDescCycleTravail>();
		journeeTypes = gestionJourneeTypeLocal.listerJourneeType();
	}

	public void addJourneeTypeDescCt() {
		if (journeeTypeDesCtList == null) {
			journeeTypeDesCtList = new ArrayList<JourneeTypeDescCycleTravail>();
		}

		JourneeTypeDescCycleTravail currentjourneeTypeDescCycleTravail = new JourneeTypeDescCycleTravail();
		currentjourneeTypeDescCycleTravail
				.setDescCycleTravail(new DescCycleTravail());

		currentjourneeTypeDescCycleTravail.setJourneeType(new JourneeType());
		journeeTypeDesCtList.add(currentjourneeTypeDescCycleTravail);

		// descCycleTravail.setJourneeTypeDescCycleTravails(journeeTypeDesCtList);

		// JourneeType currentjourneeType = new JourneeType() ;

		// currentjourneeType.setJourneeTypeDescCycleTravails(journeeTypeDesCtList);
	}

	public void initSemaineTypeDescCt() {
		semaineTypeDesCtList = new ArrayList<SemaineTypeDescCycleTravail>();
		semaineTypes = gestionSemaineType.listeSemaineType();
	}

	public void addSemaineTypeDescCt() {
		
		
		libelleList = null ;	
		
		if (semaineTypeDesCtList == null) {
			semaineTypeDesCtList = new ArrayList<SemaineTypeDescCycleTravail>();
		}

		SemaineTypeDescCycleTravail currentsemaineTypeDescCycleTravail = new SemaineTypeDescCycleTravail();

		currentsemaineTypeDescCycleTravail
				.setDescCycleTravail(new DescCycleTravail());

		currentsemaineTypeDescCycleTravail.setSemaineType(new SemaineType());
		semaineTypeDesCtList.add(currentsemaineTypeDescCycleTravail);

		// descCycleTravail.setSemaineTypeDescCycleTravails(semaineTypeDesCtList);

		// SemaineType currentsemaineType = new SemaineType() ;

		// currentsemaineType.setSemaineTypeDescCycleTravails(semaineTypeDesCtList);
	}

	/******* Gestion Journée Type *****/
	public void initCycleTravail() {
		cycleTravailList = gestionCycleTravailLocal.listerCycleTravail();
	}

	public void onJTRowSelect() {

		CycleTravail currentCycleTravail = gestionCycleTravailLocal.findCycleTravailById(selectedCT.getIdct());
		
	//	if(currentCycleTravail != null){
			
			List<DescCycleTravail> loadedDescCycleTravails = gestionDescCycleTravail.getDescCycleTravailsByCycleTravail(currentCycleTravail);
			
			//if (loadedDescCycleTravails != null && !loadedDescCycleTravails.isEmpty()) {
				
			descCycleTravails = loadedDescCycleTravails;
			
			//}
	//	}
	}

	/*************************************************************************/

	public void getLibelleListByJourneeType(Integer idph) {
		if (idph != null) {
			libelleList = gestionLibelleLocal.findLibelleByjourneeType(idph);
			if (libelleList != null ) {
				selectedLibelle = libelleList.get(0);
			}
		}
		if (idph == -1) {
			selectedLibelle = null;
		}
	}

	
	
	
	
	public void getLibelleListBySemaineType(Integer idst){
		
		selectedLibelle = null ;
		if(idst != null){
			libelleList = gestionLibelleLocal.findLibelleBySemaineType(idst);
			if(libelleList != null && !libelleList.isEmpty()){
				selectedLibelle = libelleList.get(0);
			}
		}
		if(idst == -1){
			selectedLibelle = null;
		}
	}
	
	
	
	
	
	
	
	/*******************************************************************************/
	public CycleTravail getCycleTravail() {
		return cycleTravail;
	}

	public void setCycleTravail(CycleTravail cycleTravail) {
		this.cycleTravail = cycleTravail;
	}

	public List<JourneeType> getJourneeTypes() {
		return journeeTypes;
	}

	public void setJourneeTypes(List<JourneeType> journeeTypes) {
		this.journeeTypes = journeeTypes;
	}

	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public Libelle getLibelle() {
		return libelle;
	}

	public void setLibelle(Libelle libelle) {
		this.libelle = libelle;
	}

	public List<JourneeType> getListajout() {
		return listajout;
	}

	public void setListajout(List<JourneeType> listajout) {
		this.listajout = listajout;
	}

	public List<CycleTravailAssociateJourneeType> getCtajtList() {
		return ctajtList;
	}

	public void setCtajtList(List<CycleTravailAssociateJourneeType> ctajtList) {
		this.ctajtList = ctajtList;
	}

	public CycleTravailAssociateJourneeType getCtajt() {
		return ctajt;
	}

	public void setCtajt(CycleTravailAssociateJourneeType ctajt) {
		this.ctajt = ctajt;
	}

	public List<JourneeType> getJourneesAjout() {
		return journeesAjout;
	}

	public void setJourneesAjout(List<JourneeType> journeesAjout) {
		this.journeesAjout = journeesAjout;
	}

	public List<Integer> getOrdreJours() {
		return ordreJours;
	}

	public void setOrdreJours(List<Integer> ordreJours) {
		this.ordreJours = ordreJours;
	}

	public List<CycleTravail> getCycleTravails() {
		return cycleTravails;
	}

	public void setCycleTravails(List<CycleTravail> cycleTravails) {
		this.cycleTravails = cycleTravails;
	}

	public CycleTravail getSelectedCT() {
		return selectedCT;
	}

	public void setSelectedCT(CycleTravail selectedCT) {
		this.selectedCT = selectedCT;
	}

	public List<DescCycleTravail> getDescCycleTravails() {
		return descCycleTravails;
	}

	public void setDescCycleTravails(List<DescCycleTravail> descCycleTravails) {
		this.descCycleTravails = descCycleTravails;
	}

	public DescCycleTravail getSelectedDescCycleTravail() {
		return selectedDescCycleTravail;
	}

	public void setSelectedDescCycleTravail(
			DescCycleTravail selectedDescCycleTravail) {
		this.selectedDescCycleTravail = selectedDescCycleTravail;
	}

	public Integer getDescCycleTravailMode() {
		return descCycleTravailMode;
	}

	public void setDescCycleTravailMode(Integer descCycleTravailMode) {
		this.descCycleTravailMode = descCycleTravailMode;
	}

	public List<SemaineType> getSemaineTypes() {
		return semaineTypes;
	}

	public void setSemaineTypes(List<SemaineType> semaineTypes) {
		this.semaineTypes = semaineTypes;
	}

	public SemaineType getSemaineType() {
		return semaineType;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

	public DescCycleTravail getDescCycleTravail() {
		return descCycleTravail;
	}

	public void setDescCycleTravail(DescCycleTravail descCycleTravail) {
		this.descCycleTravail = descCycleTravail;
	}

	public List<CycleTravail> getCycleTravailList() {
		return cycleTravailList;
	}

	public void setCycleTravailList(List<CycleTravail> cycleTravailList) {
		this.cycleTravailList = cycleTravailList;
	}

	public List<Libelle> getLibelleList() {
		return libelleList;
	}

	public void setLibelleList(List<Libelle> libelleList) {
		this.libelleList = libelleList;
	}

	public JourneeType getSelectedJourneeType() {
		return selectedJourneeType;
	}

	public void setSelectedJourneeType(JourneeType selectedJourneeType) {
		this.selectedJourneeType = selectedJourneeType;
	}

	public Libelle getSelectedLibelle() {
		return selectedLibelle;
	}

	public void setSelectedLibelle(Libelle selectedLibelle) {
		this.selectedLibelle = selectedLibelle;
	}

	public CycleTravail getSelectedCycleTravail() {
		return selectedCycleTravail;
	}

	public void setSelectedCycleTravail(CycleTravail selectedCycleTravail) {
		this.selectedCycleTravail = selectedCycleTravail;
	}

	public String redirect() {

		return "/gtaparam/ajoutcalendrier.jsf?faces-redirect=true";
	}

	public List<JourneeTypeDescCycleTravail> getJourneeTypeDesCtList() {
		return journeeTypeDesCtList;
	}

	public List<SemaineTypeDescCycleTravail> getSemaineTypeDesCtList() {
		return semaineTypeDesCtList;
	}

	public void setJourneeTypeDesCtList(
			List<JourneeTypeDescCycleTravail> journeeTypeDesCtList) {
		this.journeeTypeDesCtList = journeeTypeDesCtList;
	}

	public void setSemaineTypeDesCtList(
			List<SemaineTypeDescCycleTravail> semaineTypeDesCtList) {
		this.semaineTypeDesCtList = semaineTypeDesCtList;
	}

	public Boolean getRendredSelectMode() {
		return rendredSelectMode;
	}

	public void setRendredSelectMode(Boolean rendredSelectMode) {
		this.rendredSelectMode = rendredSelectMode;
	}

	public DescCycleTravail getCurrentDescCycleTravail() {
		return currentDescCycleTravail;
	}

	public void setCurrentDescCycleTravail(DescCycleTravail currentDescCycleTravail) {
		this.currentDescCycleTravail = currentDescCycleTravail;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public List<Libelle> getLibelleList2() {
		return libelleList2;
	}

	public void setLibelleList2(List<Libelle> libelleList2) {
		this.libelleList2 = libelleList2;
	}

}
