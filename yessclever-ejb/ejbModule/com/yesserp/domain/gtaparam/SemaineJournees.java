package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: SemaineJournees
 * 
 */
@Entity
public class SemaineJournees implements Serializable {

	private static final long serialVersionUID = 1L;
	private SemaineJourneesPK semaineJourneesPK;
	private CodeJour codeJour;
	private JourneeType journeeType;
	private SemaineType semaineType;

	public SemaineJournees() {
		super();
	}

	@EmbeddedId
	public SemaineJourneesPK getSemaineJourneesPK() {
		return semaineJourneesPK;
	}

	public void setSemaineJourneesPK(SemaineJourneesPK semaineJourneesPK) {
		this.semaineJourneesPK = semaineJourneesPK;
	}

	@ManyToOne
	@JoinColumn(name = "idCodejour", referencedColumnName = "idcj", insertable = false, updatable = false)
	public CodeJour getCodeJour() {
		return codeJour;
	}

	public void setCodeJour(CodeJour codeJour) {
		this.codeJour = codeJour;
	}

	@ManyToOne
	@JoinColumn(name = "idJournee", referencedColumnName = "idjt", insertable = false, updatable = false)
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	@ManyToOne
	@JoinColumn(name = "idSemaine", referencedColumnName = "idst", insertable = false, updatable = false)
	public SemaineType getSemaineType() {
		return semaineType;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

}
