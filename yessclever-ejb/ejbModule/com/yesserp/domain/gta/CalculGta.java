package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

@Entity
@Table(name="GTA_planningthorique")
public class CalculGta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateJour;
	private JourneeType journeeType;
	private SemaineType semaineType;
	private Identite identite;
	private CodeJour codeJour;

	public CalculGta() {
		super();
	}

	@ManyToOne
	public JourneeType getJourneeType() {
		return journeeType;
	}

	public void setJourneeType(JourneeType journeeType) {
		this.journeeType = journeeType;
	}

	@ManyToOne
	public CodeJour getCodeJour() {
		return codeJour;
	}

	public void setCodeJour(CodeJour codeJour) {
		this.codeJour = codeJour;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	@ManyToOne
	public SemaineType getSemaineType() {
		return semaineType;
	}

	public void setSemaineType(SemaineType semaineType) {
		this.semaineType = semaineType;
	}

	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
