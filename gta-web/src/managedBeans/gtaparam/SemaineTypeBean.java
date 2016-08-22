package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.DescSemaineTypeModel;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescSemaineType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeTypeDescSemaineType;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.gtaparam.SemaineType;
import com.yesserp.sessionbean.paramgta.gestionDescSemaineType.GestionDescSemaineTypeLocal;
import com.yesserp.sessionbean.paramgta.gestioncodejour.GestionCodeJourLocal;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;
import com.yesserp.sessionbean.paramgta.gestionsemainetype.GestionSemaineTypeLocal;

@ManagedBean
@ViewScoped
public class SemaineTypeBean {

	// attribut added by omar le 28/08
	private List<SemaineType> lsemaine;
	private SemaineType selectedsemaine;
	// fin add
	private List<JourneeType> journeeTypes = new ArrayList<>();
	private List<JourneeType> listjournee = new ArrayList<>();
	private SemaineType semaineType = new SemaineType();
	private List<CodeJour> codeJours = new ArrayList<>();
	private CodeJour codeJour = new CodeJour();
	private JourneeType journeeType = new JourneeType();
	private Libelle libelle = new Libelle();
	private boolean headerButtonsDisabled = true;
	private int id = 1;
	
/*variable descSemaineType */
	
	private List<DescSemaineTypeModel> descSemaineTypeList;
	private List<DescSemaineType> descSemaineTypes2 = new ArrayList<DescSemaineType>() ;
	private DescSemaineTypeModel selectedDescSemaineType;
	
	private DescSemaineType selectedDescSemaineType2 ;
	private List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypeList;
	private SemaineType selectedsemaine2;
	private List<SemaineType> lsemaine2;
	private List<JourneeTypeDescSemaineType>  journeeTypeDesStList ;
	private List <JourneeType> journeeTypes2 ;
	private JourneeType journeeType2 ;
	private List<CodeJour> codeJours2;
	private List<DescSemaineType> descSemaineTypes ;
	private SemaineType currentSemaineType ;
	private List<DescSemaineType> currentDescSemaineTypes ;
	
	private JourneeTypeDescSemaineType a = new JourneeTypeDescSemaineType() ; 
	
	private JourneeType b = new JourneeType() ;
	
	private DescSemaineType currentDescSemaineType ; 
	
	
	
	@EJB
	GestionJourneeTypeLocal gestionJourneeTypeLocal;
	@EJB
	GestionSemaineTypeLocal gestionSemaineTypeLocal;
	@EJB
	GestionLibelleLocal gestionLibelleLocal;
	@EJB
	GestionCodeJourLocal gestionCodeJourLocal;
	

	
	
	
	@EJB
	GestionDescSemaineTypeLocal gestionDescSemaineType;
	
	@EJB
	GestionSemaineTypeLocal gestionSemaineType ;
	
	@EJB
	GestionJourneeTypeLocal gestionJourneeType ;
	
	@EJB
	GestionCodeJourLocal gestionCodeJour;
	
	
	
	
	
	
	
	
	
	
	
	// add by omar le 28/08

	public String select() {
		return null;
	}

	public String supprimer() {
		gestionSemaineTypeLocal.supprimerSemaineType(this.selectedsemaine2);
		return redirect();
	}

	public String edit() {
		return null;
	}

	public String save() {
		return null;
	}

	// fin add

	@PostConstruct
	public void intit() {
		
		initDescSemaineType();
		
		initSemaineType();
		// add by omar le 29/08
		this.lsemaine = gestionSemaineTypeLocal.listeSemaineType();
		// fin add
		journeeTypes = gestionJourneeTypeLocal.listerJourneeType();
		codeJours = gestionCodeJourLocal.listeCodeJours();
		codeJour = gestionCodeJourLocal.findCodeJourById(2);
		
	}

	public void ajouter() {
		gestionSemaineTypeLocal.ajouterSemaineType(semaineType);
		gestionLibelleLocal.ajoutLibelle(libelle);
		libelle.setSemaineType(semaineType);
		gestionLibelleLocal.modifierLibelle(libelle);
		

		for (JourneeType j : listjournee) {
			if (id < 8) {
				gestionSemaineTypeLocal
						.ajouterDesJourneesPourSemaineAvecCodeJour(semaineType,
								j, gestionCodeJourLocal.findCodeJourById(id++));
			}
		}
		semaineType.setLibelles(new ArrayList<Libelle>());
		semaineType.getLibelles().add(libelle);
		lsemaine.add(semaineType);
		libelle = new Libelle();
		semaineType = new SemaineType();

		listjournee = new ArrayList<>();
		id = 1;

	}

	public String redirect() {

		return "/gtaparam2/Gestionsemainetype.jsf?faces-redirect=true";
	}

	public void test() {
		if (journeeType.getCodejt() != null) {
			listjournee.add(journeeType);
		}

	}

	public void afficher() {
		for (JourneeType j : listjournee) {
			System.out.println("*********" + j.getCodejt());
		}

	}

	public void supprimerSemaineType() {
		Libelle lib = selectedsemaine2.getLibelles().get(0);
		try {
			
			gestionSemaineTypeLocal.supprimerSemaineType(selectedsemaine2);
			

		} catch (Exception e) {
			e.printStackTrace();
			gestionLibelleLocal
					.modifierLibelle(lib);
		}
		
	}
	
	
	
	public void modiferSemaineType() {
		gestionSemaineTypeLocal.modifierSemaineType(selectedsemaine2);
	}

	/************************************ Desc Semaine Type *********************************/
	public void initDescSemaineType() {
		if (descSemaineTypeList == null) {
			descSemaineTypeList = new ArrayList<DescSemaineTypeModel>();
		}
		// Alimentation de la liste de descSemaineType � partir de la base de
		// donn�es
		 descSemaineTypes = gestionDescSemaineType
				.getDescSemaineTypesBySemaineType(selectedsemaine2);
		if (descSemaineTypes != null && !descSemaineTypes.isEmpty()) {
			for (DescSemaineType descSemaineType : descSemaineTypes) {
				descSemaineTypeList.add(new DescSemaineTypeModel());
				DescSemaineTypeModel descSemaineTypeModel = descSemaineTypeList
						.get(descSemaineTypeList.size() - 1);
				descSemaineTypeModel.setDescSemaineType(descSemaineType);
			}
		}
	}

	public void addDescSemaineType() {
		
		DescSemaineTypeModel descSemaineTypeModel = new DescSemaineTypeModel() ;
		initJourneeTypeDescSt();
		if (descSemaineTypeList != null) {
			
			descSemaineTypeList.add(new DescSemaineTypeModel());
			
			 descSemaineTypeModel = descSemaineTypeList.get(descSemaineTypeList.size() - 1);
			 
			 descSemaineTypeModel.getDescSemaineType().setJourneeTypeDescSemaineTypes(new ArrayList<JourneeTypeDescSemaineType>());
			 List<CodeJour> jours = gestionCodeJour.listeCodeJours();
			 if(jours != null && !jours.isEmpty()){
				 for(CodeJour jour : jours){
					 descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes().add(new JourneeTypeDescSemaineType());
					 JourneeTypeDescSemaineType journeeTypeDescSemaineType = descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes().get(descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes().size() - 1);
					 journeeTypeDescSemaineType.setCodeJour(jour);
					 journeeTypeDescSemaineType.setJourneeType(new JourneeType());
				 }
			 }
			 /*for (Integer i = 0; i <= 6; i++) {
				descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes().add(new JourneeTypeDescSemaineType());
				
				JourneeTypeDescSemaineType journeeTypeDescSemaineType = descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes().get(descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes().size() - 1);
			
				journeeTypeDescSemaineType.setIndexJour(i);
				
				switch (i) {
				case 0:
					journeeTypeDescSemaineType.setJour("Lundi");
					break;
				case 1:
					journeeTypeDescSemaineType.setJour("Mardi");
					break;
				case 2:
					journeeTypeDescSemaineType.setJour("Mercredi");
					break;
				case 3:
					journeeTypeDescSemaineType.setJour("Jeudi");
					break;
				case 4:
					journeeTypeDescSemaineType.setJour("Vendredi");
					break;
				case 5:
					journeeTypeDescSemaineType.setJour("Samedi");
					break;
				case 6:
					journeeTypeDescSemaineType.setJour("Dimanche");
					break;
				}
			}*/
			journeeTypeDescSemaineTypeList = descSemaineTypeModel.getDescSemaineType().getJourneeTypeDescSemaineTypes();
			
			 currentDescSemaineType =  descSemaineTypeModel.getDescSemaineType() ;
		}
	}

	
	
	
	public void saveDesSemaineType() {

		if (descSemaineTypeList == null) {
			descSemaineTypeList = new ArrayList<DescSemaineTypeModel>();
		}

		
		
		
		//descSemaineTypeList.add(new DescSemaineTypeModel());
 	 
		//DescSemaineType descSemaineType = currentDescSemaineType ;
		
		//for (Integer i = 0; i <= 6; i++) {
			
		//	descSemaineTypeList.get(0).setDescSemaineType(descSemaineType);
			if ((currentDescSemaineType) != null) {
				
			
		descSemaineTypes2.add(currentDescSemaineType);
		
			
		if ((selectedsemaine2) != null) {
			
		( currentDescSemaineType).setSemaineType(selectedsemaine2);

		gestionSemaineType.modifierSemaineType(selectedsemaine2);
		
			
		selectedsemaine2.setDescSemaineTypes(descSemaineTypes2);

		if ((	(currentDescSemaineType)) != null) {
		gestionDescSemaineType.ajouterDescSemaineType(	( currentDescSemaineType));
		}
		}
		
		
		
		// Sauvegarder JourneeTypes
			
			
			if ( journeeTypeDescSemaineTypeList != null && !journeeTypeDescSemaineTypeList.isEmpty()) {
		               
			for (JourneeTypeDescSemaineType jtDst : journeeTypeDescSemaineTypeList) { 
				
				
				if ( jtDst != null) {
			
					jtDst.setDescSemaineType(currentDescSemaineType);
	    //    jtDst.getDescSemaineType().setId(currentDescSemaineType.getId());
	

	        gestionDescSemaineType.associateJourneeTypeToDescSemaineType(jtDst.getDescSemaineType().getIdDescST(), jtDst.getJourneeType(), 
            jtDst.getCodeJour().getIdcj());

				}
			}
			
			}

		}
	
	}
	
	public void initSemaineType() {
		lsemaine = gestionSemaineType.listeSemaineType();
	}
	
	public void onDescSemaineTypeRowSelect() {

		

			 currentSemaineType = gestionSemaineType.findSemaineByID(selectedsemaine2.getIdst());

			descSemaineTypeList = new ArrayList<DescSemaineTypeModel>();
			
			 currentDescSemaineTypes = gestionDescSemaineType.getDescSemaineTypesBySemaineType(currentSemaineType);
			 
			 descSemaineTypes2 = gestionDescSemaineType.getDescSemaineTypesBySemaineType(currentSemaineType);
			
			for (DescSemaineType descSemaineType : currentDescSemaineTypes) {

				if (descSemaineType != null) {

					descSemaineTypeList.add(new DescSemaineTypeModel());

					descSemaineTypeList.get(descSemaineTypeList.size() - 1).setDescSemaineType(descSemaineType);
				}
			}
	
	}

	
	
	
	public void removeDescSemaineType() {
	//	if (selectedDescSemaineType != null) {
		//	SemaineType SemaineType = selectedDescSemaineType.getDescSemaineType().getSemaineType();
			
			
			
			gestionDescSemaineType.supprimerDescSemaineType(selectedDescSemaineType.getDescSemaineType());
		/*	for (DescSemaineTypeModel descJT : descSemaineTypeList) {
				if (selectedDescSemaineType.getDescSemaineType().getId() == descJT
						.getDescSemaineType().getId()) {
					descSemaineTypeList.remove(descJT);
					break;
				}
			}*/initSemaineType();
			
			// descSemaineTypes2 = gestionDescSemaineType.getDescSemaineTypesBySemaineType(currentSemaineType);
			//if (SemaineType != null) {
		//		gestionSemaineType.modifierSemaineType(SemaineType);
			//}
	//	}
	}
	
	
	
	
	
	
	
	
	
	/*
	
	public void supprimerDescSemaineType() {
		
			
		gestionDescSemaineType.delete(DescSemaineType, selectedDescSemaineType.g);;
		
		
			gestionSemaineTypeLocal.supprimerSemaineType(selectedsemaine2);
			

		} catch (Exception e) {
			e.printStackTrace();
			gestionLibelleLocal
					.modifierLibelle(lib);
		}
		
	}
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	/****************************************************************************************/
	
	
	
	public void initJourneeTypeDescSt() {
	
		journeeTypeDescSemaineTypeList = new ArrayList<JourneeTypeDescSemaineType>();
		
	
	    journeeTypes2 = gestionJourneeType.listerJourneeType() ;
	
	}
	
	

	/****************************************************************************************/

	public List<JourneeType> getJourneeTypes() {
		return journeeTypes;
	}

	public void setJourneeTypes(List<JourneeType> journeeTypes) {
		this.journeeTypes = journeeTypes;
	}

	public SemaineType getSemaineType() {
		return semaineType;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

	public Libelle getLibelle() {
		return libelle;
	}

	public void setLibelle(Libelle libelle) {
		this.libelle = libelle;
	}

	public List<JourneeType> getListjournee() {
		return listjournee;
	}

	public void setListjournee(List<JourneeType> listjournee) {
		this.listjournee = listjournee;
	}

	public List<CodeJour> getCodeJours() {
		return codeJours;
	}

	public void setCodeJours(List<CodeJour> codeJours) {
		this.codeJours = codeJours;
	}

	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public CodeJour getCodeJour() {
		return codeJour;
	}

	public void setCodeJour(CodeJour codeJour) {
		this.codeJour = codeJour;
	}

	public List<SemaineType> getLsemaine() {
		return lsemaine;
	}

	public void setLsemaine(List<SemaineType> lsemaine) {
		this.lsemaine = lsemaine;
	}

	public SemaineType getSelectedsemaine() {
		return selectedsemaine;
	}

	public void setSelectedsemaine(SemaineType selectedsemaine) {
		this.selectedsemaine = selectedsemaine;
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


	
	
	public List<DescSemaineType> getcurrentDescSemaineTypes() {
		return currentDescSemaineTypes;
	}

	public void setcurrentDescSemaineTypes(
			List<DescSemaineType> currentDescSemaineTypes) {
		this.currentDescSemaineTypes = currentDescSemaineTypes;
	}

	public DescSemaineType getCurrentDescSemaineType() {
		return currentDescSemaineType;
	}

	public void setCurrentDescSemaineType(DescSemaineType currentDescSemaineType) {
		this.currentDescSemaineType = currentDescSemaineType;
	}



	public JourneeType getB() {
		return b;
	}

	public void setB(JourneeType b) {
		this.b = b;
	}

	

	public List<DescSemaineType> getCurrentDescSemaineTypes() {
		return currentDescSemaineTypes;
	}

	

	public void setCurrentDescSemaineTypes(
			List<DescSemaineType> currentDescSemaineTypes) {
		this.currentDescSemaineTypes = currentDescSemaineTypes;
	}

	public DescSemaineTypeModel getSelectedDescSemaineType() {
		return selectedDescSemaineType;
	}

	public void setSelectedDescSemaineType(DescSemaineTypeModel selectedDescSemaineType) {
		this.selectedDescSemaineType = selectedDescSemaineType;
	}

	public SemaineType getSelectedsemaine2() {
		return selectedsemaine2;
	}

	public void setSelectedsemaine2(SemaineType selectedsemaine2) {
		this.selectedsemaine2 = selectedsemaine2;
	}

	public List<SemaineType> getLsemaine2() {
		return lsemaine2;
	}

	public void setLsemaine2(List<SemaineType> lsemaine2) {
		this.lsemaine2 = lsemaine2;
	}

	public List<JourneeTypeDescSemaineType> getJourneeTypeDesStList() {
		return journeeTypeDesStList;
	}

	public void setJourneeTypeDesStList(List<JourneeTypeDescSemaineType> journeeTypeDesStList) {
		this.journeeTypeDesStList = journeeTypeDesStList;
	}

	public List <JourneeType> getJourneeTypes2() {
		return journeeTypes2;
	}

	public void setJourneeTypes2(List <JourneeType> journeeTypes2) {
		this.journeeTypes2 = journeeTypes2;
	}

	public JourneeType getJourneeType2() {
		return journeeType2;
	}

	public void setJourneeType2(JourneeType journeeType2) {
		this.journeeType2 = journeeType2;
	}

	public List<CodeJour> getCodeJours2() {
		return codeJours2;
	}

	public void setCodeJours2(List<CodeJour> codeJours2) {
		this.codeJours2 = codeJours2;
	}

	public List<DescSemaineTypeModel> getDescSemaineTypeList() {
		return descSemaineTypeList;
	}

	public List<DescSemaineType> getDescSemaineTypes2() {
		return descSemaineTypes2;
	}

	public List<JourneeTypeDescSemaineType> getJourneeTypeDescSemaineTypeList() {
		return journeeTypeDescSemaineTypeList;
	}

	public void setDescSemaineTypeList(
			List<DescSemaineTypeModel> descSemaineTypeList) {
		this.descSemaineTypeList = descSemaineTypeList;
	}

	public void setDescSemaineTypes2(List<DescSemaineType> descSemaineTypes2) {
		this.descSemaineTypes2 = descSemaineTypes2;
	}

	public void setJourneeTypeDescSemaineTypeList(
			List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypeList) {
		this.journeeTypeDescSemaineTypeList = journeeTypeDescSemaineTypeList;
	}

	public JourneeTypeDescSemaineType getA() {
		return a;
	}

	public void setA(JourneeTypeDescSemaineType a) {
		this.a = a;
	}

	public List<DescSemaineType> getDescSemaineTypes() {
		return descSemaineTypes;
	}

	public void setDescSemaineTypes(List<DescSemaineType> descSemaineTypes) {
		this.descSemaineTypes = descSemaineTypes;
	}

	public DescSemaineType getSelectedDescSemaineType2() {
		return selectedDescSemaineType2;
	}

	public void setSelectedDescSemaineType2(DescSemaineType selectedDescSemaineType2) {
		this.selectedDescSemaineType2 = selectedDescSemaineType2;
	}

	public SemaineType getCurrentSemaineType() {
		return currentSemaineType;
	}

	public void setCurrentSemaineType(SemaineType currentSemaineType) {
		this.currentSemaineType = currentSemaineType;
	}

	

}