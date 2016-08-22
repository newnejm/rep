package managedBeans.gtaparam;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yesserp.domain.gtaparam.DescJourneeType2;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeType2;
import com.yesserp.domain.gtaparam.Libelle;
import com.yesserp.domain.gtaparam.PlageHAssociateJourneeTPK2;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraire2;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType2;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType2;
import com.yesserp.sessionbean.paramgta.gestionDescJourneeType2.GestionDescJourneeType2Local;
import com.yesserp.sessionbean.paramgta.gestionPlageHoraire2.GestionPlageHoraire2;
import com.yesserp.sessionbean.paramgta.gestionjourneetype2.GestionJourneeType2Local;
import com.yesserp.sessionbean.paramgta.gestionlibelle.GestionLibelleLocal;

import models.DescJourneeType2Model;


@ManagedBean
@SessionScoped
public class JourneeTypeBean2 {
	private JourneeType2 journeeType2 = new JourneeType2();
	private Libelle libelle = new Libelle() ;
	private  List<JourneeType2> journeeTypes2  =new ArrayList<>();
	private List<PlageHoraire2> plageHoraires2 = new ArrayList<>();
	private List<Integer> heures =new ArrayList<>() ;
	private List<Integer> heuresFin =new ArrayList<Integer>() ;
	private  boolean headerButtonsDisabled =true ;
	
	private boolean skip ;
	
	private PlageHoraireAssociateJourneeType2 phajtp2 = new PlageHoraireAssociateJourneeType2() ;
	private ArrayList<PlageHoraireAssociateJourneeType2> phajtpList2 = new ArrayList<>();
	
	private PlageHoraireAssociateJourneeType2 selectedPhajtp =new PlageHoraireAssociateJourneeType2() ;
	private ArrayList<PlageHoraireAssociateJourneeType2> selectedPhajtp2List =new  ArrayList<>() ;
	
	
	
	/*********varible descrption journeetype2*****/
	
	
	
	private List<DescJourneeType2Model> descJourneeTypeList2 ; 
	private DescJourneeType2Model descJourneeType2Model ; 
	private List<PlageHoraire2> plageHoraire2s ;
	private List<PlageHoraireDescJourneeType2> plageHoraireDesJt2List ;
	private List<JourneeType2> journeeType2List ;
	private List<Libelle> libelleList ;
	private PlageHoraire2 SelectedplageHoraire2 ;
	private Libelle selectedLibelle;
	private JourneeType2 selectedJourneeType2;
	
	private DescJourneeType2Model selectedDescJourneeType2 ;
	
	
	@EJB
	GestionJourneeType2Local gestionJourneeType2Local ;
	@EJB
	GestionLibelleLocal gestionLibelleLocal ;
	@EJB
	GestionDescJourneeType2Local gestionDescJourneeType2 ;
	@EJB
	GestionPlageHoraire2 gestionPlageHoraire2 ;
	@EJB
	GestionLibelleLocal gestionLibelle;

	@EJB
	GestionJourneeType2Local gestionJourneeType2Local2 ;
	
	
//	@PostConstruct
//	public void init() 
//	
//	{
//	 initDescJourneeType2(); 
//	 initJourneeType2() ;
//	 
//	 selectedJourneeType2 = selectedJourneeType2 ;
//	 journeeTypes2 = gestionJourneeType2Local.listerJourneeType();
//	 for(int i=0 ; i< journeeTypes2.size();i++){
//		 try {
//			 
//			 journeeTypes2.get(i).setLibelles(gestionLibelleLocal.findLibelleByjourneeType2(journeeTypes2.get(i).getIdjt2()));
//		 
//		 } catch (Exception e) {			 			 
//		 }
//		 
//		 
//	 }
//	 
//		
//	}
	
	
	public boolean isHeaderButtonsDisabled(){
		
		return headerButtonsDisabled ;
	}	
	public void onRowSelectDataTable() {	
		this.setHeaderButtonsDisabled(false); 		
	}	
	public void setHeaderButtonsDisabled(boolean headerButtonsDisabled)  {		
		this.headerButtonsDisabled = headerButtonsDisabled ;		
	}
	
	public  void ajouterJourneeType() {
		gestionJourneeType2Local.ajouterJourneeType(journeeType2);
		gestionLibelleLocal.ajoutLibelle(libelle);
		libelle.setJourneeType2(journeeType2);
		gestionLibelleLocal.modifierLibelle(libelle);
		libelle = new Libelle () ;
		gestionJourneeType2Local.findJourneeTypeByCode(journeeType2.getCodejt());
		definirJourneeType();
		journeeType2 = new JourneeType2() ;
		
		//init() ;				
	}
	
	public void supprimerJourneeType() {
		
		Libelle lib = selectedJourneeType2.getLibelles().get(0) ;
		
		try {
			
			gestionJourneeType2Local.supprimerJourneeType(selectedJourneeType2);
			
		}  catch (Exception e) {
			
			e.printStackTrace();
			gestionLibelleLocal.modifierLibelle(lib);
			
		}
		
	//	init();
	}
	
	public void modifierJourneeType() {
		
		gestionJourneeType2Local.modifierJourneeType(selectedJourneeType2);
	}
	
	
	public void definirJourneeType() {
		
		for(int i=0;i<phajtpList2.size();i++)
		{
			plageHoraires2.add(phajtpList2.get(i).getPlageHoraire2());
			heures.add(phajtpList2.get(i).gethAssociateJourneeTPK2().getHeureDeb());
			heuresFin.add(phajtpList2.get(i).getHeurefin());
		}
		try{
		gestionJourneeType2Local.associatePlageHoraireToJourneeType(journeeType2.getIdjt2(), plageHoraires2, heures, heuresFin);
		}catch(Exception e){
			e.printStackTrace();
		}
		plageHoraires2=new ArrayList<>();
		phajtp2=new PlageHoraireAssociateJourneeType2();
		phajtpList2=new ArrayList<>();
		heures=new ArrayList<>();
		heuresFin=new ArrayList<>();
		
	}
	
	
	
	public void addDefJtp(){
		phajtp2.sethAssociateJourneeTPK2(new PlageHAssociateJourneeTPK2());
		phajtpList2.add(phajtp2);
		phajtp2 =new PlageHoraireAssociateJourneeType2() ; 
		
	}
	
	public void removeDefJtp(){
		
		phajtpList2.remove(phajtpList2.size()-1);
		phajtp2 = new PlageHoraireAssociateJourneeType2() ;
	}
	
	public void afficherDefinition() {
		
selectedPhajtp2List =  (ArrayList<PlageHoraireAssociateJourneeType2>)gestionJourneeType2Local.findPlageAssociateJTByJt2(selectedJourneeType2);
	}
	
	
	public String redirect() {
		
		return "/gtaparam/addplagehorairetojourneetype.jsf?faces-redirect=true" ;
		
	}
	
	
	 /********************************   desription journnee type   *******************************/
	
	
	public void initDescJourneeType2() {		
	
		if (descJourneeTypeList2==null ) {
			
			descJourneeTypeList2 = new ArrayList<DescJourneeType2Model>() ;
		}
		
		List<DescJourneeType2> descJourneeType2s =  gestionDescJourneeType2.AfficherTousDescJourneeType2() ;
		
		if ( descJourneeType2s != null && !descJourneeType2s.isEmpty()  ) {
			for(DescJourneeType2 descJourneeType2 : descJourneeType2s   ) {
				descJourneeTypeList2.add(new DescJourneeType2Model()) ;
				descJourneeTypeList2.get(descJourneeTypeList2.size()-1)
				.setDescJourneeType2(descJourneeType2);
			}
		}
		
	}
	
	public void addDescJourneeType() {
		
		
		descJourneeType2Model = new DescJourneeType2Model() ;
		plageHoraire2s = gestionPlageHoraire2.findAllPlagesHoraire2() ;
		if (descJourneeTypeList2    != null && !descJourneeTypeList2.isEmpty() ) {
			
			descJourneeTypeList2.add(new DescJourneeType2Model());
			
			DescJourneeType2Model  descJourneeType2 = descJourneeTypeList2.get(descJourneeTypeList2.size()-1);
			
			descJourneeType2.setDescJourneeType2(descJourneeType2Model.getDescJourneeType2());	
		}
		
	}
	
	
	
	public void initJourneeType2(){
		journeeType2List = gestionJourneeType2Local.listerJourneeType();
		
	}


	public JourneeType2 getJourneeType2() {
		return journeeType2;
	}


	public Libelle getLibelle() {
		return libelle;
	}


	public List<JourneeType2> getJourneeTypes2() {
		return journeeTypes2;
	}


	public List<PlageHoraire2> getPlageHoraires2() {
		return plageHoraires2;
	}


	public List<Integer> getHeures() {
		return heures;
	}


	public List<Integer> getHeuresFin() {
		return heuresFin;
	}


	public boolean isSkip() {
		return skip;
	}


	public PlageHoraireAssociateJourneeType2 getPhajtp2() {
		return phajtp2;
	}


	public ArrayList<PlageHoraireAssociateJourneeType2> getPhajtpList2() {
		return phajtpList2;
	}


	public PlageHoraireAssociateJourneeType2 getSelectedPhajtp() {
		return selectedPhajtp;
	}


	public ArrayList<PlageHoraireAssociateJourneeType2> getSelectedPhajtp2List() {
		return selectedPhajtp2List;
	}


	public List<DescJourneeType2Model> getDescJourneeTypeList2() {
		return descJourneeTypeList2;
	}


	public DescJourneeType2Model getDescJourneeType2Model() {
		return descJourneeType2Model;
	}


	public List<PlageHoraire2> getPlageHoraire2s() {
		return plageHoraire2s;
	}


	public List<PlageHoraireDescJourneeType2> getPlageHoraireDesJt2List() {
		return plageHoraireDesJt2List;
	}


	public List<JourneeType2> getJourneeType2List() {
		return journeeType2List;
	}


	public List<Libelle> getLibelleList() {
		return libelleList;
	}


	public PlageHoraire2 getSelectedplageHoraire2() {
		return SelectedplageHoraire2;
	}


	public Libelle getSelectedLibelle() {
		return selectedLibelle;
	}


	public JourneeType2 getSelectedJourneeType2() {
		return selectedJourneeType2;
	}


	public DescJourneeType2Model getSelectedDescJourneeType2() {
		return selectedDescJourneeType2;
	}


	public void setJourneeType2(JourneeType2 journeeType2) {
		this.journeeType2 = journeeType2;
	}


	public void setLibelle(Libelle libelle) {
		this.libelle = libelle;
	}


	public void setJourneeTypes2(List<JourneeType2> journeeTypes2) {
		this.journeeTypes2 = journeeTypes2;
	}


	public void setPlageHoraires2(List<PlageHoraire2> plageHoraires2) {
		this.plageHoraires2 = plageHoraires2;
	}


	public void setHeures(List<Integer> heures) {
		this.heures = heures;
	}


	public void setHeuresFin(List<Integer> heuresFin) {
		this.heuresFin = heuresFin;
	}


	public void setSkip(boolean skip) {
		this.skip = skip;
	}


	public void setPhajtp2(PlageHoraireAssociateJourneeType2 phajtp2) {
		this.phajtp2 = phajtp2;
	}


	public void setPhajtpList2(
			ArrayList<PlageHoraireAssociateJourneeType2> phajtpList2) {
		this.phajtpList2 = phajtpList2;
	}


	public void setSelectedPhajtp(PlageHoraireAssociateJourneeType2 selectedPhajtp) {
		this.selectedPhajtp = selectedPhajtp;
	}


	public void setSelectedPhajtp2List(
			ArrayList<PlageHoraireAssociateJourneeType2> selectedPhajtp2List) {
		this.selectedPhajtp2List = selectedPhajtp2List;
	}


	public void setDescJourneeTypeList2(
			List<DescJourneeType2Model> descJourneeTypeList2) {
		this.descJourneeTypeList2 = descJourneeTypeList2;
	}


	public void setDescJourneeType2Model(DescJourneeType2Model descJourneeType2Model) {
		this.descJourneeType2Model = descJourneeType2Model;
	}


	public void setPlageHoraire2s(List<PlageHoraire2> plageHoraire2s) {
		this.plageHoraire2s = plageHoraire2s;
	}


	public void setPlageHoraireDesJt2List(
			List<PlageHoraireDescJourneeType2> plageHoraireDesJt2List) {
		this.plageHoraireDesJt2List = plageHoraireDesJt2List;
	}


	public void setJourneeType2List(List<JourneeType2> journeeType2List) {
		this.journeeType2List = journeeType2List;
	}


	public void setLibelleList(List<Libelle> libelleList) {
		this.libelleList = libelleList;
	}


	public void setSelectedplageHoraire2(PlageHoraire2 selectedplageHoraire2) {
		SelectedplageHoraire2 = selectedplageHoraire2;
	}


	public void setSelectedLibelle(Libelle selectedLibelle) {
		this.selectedLibelle = selectedLibelle;
	}


	public void setSelectedJourneeType2(JourneeType2 selectedJourneeType2) {
		this.selectedJourneeType2 = selectedJourneeType2;
	}


	public void setSelectedDescJourneeType2(
			DescJourneeType2Model selectedDescJourneeType2) {
		this.selectedDescJourneeType2 = selectedDescJourneeType2;
	}
	
	
	
	
	

}
