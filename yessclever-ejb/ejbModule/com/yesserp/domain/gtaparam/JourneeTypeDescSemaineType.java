package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class JourneeTypeDescSemaineType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JourneeTypeDescSemaineTypePK journeeTypeDescSemaineTypePK;
	private JourneeType journeeType;
	private DescSemaineType descSemaineType;
	private CodeJour codeJour;
	

	@EmbeddedId
	public JourneeTypeDescSemaineTypePK getJourneeTypeDescSemaineTypePK() {
		return journeeTypeDescSemaineTypePK;
	}

	@ManyToOne
	@JoinColumn(name = "idJourneeType", referencedColumnName = "idjt", insertable = false, updatable = false, unique = false)
	public JourneeType getJourneeType() {
		return journeeType;
	}

	@ManyToOne
	@JoinColumn(name = "idDescSemaineType", unique = false, referencedColumnName = "idDescST", insertable = false, updatable = false)
	public DescSemaineType getDescSemaineType() {
		return descSemaineType;
	}

	public void setJourneeTypeDescSemaineTypePK(
			JourneeTypeDescSemaineTypePK journeeTypeDescSemaineTypePK) {
		this.journeeTypeDescSemaineTypePK = journeeTypeDescSemaineTypePK;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	public void setDescSemaineType(DescSemaineType descSemaineType) {
		this.descSemaineType = descSemaineType;
	}

	@ManyToOne
	@JoinColumn(name = "idCodeJour", unique = false, referencedColumnName = "idcj", insertable = false, updatable = false)
	public CodeJour getCodeJour() {
		return codeJour;
	}

	public void setCodeJour(CodeJour codeJour) {
		this.codeJour = codeJour;
	}

}
