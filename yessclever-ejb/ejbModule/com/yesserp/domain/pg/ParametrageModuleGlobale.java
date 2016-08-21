package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;


@Entity
@Table(name="pg_ParametrageModuleGlobale")
public class ParametrageModuleGlobale  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Module module ;
	
	private ParametrageMail parametrageMail ;
	
	private	int code;
	private List<Libelle> libelles;
	
	private  ParametrageAbsence parametrageAbsence ;
	private  ParametrageFrais parametrageFrais;
	private  ParametrageGTA  parametrageGTA;
	private  ParametrageTM   parametrageTM;
	private  ParametrageStock  parametrageStock;
	private  ParametrageComptabilite  parametrageComptabilite;
	private  ParametrageWorkFlow  parametrageWorkFlow;
	private  ParametrageAlerte  parametrageAlerte;
	private String description ;
	private Boolean staut ;
	
	@Id
	public int getCode() {
		return this.code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@OneToMany(mappedBy = "parametrageModuleGlobale",cascade=CascadeType.REMOVE)
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@OneToOne
	public ParametrageAbsence getParametrageAbsence() {
		return parametrageAbsence;
	}
	public void setParametrageAbsence(ParametrageAbsence parametrageAbsence) {
		this.parametrageAbsence = parametrageAbsence;
	}
	
	
	@OneToOne
	public ParametrageMail getParametrageMail() {
		return parametrageMail;
	}
	
	
	public void setParametrageMail(ParametrageMail parametrageMail) {
		this.parametrageMail = parametrageMail;
	}
	public ParametrageModuleGlobale ()  {	
	}
	
	
	@OneToOne
	public ParametrageGTA getParametrageGTA() {
		return parametrageGTA;
	}
	public void setParametrageGTA(ParametrageGTA parametrageGTA) {
		this.parametrageGTA = parametrageGTA;
	}
	
	@OneToOne
	public ParametrageStock getParametrageStock() {
		return parametrageStock;
	}
	public void setParametrageStock(ParametrageStock parametrageStock) {
		this.parametrageStock = parametrageStock;
	}
	
	
	@OneToOne
	public ParametrageWorkFlow getParametrageWorkFlow() {
		return parametrageWorkFlow;
	}
	public void setParametrageWorkFlow(ParametrageWorkFlow parametrageWorkFlow) {
		this.parametrageWorkFlow = parametrageWorkFlow;
	}
	
	
	@OneToOne
	public ParametrageAlerte getParametrageAlerte() {
		return parametrageAlerte;
	}
	public void setParametrageAlerte(ParametrageAlerte parametrageAlerte) {
		this.parametrageAlerte = parametrageAlerte;
	}
	
	
	@OneToOne
	public ParametrageComptabilite getParametrageCompatibilite() {
		return parametrageComptabilite;
	}
	public void setParametrageCompatibilite(
			ParametrageComptabilite parametrageComptabilite) {
		this.parametrageComptabilite = parametrageComptabilite;
	}
	/*
	@OneToOne(mappedBy = "parametrageModuleGlobale")
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	@OneToOne
	public ParametrageFrais getParametrageFrais() {
		return parametrageFrais;
	}
	public void setParametrageFrais(ParametrageFrais parametrageFrais) {
		this.parametrageFrais = parametrageFrais;
	}
	

	
	@OneToOne
	public ParametrageTM getParametrageTM() {
		return parametrageTM;
	}
	public void setParametrageTM(ParametrageTM parametrageTM) {
		this.parametrageTM = parametrageTM;
	}
	

	
	
	
	
	
	
	
	*/
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	public Boolean getStaut() {
		return staut;
	}
	public void setStaut(Boolean staut) {
		this.staut = staut;
	}
	
}
