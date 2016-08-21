 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



/**
 * Entity implementation class for Entity: Employeur
 *
 */
@Entity
@Table(name="pg_Employeur")
public class Employeur implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Employeur() {
		super();
	}
   
	private	int code ;
	private	String nom ;
    private	List <Poste> poste ;
    private	Societe societe ;
    
    
    
    @Id   
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	
    @OneToMany( targetEntity=Poste.class ,mappedBy="employeur",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Poste> getPoste() 
	{
	return poste;
    }


    public void setPoste(List<Poste> poste) 
    {
	this.poste = poste;
    }

    @ManyToOne
    public Societe getSociete() 
    {
	return societe;
    }
    
    public void setSociete(Societe societe) 
    {
	this.societe = societe;
    }

	
	
	private List<Libelle> libelles;
	
	
	@OneToMany(mappedBy = "employeur")
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
	

	
	//
	
}