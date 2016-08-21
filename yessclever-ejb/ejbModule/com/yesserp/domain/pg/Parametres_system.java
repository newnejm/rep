 package com.yesserp.domain.pg;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.gtaparam.Libelle;



@Entity
@Table(name="pg_Parametres_system")
public class Parametres_system {
	
	
	private int  code_parametres_system ;	

	private String 	liste_des_modules_installe_par_chaque_ste ;

    private Date dateffet ;
    
    private Date datefin ;

    private String  heure ;

    private String  les_langue_a_utiliser;

    private String  devise_Utile;

    private String  RIB ;

    private String  immatriculationSociete ;

    private String  codeTVA ;

    private String  convention_Collective ;

    private String  registre_du_Commerce ;

    private List<Libelle> libelles;
    
    
	private Boolean staut ;
	

@Id
public int getCode_parametres_system() {
	return code_parametres_system;
}

public void setCode_parametres_system(int code_parametres_system) {
	this.code_parametres_system = code_parametres_system;
}

@OneToMany(mappedBy = "parametres_system")
public List<Libelle> getLibelles() {
	return libelles;
}

public void setLibelles(List<Libelle> libelles) {
	this.libelles = libelles;
}


public String getListe_des_modules_installe_par_chaque_ste() {
	return liste_des_modules_installe_par_chaque_ste;
}

public void setListe_des_modules_installe_par_chaque_ste(
		String liste_des_modules_installe_par_chaque_ste) {
	this.liste_des_modules_installe_par_chaque_ste = liste_des_modules_installe_par_chaque_ste;
}

@Temporal(TemporalType.TIMESTAMP)
public Date getDateffet() {
	return dateffet;
}

public void setDateffet(Date dateffet) {
	this.dateffet = dateffet;
}

@Temporal(TemporalType.TIMESTAMP)
public Date getDatefin() {
	return datefin;
}

public void setDatefin(Date datefin) {
	this.datefin = datefin;
}

public String getHeure() {
	return heure;
}

public void setHeure(String heure) {
	this.heure = heure;
}

public String getLes_langue_a_utiliser() {
	return les_langue_a_utiliser;
}

public void setLes_langue_a_utiliser(String les_langue_a_utiliser) {
	this.les_langue_a_utiliser = les_langue_a_utiliser;
}

public String getDevise_Utile() {
	return devise_Utile;
}

public void setDevise_Utile(String devise_Utile) {
	this.devise_Utile = devise_Utile;
}

public String getRIB() {
	return RIB;
}

public void setRIB(String rIB) {
	RIB = rIB;
}

public String getImmatriculationSociete() {
	return immatriculationSociete;
}

public void setImmatriculationSociete(String immatriculationSociete) {
	this.immatriculationSociete = immatriculationSociete;
}

public String getCodeTVA() {
	return codeTVA;
}

public void setCodeTVA(String codeTVA) {
	this.codeTVA = codeTVA;
}

public String getConvention_Collective() {
	return convention_Collective;
}

public void setConvention_Collective(String convention_Collective) {
	this.convention_Collective = convention_Collective;
}

public String getRegistre_du_Commerce() {
	return registre_du_Commerce;
}

public void setRegistre_du_Commerce(String registre_du_Commerce) {
	this.registre_du_Commerce = registre_du_Commerce;
}
	
//

public Boolean getStaut() {
	return staut;
}
public void setStaut(Boolean staut) {
	this.staut = staut;
}
}
