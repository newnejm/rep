package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ImputationGa
 *
 */
@Entity
@Table(name="ga_impurf01")

public class ImputationGa implements Serializable {

	
	private Long id;
	private String code1;
	private String code2;
	private String code3;
	private String code4;
	private String pctImput;
	private Date dateffet;
	private Date datefin;
	private Affectation affectation;
	private static final long serialVersionUID = 1L;

	public ImputationGa() {
		super();
	} 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getCode1() {
		return this.code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}   
	public String getCode2() {
		return this.code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}   
	public String getCode3() {
		return this.code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}   
	public String getCode4() {
		return this.code4;
	}

	public void setCode4(String code4) {
		this.code4 = code4;
	} 
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateffet() {
		return this.dateffet;
	}

	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
	} 
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@ManyToOne
	@JoinColumn(name="affectat")
	public Affectation getAffectation() {
		return affectation;
	}

	public void setAffectation(Affectation affectation) {
		this.affectation = affectation;
	}

	public String getPctImput() {
		return pctImput;
	}

	public void setPctImput(String pctImput) {
		this.pctImput = pctImput;
	}
   
}
