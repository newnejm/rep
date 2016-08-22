package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.DescSemaineTypeModel;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.DescSemaineType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeTypeDescSemaineType;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;
import com.yesserp.domain.gtaparam.SemaineType;
import com.yesserp.sessionbean.paramgta.gestionDescSemaineType.GestionDescSemaineTypeLocal;
import com.yesserp.sessionbean.paramgta.gestioncodejour.GestionCodeJourLocal;
import com.yesserp.sessionbean.paramgta.gestionjourneetype.GestionJourneeTypeLocal;
import com.yesserp.sessionbean.paramgta.gestionsemainetype.GestionSemaineTypeLocal;




@ManagedBean(name = "descSemaineTypeBean")
@ViewScoped
public class DescSemaineTypeBean {
	
	private List<DescSemaineTypeModel> descSemaineTypeList;
	private List<DescSemaineType> descSemaineTypes2 = new ArrayList<DescSemaineType>() ;
	private DescSemaineTypeModel selectedDescSemaineType;
	private List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypeList;
	private SemaineType selectedsemaine2;
	private List<SemaineType> lsemaine2;
	private List<JourneeTypeDescSemaineType>  journeeTypeDesStList ;
	private List <JourneeType> journeeTypes2 ;
	private JourneeType journeeType2 ;
	private List<CodeJour> codeJours2;
	
	
	private List<DescSemaineType> currentDescSemaineTypes ;
	
	private JourneeTypeDescSemaineType a = new JourneeTypeDescSemaineType() ; 
	
	private JourneeType b = new JourneeType() ;
	
	private DescSemaineType currentDescSemaineType ; 
	

	@EJB
	GestionDescSemaineTypeLocal gestionDescSemaineType;
	
	@EJB
	GestionSemaineTypeLocal gestionSemaineType ;
	
	@EJB
	GestionJourneeTypeLocal gestionJourneeType ;
	
	@EJB
	GestionCodeJourLocal gestionCodeJour;
	
	
	
	@PostConstruct
	public void init() {
		initDescSemaineType();
	
		initSemaineType();
		
	}

	/************************************ Desc Semaine Type *********************************/
	public void initDescSemaineType() {
		if (descSemaineTypeList == null) {
			descSemaineTypeList = new ArrayList<DescSemaineTypeModel>();
		}
		// Alimentation de la liste de descSemaineType � partir de la base de
		// donn�es
		List<DescSemaineType> descSemaineTypes = gestionDescSemaineType
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
		lsemaine2 = gestionSemaineType.listeSemaineType();
	}
	
	public void onDescSemaineTypeRowSelect() {

		

			SemaineType currentSemaineType = gestionSemaineType.findSemaineByID(selectedsemaine2.getIdst());

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

	/****************************************************************************************/
	
	
	
	public void initJourneeTypeDescSt() {
	
		journeeTypeDescSemaineTypeList = new ArrayList<JourneeTypeDescSemaineType>();
		
	
	    journeeTypes2 = gestionJourneeType.listerJourneeType() ;
	
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

	
}
