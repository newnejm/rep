package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.entities.RefPointage;


@Entity
public class DescJourneeType2 implements Serializable 
{
	private static final long serialVersionUID = 1L ;
	
	private Integer id ;
	private Integer code ;
	private Date dateEffet ;
	private Date plageHoraireTime;
    private Date dateFin;
	private JourneeType2 journeeType2;
//	private List<RefAbscence> refAbscences;
//	private List<RefPointage> RefPointages;
	private List<PlageHoraireDescJourneeType2> plageHoraireDescJourneeType2s ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public Integer getCode() {
		return code;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateEffet() {
		return dateEffet;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getPlageHoraireTime() {
		return plageHoraireTime;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}
	
	
	
//	@ManyToOne
//	public JourneeType2 getJourneeType2() {
//		return journeeType2;
//	}

	public void setJourneeType2(JourneeType2 journeeType2) {
		this.journeeType2 = journeeType2;
	}

//	public List<RefAbscence> getRefAbscences() {
//		return refAbscences;
//	}
//	public List<RefPointage> getRefPointages() {
//		return RefPointages;
//	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}
	public void setPlageHoraireTime(Date plageHoraireTime) {
		this.plageHoraireTime = plageHoraireTime;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
//	public void setRefAbscences(List<RefAbscence> refAbscences) {
//		this.refAbscences = refAbscences;
//	}
//	public void setRefPointages(List<RefPointage> refPointages) {
//		RefPointages = refPointages;
//	}
  
	
	
	@OneToMany(mappedBy = "descJourneeType2" ,cascade =  CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<PlageHoraireDescJourneeType2> getPlageHoraireDescJourneeType2s() {
		return plageHoraireDescJourneeType2s;
	}

	public void setPlageHoraireDescJourneeType2s(
			List<PlageHoraireDescJourneeType2> plageHoraireDescJourneeType2s) {
		this.plageHoraireDescJourneeType2s = plageHoraireDescJourneeType2s;
	}
	
	
	
	
	
	
	
}
