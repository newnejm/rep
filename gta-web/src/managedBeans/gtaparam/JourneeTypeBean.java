package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;

import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.gtaparam.PlageHAssociateJourneeTPK;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;

import org.primefaces.context.RequestContext;

import com.yesserp.domain.dao.gta.RefPointageDao;
import com.yesserp.domain.entities.RefPointage;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;
import com.yesserp.domain.gtaparam.RefAbscence;
import com.yesserp.domain.gtaparam.RefAbscence;
import com.yesserp.domain.pg.Parametres_system;
import com.yesserp.sessionbean.paramgta.gestionDescJourneeType.GestionDescJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionRefAbscence.GestionRefAbscenceLocal;
import com.yesserp.sessionbean.paramgta.gestionplagehoraire.GestionPlageHoraireLocal;

import models.DescJourneeTypeModel;
import models.RefPointageModel;

@ManagedBean
@SessionScoped
public class JourneeTypeBean {
	private JourneeType journeeType = new JourneeType();
	private Libelle libelle = new Libelle();
	private List<JourneeType> journeeTypes = new ArrayList<>();
	//private JourneeType selectedJourneeType = new JourneeType();
	private List<PlageHoraire> plageHoraires = new ArrayList<>();
	private PlageHoraire plageHoraire = new PlageHoraire();
	private List<Integer> heures = new ArrayList<>();
	private List<Integer> heuresFin = new ArrayList<>();
	private boolean headerButtonsDisabled = true;
	
	 private boolean skip;

	
	private PlageHoraireAssociateJourneeType phajtp=new PlageHoraireAssociateJourneeType();
	private ArrayList<PlageHoraireAssociateJourneeType> phajtpList=new ArrayList<>();
	
	private PlageHoraireAssociateJourneeType selectedPhajtp=new PlageHoraireAssociateJourneeType();
	private ArrayList<PlageHoraireAssociateJourneeType> selectedPhajtpList=new ArrayList<>();
	
	
	
	
	/*********varible descrption journeetype*****/
	
	
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
	
	
	

	@EJB
	GestionJourneeTypeLocal gestionJourneeTypeLocal;
	@EJB
	GestionLibelleLocal gestionLibelleLocal;
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

	@PostConstruct
	public void init() {
		
		initDescJourneeType();
		initJourneeType();
		selectedJourneeType=selectedJourneeType;
		journeeTypes = gestionJourneeTypeLocal.listerJourneeType();
		for (int i = 0; i < journeeTypes.size(); i++) {
			try {
				journeeTypes.get(i).setLibelles(
						gestionLibelleLocal
								.findLibelleByjourneeType(journeeTypes.get(i)
										.getIdjt()));

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public boolean isHeaderButtonsDisabled() {
		
		return headerButtonsDisabled;
	}

	public void onRowSelectDataTable() {
		this.setHeaderButtonsDisabled(false);
	}

	public void setHeaderButtonsDisabled(boolean headerButtonsDisabled) {
		this.headerButtonsDisabled = headerButtonsDisabled;
	}
	
	public void ajouterJourneeType() {
		gestionJourneeTypeLocal.ajoutJourneeType(journeeType);
		gestionLibelleLocal.ajoutLibelle(libelle);
		libelle.setJourneeType(journeeType);
		gestionLibelleLocal.modifierLibelle(libelle);
		libelle = new Libelle();
gestionJourneeTypeLocal.findJourneeTypeByCode(journeeType.getCodejt());
		definirJourneeType();
		journeeType = new JourneeType();

		init();
	}

	public void supprimerJourneeType() {
		Libelle lib = selectedJourneeType.getLibelles().get(0);
		
		try {
			
			gestionJourneeTypeLocal.supprimerJourneeType(selectedJourneeType);
			
            
		} catch (Exception e) {
			e.printStackTrace();
			gestionLibelleLocal
					.modifierLibelle(lib);
		}
		init();	
	}

	public void modiferJourneeType() {
		gestionJourneeTypeLocal.modifierJourneeType(selectedJourneeType);
	}

	public void definirJourneeType() {
		
		for(int i=0;i<phajtpList.size();i++)
		{
			plageHoraires.add(phajtpList.get(i).getPlageHoraire());
			heures.add(phajtpList.get(i).gethAssociateJourneeTPK().getHeureDeb());
			heuresFin.add(phajtpList.get(i).getHeureFin());
		}
		try{
		gestionJourneeTypeLocal.associatePlageHoraireToJourneeType(journeeType.getIdjt(), plageHoraires, heures, heuresFin);
		}catch(Exception e){
			e.printStackTrace();
		}
		plageHoraires=new ArrayList<>();
		phajtp=new PlageHoraireAssociateJourneeType();
		phajtpList=new ArrayList<>();
		heures=new ArrayList<>();
		heuresFin=new ArrayList<>();
		
	}
	public void addDefJtp(){
		phajtp.sethAssociateJourneeTPK(new PlageHAssociateJourneeTPK());
		phajtpList.add(phajtp);
		phajtp=new PlageHoraireAssociateJourneeType();
	}
	public void removeDefJtp(){
		phajtpList.remove(phajtpList.size()-1);
		phajtp=new PlageHoraireAssociateJourneeType();
	}
	
	public void afficherDefinition(){
		selectedPhajtpList=(ArrayList<PlageHoraireAssociateJourneeType>) gestionJourneeTypeLocal.findPlageAssociateJtByJt(selectedJourneeType);
	}
	
	public String redirect() {

		return "/gtaparam/addplagehorairetojourneetype.jsf?faces-redirect=true";
	}
	
	//ajouter par sofien
	 public String onFlowProcess(FlowEvent event) {
	        if(skip) {
	            skip = false;   //reset in case user goes back
	            return "confirm";
	        }
	        else {
	            return event.getNewStep();
	        }
	    }

	 
	 
	 /********************************   desription journnee type   *******************************/
	 
	 
	 
	 
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
			plageHoraires2 = gestionPlageHoraire.findAllPlagesHoraire();
			if (descJourneeTypeList != null && !descJourneeTypeList.isEmpty()) {
				descJourneeTypeList.add(new DescJourneeTypeModel());
				DescJourneeTypeModel descJourneeType = descJourneeTypeList.get(descJourneeTypeList.size() - 1);
				descJourneeType.setDescJourneeType(descJourneeTypeModel.getDescJourneeType());
			}
		}
		
		public void initToUpdateDescJT(){
			if(selectedDescJourneeType != null){
				plageHoraires2 = gestionPlageHoraire.findAllPlagesHoraire();
				setDescJourneeTypeModel(selectedDescJourneeType);
				plageHoraireDesJtList = 
						gestionPlageHoraire.findPlageHoraireDescJourneeType(selectedDescJourneeType.getDescJourneeType());
				refAbscences = gestionRefAbscence.findRefAbscenceByDescJourneeType(selectedDescJourneeType.getDescJourneeType());
				refPointages = refPointageDao.findRefPointageByDescJourneeType(selectedDescJourneeType.getDescJourneeType());
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
		

		public void updateDescJourneeType(){
			if(descJourneeTypeModel != null){
				gestionDescJourneeType.modifierDescJourneeType(selectedDescJourneeType.getDescJourneeType());
				
				// Modifier Plage Horaire
				if (plageHoraireDesJtList != null && !plageHoraireDesJtList.isEmpty()) {
					int i = 0;
					for (PlageHoraireDescJourneeType phDjt : plageHoraireDesJtList) {
						
						phDjt.getDescJourneeType().setId(descJourneeTypeModel.getDescJourneeType().getId());
						PlageHoraireDescJourneeType oldPlageHoraire = selectedDescJourneeType.getDescJourneeType().getPlageHoraireDescJourneeTypes().get(i);
						gestionDescJourneeType.updatePlageHoraireDescJourneeType(oldPlageHoraire.getPlageHoraire(), descJourneeTypeModel.getDescJourneeType(),
									phDjt.getPlageHoraire(), phDjt.getHeure());
						i++;

					}

				}
				
				//Modifier RefAbscence
					if (refAbscences != null && !refAbscences.isEmpty()) {
						for (RefAbscence refAbscence : refAbscences) {
						gestionRefAbscence.modifierRefAbscence(refAbscence);
					}
				}
				
				// Modifier Refpointage
					if (refPointages != null && !refPointages.isEmpty()) {
						for (RefPointage refPointage : refPointages) {
						refPointageDao.update(refPointage);
					}
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
				//if (JourneeType != null) {
			//		gestionJourneeType.modifierJourneeType(JourneeType);
				//}
			}
			
			
			initJourneeType();
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
//			if (refPointages == null) {
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
		
		public void onDescJTRowSelect(){
			if(journeeType != null){
				selectedDescJourneeType.getDescJourneeType().setJourneeType(selectedJourneeType);
			}
		}

		/************************* Gestion Journée Type ***************************/
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



	public List<PlageHoraire> getPlageHoraires() {
		return plageHoraires;
	}

	public void setPlageHoraires(List<PlageHoraire> plageHoraires) {
		this.plageHoraires = plageHoraires;
	}

	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	public List<Integer> getHeures() {
		return heures;
	}

	public void setHeures(List<Integer> heures) {
		this.heures = heures;
	}



	public PlageHoraireAssociateJourneeType getPhajtp() {
		return phajtp;
	}

	public void setPhajtp(PlageHoraireAssociateJourneeType phajtp) {
		this.phajtp = phajtp;
	}

	public ArrayList<PlageHoraireAssociateJourneeType> getPhajtpList() {
		return phajtpList;
	}

	public void setPhajtpList(ArrayList<PlageHoraireAssociateJourneeType> phajtpList) {
		this.phajtpList = phajtpList;
	}

	public List<Integer> getHeuresFin() {
		return heuresFin;
	}

	public void setHeuresFin(List<Integer> heuresFin) {
		this.heuresFin = heuresFin;
	}

	public PlageHoraireAssociateJourneeType getSelectedPhajtp() {
		return selectedPhajtp;
	}

	public void setSelectedPhajtp(PlageHoraireAssociateJourneeType selectedPhajtp) {
		this.selectedPhajtp = selectedPhajtp;
	}

	public ArrayList<PlageHoraireAssociateJourneeType> getSelectedPhajtpList() {
		return selectedPhajtpList;
	}

	public void setSelectedPhajtpList(ArrayList<PlageHoraireAssociateJourneeType> selectedPhajtpList) {
		this.selectedPhajtpList = selectedPhajtpList;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
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
