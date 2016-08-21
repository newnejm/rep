package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;





@Entity
@Table(name="pg_TypeTel")
public class TypeTel implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;

	public TypeTel() {
		super();
	}

	 private int code_Tel ;
	 private String nom ;
	 private List<Libelle> libelles;
	 
	 @Id   
	public int getCode_Tel() {
		return code_Tel;
	}
	public void setCode_Tel(int code_Tel) {
		this.code_Tel = code_Tel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@OneToMany(mappedBy = "typeTel")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	
	
	
	//
	
	

}
