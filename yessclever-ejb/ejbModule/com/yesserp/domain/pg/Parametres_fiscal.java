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
@Table(name="pg_Parametres_fiscal")
public class Parametres_fiscal {
	
	private	int code_Parametres_fiscal ;
	private Date dateffet ;
    private Date datefin ;
	private List<Libelle> libelles;
	
	
	private Boolean staut ;
	
	
	
	@Id 
	public int getCode_Parametres_fiscal() {
		return code_Parametres_fiscal;
	}
	public void setCode_Parametres_fiscal(int code_Parametres_fiscal) {
		this.code_Parametres_fiscal = code_Parametres_fiscal;
	}
	
	
	@OneToMany(mappedBy = "parametres_fiscal")
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
	
	public Boolean getStaut() {
		return staut;
	}
	public void setStaut(Boolean staut) {
		this.staut = staut;
	}
//
}