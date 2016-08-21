package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: LangageMaternelle
 *
 */
@Entity
@Table(name = "TM_LangRH")
public class LangageMaternelle implements Serializable {

	
	private int code;
	private String libelle;
	private static final long serialVersionUID = 1L;
	private List<Identite> identites ;
	public LangageMaternelle() {
		super();
	}   
	@Id 
	@GeneratedValue
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@ManyToMany(mappedBy="langages")
	public List<Identite> getIdentites() {
		return identites;
	}
	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}
	
	
	
	
   
}
