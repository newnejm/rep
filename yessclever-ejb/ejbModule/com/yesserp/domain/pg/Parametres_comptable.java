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
@Table(name="pg_Parametres_comptable")
public class Parametres_comptable {
	
	private int code_Parametre_comptable ;
	private Date dateffet ;
    private Date datefin ;
    private List<Libelle> libelles;
    
    
	private Boolean staut ;
	

	@Id 
	public int getCode_Parametre_comptable() {
		return code_Parametre_comptable;
	}
	public void setCode_Parametre_comptable(int code_Parametre_comptable) {
		this.code_Parametre_comptable = code_Parametre_comptable;
	}
	
	@OneToMany(mappedBy = "parametrageComptabilite")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
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
	//
	public Boolean getStaut() {
		return staut;
	}
	public void setStaut(Boolean staut) {
		this.staut = staut;
	}

}