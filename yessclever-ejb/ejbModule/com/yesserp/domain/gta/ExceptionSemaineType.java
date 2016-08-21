package com.yesserp.domain.gta;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.SemaineType;

/**
 * Entity implementation class for Entity: ExceptionSemaineType
 *
 */
@Entity
@Table(name="GTA_excsem")
public class ExceptionSemaineType implements Serializable {

	
	private int id;
	private String semaineAvant;
	private Date dateChangement;
	private SemaineType semaineType;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public ExceptionSemaineType() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSemaineAvant() {
		return this.semaineAvant;
	}

	public void setSemaineAvant(String semaineAvant) {
		this.semaineAvant = semaineAvant;
	}   
	public Date getDateChangement() {
		return this.dateChangement;
	}

	public void setDateChangement(Date dateChangement) {
		this.dateChangement = dateChangement;
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
   
}
