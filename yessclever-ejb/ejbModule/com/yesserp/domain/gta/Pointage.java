package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.DescJourneeType;

/**
 * Entity implementation class for Entity: Pointage
 * 
 */
@Entity
public class Pointage implements Serializable {

	private int idp;
	private Date date;
	private Date dateForcee;
	private Date heurep;
	private int tolinf;
	private int tolsup;
	private boolean soumisPointage ;

	private Identite identite;
	
	private Terminal terminal;
	private TypePointage sens;
	
	private static final long serialVersionUID = 1L;

	public Pointage() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdp() {
		return this.idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public int getTolinf() {
		return this.tolinf;
	}

	public void setTolinf(int tolinf) {
		this.tolinf = tolinf;
	}

	public int getTolsup() {
		return this.tolsup;
	}

	public void setTolsup(int tolsup) {
		this.tolsup = tolsup;
	}

	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	@Temporal(TemporalType.TIME)
	public Date getHeurep() {
		return heurep;
	}

	public void setHeurep(Date heurep) {
		this.heurep = heurep;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateForcee() {
		return dateForcee;
	}

	public void setDateForcee(Date dateForcee) {
		this.dateForcee = dateForcee;
	}

	@ManyToOne
	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	@ManyToOne
	public TypePointage getSens() {
		return sens;
	}

	public void setSens(TypePointage sens) {
		this.sens = sens;
	}

	public boolean isSoumisPointage() {
		return soumisPointage;
	}

	public void setSoumisPointage(boolean soumisPointage) {
		this.soumisPointage = soumisPointage;
	}

}