package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.DescJourneeTypeModel;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.yesserp.domain.dao.gta.RefPointageDao;
import com.yesserp.domain.entities.RefPointage;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;
import com.yesserp.domain.gtaparam.RefAbscence;
import com.yesserp.sessionbean.paramgta.gestionDescJourneeType.GestionDescJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionRefAbscence.GestionRefAbscenceLocal;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;
import com.yesserp.sessionbean.paramgta.gestionplagehoraire.GestionPlageHoraireLocal;

@ManagedBean
@ViewScoped
public class DescJourneeTypeBean {

	@EJB
	GestionDescJourneeTypeLocal gestionDescJourneeType;
	@EJB
	GestionPlageHoraireLocal gestionPlageHoraire;
	@EJB
	GestionLibelleLocal gestionLibelle;
	@EJB
	GestionRefAbscenceLocal gestionRefAbscence;
	@EJB
	RefPointageDao refPointageDao;
	@EJB
	GestionJourneeTypeLocal gestionJourneeType;

	private List<DescJourneeTypeModel> descJourneeTypeList;
	private DescJourneeTypeModel descJourneeTypeModel;
	private List<PlageHoraire> plageHoraires2;
	private List<PlageHoraireDescJourneeType> plageHoraireDesJtList;
	private List<JourneeType> journeeTypeList;
	private List<RefAbscence> refAbscences;
	private List<Libelle> libelleList;
	private Integer SelectedRefAbscence;

	private PlageHoraire selectedPlageHoraire;
	private Libelle selectedLibelle;
	private JourneeType selectedJourneeType;

	private RefPointage refPointage;
	

	private RefAbscence refAbscence;
	private List<RefPointage> refPointages;
	private DescJourneeTypeModel selectedDescJourneeType;

	@PostConstruct
	public void init() {
		initDescJourneeType();
		initJourneeType();
	}

	public void initDescJourneeType() {
		if (descJourneeTypeList == null) {
			descJourneeTypeList = new ArrayList<DescJourneeTypeModel>();
		}
		List<DescJourneeType> descJourneeTypes = gestionDescJourneeType
				.AfficherTousDescJourneeType();
		if (descJourneeTypes != null && !descJourneeTypes.isEmpty()) {
			for (DescJourneeType descJourneeType : descJourneeTypes) {
				descJourneeTypeList.add(new DescJourneeTypeModel());
				descJourneeTypeList.get(descJourneeTypeList.size() - 1)
						.setDescJourneeType(descJourneeType);
			}
		}
	}

	public void addDescJourneeType() {

		descJourneeTypeModel = new DescJourneeTypeModel();
		initPlageHoraireDescJt();
		initRefAbscence();
		initRefPointage();
		if (descJourneeTypeList != null && !descJourneeTypeList.isEmpty()) {
			descJourneeTypeList.add(new DescJourneeTypeModel());
			DescJourneeTypeModel descJourneeType = descJourneeTypeList.get(descJourneeTypeList.size() - 1);
			descJourneeType.setDescJourneeType(descJourneeTypeModel.getDescJourneeType());
		}
	}

	public void saveDesJourneeType() {

		if (descJourneeTypeList == null) {
			descJourneeTypeList = new ArrayList<DescJourneeTypeModel>();
		}

		List<DescJourneeType> descJourneeTypes2 = new ArrayList<DescJourneeType>();

		// descJourneeTypes2.set(0, descJourneeTypeModel.getDescJourneeType());

		descJourneeTypes2.add(descJourneeTypeModel.getDescJourneeType());

		gestionJourneeType.modifierJourneeType(selectedJourneeType);

		selectedJourneeType.setDescJourneeTypes(descJourneeTypes2);
		
		descJourneeTypeModel.getDescJourneeType().setJourneeType(selectedJourneeType);

		gestionDescJourneeType.ajouterDescJourneeType(descJourneeTypeModel.getDescJourneeType());

		// Sauvegarder PlageHoraire
		if (plageHoraireDesJtList != null && !plageHoraireDesJtList.isEmpty()) {
			
			for (PlageHoraireDescJourneeType phDjt : plageHoraireDesJtList) {
				
				phDjt.getDescJourneeType().setId(descJourneeTypeModel.getDescJourneeType().getId());
				
				gestionDescJourneeType.associatePlageHoraireToDescJourneeType(phDjt.getDescJourneeType().getId(),phDjt.getPlageHoraire(), phDjt.getHeure());

			}

		}
		// Sauvegarder RefAbscence
		if (refAbscences != null && !refAbscences.isEmpty()) {
			for (RefAbscence refAbscence : refAbscences) {
				gestionRefAbscence.ajouterRefAbscence(refAbscence);
			}
		}
		// Sauvegarder Refpointage
		if (refPointages != null && !refPointages.isEmpty()) {
			for (RefPointage refPointage : refPointages) {
				refPointageDao.create(refPointage);
			}
		}

	}
	
	

	public void removeDescJourneeType() {
		if (selectedDescJourneeType != null) {
			JourneeType JourneeType = selectedDescJourneeType.getDescJourneeType().getJourneeType();
			gestionDescJourneeType.supprimerDescJourneeType(selectedDescJourneeType.getDescJourneeType());
			for (DescJourneeTypeModel descJT : descJourneeTypeList) {
				if (selectedDescJourneeType.getDescJourneeType().getId() == descJT
						.getDescJourneeType().getId()) {
					descJourneeTypeList.remove(descJT);
					break;
				}
			}
			if (JourneeType != null) {
				gestionJourneeType.modifierJourneeType(JourneeType);
			}
		}
	}
	
	
	

	public void initPlageHoraireDescJt() {
		plageHoraireDesJtList = new ArrayList<PlageHoraireDescJourneeType>();
		setPlageHoraires2(gestionPlageHoraire.findAllPlagesHoraire());
	}

	public void addPlageHoraireDescJt() {
		if (plageHoraireDesJtList == null) {
			plageHoraireDesJtList = new ArrayList<PlageHoraireDescJourneeType>();
		}
		plageHoraireDesJtList.add(new PlageHoraireDescJourneeType());
		PlageHoraireDescJourneeType plageHoraireDesJt = plageHoraireDesJtList.get(plageHoraireDesJtList.size() - 1);
		plageHoraireDesJt.setDescJourneeType(new DescJourneeType());
		plageHoraireDesJt.setPlageHoraire(new PlageHoraire());
	}

	public void initRefAbscence() {

		//if (refAbscences == null) {
			setRefAbscences(new ArrayList<RefAbscence>());
	//	}

	}

	public void addRefAbscence() {
		if (refAbscences == null) {
			refAbscences = new ArrayList<RefAbscence>();
		}
		
		
		refAbscences.add(new RefAbscence());
		refAbscence = refAbscences.get(refAbscences.size() - 1);
		refAbscence.setDescJourneeType(descJourneeTypeModel
				.getDescJourneeType());

	}

	public void initRefPointage() {
//		if (refPointages == null) {
			setRefPointages(new ArrayList<RefPointage>());
	//	}
	}

	public void addRefPointage() {
		// if (refPointages != null && !refPointages.isEmpty()) {
		refPointages.add(new RefPointage());
		refPointage = refPointages.get(refPointages.size() - 1);
		refPointage.setDescJourneeType(descJourneeTypeModel
				.getDescJourneeType());
		// }
	}

	/************************* Gestion Journ�e Type ***************************/
	public void initJourneeType() {
		journeeTypeList = gestionJourneeType.listerJourneeType();
	}

	public void onJTRowSelect() {

		JourneeType currentJourneeType = gestionJourneeType.findJourneeTypeById(selectedJourneeType.getIdjt());

		descJourneeTypeList = new ArrayList<DescJourneeTypeModel>();

		List<DescJourneeType> currentDescJourneeType = gestionDescJourneeType.getDescJourneeTypesByJourneeType(currentJourneeType);

		for (DescJourneeType descJourneeType : currentDescJourneeType) {

			if (descJourneeType != null) {

				descJourneeTypeList.add(new DescJourneeTypeModel());

				descJourneeTypeList.get(descJourneeTypeList.size() - 1).setDescJourneeType(descJourneeType);
			}
		}
	}

	/*************************************************************************/

	public void getLibelleListByPlageHoraire(Integer idph){
		if(idph != null){
			libelleList = gestionLibelle.findLibelleByPlageHoraire(idph);
			if(libelleList != null && !libelleList.isEmpty()){
				selectedLibelle = libelleList.get(0);
			}
		}
		if(idph == -1){
			selectedLibelle = null;
		}
	}
	
	public List<DescJourneeTypeModel> getDescJourneeTypeList() {
		return descJourneeTypeList;
	}

	public RefPointage getRefPointage() {
		return refPointage;
	}

	public List<RefPointage> getRefPointages() {
		return refPointages;
	}

	public void setRefPointage(RefPointage refPointage) {
		this.refPointage = refPointage;
	}

	public void setRefPointages(List<RefPointage> refPointages) {
		this.refPointages = refPointages;
	}

	public void setDescJourneeTypeList(
			List<DescJourneeTypeModel> descJourneeTypeList) {
		this.descJourneeTypeList = descJourneeTypeList;
	}

	public DescJourneeTypeModel getDescJourneeTypeModel() {
		return descJourneeTypeModel;
	}

	public void setDescJourneeTypeModel(
			DescJourneeTypeModel descJourneeTypeModel) {
		this.descJourneeTypeModel = descJourneeTypeModel;
	}

	
	public List<PlageHoraireDescJourneeType> getPlageHoraireDesJtList() {
		return plageHoraireDesJtList;
	}

	public void setPlageHoraireDesJtList(
			List<PlageHoraireDescJourneeType> plageHoraireDesJtList) {
		this.plageHoraireDesJtList = plageHoraireDesJtList;
	}

	public List<RefAbscence> getRefAbscences() {
		return refAbscences;
	}

	public void setRefAbscences(List<RefAbscence> refAbscences) {
		this.refAbscences = refAbscences;
	}

	public Integer getSelectedRefAbscence() {
		return SelectedRefAbscence;
	}

	public void setSelectedRefAbscence(Integer selectedRefAbscence) {
		SelectedRefAbscence = selectedRefAbscence;
	}

	public RefAbscence getRefAbscence() {
		return refAbscence;
	}

	public void setRefAbscence(RefAbscence refAbscence) {
		this.refAbscence = refAbscence;
	}

	public PlageHoraire getSelectedPlageHoraire() {
		return selectedPlageHoraire;
	}

	public void setSelectedPlageHoraire(PlageHoraire selectedPlageHoraire) {
		this.selectedPlageHoraire = selectedPlageHoraire;
	}

	public List<JourneeType> getJourneeTypeList() {
		return journeeTypeList;
	}

	public void setJourneeTypeList(List<JourneeType> journeeTypeList) {
		this.journeeTypeList = journeeTypeList;
	}

	public JourneeType getSelectedJourneeType() {
		return selectedJourneeType;
	}

	public void setSelectedJourneeType(JourneeType selectedJourneeType) {
		this.selectedJourneeType = selectedJourneeType;
	}

	public List<Libelle> getLibelleList() {
		return libelleList;
	}

	public void setLibelleList(List<Libelle> libelleList) {
		this.libelleList = libelleList;
	}

	public Libelle getSelectedLibelle() {
		return selectedLibelle;
	}

	public void setSelectedLibelle(Libelle selectedLibelle) {
		this.selectedLibelle = selectedLibelle;
	}
	public DescJourneeTypeModel getSelectedDescJourneeType() {
		return selectedDescJourneeType;
	}

	public void setSelectedDescJourneeType(
			DescJourneeTypeModel selectedDescJourneeType) {
		this.selectedDescJourneeType = selectedDescJourneeType;
	}

	public List<PlageHoraire> getPlageHoraires2() {
		return plageHoraires2;
	}

	public void setPlageHoraires2(List<PlageHoraire> plageHoraires2) {
		this.plageHoraires2 = plageHoraires2;
	}
}
