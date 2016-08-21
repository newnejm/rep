package com.yesserp.domain.gta;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: AffectationClassEmp
 *
 */
@Entity
@Table(name="GTA_AffectationClassEmp")
public class AffectationClassEmp implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private AffectationClassEpmPK affectationClassEpmPK ;
	private ClasseEmp classeEmp ;
	private Identite identite ;

	public AffectationClassEmp() {
		super();
	}

	@EmbeddedId
	public AffectationClassEpmPK getAffectationClassEpmPK() {
		return affectationClassEpmPK;
	}

	public void setAffectationClassEpmPK(AffectationClassEpmPK affectationClassEpmPK) {
		this.affectationClassEpmPK = affectationClassEpmPK;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="classEmp",referencedColumnName="id",insertable=false,updatable=false)
	public ClasseEmp getClasseEmp() {
		return classeEmp;
	}

	public void setClasseEmp(ClasseEmp classeEmp) {
		this.classeEmp = classeEmp;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idIdentite",referencedColumnName="numedoss",insertable=false,updatable=false)
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
   
}
