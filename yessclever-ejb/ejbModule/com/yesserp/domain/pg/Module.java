package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.jws.Oneway;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;


@Entity
@Table(name="pg_Module")
public class Module  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Module () {	
	}

	private	int code;
	private	String codemodule;
	

	private List<Libelle> libelles;
	private Filiale  filiale ; 
	private ParametrageModuleGlobale parametrageModuleGlobale ;
	
	
	
	
	private String description ;
	private Boolean staut ;
	
	
	
	@Id
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	public String getCodemodule() {
		return codemodule;
	}
	public void setCodemodule(String codemodule) {
		this.codemodule = codemodule;
	}
	
	@OneToMany(mappedBy = "module",cascade=CascadeType.REMOVE)
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToOne
	public Filiale getFiliale() {
		return filiale;
	}
	public void setFiliale(Filiale filiale) {
		this.filiale = filiale;
	}
	
	
	  @OneToOne
	public ParametrageModuleGlobale getParametrageModuleGlobale() {
		return parametrageModuleGlobale;
	}
	public void setParametrageModuleGlobale(
			ParametrageModuleGlobale parametrageModuleGlobale) {
		this.parametrageModuleGlobale = parametrageModuleGlobale;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getStaut() {
		return staut;
	}
	public void setStaut(Boolean staut) {
		this.staut = staut;
	}

}
