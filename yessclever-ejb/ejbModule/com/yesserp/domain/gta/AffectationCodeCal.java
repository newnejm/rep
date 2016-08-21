package com.yesserp.domain.gta;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: AffectationClassEmp
 *
 */
@Entity
@Table(name="GTA_AffectationCodeCal")
public class AffectationCodeCal implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private AffectationCodeCalPK affectationCodeCalPK;
	private CodeCalendrier codeCalendrier ;
	private Identite identite ;

	public AffectationCodeCal() {
		super();
	}

	@EmbeddedId
	public AffectationCodeCalPK getAffectationCodeCalPK() {
		return affectationCodeCalPK;
	}

	public void setAffectationCodeCalPK(AffectationCodeCalPK affectationCodeCalPK) {
		this.affectationCodeCalPK = affectationCodeCalPK;
	}



	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idIdentite",referencedColumnName="numedoss",insertable=false,updatable=false)
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcodeCal",referencedColumnName="idCalendrier",insertable=false,updatable=false)
	public CodeCalendrier getCodeCalendrier() {
		return codeCalendrier;
	}

	public void setCodeCalendrier(CodeCalendrier codeCalendrier) {
		this.codeCalendrier = codeCalendrier;
	}








   
}
