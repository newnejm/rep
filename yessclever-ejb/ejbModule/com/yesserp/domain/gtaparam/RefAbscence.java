package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ref_abscence")
public class RefAbscence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -450230708323849607L;

	private Integer idap;
	private Date heureDeb;
	private Date heureFin;
	private Integer count=0 ;
	
	private DescJourneeType descJourneeType ;
	private List<RefAbscenceDescJourneeType> RefAbscenceDescJourneeTypes;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdap() {
		return idap;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeureDeb() {
		return heureDeb;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeureFin() {
		return heureFin;
	}

	public void setIdap(Integer idap) {
		this.idap = idap;
	}

	public void setHeureDeb(Date heureDeb) {
		this.heureDeb = heureDeb;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	
	@ManyToOne
	public DescJourneeType getDescJourneeType() {
		return descJourneeType;
	}

	public void setDescJourneeType(DescJourneeType descJourneeType) {
		this.descJourneeType = descJourneeType;
	}

	
	@OneToMany(mappedBy = "refAbscence")
	public List<RefAbscenceDescJourneeType> getRefAbscenceDescJourneeTypes() {
		return RefAbscenceDescJourneeTypes;
	}

	public void setRefAbscenceDescJourneeTypes(
			List<RefAbscenceDescJourneeType> refAbscenceDescJourneeTypes) {
		RefAbscenceDescJourneeTypes = refAbscenceDescJourneeTypes;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
