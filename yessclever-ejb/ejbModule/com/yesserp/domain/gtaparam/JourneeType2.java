package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.gta.Exceptionjournee;
import com.yesserp.domain.gta.PlanningReel;
import com.yesserp.domain.pg.CodeGTA;


@Entity
@Table
public class JourneeType2 implements Serializable {
	private Integer idjt2 ;
	private String  codejt;
	private Date dateff;
	private Integer poids;
	private String typeJournee ;
	private List<Filtre> filtres ;
	private List<Libelle> libelles ;
	private List<PlageHoraireAssociateJourneeType2>  plageHoraireAssociateJourneeTypes2 ;
//	private List<HoraireDeReference> horaireDeReference ;
//	private List<HoraireDeReferenceAbsence> horaireDeReferenceAbsences ;
//	private List<Exceptionjournee> exceptionjournees ;
//	private List<PlanningReel> planningReels ;
	//private List<CalculGta> calculGtas ;
	private List<DescJourneeType2> descJourneeType2s ;
	
	private CodeGTA codeGTA ;
	private static final long serialVersionUID =1L ;
	
	public JourneeType2() {
		super();
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdjt2() {
		return idjt2;
	}

	public String getCodejt() {
		return codejt;
	}

	public Date getDateff() {
		return dateff;
	}

	public Integer getPoids() {
		return poids;
	}

	public String getTypeJournee() {
		return typeJournee;
	}

	@ManyToMany(mappedBy="journeeType2s")
	public List<Filtre> getFiltres() {
		return filtres;
	}

	@OneToMany(mappedBy = "journeeType2",cascade = CascadeType.ALL ,fetch = FetchType.EAGER) 
	public List<Libelle> getLibelles() {
		return libelles;
	}

	
	@OneToMany(mappedBy = "journeeType2")
	public List<PlageHoraireAssociateJourneeType2> getPlageHoraireAssociateJourneeTypes2() {
		return plageHoraireAssociateJourneeTypes2;
	}

//	public List<HoraireDeReference> getHoraireDeReference() {
//		return horaireDeReference;
//	}
//
//	public List<HoraireDeReferenceAbsence> getHoraireDeReferenceAbsences() {
//		return horaireDeReferenceAbsences;
//	}

//	public List<Exceptionjournee> getExceptionjournees() {
//		return exceptionjournees;
//	}
//
//	public List<PlanningReel> getPlanningReels() {
//		return planningReels;
//	}

//	public List<CalculGta> getCalculGtas() {
//		return calculGtas;
//	}

	
	
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	
//	@OneToMany(mappedBy= "journeeType2", fetch =FetchType.EAGER , cascade = CascadeType.REMOVE   )
//	public List<DescJourneeType2> getDescJourneeType2s() {
//		return descJourneeType2s;
//	}


	public void setDescJourneeType2s(List<DescJourneeType2> descJourneeType2s) {
		this.descJourneeType2s = descJourneeType2s;
	}


	public void setIdjt2(Integer idjt2) {
		this.idjt2 = idjt2;
	}

	public void setCodejt(String codejt) {
		this.codejt = codejt;
	}

	public void setDateff(Date dateff) {
		this.dateff = dateff;
	}

	public void setPoids(Integer poids) {
		this.poids = poids;
	}

	public void setTypeJournee(String typeJournee) {
		this.typeJournee = typeJournee;
	}

	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	public void setPlageHoraireAssociateJourneeTypes2(
			List<PlageHoraireAssociateJourneeType2> plageHoraireAssociateJourneeTypes2) {
		this.plageHoraireAssociateJourneeTypes2 = plageHoraireAssociateJourneeTypes2;
	}

//	public void setHoraireDeReference(List<HoraireDeReference> horaireDeReference) {
//		this.horaireDeReference = horaireDeReference;
//	}
//
//	public void setHoraireDeReferenceAbsences(
//			List<HoraireDeReferenceAbsence> horaireDeReferenceAbsences) {
//		this.horaireDeReferenceAbsences = horaireDeReferenceAbsences;
//	}

//	public void setExceptionjournees(List<Exceptionjournee> exceptionjournees) {
//		this.exceptionjournees = exceptionjournees;
//	}
//
//	public void setPlanningReels(List<PlanningReel> planningReels) {
//		this.planningReels = planningReels;
//	}

//	public void setCalculGtas(List<CalculGta> calculGtas) {
//		this.calculGtas = calculGtas;
//	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}


	
	
	
	


	
	

}
