package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.entities.RefPointage;

@Entity
@Table(name = "desc_journee_type")
public class DescJourneeType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2593486567372107214L;

	private Integer id;
	private Integer code ;
	private Date dateEffet;
	private Date plageHoraireTime;
    private Date dateFin;
	private JourneeType journeeType;
	private List<RefAbscence> refAbscences;
	private List<RefPointage> RefPointages;
	private List<PlageHoraireDescJourneeType> plageHoraireDescJourneeTypes;
	private List<RefAbscenceDescJourneeType> refAbscenceDescJourneeTypes;
	private JourneeType testjourneeType2 ; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	@Temporal(TemporalType.TIME)
	public Date getPlageHoraireTime() {
		return plageHoraireTime;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPlageHoraireTime(Date plageHoraireTime) {
		this.plageHoraireTime = plageHoraireTime;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@OneToMany(mappedBy = "descJourneeType", cascade = CascadeType.REMOVE,fetch= FetchType.EAGER )
	public List<RefAbscence> getRefAbscences() {
		return refAbscences;
	}

	public void setRefAbscences(List<RefAbscence> refAbscences) {
		this.refAbscences = refAbscences;
	}

	@OneToMany(mappedBy = "descJourneeType", cascade = CascadeType.REMOVE,fetch= FetchType.EAGER )
	public List<RefPointage> getRefPointages() {
		return RefPointages;
	}

	public void setRefPointages(List<RefPointage> RefPointages) {
		this.RefPointages = RefPointages;
	}

	@OneToMany(mappedBy = "descJourneeType", cascade = CascadeType.REMOVE ,fetch= FetchType.EAGER    )
	public List<PlageHoraireDescJourneeType> getPlageHoraireDescJourneeTypes() {
		return plageHoraireDescJourneeTypes;
	}

	public void setPlageHoraireDescJourneeTypes(
			List<PlageHoraireDescJourneeType> plageHoraireDescJourneeTypes) {
		this.plageHoraireDescJourneeTypes = plageHoraireDescJourneeTypes;
	}

	@OneToMany(mappedBy = "descJourneeType" )
	public List<RefAbscenceDescJourneeType> getRefAbscenceDescJourneeTypes() {
		return refAbscenceDescJourneeTypes;
	}

	public void setRefAbscenceDescJourneeTypes(
			List<RefAbscenceDescJourneeType> refAbscenceDescJourneeTypes) {
		this.refAbscenceDescJourneeTypes = refAbscenceDescJourneeTypes;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@ManyToOne
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	
	@ManyToOne(fetch= FetchType.LAZY)
	public JourneeType getTestjourneeType2() {
		return testjourneeType2;
	}

	public void setTestjourneeType2(JourneeType testjourneeType2) {
		this.testjourneeType2 = testjourneeType2;
	}

	
	
	
}
