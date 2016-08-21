package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.entities.BaseEntity;

@Entity
@Table(name = "desc_cycleTravail")
public class DescCycleTravail  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8963249475962831812L;

	private Integer idDescCT;
	private String code;
	private Date dateEffet;
	private Date dateFin;
	private CycleTravail cycleTravail;
	private List<JourneeTypeDescCycleTravail> journeeTypeDescCycleTravails;
	private List<SemaineTypeDescCycleTravail> semaineTypeDescCycleTravails;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdDescCT() {
		return idDescCT;
	}

	public String getCode() {
		return code;
	}
	@ManyToOne
	public CycleTravail getCycleTravail() {
		return cycleTravail;
	}

	@OneToMany(mappedBy = "descCycleTravail", cascade = CascadeType.REMOVE)
	public List<JourneeTypeDescCycleTravail> getJourneeTypeDescCycleTravails() {
		return journeeTypeDescCycleTravails;
	}

	public void setIdDescCT(Integer idDescCT) {
		this.idDescCT = idDescCT;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCycleTravail(CycleTravail cycleTravail) {
		this.cycleTravail = cycleTravail;
	}

	public void setJourneeTypeDescCycleTravails(
			List<JourneeTypeDescCycleTravail> journeeTypeDescCycleTravails) {
		this.journeeTypeDescCycleTravails = journeeTypeDescCycleTravails;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	
	@OneToMany(mappedBy = "descCycleTravail", cascade = CascadeType.REMOVE)
	public List<SemaineTypeDescCycleTravail> getSemaineTypeDescCycleTravails() {
		return semaineTypeDescCycleTravails;
	}

	public void setSemaineTypeDescCycleTravails(
			List<SemaineTypeDescCycleTravail> semaineTypeDescCycleTravails) {
		this.semaineTypeDescCycleTravails = semaineTypeDescCycleTravails;
	}

}
