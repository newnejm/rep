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

import com.yesserp.domain.entities.BaseEntity;

@Entity
@Table(name = "desc_semaine_type")
public class DescSemaineType extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8963249475962831812L;

	private Integer idDescST;
	private String code;
	private Date dateEffet;
	private Date dateFin;
	private SemaineType semaineType;
	private List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypes;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdDescST() {
		return idDescST;
	}

	public String getCode() {
		return code;
	}
	@ManyToOne
	public SemaineType getSemaineType() {
		return semaineType;
	}

	@OneToMany(mappedBy = "descSemaineType", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	public List<JourneeTypeDescSemaineType> getJourneeTypeDescSemaineTypes() {
		return journeeTypeDescSemaineTypes;
	}

	public void setIdDescST(Integer idDescST) {
		this.idDescST = idDescST;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

	public void setJourneeTypeDescSemaineTypes(
			List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypes) {
		this.journeeTypeDescSemaineTypes = journeeTypeDescSemaineTypes;
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

}
