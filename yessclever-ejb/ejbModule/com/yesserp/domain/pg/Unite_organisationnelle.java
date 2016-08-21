 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



/**
 * Entity implementation class for Entity: Unite_organisationnelle
 *
 */
@Entity
@Table(name="pg_UO")
public class Unite_organisationnelle implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Unite_organisationnelle() {
		super();
	}
	
	
	
	private	int code ;

	private	String nom ;
	
	private	Societe societe ;
	
    private	Description_UO DUO ;
	
	private int code_UOparent ;

	private int code_UOenfant ;
	
	
	@Id   
	//@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	
	private List<Libelle> libelles;
	
	
	@OneToMany(mappedBy = "unite_organisationnelle")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@ManyToOne
	public Description_UO getDUO() {
		return DUO;
	}

	public void setDUO(Description_UO dUO) {
		DUO = dUO;
	}
	@ManyToOne
	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	
	public int getCode_UOparent() {
		return code_UOparent;
	}
	public void setCode_UOparent(int code_UOparent) {
		this.code_UOparent = code_UOparent;
	}
	public int getCode_UOenfant() {
		return code_UOenfant;
	}
	public void setCode_UOenfant(int code_UOenfant) {
		this.code_UOenfant = code_UOenfant;
	}


	
	//
	
   
}
