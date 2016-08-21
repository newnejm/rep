 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;

@Entity
@Table(name="pg_Societe")
public class Societe implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Societe() {
		super();
	}
	
	private   int code;
    private  String adresses ;
    private    String registre_de_commerce ;
    private  String codedouane;
    private   String raison_social; 
    private   String matricule_fiscal;
    private   String code_douane ;
    private   long nombre_utilisateurs; 
    private  String secteur_d_activite ;
    private  String contact ;
    private  String capitale;
    private  String Type;
	private  Parametres_Generaux pg ;
    
    private  List<Employeur> employeur ;
   
    private  List<Unite_organisationnelle> UO ;
    
    private List<Libelle> libelles;
    


	private List<Filiale> filiale ;
 
@Id
public int getCode() {
	return this.code;
}
public void setCode(int code) {
	this.code = code;
}



public String getAdresses() {
	return adresses;
}
public void setAdresses(String adresses) {
	this.adresses = adresses;
}
public String getRegistre_de_commerce() {
	return registre_de_commerce;
}
public void setRegistre_de_commerce(String registre_de_commerce) {
	this.registre_de_commerce = registre_de_commerce;
}
public String getCodedouane() {
	return codedouane;
}
public void setCodedouane(String codedouane) {
	this.codedouane = codedouane;
}
public String getRaison_social() {
	return raison_social;
}
public void setRaison_social(String raison_social) {
	this.raison_social = raison_social;
}
public String getMatricule_fiscal() {
	return matricule_fiscal;
}
public void setMatricule_fiscal(String matricule_fiscal) {
	this.matricule_fiscal = matricule_fiscal;
}
public String getCode_douane() {
	return code_douane;
}
public void setCode_douane(String code_douane) {
	this.code_douane = code_douane;
}

public long getNombre_utilisateurs() {
	return nombre_utilisateurs;
}
public void setNombre_utilisateurs(long nombre_utilisateurs) {
	this.nombre_utilisateurs = nombre_utilisateurs;
}
public String getSecteur_d_activite() {
	return secteur_d_activite;
}
public void setSecteur_d_activite(String secteur_d_activite) {
	this.secteur_d_activite = secteur_d_activite;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getCapitale() {
	return capitale;
}
public void setCapitale(String capitale) {
	this.capitale = capitale;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
} 

@OneToMany(mappedBy = "societe",cascade=CascadeType.REMOVE)
public List<Libelle> getLibelles() {
	return libelles;
}

public void setLibelles(List<Libelle> libelles) {
	this.libelles = libelles;
}



	@OneToMany(targetEntity=Employeur.class ,mappedBy="societe",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Employeur> getEmployeur() {
		return employeur;
	}
	public void setEmployeur(List<Employeur> employeur) {
		this.employeur = employeur;
	}
	
	@OneToMany(targetEntity=Unite_organisationnelle.class ,mappedBy="societe",cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	public List<Unite_organisationnelle> getUO() {
		return UO;
	}
	public void setUO(List<Unite_organisationnelle> uO) {
		UO = uO;
	}

	@OneToMany(targetEntity=Filiale.class ,mappedBy = "societe",cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
    public List<Filiale> getFiliale() {
		return filiale;
	}
	public void setFiliale(List<Filiale> filiale) {
		this.filiale = filiale;
	}

	
	@ManyToOne
	   public Parametres_Generaux getPg()
	   {
			return pg;
		}
		public void setPg(Parametres_Generaux pg) {
			this.pg = pg;
		}
	
	
	
	
	
	//
	
	
}
