 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



/**
 * Entity implementation class for Entity: Description_UO
 *
 */
@Entity
@Table(name="pg_Description_UO")
public class Description_UO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Description_UO() {
		super();
	}
   
	
	private int code  ;
	private	String type;
	private	String descption ;
	private	String objectif ;
	private	String responsabilite ;
	private List<Unite_organisationnelle> UO;
	private List<Libelle> libelles;

	@Id   
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	@OneToMany(mappedBy = "description_UO")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescption() {
		return descption;
	}
	public void setDescption(String descption) {
		this.descption = descption;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}
	
	@OneToMany(targetEntity=Unite_organisationnelle.class,mappedBy="DUO",cascade=CascadeType.ALL)
	public List<Unite_organisationnelle> getUO() {
		return UO;
	}
	public void setUO(List<Unite_organisationnelle> uO) {
		UO = uO;
	}
//
}
