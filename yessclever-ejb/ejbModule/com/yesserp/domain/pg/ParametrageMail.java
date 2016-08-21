package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;


@Entity
@Table(name="pg_ParametrageMail")
  public class ParametrageMail  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public ParametrageMail () {	
	}
	
	private	int code;
	private List<Libelle> libelles;
    private ParametrageModuleGlobale  parametrageModuleGlobale ;
    
    private String protocole ;
    private String port ;
    private Boolean securiser ; 
	
	private Boolean staut ;


	@Id
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	public String getProtocole() {
		return protocole;
	}
	public void setProtocole(String protocole) {
		this.protocole = protocole;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public Boolean getSecuriser() {
		return securiser;
	}
	public void setSecuriser(Boolean securiser) {
		this.securiser = securiser;
	}
	
	
	@OneToMany(mappedBy = "parametrageMail")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	
	@OneToOne(mappedBy = "parametrageMail")
	public ParametrageModuleGlobale getParametrageModuleGlobale() {
		return parametrageModuleGlobale;
	}
	public void setParametrageModuleGlobale(
			ParametrageModuleGlobale parametrageModuleGlobale) {
		this.parametrageModuleGlobale = parametrageModuleGlobale;
	}
	
	public Boolean getStaut() {
		return staut;
	}
	public void setStaut(Boolean staut) {
		this.staut = staut;
	}
	
	
}
